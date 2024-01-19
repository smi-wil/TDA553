import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Volvo240Test {
    Volvo240 Volvo1 = new Volvo240();
    Volvo240 Volvo2 = new Volvo240();

    @BeforeEach
    void setUp() {
         Volvo1 = new Volvo240();
         Volvo2 = new Volvo240();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getNrDoors() {
    }

    @Test
    void getEnginePower() {
    }

    @Test
    void getCurrentSpeed() {
    }

    @Test
    void getColor() {
    }

    @Test
    void setColor() {
    }

    @Test
    void startEngine() {
    }

    @Test
    void stopEngine() {
    }

    @Test
    void incrementSpeed() {
    }

    @Test
    void decrementSpeed() {
    }

    @Test
    void move() {
        double y = Volvo1.yPosition;
        double x = Volvo1.xPosition;
        Volvo1.gas(1);
        Volvo1.move();
        assertTrue(y < Volvo1.yPosition);
        assertEquals(x, Volvo1.xPosition);
    }

    @Test
    void turnLeft() {
        Volvo1.turnLeft();
        Volvo1.currentSpeed = 10;
        Volvo1.move();

        assertTrue(Volvo1.xPosition < 0);

    }

    @Test
    void turnRight() {
            Volvo1.turnRight();
            Volvo1.currentSpeed = 10;
            Volvo1.move();
            assertTrue(Volvo1.xPosition > 0);

        }

    @Test
    void gas() {
    }

    @Test
    void brake() {
    }

    @Test
    void speedFactor() {
        double speedF = Volvo1.speedFactor();
        assertEquals(speedF, 1.25);
    }
}