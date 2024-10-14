package org.rating_service.Repository;

import org.rating_service.Entities.Rating;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RatingRepository extends MongoRepository<Rating,String > {
    // custom finder methods...

    List<Rating> findByUserId(String userId); // method ka naam colum ke naam se match hona chahiye in camelcase and argument also...
    List<Rating> findByHotelId(String hotelId);// same as above...
}
