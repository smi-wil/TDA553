//import carModel.Saab95;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class Saab95Test {
//    Saab95 Saab1 = new Saab95();
//    Saab95 Saab2 = new Saab95();
//    @BeforeEach
//    void setUp() {
//         Saab1 = new Saab95();
//         Saab2 = new Saab95();
//    }
//
//    @Test
//    void getNrDoors() {
//        assertEquals(Saab1.nrDoors, 2);
//    }
//
//    @Test
//    void incrementSpeed() {
//        Saab1.currentSpeed = Saab1.enginePower;
//        Saab1.incrementSpeed(0.5);
//        assertEquals(Saab1.currentSpeed, Saab1.enginePower);
//    }
//
//    @Test
//    void decrementSpeed() {
//        Saab1.currentSpeed = 0;
//        Saab1.decrementSpeed(0.5);
//        assertEquals(Saab1.currentSpeed, 0);
//    }
//
//    @Test
//    void gas() {
//        double speed = Saab1.getCurrentSpeed();
//        Saab1.gas(1);
//
//        assertTrue(Saab1.getCurrentSpeed() > speed);
//    }
//    @Test
//    void gas2() {
//        double speed = Saab1.getCurrentSpeed();
//        Saab1.gas(-1);
//
//        assertEquals(Saab1.getCurrentSpeed(), speed);
//    }
//
//    @Test
//    void brake() {
//        Saab1.gas(1);
//        double speed = Saab1.getCurrentSpeed();
//        Saab1.brake(1);
//        assertTrue(Saab1.getCurrentSpeed() < speed);
//    }
//    @Test
//    void brake2() {
//        Saab1.gas(1);
//        double speed = Saab1.getCurrentSpeed();
//        Saab1.brake(2);
//        assertNotEquals(Saab1.getCurrentSpeed(), speed);
//    }
//
//    @Test
//    void speedFactor() {
//        double speed1 = Saab1.speedFactor();
//        Saab1.activateTurbo();
//        double speed2 = Saab1.speedFactor();
//        assertTrue(speed2 > speed1);
//    }
//
//    @Test
//    void activateTurbo() {
//        Saab1.activateTurbo();
//        assertTrue(Saab1.turboOn);
//    }
//}