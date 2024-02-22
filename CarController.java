import carModel.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

/*
* This class represents the Controller part in the MVC pattern.
* It's responsibilities is to listen to the View and responds in a appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with a listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    int index;
    // A list of cars, modify if needed
    ArrayList<Vehicle> cars = new ArrayList<>();
    RepairShop<Volvo240> volvo240RepairShop;

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.volvo240RepairShop = new RepairShop<>(6);
        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania());
        cc.initilizePositions();
        cc.frame = new CarView("CarSim 1.0");
        cc.frame.drawPanel.addPoints(cc.cars);
        cc.actionListener("hello");
        // Start a new view and send a reference of self
        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */

    void initilizePositions(){
        int i = 0;
        for (Vehicle car : cars){
            int yPos = car.getYPosition();
            car.setYPosition(yPos + 100*i);
            i++;
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : cars
        ) {
            car.brake(brake);
        }
    }
    void activateTurbo() {
        for (Vehicle car : cars){
            if(car instanceof Saab95)
            {
                ((Saab95) car).activateTurbo();
            }
        }
    }
    void deactivateTurbo() {
        for (Vehicle car : cars){
            if(car instanceof Saab95)
            {
                ((Saab95) car).deactivateTurbo();
            }
        }
    }
    void liftBed() {
        for (Vehicle car : cars){
            if(car instanceof Truck)
            {
                ((Truck) car).increaseBedAngle();
            }
        }
    }
    void lowerBed() {
        for (Vehicle car : cars){
            if(car instanceof Truck)
            {
                ((Truck) car).decreaseBedAngle();
            }
        }
    }
    void startCars() {
        for (Vehicle car : cars){
               car.startEngine();
        }
    }
    void stopCars() {
        for (Vehicle car : cars){
            car.stopEngine();
        }
    }
    void changeDirection(Vehicle car){
        car.direction -= 180;
    }

    //borde vi ha en checkWidthCollision och en checkHeightCollison? Blir det mer modulärt?
    // däremot borde vi inte ta in index utan snarare skicka med rätt bild som argument. blir tydligare utifrån.
    boolean checkWallCollision(Vehicle car, int i) {
        // BufferedImage image = car.image;
        BufferedImage image = frame.drawPanel.imageList.get(i);
        // check width
        if (car.getXPosition() + image.getWidth() >= frame.drawPanel.getWidth() || car.getXPosition() < 0) {
            if (car.getXPosition() > 0) {
                car.setXPosition(frame.drawPanel.getWidth() - image.getWidth());
            } else {
                car.setXPosition(0);
            }
            return true;
        }
        // check height
        else if (car.getYPosition() + image.getHeight() >= frame.drawPanel.getHeight() || car.getYPosition() < 0) {
            if (car.getYPosition() > 0) {
                car.setYPosition(frame.drawPanel.getHeight() - image.getHeight());
            } else {
                car.setYPosition(0);
            }
            return true;
        }
    return false;
    }

    void addToRepairShop(Volvo240 car){
        if (!volvo240RepairShop.getCarList().contains(car)) {
            volvo240RepairShop.addCar(car);
        }
    }
    boolean checkCollisionRepairShop(Vehicle car, int i){
        Point point = frame.drawPanel.volvoWorkshopPoint;
        BufferedImage imageRepairShop = frame.drawPanel.volvoWorkshopImage;
        BufferedImage image = frame.drawPanel.imageList.get(i);

        if (car instanceof Volvo240){
            if ((car.getXPosition() + image.getWidth() >= point.getX()  && car.getXPosition() <= point.getX()
            && car.getYPosition() + image.getHeight() >= point.getY() && car.getYPosition() <= point.getY()) ||
            (car.getXPosition() >= point.getX()  && car.getXPosition() <= point.getX()+imageRepairShop.getWidth() &&
            car.getYPosition() >= point.getY()  && car.getYPosition() <= point.getY()+imageRepairShop.getHeight()))
            {
                car.stopEngine();
                car.setXPosition((int) point.getX());
                car.setYPosition((int) point.getY());
              return true;
                }
            }
        return false;
        }

        // ACTIONLISTENERS
    private void actionListener(String title) {

        frame.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                frame.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gas(frame.gasAmount);
            }
        });
        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brake(frame.gasAmount);
            }
        });
        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                activateTurbo();
            }
        });
        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deactivateTurbo();
            }
        });
        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                liftBed();
            }
        });
        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                lowerBed();
            }
        });
        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startCars();
            }
        });
        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                stopCars();
            }
        });

    }
}


