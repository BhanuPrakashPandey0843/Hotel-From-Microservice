// src\main\java\com\example\rest_api\controller\RoomController.java

package com.example.rest_api.controller;



import com.example.rest_api.dto.RoomDTO;
import com.example.rest_api.model.Room;
import com.example.rest_api.service.RoomService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/rooms")
@RequiredArgsConstructor
public class RoomController {
    private final RoomService roomService;

    @PostMapping("/add")
    public ResponseEntity<Room> addRoom(@Validated @RequestBody RoomDTO roomDTO) {
        Room savedRoom = roomService.saveRoom(roomDTO);
        return ResponseEntity.ok(savedRoom);
    }
}
