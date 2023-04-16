package com.kiemtra._GiangVuHoangTuan.runner;

import com.kiemtra._GiangVuHoangTuan.models.City;
import com.kiemtra._GiangVuHoangTuan.models.District;
import com.kiemtra._GiangVuHoangTuan.services.CityService;
import com.kiemtra._GiangVuHoangTuan.services.DistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ApplicationRunner implements CommandLineRunner {
    private final CityService cityService;
    private final DistrictService districtService;

    @Autowired
    public ApplicationRunner(CityService cityService, DistrictService districtService) {
        this.cityService = cityService;
        this.districtService = districtService;
    }

    @Override
    public void run(String... args) throws Exception {
        // Create district 1
        District newDistrict1 = new District("1", "Tan Binh District", 100);
        districtService.createDistrict(newDistrict1);

        // Create district 2
        District newDistrict2 = new District("2", "Go Vap District", 200);
        districtService.createDistrict(newDistrict2);

        // Create city 1
        List<District> districtList = new ArrayList<District>();
        districtList.add(newDistrict1);
        districtList.add(newDistrict2);

        cityService.createCity(new City("1", 1000, "HCM", districtList));

        // Create city 2
        cityService.createCity(new City("2", 500, "Ha Noi"));

        // List districts
        System.out.println(districtService.findAllDistricts().toString());

        // List cities
        System.out.println(cityService.findAllCities().toString());

        // 1)  Liệt kê các quận thuộc về một thành phố
        System.out.println("\nCau 1: " + cityService.findAllDistrictInCity("1"));

        // 2)  Tìm tên thành phố khi biết tên quận
        System.out.println("Cau 2: " + cityService.findCityNameByDistrictName("Tan Binh District"));

        // 3) Liệt kê các thành phố có dân số (population) trong một khoảng nào đó
        System.out.println("Cau 3: " + cityService.findCitiesByPopulationBetween(100, 2000));

        // Update district
        System.out.println();

        District updateDistrict = new District();
        updateDistrict.setName("District 10");
        updateDistrict.setPopulation(1000);

        District newDistrict = districtService.updateDistrict("2", updateDistrict);
        System.out.println(newDistrict);

        // List districts again
        System.out.println(districtService.findAllDistricts().toString());
    }
}