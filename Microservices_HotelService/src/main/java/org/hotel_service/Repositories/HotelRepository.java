package org.hotel_service.Repositories;

import org.hotel_service.Entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel,String> {
    // JPARepository<Kis entity ke saath kaam krna h,Uski id ka data type>
}
