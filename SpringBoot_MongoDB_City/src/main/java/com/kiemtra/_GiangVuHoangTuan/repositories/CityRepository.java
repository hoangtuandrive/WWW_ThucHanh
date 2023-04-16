package com.kiemtra._GiangVuHoangTuan.repositories;

import com.kiemtra._GiangVuHoangTuan.models.City;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CityRepository extends MongoRepository<City, String> {
    // 1)  Liệt kê các quận thuộc về một thành phố --> ở CityService.findAllDistrictInCity();

    // 2)  Tìm tên thành phố khi biết tên quận
    City findFirstCityByDistrictList_Name(String districtName);

    // 3)  Liệt kê các thành phố có dân số (population) trong một khoảng nào đó
    List<City> findCitiesByPopulationBetween(int minPopulation, int maxPopulation);
}
