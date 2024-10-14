package org.user_service.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.user_service.Entities.User;

public interface UserRepository extends JpaRepository<User,String> {
    // If you want to implement any custom method or any query...
}
