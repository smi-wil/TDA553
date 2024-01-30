import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RepairShopTest {

    RepairShop<Volvo240> volvo240RepairShop = new RepairShop<>(5);
    RepairShop<Car> carRepairShop;
    RepairShop<Saab95> saab95RepairShop;
    Volvo240 volvo1 = new Volvo240();
    Volvo240 volvo2 = new Volvo240();
    Saab95 saab1 = new Saab95();
    @BeforeEach
    void setUp() {
        volvo240RepairShop = new RepairShop<>(5);
        carRepairShop = new RepairShop<>(5);
        saab95RepairShop = new RepairShop<>(1);
        volvo1 = new Volvo240();
        volvo2 = new Volvo240();
        saab1 = new Saab95();
    }

    @Test
    void addCar1() {
        volvo240RepairShop.addCar(volvo1);
        assertEquals(volvo240RepairShop.getCarList().size(), 1);
    }

    @Test
    void addCar2() {
        volvo240RepairShop.addCar(volvo2);
        assertEquals(volvo240RepairShop.getCarList().size(), 1);
    }

    @Test
    void removeCar() {
    }
}