package carModel;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class RepairShop <A extends Car> implements Loadable<A>{

    private final ArrayList<A> carList = new ArrayList<>();
    private final int maxCars;
    private int x;
    private int y;
    private BufferedImage image;

    public RepairShop(int maxCars){
        this.x = 300;
        this.y = 300;
        this.maxCars = maxCars;
        try {
            this.image = ImageIO.read(new File("pics/VolvoBrand.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected int getMaxCars(){
        return this.maxCars;}

    @Override
    public void addCar(A car){
        if (carList.size() < maxCars) {
            carList.add(car);
        }
    }

    @Override // FIFO
    public A removeCar(){
        if (carList.size() > 0){
           return carList.remove(0);
        }
        else return null;

    }

    public ArrayList<A> getCarList(){
        return carList;
    }
    public BufferedImage getImage(){
        return this.image;
    }
    public int getX(){
        return this.x;
    }
    public int getY(){
        return this.y;
    }
}
