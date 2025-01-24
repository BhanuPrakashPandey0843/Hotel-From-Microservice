// src\main\java\com\example\rest_api\model\Hotel.java

package com.example.rest_api.model;



import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "hotels")
public class Hotel {
    @Id
    private String id;
    private String hotelName;
    private String address;
    private String city;
    private String state;
    private String country;
    private String postalCode;
    private String landmark;
}




