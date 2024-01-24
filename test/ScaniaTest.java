import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.awt.*;

import static org.junit.jupiter.api.Assertions.*;

class ScaniaTest {
    Scania scania1 = new Scania(Color.pink, "Scania");


    @BeforeEach
    void setUp() {
        scania1 = new Scania(Color.pink, "Scania");
    }

    @Test
    void speedFactor() {
    }

    @Test
    void increaseBedAngle() {
        scania1.increaseBedAngle();
        assertTrue(scania1.truckBedAngle > 0);

    }

    @Test
    void decreaseBedAngle() {
        scania1.incrementSpeed(1);
        scania1.truckBedAngle = 10;
        scania1.decreaseBedAngle();
        assertEquals(scania1.truckBedAngle, 10);
    }

    @Test
    void getBedTruckAngle() {
    }

    @Test
    void move() {
        scania1.increaseBedAngle();
        scania1.move();
        assertEquals(scania1.yPosition, 0);
        assertEquals(scania1.xPosition, 0);
    }
    @Test
    void move2() {
        scania1.currentSpeed = 10;
        scania1.move();
        assertEquals(scania1.yPosition, 10);
        assertEquals(scania1.xPosition, 0);
    }
}