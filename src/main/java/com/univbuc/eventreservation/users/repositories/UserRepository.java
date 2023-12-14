package com.univbuc.eventreservation.users.repositories;

import java.util.Optional;

import com.univbuc.eventreservation.users.model.User;

public interface UserRepository {
    User save(User user);

    User findByUserName(String userName);

    Optional<User> findById(Integer id);
}
