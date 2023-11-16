package com.univbuc.eventreservation.users.repositories;

import com.univbuc.eventreservation.users.model.User;

public interface UserRepository {
    User createUser(User user);

    User getUser(String userName);
}
