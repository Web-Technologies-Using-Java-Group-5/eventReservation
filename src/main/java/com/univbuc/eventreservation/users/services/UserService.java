package com.univbuc.eventreservation.users.services;

import com.univbuc.eventreservation.users.model.User;
import com.univbuc.eventreservation.users.model.UserResponse;

public interface UserService {
    User createUser(User user);

    UserResponse login(User user);
}
