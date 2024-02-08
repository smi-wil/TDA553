import java.awt.*;

abstract class Vehicle implements Movable {
    protected int nrDoors; // Number of doors on the car
    protected double enginePower; // Engine power of the car
    protected double currentSpeed; // The current speed of the car

    protected Color color; // Color of the car
    protected String modelName; // The car model name
    protected int xPosition;
    protected int yPosition;
    protected double direction;


    protected Vehicle(int nrDoors, Color color, double enginePower, String modelName) {
        this.nrDoors = nrDoors;
        this.color = color;
        this.enginePower = enginePower;
        this.modelName = modelName;
        this.xPosition = 0;
        this.yPosition = 0;
        this.direction = 0;
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
    protected int getXPosition() {
        return xPosition;
    }
    protected int getYPosition() {
        return yPosition;
    }

    protected Color getColor() {
        return color;
    }
    protected void setColor(Color clr) {
        color = clr;
    }
    protected void startEngine() {
        currentSpeed = 0.1;
    }
    protected void stopEngine() {
        currentSpeed = 0;
    }
    protected abstract double speedFactor();

    protected void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
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
}