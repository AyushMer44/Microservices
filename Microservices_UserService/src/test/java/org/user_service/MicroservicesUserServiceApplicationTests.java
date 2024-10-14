package org.user_service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.user_service.Entities.Rating;
import org.user_service.ExternalServices.RatingService;

@SpringBootTest
class MicroservicesUserServiceApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private RatingService ratingService;

//    @Test
//    void createRating(){
//        Rating rating = Rating.builder().rating("10").userId("").hotelId("").feedback("This is created using feign client").build();
//        ResponseEntity<Rating> ratingResponseEntity = ratingService.createRating(rating);
//        ratingResponseEntity.getStatusCode();
//
//        System.out.println("New rating created...");
//    }

}
