// src\main\java\com\example\rest_api\repository\HotelRepository.java


package com.example.rest_api.repository;



import com.example.rest_api.model.Hotel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface HotelRepository extends MongoRepository<Hotel, String> {
}

