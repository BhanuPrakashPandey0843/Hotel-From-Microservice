// src\main\java\com\example\rest_api\dto\MediaDTO.java

package com.example.rest_api.dto;



import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class MediaDTO {
    private String hotelId;
    private MultipartFile file; // File uploaded by the user
}


