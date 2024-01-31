import java.awt.*;
import java.util.Stack;
import java.util.Iterator;

class Lorry extends Truck implements Loadable<Car> {

    protected Stack<Car> carStack = new Stack<>();
    protected int totCars = 0;


    protected Lorry() {
        super(Color.black, 2000, "Lorry");


        stopEngine();
    }
    @Override
    public void increaseBedAngle() {
        if (currentSpeed == 0) {
            truckBed.setTruckBedAngle(70);
        }
    }
    @Override
    public void decreaseBedAngle() {
        if (currentSpeed == 0) {
            truckBed.setTruckBedAngle(0);
        }
    }

    @Override
    protected double speedFactor() {
        return enginePower * 0.01;
    }

    public double calculateDistance(Car car) {
        double carXpos = car.xPosition;
        double carYpos = car.yPosition;

        double lorryXpos = this.xPosition;
        double lorryYpos = this.xPosition;

        double deltaX = carXpos - lorryXpos;
        double deltaY = carYpos - lorryYpos;

        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);


    }
    @Override
    public void addCar(Car car) {
        double dist = this.calculateDistance(car);
        if (totCars < 6 && dist <= 12 && (truckBed.getTruckBedAngle() == 70)) {
            carStack.push(car);
            totCars++;
        }
    }
    @Override
    public Car removeCar() {
        if (totCars > 0 && !(truckBed.getTruckBedAngle() == 70)) { // This means the Lorry will be still.

            Car removedCar = carStack.pop();
            removedCar.xPosition -= 5;
            removedCar.yPosition -= 5;
            return removedCar;
        } else return null;
    }


    @Override
    public void move() {

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


