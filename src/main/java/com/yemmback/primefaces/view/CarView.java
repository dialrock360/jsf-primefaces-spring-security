package com.yemmback.primefaces.view;


import com.yemmback.primefaces.model.*;
import com.yemmback.primefaces.model.colections.Color;
import com.yemmback.primefaces.repository.BrandRepository;
import com.yemmback.primefaces.repository.CarRepository;
import com.yemmback.primefaces.service.BrandService;
import com.yemmback.primefaces.service.CarService;
import org.primefaces.event.CellEditEvent;
import org.primefaces.event.RowEditEvent;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;


@Named
@RequestScoped
public class CarView  {

    private List<Car> cars1;
    private List<Car> cars2;
    private Car car2;
    private List<String> colors2;
    private Brand brand;
    private List<Brand> brands2;

    private List<Car> filteredCars1;
    private List<Car> filteredCars2;

    private Car car;
    private List<String> colors;
    private List<Hashtable> icolors;
    private String color;
    private Hashtable icolor;

    private Brand brand2;


    private List<Car> cars;
    private List<Brand> brands;
    private List<String> Colors;

    @Inject
    private CarService carservice;
    @Inject
    private BrandService brandService;
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private BrandRepository brandRepository;






    public void onRowEdit(RowEditEvent event) {



        try{
            Car c= (Car) event.getObject();
            long id=(long)c.getId();
            long brand_id=(long)c.getBrand().getId();

            if ((id!=0) && (brand_id!=0)) {
                System.out.println("//-----------------------  SAVE VIEW  ------------------------------------------------//");
                car=carRepository.getOne(id) ;
                brand=brandRepository.getOne(brand_id) ;
                car.setBrand(brand);

                carservice.saveCar(car);

                //int year=car.getYear();long price=car.getPrice();boolean soldState=car.isSoldState();color=car.getColor();

                //System.out.println("update Brand : "+  carRepository.update( id,  year, price , soldState, color, brand.getId()));
                //carRepository.updatebradId(brand_id,id);

                // carRepository.update(id, car.getYear(), car.getPrice(), car.isSoldState(), car.getColor(), brand_id);

                System.out.println("N Car : "+car.toString());



                System.out.println("//-----------------------  SAVE VIEW  ------------------------------------------------//");

                // carRepository.save(car);

                FacesMessage msg = new FacesMessage("Car Edited", car.getBrand().getName());
                FacesContext.getCurrentInstance().addMessage(null, msg);
            }





        }catch(Exception e){
            Car c = (Car) event.getObject();

            System.out.println("//-----------------------  Exception VIEW  ------------------------------------------------//");

            System.out.println("Car : "+c);
            System.out.println("Error : "+e);
            System.out.println("Error Message : "+e.getMessage());

            System.out.println("//-----------------------  Exception VIEW  ------------------------------------------------//");
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage("Error of edition: please contact web master !!!"));
        }
    }

    public void onRowCancel(RowEditEvent event) {
        Car c = (Car) event.getObject();
        FacesMessage msg = new FacesMessage("Edit Cancelled", c.getBrand().getName());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }


    public void onCellEdit(CellEditEvent event) {

        try{

            FacesContext context = FacesContext.getCurrentInstance();
            Car nc = context.getApplication().evaluateExpressionGet(context, "#{car}", Car.class);
            Object oldValue = event.getOldValue();
            Object newValue = event.getNewValue();
            String column_name=event.getColumn().getClientId().split(":")[3];
            String column_Text=event.getColumn().getHeaderText();
            long id=(long)nc.getId();
            long brand_id=(long)nc.getBrand().getId();

            if ((id!=0) && (brand_id!=0)) {
                System.out.println("//-----------------------  SAVE VIEW  ------------------------------------------------//");

                car=carRepository.getOne(id) ;
                brand=brandRepository.getOne(car.getBrand().getId()) ;
                car.setBrand(brand);

                switch(column_name) {
                    case "brand":
                        // code block
                        Brand brand=brandRepository.findByName((String) newValue);
                        car.setBrand(brand);
                        car.getBrand().setId(brand.getId());
                        System.out.println("N Brand : "+brand);

                        break;
                    case "color":
                        // code block
                        String color=(String) newValue;
                        car.setColor(color);
                        break;
                    case "year":
                        // code block
                        car.setYear((Integer) newValue);
                        break;
                    case "price":
                        // code block
                        car.setPrice((Long) newValue);
                        break;
                    case "soldState":
                        // code block
                        car.setSoldState((Boolean) newValue);
                        break;
                    default:
                        // code block
                }

                carservice.saveCar(car);

                //int year=car.getYear();long price=car.getPrice();boolean soldState=car.isSoldState();color=car.getColor();

                //System.out.println("update Brand : "+  carRepository.update( id,  year, price , soldState, color, brand.getId()));
                //carRepository.updatebradId(brand_id,id);

                // carRepository.update(id, car.getYear(), car.getPrice(), car.isSoldState(), car.getColor(), brand_id);

                System.out.println("N Car : "+car.toString());



                // System.out.println("col : "+color+" sol : "+soldState+" px : "+price);
                System.out.println(newValue.getClass().getName());
                System.out.println("//-----------------------  SAVE VIEW  ------------------------------------------------//");

                // carRepository.save(car);
                FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cell "+column_name.toUpperCase()+" : ", "Old:" + oldValue+ ", New:" + newValue);
                context.addMessage(null, msg);
            }





        }catch(Exception e){
            FacesContext context = FacesContext.getCurrentInstance();
            Car nc = context.getApplication().evaluateExpressionGet(context, "#{car}", Car.class);
            System.out.println("//-----------------------  Exception VIEW  ------------------------------------------------//");

            System.out.println(event.getNewValue().getClass().getName());
            System.out.println(event.getNewValue());
            System.out.println("//-----------------------  Exception VIEW  ------------------------------------------------//");

            System.out.println("Car : "+nc);
            System.out.println("Error : "+e);
            System.out.println("Error Message : "+e.getMessage());

            System.out.println("//-----------------------  Exception VIEW  ------------------------------------------------//");
            FacesContext.getCurrentInstance().addMessage("",
                    new FacesMessage("Error of edition: please contact web master !!!"));
        }





    }

    public void savecar() {

        FacesMessage msg = new FacesMessage("Car Created :"+car.toString() );
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }

    public void savebrand() {

        FacesMessage msg = new FacesMessage("Brand Created :"+brand.toString() );
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
    //-----------------------  EDITABLE TABLE ------------------------------------------------//

    //-----------------------  DataTable - Filter ------------------------------------------------//
    public boolean filterByPrice(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim();
        if (filterText == null || filterText.equals("")) {
            return true;
        }

        if (value == null) {
            return false;
        }

        return ((Comparable) value).compareTo(getInteger(filterText)) > 0;
    }

    public boolean globalFilterFunction(Object value, Object filter, Locale locale) {
        String filterText = (filter == null) ? null : filter.toString().trim().toLowerCase();
        if (filterText == null || filterText.equals("")) {
            return true;
        }
        int filterInt = getInteger(filterText);

        Car car = (Car) value;
        return String.valueOf(car.getId()).toLowerCase().contains(filterText)
                || car.getBrand().getName().toLowerCase().contains(filterText)
                || car.getColor().toLowerCase().contains(filterText)
                || (car.isSoldState() ? "sold" : "sale").contains(filterText)
                || car.getYear() < filterInt
                || car.getPrice() < filterInt;
    }

    private int getInteger(String string) {
        try {
            return Integer.valueOf(string);
        }
        catch (NumberFormatException ex) {
            return 0;
        }
    }
    //-----------------------  DataTable - Filter ------------------------------------------------//




    //-----------------------  PRIVATE METHOD ------------------------------------------------//


    private void initcars() {
        System.out.println("//-----------------------  INIT VIEW  ------------------------------------------------//");
        try {

            //System.out.println("//-----------------------  INIT VIEW  ------------------------------------------------//");
            if (brands.isEmpty()) {
                System.out.println("//-----------------------    autoinsertBrands   Exception  ------------------------------------------------//");
                brandService.autoinsertBrands(1);
            }
            if (cars.isEmpty()) {
                System.out.println("//-----------------------    autoinsertCars   Exception  ------------------------------------------------//");

                carservice.autoinsertCars(12);
            }
            //System.out.println("//-----------------------  INIT VIEW  ------------------------------------------------//");
            System.out.println("//-----------------------  INIT VIEW  ------------------------------------------------//");

        }
        catch (NumberFormatException ex) {
            System.out.println("Something went wrong:       "+ex);
        }

    }


           /* if (brands.isEmpty()) {
                autoinsertBrands();
                autoinsertCars();
            }*/
    //}
    //-----------------------  PRIVATE METHOD ------------------------------------------------//




    //-----------------------  GETTER AND SETTER ------------------------------------------------//

    //-----------------------------------------------------------------------------------

    public List<Car> getCars1() {
        return cars1;
    }

    public void setCars1(List<Car> cars1) {
        this.cars1 = cars1;
    }

    public List<Car> getCars2() {
        return cars2;
    }

    public void setCars2(List<Car> cars2) {
        this.cars2 = cars2;
    }

    public Car getCar2() {
        return car2;
    }

    public void setCar2(Car car2) {
        this.car2 = car2;
    }
    public void setColors2(List<String> colors2) {
        this.colors2 = colors2;
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }


    public void setBrands2(List<Brand> brands2) {
        this.brands2 = brands2;
    }

    public CarService getCarservice() {
        return carservice;
    }

    public void setCarservice(CarService carservice) {
        this.carservice = carservice;
    }
    public List<String> getBrands2() {
        return carservice.getBrands2();
    }

    public List<String> getColors2() {
        return carservice.getColors2();
    }

    public List<Car> getFilteredCars1() {
        return filteredCars1;
    }

    public void setFilteredCars1(List<Car> filteredCars1) {
        this.filteredCars1 = filteredCars1;
    }

    public List<Car> getFilteredCars2() {
        return filteredCars2;
    }

    public void setFilteredCars2(List<Car> filteredCars2) {
        this.filteredCars2 = filteredCars2;
    }






    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public BrandService getBrandService() {
        return brandService;
    }

    public void setBrandService(BrandService brandService) {
        this.brandService = brandService;
    }

    public List<Hashtable> getIcolors() {
        return icolors;
    }

    public void setIcolors(List<Hashtable> icolors) {
        this.icolors = icolors;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Hashtable getIcolor() {
        return icolor;
    }

    public void setIcolor(Hashtable icolor) {
        this.icolor = icolor;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public List<Brand> getBrands() {
        return brands;
    }

    public void setBrands(List<Brand> brands) {
        this.brands = brands;
    }


    public Brand getBrand2() {
        return brand2;
    }

    public void setBrand2(Brand brand2) {
        this.brand2 = brand2;
    }

    //-----------------------------------------------------------------------------------



    //-----------------------  GETTER AND SETTER ------------------------------------------------//


    @PostConstruct
    private void init(){
        brand= new Brand(0,carservice.getBrands()[0], carservice.getModels()[0]+String.valueOf(carservice.getRandomYear()));
        brand2= new Brand(0,carservice.getBrands()[0], carservice.getModels()[0]+String.valueOf(carservice.getRandomYear()));
        brands = brandService.lisbrands();
        cars = carRepository.findAll();
        cars2 = carservice.genCars(12);
        initcars();

        colors = Color.listColors();
        icolors = Color.htlistColors();

        cars1 = carservice.genCars(12);
        cars2 =  carservice.genCars(10);
       /*
        cars = carRepository.findAll();
        Colors = carservice.listColors();
        cars2 = carservice.genCars(12);
        car = new Car(0, carservice.getRandomYear(), carservice.getRandomPrice(), carservice.getRandomSoldState() , brand,0);
        */

    }












    private String firstname;
    private String lastname;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void save() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Welcome " + firstname + " " + lastname));
    }
}