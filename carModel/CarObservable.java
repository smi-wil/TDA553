package carModel;


import java.util.ArrayList;

class CarObservable implements Observable {
    private final ArrayList<Observer> observers = new ArrayList<>();
    public void addObserver(Observer o){
        observers.add(o);
    }
    public void removeObserver(Observer o){
        observers.remove(o);
    }

    public void notifyListeners(){
        for (Observer o: observers){
            o.actOnModelUpdate();
        }
    }
    public ArrayList<Observer> getObservers(){
        return observers;
    }
}

