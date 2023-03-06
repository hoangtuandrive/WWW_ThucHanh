package com.thuchanh.demotuan2.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Manufacturer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String contactName;

    private String contactEmail;

    private String contactPhone;

    private String website;

    @OneToMany(mappedBy = "manufacturer")
    private List<Product> products;

    public Manufacturer() {
    }

    public Manufacturer(int id, String name, String contactName, String contactEmail, String contactPhone, String website, List<Product> products) {
        this.id = id;
        this.name = name;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.website = website;
        this.products = products;
    }

    public Manufacturer(String name, String contactName, String contactEmail, String contactPhone, String website) {
        this.name = name;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.website = website;
    }

    public Manufacturer(int id, String name, String contactName, String contactEmail, String contactPhone, String website) {
        this.id = id;
        this.name = name;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
        this.contactPhone = contactPhone;
        this.website = website;
    }
}
