
//E:\01 Travifai\rest-api\src\main\java\com\example\rest_api\repository\AmenityRepository.java
package com.example.rest_api.repository;

import com.example.rest_api.model.Amenity;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AmenityRepository extends MongoRepository<Amenity, String> {
    List<Amenity> findByHotelId(String hotelId);
}
