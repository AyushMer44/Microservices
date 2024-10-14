package org.user_service.ExternalServices;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.user_service.Entities.Rating;

@Service
@FeignClient(name = "RATING-SERVICE")
public interface RatingService {
    // GET
    // POST
    @PostMapping("/ratings")
    ResponseEntity<Rating> createRating(Rating values);

    //PUT
    @PutMapping("/ratings/{ratingId}")
    ResponseEntity<Rating> updateRating(@PathVariable String ratingId, Rating rating);

    // Ye API or handler present nhi h... ye aise hi bna diya h...
    //DELETE
    @DeleteMapping("/ratings/{ratingId}")
    public void deleteRating(@PathVariable String ratingId);
}
