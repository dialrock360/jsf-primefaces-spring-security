package com.yemmback.primefaces.model;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "brands")
public class Brand implements Serializable {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        @Column(length = 20,unique = true)
        private String name;
        @Column(length = 20)
        private String model;

        @Column(length = 100,unique = true)
        private String displayName;


        @OneToMany(
                mappedBy = "brand",
                cascade = CascadeType.ALL,
                fetch = FetchType.EAGER,
                orphanRemoval = true
        )
        @Fetch(FetchMode.SELECT)
        private List<Car> cars = new ArrayList<>();

        public Brand() {
        }

        public Brand(long id, String name, String model) {
                this.id = id;
                this.name = name;
                this.model = model;
        }

        public Brand(long id, String name, String model, String displayName) {
                this.id = id;
                this.name = name;
                this.model = model;
                this.displayName = displayName;
        }

        public Brand(String name, String model, String displayName) {
                this.name = name;
                this.model = model;
                this.displayName = displayName;
        }

        public Brand(String brand, String s) {
        }

        public Brand(long id, String name, String model, String displayName, List<Car> cars) {
                this.id = id;
                this.name = name;
                this.model = model;
                this.displayName = displayName;
                this.cars = cars;
        }

        public List<Car> getCars() {
                return cars;
        }

        public void setCars(List<Car> cars) {
                this.cars = cars;
        }

        public long getId() {
                return id;
        }

        public void setId(long id) {
                this.id = id;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public String getModel() {
                return model;
        }

        public void setModel(String model) {
                this.model = model;
        }

        public String getDisplayName() {
                return displayName;
        }

        public void setDisplayName(String displayName) {
                this.displayName = displayName;
        }

        @Override
        public String toString() {
                return "Brand{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", model='" + model + '\'' +
                        ", displayName='" + displayName + '\'' +
                        '}';
        }
}
