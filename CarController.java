import carModel.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        this.actionListener();

    }


        // ACTIONLISTENERS
    private void actionListener() {

        frame.gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                frame.gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
        });
        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.gas(frame.gasAmount);
            }
        });
        frame.brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.brake(frame.gasAmount);
            }
        });
        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                model.activateTurbo();
            }
        });
        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.deactivateTurbo();
            }
        });
        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.liftBed();
            }
        });
        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.lowerBed();
            }
        });
        frame.startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.startCars();
            }
        });
        frame.stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.stopCars();
            }
        });

    }
}

