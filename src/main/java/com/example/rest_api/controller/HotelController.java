// src\main\java\com\example\rest_api\controller\HotelController.java

package com.example.rest_api.controller;



import com.example.rest_api.dto.HotelRequest;
import com.example.rest_api.model.Hotel;
import com.example.rest_api.service.HotelService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/hotels")
public class HotelController {

    @Autowired
    private HotelService hotelService;

    @PostMapping("/register")
    public ResponseEntity<Hotel> registerHotel(@Valid @RequestBody HotelRequest hotelRequest) {
        Hotel hotel = hotelService.registerHotel(hotelRequest);
        return ResponseEntity.ok(hotel);
    }
}
