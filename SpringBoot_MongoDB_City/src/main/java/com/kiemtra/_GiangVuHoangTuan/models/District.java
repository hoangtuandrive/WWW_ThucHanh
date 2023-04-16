package com.kiemtra._GiangVuHoangTuan.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class District {
    @Id
    private String id;
    private String name;
    private long population;

    public District() {
    }

    public District(String id, String name, long population) {
        this.id = id;
        this.name = name;
        this.population = population;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    @Override
    public String toString() {
        return "District{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", population=" + population +
                '}';
    }
}
