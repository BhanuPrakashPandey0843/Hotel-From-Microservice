// src\main\java\com\example\rest_api\controller\LocationController.java


package com.example.rest_api.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.rest_api.dto.LocationDto;
import com.example.rest_api.model.Location;
import com.example.rest_api.service.LocationService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/locations")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostMapping
    public ResponseEntity<String> addLocation(@RequestBody @Valid LocationDto locationDto) {
        locationService.addLocation(locationDto);
        return ResponseEntity.ok("Location added successfully");
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<List<Location>> getLocations(@PathVariable String hotelId) {
        return ResponseEntity.ok(locationService.getLocationsByHotelId(hotelId));
    }
}
