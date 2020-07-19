package com.yemmback.primefaces.model;


import com.yemmback.primefaces.model.colections.Color;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "cars")
public class Car  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private   int  year;
    private   long  price;
    private   boolean soldState;

/*

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="brand_id")
    @Column(insertable=false, updatable=false)
    private Brand brand;
   */
    private String color;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "brand_id", nullable = false)
    private Brand brand;

    public Car() {
    }

    public Car(long id, int year, long price, boolean soldState, String color, Brand brand) {
        this.id = id;
        this.year = year;
        this.price = price;
        this.soldState = soldState;
        this.color = color;
        this.brand = brand;
    }

    public Car(long id, int year, long price, boolean soldState, Brand brand,int n) {
        this.id = id;
        this.year = year;
        this.price = price;
        this.soldState = soldState;
        this.color = Color.getvalueByindex(n);
       // this.color = Color.values()[n];
        this.brand = brand;
    }

    public Car(int year, long price, boolean soldState, Brand brand,int n) {
        this.id = 0;
        this.year = year;
        this.price = price;
        this.soldState = soldState;
        this.color = Color.getvalueByindex(n);
        this.brand = brand;
        // this.color = Color.values()[n];        this.brand = brand;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public boolean isSoldState() {
        return soldState;
    }

    public void setSoldState(boolean soldState) {
        this.soldState = soldState;
    }

    public String getColor() {
        return color;
    }

    public int getColorbyname(String name) {
        return Color.valueOf(name).ordinal();
    }
    public void setColorbyname(String name) {
        this.color =  Color.getcolorByname(name);
    }

    public void setColor(String color) {
        this.color = Color.getcolorByname(color);
    }

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    public List<String> getStaticBrands(String[] brands) { return Arrays.asList(brands); }
    public List<String> getStaticColors(String[] colors) { return Arrays.asList(colors); }

    public String getRandomColor(int key,String[] colors) { return colors[key]; }
    public String getRandomBrand(int key, String[] brands) { return brands[key]; }



    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", year=" + year +
                ", price=" + price +
                ", soldState=" + soldState +
                ", color=" + color +
                ", brand=" + brand +
                '}';
    }


}
