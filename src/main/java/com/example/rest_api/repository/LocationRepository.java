// src\main\java\com\example\rest_api\repository\LocationRepository.java
package com.example.rest_api.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.rest_api.model.Location;

@Repository
public interface LocationRepository extends MongoRepository<Location, String> {
    List<Location> findByHotelId(String hotelId);
}
