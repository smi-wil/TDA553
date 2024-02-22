package carModel;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class CarModel {

    ArrayList<Vehicle> cars = new ArrayList<>();
    ArrayList<CarObserver> observers = new ArrayList<>();
    RepairShop<Volvo240> volvo240RepairShop;

    public CarModel(){
        cars.add(new Volvo240());
        cars.add(new Saab95());
        cars.add(new Scania());
        volvo240RepairShop = new RepairShop<>(6);
    }

    public RepairShop<Volvo240> getVolvo240RepairShop(){
        return this.volvo240RepairShop;
    }
    public ArrayList<Vehicle> getCars(){
        return this.cars;
    }
    public void addObservers(){

    }
    public void notifyObservers(){
        for (CarObserver o : observers){
            o.actOnModelUpdate();
        }
    }
    void changeDirection(Vehicle car){
        car.direction -= 180;
    }

    //borde vi ha en checkWidthCollision och en checkHeightCollison? Blir det mer modulärt?
    // däremot borde vi inte ta in index utan snarare skicka med rätt bild som argument. blir tydligare utifrån.
    boolean checkWallCollision(Vehicle car, int width, int height) {
        // BufferedImage image = car.image;
        int carXpos = car.getXPosition();
        int carYpos = car.getYPosition();
        BufferedImage image = car.getImage();

        // check width
        if (carXpos + image.getWidth() >= width || carXpos < 0) {
            if (carXpos > 0) {
                car.setXPosition(width - image.getWidth());
            } else {
                car.setXPosition(0);
            }
            return true;
        }
        // check height
        else if (carYpos + image.getHeight() >= height || carYpos < 0) {
            if (carYpos > 0) {
                car.setYPosition(height - image.getHeight());
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
    boolean checkCollisionRepairShop(Vehicle car, RepairShop repairShop){
        BufferedImage imageRepairShop = repairShop.getImage();
        BufferedImage image = car.getImage();
        int carXpos = car.getXPosition();
        int carYpos = car.getYPosition();
        int repXpos = repairShop.getX();
        int repYpos = repairShop.getY();

        if (car instanceof Volvo240){
            if ((carXpos + image.getWidth() >= repXpos  && carXpos <= repXpos
                    && carYpos + image.getHeight() >= repYpos && carYpos <= repYpos) ||
                    (carXpos >= repXpos  && carXpos <= repXpos+imageRepairShop.getWidth() &&
                            carYpos >= repYpos && carYpos <= repYpos+imageRepairShop.getHeight()))
            {
                car.stopEngine();
                car.setXPosition(repXpos);
                car.setYPosition(repYpos);
                return true;
            }
        }
        return false;
    }
}
