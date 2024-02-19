package carModel;

interface Loadable <A extends Vehicle>{
    public void addCar(A car);
    public A removeCar();

}
