package com.kiemtra._GiangVuHoangTuan.repositories;

import com.kiemtra._GiangVuHoangTuan.models.District;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface DistrictRepository extends MongoRepository<District, String> {
}
