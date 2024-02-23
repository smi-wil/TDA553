package carModel;


import javax.swing.*;
import java.util.ArrayList;

class CarObservable implements Observable {
//    private Timer timer;
//    private ArrayList<Vehicle> carSet;
    private final ArrayList<CarObserver> observers = new ArrayList<>();
    public void addObserver(CarObserver o){
        observers.add(o);
    }
    public void removeObserver(CarObserver o){
        observers.remove(o);
    }

    public void notifyListeners(){
        for (CarObserver o: observers){
            o.actOnModelUpdate();
        }
    }
    public ArrayList<CarObserver> getObservers(){
        return observers;
    }
}

