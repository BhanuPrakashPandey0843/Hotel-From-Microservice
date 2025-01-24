// src\main\java\com\example\rest_api\dto\RoomDTO.java

package com.example.rest_api.dto;


import lombok.Data;

@Data
public class RoomDTO {
    private String hotelId;
    private String roomType;
    private String priceRange;
    private int numberOfRooms;
    private String[] amenities;
    private String description;
}
