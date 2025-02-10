package ge.guka.SpringBootApp.car.model;

public class Engine {

    private int hoursePower;
    private double capacity;

    public Engine(int hoursePower, double capacity){
        this.capacity = capacity;
        this.hoursePower = hoursePower;
    }

    public int getHoursePower() {
        return hoursePower;
    }

    public double getCapacity() {
        return capacity;
    }
}
