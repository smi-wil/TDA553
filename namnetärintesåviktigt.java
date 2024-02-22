import carModel.CarObserver;
import carModel.Drawable;
import carModel.RepairShop;
import carModel.Vehicle;

import java.util.ArrayList;

public class namnetärintesåviktigt {
    private Drawable repairShop;
    //private final ArrayList<Drawable> drawables = new ArrayList<>();
    private ArrayList<Drawable> cars;



    public namnetärintesåviktigt(ArrayList<Drawable> cars, Drawable repairShop){
        this.repairShop = repairShop;
        this.cars = cars;
    }
}
