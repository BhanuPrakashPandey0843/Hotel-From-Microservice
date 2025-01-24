// src\main\java\com\example\rest_api\dto\LocationRequest.java
package com.example.rest_api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class LocationDto {
    @NotBlank
    private String hotelId;

    @NotNull
    private Double latitude;

    @NotNull
    private Double longitude;

    @NotBlank
    private String pinCode;

    @NotBlank
    private String address;

    private String landmark; // Optional
}


