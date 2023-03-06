package com.thuchanh.demotuan2.model;

import jakarta.persistence.*;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String description;

    @ManyToOne(optional = false)
    private Manufacturer manufacturer;

    public Manufacturer getManufacturers() {
        return manufacturer;
    }

    public void setManufacturers(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Product() {
    }

    public Product(int id, String name, String description, Manufacturer manufacturer) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }

    public Product(String name, String description, Manufacturer manufacturer) {
        this.name = name;
        this.description = description;
        this.manufacturer = manufacturer;
    }
}
