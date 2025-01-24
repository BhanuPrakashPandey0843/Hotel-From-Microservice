// src\main\java\com\example\rest_api\repository\RoomRepository.java

package com.example.rest_api.repository;



import com.example.rest_api.model.Room;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface RoomRepository extends MongoRepository<Room, String> {
}
