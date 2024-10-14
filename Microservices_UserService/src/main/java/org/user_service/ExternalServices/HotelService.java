package org.user_service.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.user_service.Entities.Hotel;

@FeignClient(name = "HOTEL-SERVICE")
public interface HotelService {
    @GetMapping("/hotels/{hotelId}")
     Hotel getHotel(@PathVariable String hotelId);
}
