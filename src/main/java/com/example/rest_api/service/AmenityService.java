// src\main\java\com\example\rest_api\service\AmenityService.java

package com.example.rest_api.service;

import com.example.rest_api.dto.AmenityDto;
import com.example.rest_api.model.Amenity;
import com.example.rest_api.repository.AmenityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AmenityService {

    private final AmenityRepository amenityRepository;

    public AmenityService(AmenityRepository amenityRepository) {
        this.amenityRepository = amenityRepository;
    }

    // Add a new amenity
    public void addAmenity(AmenityDto amenityDto) {
        Amenity amenity = new Amenity();
        amenity.setHotelId(amenityDto.getHotelId());
        amenity.setAmenityName(amenityDto.getAmenityName());
        amenityRepository.save(amenity);
    }

    // Get all amenities
    public List<Amenity> getAllAmenities() {
        return amenityRepository.findAll();
    }

    // Get amenities by hotel ID
    public List<Amenity> getAmenitiesByHotelId(String hotelId) {
        return amenityRepository.findByHotelId(hotelId);
    }
}
