// src\main\java\com\example\rest_api\dto\AmenityDto.java

package com.example.rest_api.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class AmenityDto {
    @NotBlank
    private String hotelId;

    @NotBlank
    private String amenityName;
}
