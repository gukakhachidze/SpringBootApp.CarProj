package ge.guka.SpringBootApp.car.model;

public class Car {

    private int id;
    private String model;
    private String color;
    private int year;
    private Engine engine;

    public Car(int id, String model, String color, int year, Engine engine){
        this.id = id;
        this.model = model;
        this.color = color;
        this.year = year;
        this.engine = engine;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getYear() {
        return year;
    }

    public Engine getEngine() {
        return engine;
    }

    public int getId(){
        return id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }
}
