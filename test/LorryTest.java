import carModel.Car;
import carModel.Lorry;
import carModel.Scania;
import carModel.Volvo240;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class LorryTest {

    Lorry lorry1 = new Lorry();
    Lorry lorry2 = new Lorry();
    Car volvo1 = new Volvo240();
    Car volvo2 = new Volvo240();

    Scania scania1 = new Scania();
    @BeforeEach
    void setUp() {
        lorry1 = new Lorry();
        lorry2 = new Lorry();
        volvo1 = new Volvo240();
        volvo2 = new Volvo240();
        scania1 = new Scania();
    }

    @Test
    void increaseBedAngle() {
        lorry1.truckBed.setTruckBedAngle(0);
        lorry1.increaseBedAngle();
        assertEquals(lorry1.truckBed.getTruckBedAngle(), 70);
    }



    @Test
    void calculateDistance() {
        double dist = lorry1.calculateDistance(volvo1);
        assertEquals(dist, 0);

    }


    @Test
    void addCar1() {
        lorry1.carStack.add(volvo1);
        lorry1.currentSpeed = 100;
        lorry1.move();
        assertEquals(lorry1.carStack.size(),1);
    }
    @Test
    void addCar2() {
        lorry1.increaseBedAngle();
        lorry1.addCar(volvo1);
        lorry1.addCar(volvo2);


        assertEquals(lorry1.totCars,2);
    }

    @Test
    void removeCar() {
        lorry1.decreaseBedAngle();
        lorry1.addCar(volvo1);
        lorry1.removeCar();
        assertTrue(lorry1.carStack.isEmpty());


    }
    @Test
    void move1() {
        lorry1.carStack.add(volvo1);
        lorry1.currentSpeed = 100;
        lorry1.move();
        assertEquals(lorry1.getYPosition(), volvo1.getYPosition());
        assertEquals(lorry1.getXPosition(), volvo1.getXPosition());
    }
    @Test
    void move2() {
        lorry1.currentSpeed = 10;
        lorry1.move();
        assertTrue(lorry1.getYPosition() > 0);
    }
}