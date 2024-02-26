import carModel.*;

public class CarApp {

    public static void main(String[] args) {
        CarModel model = new CarModel();
        model.addVehicle(VehicleFactory.createVolvo());
        model.addVehicle(VehicleFactory.createSaab());
        model.addVehicle(VehicleFactory.createScania());

        CarView view = new CarView("CarSimulator", model);
        model.addObserver(view);

        new CarController(model, view);

        model.initilizePositions();

        model.timer.start();


    }
}

