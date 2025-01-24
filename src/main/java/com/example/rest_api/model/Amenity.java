package com.example.rest_api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "amenities")
public class Amenity {
    @Id
    private String id;
    private String hotelId;
    private String amenityName;
}
