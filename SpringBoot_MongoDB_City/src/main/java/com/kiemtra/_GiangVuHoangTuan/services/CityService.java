package com.kiemtra._GiangVuHoangTuan.services;

import com.kiemtra._GiangVuHoangTuan.models.City;
import com.kiemtra._GiangVuHoangTuan.models.District;
import com.kiemtra._GiangVuHoangTuan.repositories.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {
    private final CityRepository cityRepository;

    @Autowired
    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<City> findAllCities() {
        return cityRepository.findAll();
    }

    public City findCityById(String id) {
        return cityRepository.findById(id).get();
    }

    // 1)  Liệt kê các quận thuộc về một thành phố
    public List<District> findAllDistrictInCity (String cityId) {
        City city = findCityById(cityId);
        return city.getDistrictList();
    }

    // 2)  Tìm tên thành phố khi biết tên quận
    public String findCityNameByDistrictName(String districtName) {
        City city = cityRepository.findFirstCityByDistrictList_Name(districtName);
        return city.getName();
    }

    // 3)  Liệt kê các thành phố có dân số (population) trong một khoảng nào đó
    public List<City> findCitiesByPopulationBetween(int minPopulation, int maxPopulation) {
        return cityRepository.findCitiesByPopulationBetween(minPopulation, maxPopulation);
    }

    public City createCity(City city) {
        return cityRepository.save(city);
    }

    public City updateCity(String id, City city){
        City cityToBeUpdated = findCityById(id);

        cityToBeUpdated.setName(city.getName());
        cityToBeUpdated.setPopulation(city.getPopulation());
        cityToBeUpdated.setDistrictList(city.getDistrictList());

        return cityRepository.save(cityToBeUpdated);
    }

    public void deleteCity(String id){
        cityRepository.deleteById(id);
    }


}
