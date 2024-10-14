package org.hotel_service.Services;

import org.hotel_service.Entities.Hotel;
import org.hotel_service.Exception.ResourceNotFoundException;
import org.hotel_service.Repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService{
    @Autowired
    private HotelRepository hotelRepository;
    @Override
    public Hotel create(Hotel hotel) {
        // Hotel ki random id generate kr rahe hain...
        String hotelId = UUID.randomUUID().toString();
        hotel.setId(hotelId);

        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAllHotels() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Hotel with given id not found.")
        );
    }
}
