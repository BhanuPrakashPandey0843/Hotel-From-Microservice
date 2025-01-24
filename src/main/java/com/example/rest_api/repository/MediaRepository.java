// src\main\java\com\example\rest_api\repository\MediaRepository.java
package com.example.rest_api.repository;


import com.example.rest_api.model.Media;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MediaRepository extends MongoRepository<Media, String> {
}
