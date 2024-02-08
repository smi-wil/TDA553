import javax.imageio.ImageIO;
import javax.swing.*;
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

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240());
        cc.cars.add(new Saab95());
        cc.cars.add(new Scania(Color.pink, "Scania"));
        cc.initilizePositions();
        cc.frame.drawPanel.addPoints(cc.cars);
        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            index = 0;
            for (Vehicle car : cars) {
                changeDirection(car);
                car.move();
                int x = (int) Math.round(car.getXPosition());
                int y = (int) Math.round(car.getYPosition());

                frame.drawPanel.moveit(x, y, index);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
                index++;
            }
        }
    }
    void initilizePositions(){
        int i = 0;
        for (Vehicle car : cars){
            car.yPosition += 100*i;
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

    void changeDirection(Vehicle car) {
        BufferedImage image = frame.drawPanel.volvoImage;
        System.out.println(car.yPosition);
        // check width
        if (car.xPosition + image.getWidth() >= frame.drawPanel.getWidth() || car.xPosition < 0) {
            if (car.xPosition > 0) {
                car.xPosition = frame.drawPanel.getWidth() - image.getWidth();
            } else {
                car.xPosition = 0;
            }

            // car.stopEngine();
            car.direction -= 180;
            // car.startEngine();
        }
        // check height
        else if (car.yPosition + image.getHeight() >= frame.drawPanel.getHeight() || car.yPosition < 0) {
            if (car.yPosition > 0) {
                car.yPosition = frame.drawPanel.getHeight() - image.getHeight() - 5;
            } else {
                car.yPosition = 0;
            }

            // car.stopEngine();
            car.direction -= 180;
            // car.startEngine();
        }

    }
}
