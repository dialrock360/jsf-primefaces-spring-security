package com.yemmback.primefaces.service;

import com.yemmback.primefaces.model.Brand;
import com.yemmback.primefaces.repository.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Named
@ApplicationScoped
public class BrandService {

    private  final static String[] lbrands={"Volvo", "BMW", "Ford", "Mazda","Renault","Mercedes","Fiat","Volkswagen","Honda","Jaguar","Cadillac","Audi","Toyota"};

    private final   static String[] leters = {"M", "S", "V", "K", "D", "J", "B", "A", "E", "H", "L", "P", "M"};
    private static List<Brand> brands;

    @Autowired
    private BrandRepository brandRepository;

    private Brand  brand;

    public static   List<Brand> autogenBrands() {

        List<Brand> list = new ArrayList<Brand>();
        Random rand = new Random();
        for(int i = 1 ; i <= 12 ; i++) {
            Brand brand= new Brand(i, lbrands[i], leters[i]+String.valueOf(i), lbrands[i]);
            list.add(brand);
        }

        brands = list;
        return list;
    }

    public List<Brand> lisbrands() {
        return brands=brandRepository.findAll();
    }
    public static String[] getLbrands() {
        return lbrands;
    }

    public static String[] getLeters() {
        return leters;
    }

    public static List<Brand> getBrands() {
        return brands;
    }
    public   void autoinsertBrands(int i) {
        Random rand = new Random();
        if (i<=12) {
            int n=rand.nextInt(1000);
           Brand brand= new Brand(i, BrandService.getLbrands()[i], BrandService.getLeters()[i]+String.valueOf(n), BrandService.getLbrands()[i]);
            System.out.println("Brand : "+brand.toString() );
            brandRepository.save(brand);
            brands.add(brand);
            autoinsertBrands(i+1);
        }

    }

    public Brand find(long id) {
        brand = new Brand();
        for(Brand c: brands) {
            if (c.getId()==id){
                brand=c;
                break;
            }
        }
        return brand;
    }


}
