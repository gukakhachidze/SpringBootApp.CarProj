package ge.guka.SpringBootApp.car;

import ge.guka.SpringBootApp.car.model.Car;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("car")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    ResponseEntity<List<Car>> getCars(){
        List<Car> cars = carService.getCarList();
        if (cars == null || cars.isEmpty()){
            return  ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(cars);
    }

    @PostMapping
    ResponseEntity<String> addCar(@RequestBody Car car){
        if (carService.addCar(car)){
            return ResponseEntity.ok("Successfully added car");
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("{id}")
    ResponseEntity updateCar(@PathVariable int id, @RequestBody Car car){
        if (carService.updateCar(id,car)){
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("{id}")
    ResponseEntity deleteCar(@PathVariable int id){
        if (carService.deleteCar(id)){
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{id}")
    ResponseEntity<Car> getCarById(@PathVariable int id){
        Car car = carService.findCarById(id);
        if (car != null){
            return ResponseEntity.ok(car);
        }

       return ResponseEntity.notFound().build();
    }

}
