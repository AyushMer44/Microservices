package org.hotel_service.Services;

import org.hotel_service.Entities.Hotel;

import java.util.List;

public interface HotelService {
    // create
    Hotel create(Hotel hotel);

    // getAllHotels
    List<Hotel> getAllHotels();

    // getSingleHotelById
    Hotel getHotelById(String id);
}
