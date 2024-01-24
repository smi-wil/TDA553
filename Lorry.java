import java.awt.*;
import java.util.Stack;
import java.util.List;

public class Lorry extends Scania {
    protected Stack<Vehicle> carStack;
    protected int totCars = 0;

    protected Lorry() {
        super(Color.black, "Lorry");
        carStack = new Stack<>();

        stopEngine();
    }

    public double calculateDistance(Vehicle car){
       double carXpos = car.xPosition;
       double carYpos = car.yPosition;

       double lorryXpos = this.xPosition;
       double lorryYpos = this.xPosition;

       double deltaX = carXpos - lorryXpos;
       double deltaY = carYpos - lorryYpos;

       return Math.sqrt(deltaX*deltaX + deltaY*deltaY);


    }
    protected void addCar(Vehicle car) {
        double dist = this.calculateDistance(car);
        if (!(car instanceof Scania) && totCars < 6 && dist <= 12 && truckBedAngle == 1) {

            carStack.push(car);
            totCars++;

        }
    }
    protected void removeCar(){
            double dist = this.calculateDistance(car);
            if (!(car instanceof Scania) && totCars < 6 && dist <= 12  && truckBedAngle == 1){

                carStack.push(car);
                totCars++;

            }

    }


    @Override
    protected void increaseBedAngle() {
        //fälla ner
        truckBedAngle = 1;
    }


    @Override
    protected void decreaseBedAngle() {
        //fälla upp
        truckBedAngle = 0;
    }

    protected double getBedTruckAngle() {
        return truckBedAngle;
    }

    @Override
    public void move(){
        List<Vehicle> listFromStack = List.copyOf(carStack);

        for (int i = carStack.size() - 1; i >= 0; i--){

        }

    }

}

