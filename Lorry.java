import java.awt.*;
import java.util.Stack;
import java.util.List;
import java.util.Iterator;

public class Lorry extends Truck implements HasBed, Loadable{
    protected TruckBed truckBed;
    protected Stack<Car> carStack;
    protected int totCars = 0;


    protected Lorry() {
        super(Color.black, 2000, "Lorry");
        truckBed = new TruckBed();

        stopEngine();
    }
    public void increaseBedAngle(){
        if (currentSpeed == 0) {
            truckBed.setTruckBedAngle(70);
        }
    }
    public void decreaseBedAngle(){
        if (currentSpeed == 0){
            truckBed.setTruckBedAngle(0);
        }
    }
    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }
    public double calculateDistance(Car car){
       double carXpos = car.xPosition;
       double carYpos = car.yPosition;

       double lorryXpos = this.xPosition;
       double lorryYpos = this.xPosition;

       double deltaX = carXpos - lorryXpos;
       double deltaY = carYpos - lorryYpos;

       return Math.sqrt(deltaX*deltaX + deltaY*deltaY);


    }
    public void addCar(Car car) {
        double dist = this.calculateDistance(car);
        if (totCars < 6 && dist <= 12 && (truckBed.getTruckBedAngle() == 70)) {
            carStack.push(car);
            totCars++;
        }
    }
    public void removeCar(){
        if (totCars > 0 && !(truckBed.getTruckBedAngle() == 70)){
            carStack.pop();
            }
    }


    @Override
    public void move(){

        if (truckBed.getTruckBedAngle() == 0) {
            super.move();

            Iterator<Car> iterator = carStack.iterator();

            while (iterator.hasNext()) {
                Car car = iterator.next();
                car.xPosition = this.xPosition;
                car.yPosition = this.yPosition;
            }
        }
    }
}

