import java.util.ArrayList;

public class RepairShop <A extends Car> implements Loadable<A>{

    private final ArrayList<A> carList = new ArrayList<>();
    private final int maxCars;

    protected RepairShop(int maxCars){
        this.maxCars = maxCars;

    }
    @Override
    public void addCar(A car){
        if (carList.size() < maxCars) {
            carList.add(car);
        }
    }

    @Override // FIFO
    public A removeCar(){
        if (carList.size() > 0){
           return carList.remove(0);
        }
        else return null;

    }

    protected ArrayList<A> getCarList(){
        return carList;
    }
}
