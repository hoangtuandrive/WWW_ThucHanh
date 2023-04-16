package com.kiemtra._GiangVuHoangTuan.services;

import com.kiemtra._GiangVuHoangTuan.models.District;
import com.kiemtra._GiangVuHoangTuan.repositories.DistrictRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DistrictService {
    private final DistrictRepository districtRepository;

    @Autowired
    public DistrictService(DistrictRepository districtRepository) {
        this.districtRepository = districtRepository;
    }

    public List<District> findAllDistricts(){
        return districtRepository.findAll();
    }

    public District findDistrictById(String id) {
        return districtRepository.findById(id).get();
    }

    public District createDistrict(District district) {
        return districtRepository.save(district);
    }

    public District updateDistrict(String id, District district) {
        District districtToBeUpdated = findDistrictById(id);

        districtToBeUpdated.setName(district.getName());
        districtToBeUpdated.setPopulation(district.getPopulation());

        return districtRepository.save(districtToBeUpdated);
    }

    public void deleteDistrict(String id) {
        districtRepository.deleteById(id);
    }
}
