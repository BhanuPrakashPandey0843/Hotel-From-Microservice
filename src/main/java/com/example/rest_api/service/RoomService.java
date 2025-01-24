// src\main\java\com\example\rest_api\service\RoomService.java

package com.example.rest_api.service;



import com.example.rest_api.dto.RoomDTO;
//import com.example.rest_api.exception.ResourceNotFoundException;
import com.example.rest_api.model.Room;
import com.example.rest_api.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoomService {
    private final RoomRepository roomRepository;

    public Room saveRoom(RoomDTO roomDTO) {
        Room room = new Room();
        room.setHotelId(roomDTO.getHotelId());
        room.setRoomType(roomDTO.getRoomType());
        room.setPriceRange(roomDTO.getPriceRange());
        room.setNumberOfRooms(roomDTO.getNumberOfRooms());
        room.setAmenities(roomDTO.getAmenities());
        room.setDescription(roomDTO.getDescription());
        return roomRepository.save(room);
    }
}
