package com.example.rest_api.controller;

import com.example.rest_api.dto.AmenityDto;
import com.example.rest_api.model.Amenity;
import com.example.rest_api.service.AmenityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/amenities")
public class AmenityController {

    private final AmenityService amenityService;

    public AmenityController(AmenityService amenityService) {
        this.amenityService = amenityService;
    }

    // Add a new amenity
    @PostMapping
    public ResponseEntity<String> addAmenity(@RequestBody AmenityDto amenityDto) {
        amenityService.addAmenity(amenityDto);
        return ResponseEntity.ok("Amenity added successfully");
    }

    // Get all amenities
    @GetMapping
    public ResponseEntity<List<Amenity>> getAllAmenities() {
        return ResponseEntity.ok(amenityService.getAllAmenities());
    }

    // Get amenities for a specific hotel
    @GetMapping("/{hotelId}")
    public ResponseEntity<List<Amenity>> getAmenitiesByHotelId(@PathVariable String hotelId) {
        return ResponseEntity.ok(amenityService.getAmenitiesByHotelId(hotelId));
    }
}
