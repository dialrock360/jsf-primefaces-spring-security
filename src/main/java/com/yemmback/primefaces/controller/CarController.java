package com.yemmback.primefaces.controller;


import com.yemmback.primefaces.exception.ResourceNotFoundException;
import com.yemmback.primefaces.model.Brand;
import com.yemmback.primefaces.model.Car;
import com.yemmback.primefaces.repository.BrandRepository;
import com.yemmback.primefaces.repository.CarRepository;
import com.yemmback.primefaces.service.BrandService;
import com.yemmback.primefaces.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.validation.Valid;
import java.util.Hashtable;
import java.util.List;


@RestController
@RequestMapping("/api")
public class CarController {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private BrandRepository brandRepository;

    private Car car;
    private List<Car> cars;
    private Brand brand;
    private List<Brand> brands;
    private List<String> colors;
    private List<Hashtable> icolors;
    private String color;
    private Hashtable icolor;

    @Inject
    private CarService carservice;
    @Inject
    private BrandService brandService;

    private List<String> Colors;




    // Create a new car
    @PostMapping("/car")
    public String createCar(@Valid @RequestBody Car car) {

        try {
             brand = brandService.find(car.getBrand().getId());
             car.setBrand(brand);
             carservice.saveCar(car);
            return "/apis.xhtml?faces-redirect=true";

        }
        catch (NumberFormatException ex) {
            System.out.println("Error : "+ex);
            return ex.toString();
        }
    }

    // Update a Car
    @PostMapping("/car/{id}")
    public Car updateCar(@PathVariable(value = "id") Long carId,
                         @Valid @RequestBody Car carDetails) {

        try {
            Car car = carRepository.findById(carId)
                    .orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));
            brand = brandService.find(car.getBrand().getId());

            car.setBrand(brand);
            car.setYear(carDetails.getYear());
            car.setPrice(carDetails.getPrice());
            car.setColor(carDetails.getColor());
            car.setSoldState(carDetails.isSoldState());

            return carRepository.save(car);
        }
        catch (NumberFormatException ex) {
            System.out.println("Error : "+ex);
            return car;
        }
    }
    // Get a Single Car
    @GetMapping("/car/{id}")
    public Car getCarById(@PathVariable(value = "id") Long carId) {
        return carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));
    }

    // Delete a Car
    @DeleteMapping("/car/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable(value = "id") Long carId) {
        Car car = carRepository.findById(carId)
                .orElseThrow(() -> new ResourceNotFoundException("Car", "id", carId));

        carRepository.delete(car);

        return ResponseEntity.ok().build();
    }

    // Get All Cars
    @GetMapping("/cars")
    public List<Car> getAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public List<Car> getCars() {
        return cars=carRepository.findAll();
    }

    public List<Brand> getBrands() {
        return brands=brandRepository.findAll();
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
