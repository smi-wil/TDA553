package carModel;

import java.util.ArrayList;

public interface Observable {
    public void addObserver(CarObserver o);

    public void removeObserver(CarObserver o);

    void notifyListeners();
}
