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
* It's responsibilities is to listen to the View and responds in an appropriate manner by
* modifying the model state and the updating the view.
 */

public class CarController{
    // The frame that represents this instance View of the MVC pattern
    CarModel model;
    CarView frame;


    public CarController(CarModel model, CarView view){
        this.model = model;
        this.frame = view;
        this.actionListener("Simulation Buttons");

    }

    void initilizePositions(){
        int i = 0;
        for (Vehicle car : model.getCars()){
            int yPos = car.getYPosition();
            car.setYPosition(yPos + 100*i);
            i++;
        }
    }

    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle car : model.getCars()
        ) {
            car.gas(gas);
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : model.getCars()
        ) {
            car.brake(brake);
        }
    }
    void activateTurbo() {
        for (Vehicle car : model.getCars()){
            if(car instanceof Saab95)
            {
                ((Saab95) car).activateTurbo();
            }
        }
    }
    void deactivateTurbo() {
        for (Vehicle car : model.getCars()){
            if(car instanceof Saab95)
            {
                ((Saab95) car).deactivateTurbo();
            }
        }
    }
    void liftBed() {
        for (Vehicle car : model.getCars()){
            if(car instanceof Truck)
            {
                ((Truck) car).increaseBedAngle();
            }
        }
    }
    void lowerBed() {
        for (Vehicle car : model.getCars()){
            if(car instanceof Truck)
            {
                ((Truck) car).decreaseBedAngle();
            }
        }
    }
    void startCars() {
        for (Vehicle car : model.getCars()){
               car.startEngine();
        }
    }
    void stopCars() {
        for (Vehicle car : model.getCars()){
            car.stopEngine();
        }
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


