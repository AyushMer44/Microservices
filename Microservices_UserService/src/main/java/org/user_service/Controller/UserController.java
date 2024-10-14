package org.user_service.Controller;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.user_service.Entities.User;
import org.user_service.Services.UserService;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    // create
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        User user1 = userService.saveUser(user); // Jo user DB mai save ho gya hai hum wo mila hai user1 mai...
        return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    // get single user
    int retryCount = 1;
    // ye api hotel and rating service ko call kr rahi hai...
    // So, here we are also implementing circuit breaker for Fault Tolerance...
    @GetMapping("/{userId}")
//    @CircuitBreaker(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//    @Retry(name = "ratingHotelService",fallbackMethod = "ratingHotelFallback")
    @RateLimiter(name = "userRateLimiter", fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId){
//        logger.info("Get single user handler: UserController...");
        logger.info("Retry Count: {}",retryCount);
        retryCount++;
        User user = userService.getUser(userId);
        return ResponseEntity.ok(user);
    }

    // Creating Fallback method for CircuitBreaker and Retry...

    // ye method tab chlega when koi service fail/down ho jayegi(hotel ya rating service mai se koi)

    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex){ // Fallback method ka return type and main service method/apiHandler ka return type same hona chahiye and also parameters i.e. ResponseEntity<User>
        logger.info("Fallback is executed because service is down : {}",ex.getMessage());
        ex.printStackTrace();
        User user = User.builder()
                .email("dummy@gmail.com")
                .name("Dummy")
                .about("This user is created dummy because some services are down.")
                .userId("1234")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    // get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> allUsers = userService.getAllUsers();
        return ResponseEntity.ok(allUsers);
    }
}
