import carModel.*;

import java.util.ArrayList;

public class CarApp {

    public static void main(String[] args) {
        CarModel model = new CarModel();

       // CarView view =
                //createViewForModel(cars);
        ArrayList<Drawable> drawables = model.getDrawables();

        CarView view = new CarView("hej", model);
        model.addObserver(view);

        CarController cc = new CarController(model, view);

        cc.initilizePositions();

        model.timer.start();
    }
}
//public static CarModel createModel(){
//    CarModel model = new CarModel();
//
//    model.addCar(VehicleFactory.createVolvo());
//    model.addCar(PolygonFactory.createSaab());
//    model.addCar(PolygonFactory.createScania());
//
//    return model;
//    private static CarView createViewForModel(CarModel carModel) {
//        CarView view = new CarView();
//        view.addModel(polygonModel);
//        polygonModel.addListener(view);
//        return view;
//    }//initViewForModel
