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
