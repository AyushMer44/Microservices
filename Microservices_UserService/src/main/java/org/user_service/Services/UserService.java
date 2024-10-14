package org.user_service.Services;

import org.user_service.Entities.User;

import java.util.List;

public interface UserService {
    // User Operations

    // Create

    User saveUser(User user);

    // Get all Users

    List<User> getAllUsers();

    // Get single User with UserId

    User getUser(String userId);
}
