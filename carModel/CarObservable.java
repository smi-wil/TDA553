package carModel;


import javax.swing.*;
import java.util.ArrayList;

class CarObservable implements Observable {

    private Timer timer;
    private ArrayList<Vehicle> carSet;

    //private CarModel carModel;

    public void addObserver(CarObserver o){
        observers.add(o);
    }
    public void removeObserver(CarObserver o){
        observers.remove(o);
    }
    private final ArrayList<CarObserver> observers = new ArrayList<>();
    public void notifyListeners(){
        for (CarObserver o: observers){
            o.actOnModelUpdate();
        }
    }
}

