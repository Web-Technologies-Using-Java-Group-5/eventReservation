package com.univbuc.eventreservation.users.repositories;

import com.univbuc.eventreservation.users.model.User;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;

@Primary
public interface UserRepositoryJPA extends CrudRepository<User, Integer>, UserRepository {
    @Override
    User findByUserName(String userName);
}
