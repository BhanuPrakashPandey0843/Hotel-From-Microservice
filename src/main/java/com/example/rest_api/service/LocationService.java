// src\main\java\com\example\rest_api\service\LocationService.java
package com.example.rest_api.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.rest_api.dto.LocationDto;
import com.example.rest_api.model.Location;
import com.example.rest_api.model.Location.GMapLocation;
import com.example.rest_api.repository.LocationRepository;

@Service
public class LocationService {

    private final LocationRepository locationRepository;

    public LocationService(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    public void addLocation(LocationDto locationDto) {
        Location location = new Location();
        location.setHotelId(locationDto.getHotelId());
        location.setGmapLocation(new GMapLocation(locationDto.getLatitude(), locationDto.getLongitude()));
        location.setPinCode(locationDto.getPinCode());
        location.setAddress(locationDto.getAddress());
        location.setLandmark(locationDto.getLandmark());
        locationRepository.save(location);
    }

    public List<Location> getLocationsByHotelId(String hotelId) {
        return locationRepository.findByHotelId(hotelId);
    }
}
