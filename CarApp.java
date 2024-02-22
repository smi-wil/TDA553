import carModel.*;

public class CarApp {

    public static void main(String[] args) {
        CarModel model = new CarModel();
       // CarView view =
                //createViewForModel(cars);
        namnetärintesåviktigt n = new namnetärintesåviktigt(model.getCars(), model.getVolvo240RepairShop());

        CarView view = new CarView("hej", n);
        CarController cc = new CarController(model, view);

        cc.initilizePositions();



        model.timer.start();
    }



//    private static CarView createViewForModel(CarModel carModel) {
//        CarView view = new CarView();
//        view.addModel(polygonModel);
//        polygonModel.addListener(view);
//        return view;
//    }//initViewForModel
}
