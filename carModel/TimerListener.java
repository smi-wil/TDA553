package carModel;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class TimerListener implements ActionListener {
    private final int delay = 50;
    private Timer timer;
    private CarModel cars;

    public TimerListener(CarModel cars, DrawPanel panel){
        this.cars = cars;
        this.timer = new Timer(delay, actionPerformed();)

    }
    public void actionPerformed(ActionEvent e) {
        for (Vehicle car : cars) {
            if (checkWallCollision(car, index)){
                changeDirection(car);
            }
            if (checkCollisionRepairShop(car, index)){
                addToRepairShop((Volvo240) car);
            }
            car.move();
            panel.repaint();
        }
    }
}

