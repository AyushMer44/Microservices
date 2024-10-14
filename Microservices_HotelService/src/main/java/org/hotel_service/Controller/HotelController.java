package org.hotel_service.Controller;

import org.hotel_service.Entities.Hotel;
import org.hotel_service.Services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    // Hum 3 api banayenge create,getSingleHotel and getAllHotels

    // create
//    @PreAuthorize("hasAuthority('Admin')")
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    // get single
//    @PreAuthorize("hasAuthority('SCOPE_internal')") // koi isse direct acces na kr paaye...only through gateway with okta security...
    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotelById(hotelId));
    }

    // get all
//    @PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAllHotels());
    }
}
