package carModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CarModel {
    private static final int X = 800;
    private static final int Y = 800;
    public final CarObservable observable;
    private final int delay = 50;
    public Timer timer = new Timer(delay, new TimerListener());
    ArrayList<Vehicle> cars = new ArrayList<>();
    RepairShop<Volvo240> volvo240RepairShop;


    public CarModel(){

        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());

        observable = new CarObservable();
        volvo240RepairShop = new RepairShop<>(6);
    }

    public RepairShop<Volvo240> getVolvo240RepairShop(){
        return this.volvo240RepairShop;
    }
    public ArrayList<Vehicle> getCars(){
        return this.cars;
    }
    public void initilizePositions(){
        int i = 0;
        for (Vehicle car : getCars()){
            int yPos = car.getYPosition();
            car.setYPosition(yPos + 100*i);
            i++;
        }
    }

    void changeDirection(Vehicle car){
        car.direction -= 180;
    }

    boolean checkWallCollision(Vehicle car, int width, int height) {
        int carXpos = car.getXPosition();
        int carYpos = car.getYPosition();
        BufferedImage carImage = car.getImage();

        // check width
        if (carXpos + carImage.getWidth() >= width || carXpos < 0) {
            if (carXpos > 0) {
                car.setXPosition(width - carImage.getWidth());
            } else {
                car.setXPosition(0);
            }
            return true;
        }
        // check height
        else if (carYpos + carImage.getHeight() >= height || carYpos < 0) {
            if (carYpos > 0) {
                car.setYPosition(height - carImage.getHeight());
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
    boolean checkCollisionRepairShop(Vehicle car, RepairShop <? extends Vehicle> repairShop){
        BufferedImage imageRepairShop = repairShop.getImage();
        BufferedImage image = car.getImage();
        int carXpos = car.getXPosition();
        int carYpos = car.getYPosition();
        int repXpos = repairShop.getXPosition();
        int repYpos = repairShop.getYPosition();

        if (car instanceof Volvo240){
            if ((carXpos + image.getWidth() >= repXpos  && carXpos <= repXpos
                    && carYpos + image.getHeight() >= repYpos && carYpos <= repYpos) ||
                    (carXpos >= repXpos  && carXpos <= repXpos+imageRepairShop.getWidth() &&
                            carYpos >= repYpos && carYpos <= repYpos+imageRepairShop.getHeight()))
            {
                addToRepairShop((Volvo240) car);
                car.stopEngine();
                car.setXPosition(repXpos);
                car.setYPosition(repYpos);
                return true;
            }
        }
        return false;
    }
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle car : cars) {
                if (checkWallCollision(car, X, Y-240)) {
                    changeDirection(car);
                }
                if (checkCollisionRepairShop(car, volvo240RepairShop)) {
                    changeDirection(car);
                }
                car.move();
            }
            observable.notifyListeners();
        }
    }
    public ArrayList<Drawable> getDrawables(){
        ArrayList<Drawable> drawables = new ArrayList<>();
        for (Drawable car : cars){
            drawables.add(car);
        }
        drawables.add(volvo240RepairShop);
        return drawables;
    }
    public void addObserver(Observer observer){
        observable.addObserver(observer);
    }


    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        getCars().forEach(car -> car.gas(gas));
    }// make for everyone

    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle car : getCars()
        ) {
            car.brake(brake);
        }
    }
    public void activateTurbo() {
        for (Vehicle car : getCars()){
            if(car instanceof Saab95)
            {
                ((Saab95) car).activateTurbo();
            }
        }
    }
    public void deactivateTurbo() {
        for (Vehicle car : getCars()){
            if(car instanceof Saab95)
            {
                ((Saab95) car).deactivateTurbo();
            }
        }
    }
    public void liftBed() {
        for (Vehicle car : getCars()){
            if(car instanceof Truck)
            {
                ((Truck) car).increaseBedAngle();
            }
        }
    }
    public void lowerBed() {
        for (Vehicle car : getCars()){
            if(car instanceof Truck)
            {
                ((Truck) car).decreaseBedAngle();
            }
        }
    }
    public void startCars() {
        for (Vehicle car : getCars()){
            car.startEngine();
        }
    }
    public void stopCars() {
        for (Vehicle car : getCars()){
            car.stopEngine();
        }
    }

}


