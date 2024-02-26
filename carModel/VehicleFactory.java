package carModel;

public class VehicleFactory {

    public static Vehicle createVolvo(){
        return new Volvo240();
}
    public static Vehicle createSaab(){
        return new Saab95();
    }
    public static Vehicle createScania(){
        return new Scania();
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