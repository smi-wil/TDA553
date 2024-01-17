import java.awt.Color;

public abstract class Vehicle implements Movable {
    private int nrDoors; // Number of doors on the vehicle
    private double enginePower; // Engine power of the vehicle
    private double currentSpeed; // The current speed of the vehicle
    private Color color; // Color of the vehicle
    private String modelName; // The vehicle model name
    private double xPosition; // X position of the vehicle
    private double yPosition; // Y position of the vehicle
    private double direction; // Direction of the vehicle in degrees

    public Vehicle(int nrDoors, double enginePower, Color color, String modelName) {
        this.nrDoors = nrDoors;
        this.enginePower = enginePower;
        this.color = color;
        this.modelName = modelName;
        this.xPosition = 0;
        this.yPosition = 0;
        this.direction = 0;
        stopEngine();
    }


    public int getNrDoors(){
        return nrDoors;
    }

    public double getEnginePower() {
        return enginePower;
    }

    public double getCurrentSpeed() {
        return currentSpeed;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color clr) {
        color = clr;
    }

    public void startEngine() {
        currentSpeed = 0.1;
    }

    public void stopEngine() {
        currentSpeed = 0;
    }

    public abstract double speedFactor();

    private void incrementSpeed(double amount) {
        currentSpeed = Math.min(getCurrentSpeed() + speedFactor() * amount, enginePower);
    }

    private void decrementSpeed(double amount) {
        currentSpeed = Math.max(getCurrentSpeed() - speedFactor() * amount, 0);
    }

    public void gas(double amount) {
        if (amount >= 0 && amount <= 1) {
            incrementSpeed(amount);
        }
    }

    public void brake(double amount) {
        if (amount >= 0 && amount <= 1) {
            decrementSpeed(amount);
        }
    }

    // Movable implementation
    @Override
    public void move() {
        xPosition += currentSpeed * Math.cos(Math.toRadians(direction));
        yPosition += currentSpeed * Math.sin(Math.toRadians(direction));
    }

    @Override
    public void turnLeft() {
        direction = (direction - 5) % 360;
    }

    @Override
    public void turnRight() {
        direction = (direction + 5) % 360;
    }

    // Additional methods for position and direction
    public double getXPosition() {
        return xPosition;
    }

    public double getYPosition() {
        return yPosition;
    }

    public double getDirection() {
        return direction;
    }
}