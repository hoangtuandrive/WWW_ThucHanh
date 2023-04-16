package com.kiemtra._GiangVuHoangTuan.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
public class City {
    @Id
    private String id;
    private long population;
    private String name;
    private List<District> districtList;

    public City() {
        districtList = new ArrayList<>();
    }

    public City(String id, long population, String name) {
        this.id = id;
        this.population = population;
        this.name = name;
        this.districtList = new ArrayList<>();
    }

    public City(String id, long population, String name, List<District> districtList) {
        this.id = id;
        this.population = population;
        this.name = name;
        this.districtList = districtList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(List<District> districtList) {
        this.districtList = districtList;
    }

    @Override
    public String toString() {
        return "City{" +
                "id='" + id + '\'' +
                ", population='" + population + '\'' +
                ", name='" + name + '\'' +
                ", districtList=" + districtList +
                '}';
    }
}
