package org.user_service.Services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.user_service.Entities.Hotel;
import org.user_service.Entities.Rating;
import org.user_service.Entities.User;
import org.user_service.Exception.ResourceNotFoundException;
import org.user_service.ExternalServices.HotelService;
import org.user_service.Repositories.UserRepository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService{
    // Agr hum kisi interface ko implement kr rhe hain toh hume uss
    // interface ke saare methods ko override krna pdega yaha...

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {
        String randomUserId = UUID.randomUUID().toString(); // We are generating unique id.
        user.setUserId(randomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {

        List<User> users = userRepository.findAll();

        // fetching ratings of above users from RatingService...

//        ArrayList<Rating> ratingsOfUsers = restTemplate.getForObject("http://localhost:8082/ratings/users",ArrayList.class);
//        logger.info("{}",ratingsOfUsers);
//
//        users.forEach(user -> user.setRatings(ratingsOfUsers));

        users.forEach(user -> {
            ArrayList<Rating> ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(),ArrayList.class);
            user.setRatings(ratings);
        });

        return users;
    }

    @Override
    public User getUser(String userId) {

        // getting user from database...
        User user = userRepository.findById(userId).orElseThrow(
                () -> new ResourceNotFoundException("User with given id is not found on server ! : "+userId)
        );

        // fetching rating of the above user from RatingService...

        // http://localhost:8082/ratings/users/{userId}

        // Hum rating ko doosre server/API se nikal rhe hain i.e RatingServer se...
        logger.info("Yaha tak chl raha h...");

        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserId(), Rating[].class);//direct +userId bhi use kr skte hain...
        logger.info("{}",ratingsOfUser);

        List<Rating> ratings = Arrays.stream(ratingsOfUser).toList();

        List<Rating> ratingList = ratings.stream().map(rating -> {
            // api call to hotel service to get the hotel
            //http://localhost:8081/hotels/d5fb99d0-169a-43a7-968e-4fbfc304c6a9

//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();
//            logger.info("Response Status code: {}",forEntity.getStatusCode());

            // This is done using Feign client...
            Hotel hotel = hotelService.getHotel(rating.getHotelId());

            // set the hotel to rating
            rating.setHotel(hotel);

            // return the rating
            return rating;

        }).collect(Collectors.toList());

        user.setRatings(ratingList);
        logger.info("Yaha bhi chl rhi h rating");

        return user;
    }
}
