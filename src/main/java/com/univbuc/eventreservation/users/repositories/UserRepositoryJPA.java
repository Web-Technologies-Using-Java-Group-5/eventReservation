package com.univbuc.eventreservation.users.repositories;

import com.univbuc.eventreservation.users.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepositoryJPA extends CrudRepository<User, Integer> {
    User findByUserName(String userName);
}
