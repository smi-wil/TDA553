package carModel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public abstract class Vehicle implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    public double currentSpeed; // The current speed of the car
    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected int xPosition;
    protected int yPosition;
    public double direction;
    protected BufferedImage image;


    protected Vehicle(int nrDoors, Color color, double enginePower, String modelName, String imagePath) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.xPosition = 0;
        this.yPosition = 0;
        this.direction = 0;
        try {
            this.image = ImageIO.read(new File(imagePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        stopEngine();
    }

    protected int getNrDoors() {
        return nrDoors;
    }

    protected double getEnginePower() {
        return enginePower;
    }

    protected double getCurrentSpeed() {
        return currentSpeed;
    }
    public int getXPosition() {
        return xPosition;
    }
    public int getYPosition() {
        return yPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }
    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    protected Color getColor() {
        return color;
    }
    protected void setColor(Color clr) {
        color = clr;
    }
    public void startEngine() {
        currentSpeed = 0.1;
    }
    public void stopEngine() {
        currentSpeed = 0;
    }
    protected abstract double speedFactor();

    protected void incrementSpeed(double amount) {
        if (currentSpeed != 0) {
            currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
        }
    }
    protected void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }
    @Override
    public void move() {
        xPosition += currentSpeed * Math.sin(Math.toRadians(direction));
        yPosition += currentSpeed * Math.cos(Math.toRadians(direction));
    }
    @Override
    public void turnLeft() {
        direction = (direction - 10) % 360;
    }
    @Override
    public void turnRight() {
        direction = (direction + 10) % 360;
    }
    public void gas(double amount) {
        if (amount > 1) {
            amount = 1;
        } else if (amount < 0) {
            amount = 0;
        }
        incrementSpeed(amount);
    }
    public void brake(double amount) {
        if (amount > 1) {
            amount = 1;
        } else if (amount < 0) {
            amount = 0;
        }
        decrementSpeed(amount);
    }

    public BufferedImage getImage(){
        return this.image;
    }
}