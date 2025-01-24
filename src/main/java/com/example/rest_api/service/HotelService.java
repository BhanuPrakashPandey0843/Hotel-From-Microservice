// src\main\java\com\example\rest_api\service\HotelService.java

package com.example.rest_api.service;



import com.example.rest_api.dto.HotelRequest;
import com.example.rest_api.model.Hotel;
import com.example.rest_api.repository.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HotelService {

    @Autowired
    private HotelRepository hotelRepository;

    public Hotel registerHotel(HotelRequest hotelRequest) {
        Hotel hotel = new Hotel();
        hotel.setHotelName(hotelRequest.getHotelName());
        hotel.setAddress(hotelRequest.getAddress());
        hotel.setCity(hotelRequest.getCity());
        hotel.setState(hotelRequest.getState());
        hotel.setCountry(hotelRequest.getCountry());
        hotel.setPostalCode(hotelRequest.getPostalCode());
        hotel.setLandmark(hotelRequest.getLandmark());
        return hotelRepository.save(hotel);
    }
}
