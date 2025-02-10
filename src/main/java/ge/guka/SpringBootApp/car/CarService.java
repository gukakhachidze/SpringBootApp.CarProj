package ge.guka.SpringBootApp.car;

import ge.guka.SpringBootApp.car.model.Car;
import ge.guka.SpringBootApp.car.model.Engine;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarService {

    private List<Car> carList = new ArrayList<>();

    @PostConstruct
    void setup() {

        carList.add(new Car(1, "VAZ 2107", "Black", 1985, new Engine(125, 1.5)));
        carList.add(new Car(2, "MERCEDES E190", "GRAY", 1987, new Engine(312, 5.0)));
    }

    public List<Car> getCarList() {
        return carList;
    }

    public boolean addCar(Car car) {

        Car findedCar = findCarById(car.getId());
        if (findedCar != null){
            return false;
        }

        if (car.getColor() == null || car.getEngine() == null || car.getModel() == null){
            return false;
        }

        carList.add(car);
        return true;

    }

    public boolean updateCar(int id, Car car){
        Car carToUpdate = findCarById(id);
        if (carToUpdate != null){
            carToUpdate.setColor(car.getColor());
            carToUpdate.setModel(car.getModel());
            carToUpdate.setYear(car.getYear());
            carToUpdate.setEngine(car.getEngine());
            return true;
        }

        return false;
    }

    public boolean deleteCar(int id){
        Car deleteToCar = findCarById(id);
        if (deleteToCar != null){
            carList.remove(deleteToCar);
            return true;
        }

        return false;
    }

    public Car findCarById(int id){

        for (Car car : carList){
            if (car.getId() == id){
                return car;
            }
        }
        return null;
    }
}
