package com.codenotfound.primefaces.service;

import com.primestap.primefaces.model.Brand;
import com.primestap.primefaces.model.Car;
import com.primestap.primefaces.model.colections.Color;
import com.primestap.primefaces.repository.BrandRepository;
import com.primestap.primefaces.repository.CarRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class CarService {


    @Autowired
    private CarRepository carRepository;

    @Autowired
    private BrandRepository brandRepository;

    private static final Logger logger = LoggerFactory.getLogger(com.primestap.primefaces.service.CarService.class);

    private List<Car> cars;
    private  final   String[] brands={"Volvo", "BMW", "Ford", "Mazda","Renault","Mercedes","Fiat","Volkswagen","Honda","Jaguar","Ford","Audi","Toyota"};
    private final     String[] colors ={"Black", "White", "Green", "Red","Blue","Orange","Silver","Yellow","Brown","Maroon","Indigo","Dark blue","Gold"};
    private final     String[] Models = {"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"};


    public    Car  car ;


    public     List<Car> genCars(int number ) {
        List<Car> list = new ArrayList<Car>();
        Random rand = new Random();
        for(int i = 1 ; i <= number ; i++) {
            int n=rand.nextInt(number);
            Brand brand= new Brand(i, brands[n], Models[n]+String.valueOf(n));
            this.car = new Car(i, this.getRandomYear(), this.getRandomPrice(), this.getRandomSoldState() , brand,n);
            list.add(this.car);
        }

        this.cars = list;
        return list;
    }


    public   String getRandomId() { return UUID.randomUUID().toString().substring(0, 8);}
    public   int getRandomYear() { return (int) (Math.random() * 50 + 1960); }
    public   int getRandomPrice() { return (int) (Math.random() * 100000); }
    public   boolean getRandomSoldState() { return Math.random() > 0.5; }





    public Car find(long id) {
        car = new Car();
        for(Car c: cars) {
            if (c.getId()==id){
                car=c;
                break;
            }
        }
        return car;
    }

    public List<Car> getCars() {
        return cars=carRepository.findAll();
    }


    public void edit(Car c) {
        int i = 0;
        List<Car> list =  cars;
        for(Car car: list) {
            if (car.getId()==car.getId()){
                this.cars.get(i).setBrand(c.getBrand());
                this.cars.get(i).setColor(c.getColor());
                this.cars.get(i).setPrice(c.getPrice());
                this.cars.get(i).setYear(c.getYear());
                break;
            }
            i+=i;
        }
    }

    public String[] getBrands() {
        return brands;
    }

    public String[] getColors() {
        return colors;
    }

    public String[] getModels() {
        return Models;
    }


    public List<String> listColors() {

        List<String> icolors = new ArrayList<String>();
        for (Color color : Color.values()) {
            icolors.add(color.name());
        }
        return icolors;
    }
    public List<Hashtable> ilistColors() {

        List<Hashtable> icolors = new ArrayList<Hashtable>();
        int i=1;
        for (Color color : Color.values()) {
            Hashtable cl = new Hashtable();
            cl.put("id", String.valueOf(i));
            cl.put("name", color);
            icolors.add(cl);
            i+=i;
        }
        return icolors;
    }


    public Car saveCar(Car carRequest) {
        Car car = new Car();
        car.setId(carRequest.getId());
        car.setBrand(carRequest.getBrand());
        car.setColor(carRequest.getColor());
        car.setPrice(carRequest.getPrice());
        car.setYear(carRequest.getYear());
        car.setSoldState(carRequest.isSoldState());
        return carRepository.save(car);
    }


    public   void autoinsertCars(int i) {
            Random rand = new Random();
         if (i>0) {
            int n=rand.nextInt(12);
            Brand  brand=new Brand();
            brand.setId((long) i);
            //Brand  brand=brandRepository.getOne((long) i);
            System.out.println("//-----------------------  INIT Car  ------------------------------------------------//");
            car = new Car(getRandomYear(), getRandomPrice(), getRandomSoldState() , brand,n);
            System.out.println("Brand : "+brand.toString() );
            System.out.println("Car : "+car.toString() );
            saveCar(car);
            //carRepository.save(car);
            cars.add(car);
            System.out.println("//-----------------------  INIT Car  ------------------------------------------------//");
            autoinsertCars(i-1);
        }

    }


    public List<Car> lisCars() {
        return cars=carRepository.findAll();
    }
    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

/*
    private void autoinsertCars(int i) {
        try {
            Random rand = new Random();
            if (i>0) {
                int n=rand.nextInt(12);
                brand=brandRepository.getOne((long) i);
                System.out.println("//-----------------------  INIT Car  ------------------------------------------------//");
                car = new Car(carservice.getRandomYear(), carservice.getRandomPrice(), carservice.getRandomSoldState() , brand,n);
                System.out.println("Brand : "+brand.toString() );
                System.out.println("Car : "+car.toString() );
                carRepository.save(car);
                cars.add(car);
                System.out.println("//-----------------------  INIT Car  ------------------------------------------------//");
                autoinsertCars(i-1);
            }
        } catch (Exception e) {
            System.out.println("Something went wrong:       "+e);
        }


    }
*/
   /* private void autoinsertBrands(int i) {
        Random rand = new Random();
        if (i<=12) {
            int n=rand.nextInt(1000);
            brand= new Brand(i, BrandService.getLbrands()[i], BrandService.getLeters()[i]+String.valueOf(n), BrandService.getLbrands()[i]);
            System.out.println("Brand : "+brand.toString() );
            brandRepository.save(brand);
            brands.add(brand);
            autoinsertBrands(i+1);
        }

    }*/
public List<String> getColors2() {
    return Arrays.asList(colors);
}

    public List<String> getBrands2() {
        return Arrays.asList(brands);
    }


}
