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
        truckBed.increaseBedAngle(true, currentSpeed); //delegation
    }
    public void decreaseBedAngle(){
        truckBed.decreaseBedAngle(true, currentSpeed);
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
        if (totCars < 6 && dist <= 12 && !(truckBed.truckBedUp)) {
            carStack.push(car);
            totCars++;
        }
    }
    public void removeCar(){
        if (totCars > 0 && !(truckBed.truckBedUp)){
            carStack.pop();
            }
    }


    @Override
    public void move(){

        if (truckBed.truckBedUp) {
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

