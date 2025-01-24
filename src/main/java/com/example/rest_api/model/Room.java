// src\main\java\com\example\rest_api\model\Room.java

package com.example.rest_api.model;



import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "rooms")
public class Room {
    @Id
    private String id;
    private String hotelId;
    private String roomType;
    private String priceRange;
    private int numberOfRooms;
    private String[] amenities;
    private String description;
}
