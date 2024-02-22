import carModel.*;

public class CarApp {
    TimerListener timer;
    public static void main(String[] args) {
        CarModel cars = new CarModel();
       // CarView view =
                //createViewForModel(cars);

        CarController cc = new CarController();
        DrawPanel panel = view.drawPanel;

        cc.initilizePositions();

        cars.animate();

        TimerListener timer = new TimerListener(cars, panel);
        timer.start();
    }



//    private static CarView createViewForModel(CarModel carModel) {
//        CarView view = new CarView();
//        view.addModel(polygonModel);
//        polygonModel.addListener(view);
//        return view;
//    }//initViewForModel
}
