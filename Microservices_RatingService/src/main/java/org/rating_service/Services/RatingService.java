package org.rating_service.Services;

import org.rating_service.Entities.Rating;

import java.util.List;

public interface RatingService {
    // create
    Rating create(Rating rating);

    // getAllRatings
    List<Rating> getAllRatings();

    // getRatingsById
    List<Rating> getRatingsByUserId(String userId);

    // getRatingsByHotelId
    List<Rating> getRatingsByHotelId(String hotelId);
}
