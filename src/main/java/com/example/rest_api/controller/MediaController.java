// src\main\java\com\example\rest_api\controller\MediaController.java

package com.example.rest_api.controller;

import com.example.rest_api.dto.MediaDTO;
import com.example.rest_api.model.Media;
import com.example.rest_api.service.MediaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/media")
@RequiredArgsConstructor
public class MediaController {

    private final MediaService mediaService;

    @PostMapping("/upload")
    public ResponseEntity<?> uploadMedia(
            @RequestParam(name = "hotelId") String hotelId, 
            @RequestParam(name = "file") MultipartFile file 
    ) {
        try {
            if (hotelId == null || hotelId.isEmpty()) {
                return ResponseEntity.badRequest().body("Hotel ID is required");
            }

            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("File must not be empty");
            }

            // Populate MediaDTO and save the media
            MediaDTO mediaDTO = new MediaDTO();
            mediaDTO.setHotelId(hotelId);
            mediaDTO.setFile(file);

            Media savedMedia = mediaService.saveMedia(mediaDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedMedia);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }
}
