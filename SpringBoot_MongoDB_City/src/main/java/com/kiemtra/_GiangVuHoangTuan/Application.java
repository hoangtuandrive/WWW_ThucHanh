package com.kiemtra._GiangVuHoangTuan;

import com.kiemtra._GiangVuHoangTuan.models.City;
import com.kiemtra._GiangVuHoangTuan.models.District;
import com.kiemtra._GiangVuHoangTuan.services.CityService;
import com.kiemtra._GiangVuHoangTuan.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
