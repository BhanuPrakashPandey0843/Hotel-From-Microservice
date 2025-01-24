// src\main\java\com\example\rest_api\dto\HotelRequest.java
package com.example.rest_api.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class HotelRequest {
    @NotBlank(message = "Hotel name is required")
    private String hotelName;
    
    @NotBlank(message = "Address is required")
    private String address;
    
    @NotBlank(message = "City is required")
    private String city;
    
    @NotBlank(message = "State is required")
    private String state;
    
    @NotBlank(message = "Country is required")
    private String country;
    
    @NotBlank(message = "Postal code is required")
    private String postalCode;
    
    private String landmark;
}
