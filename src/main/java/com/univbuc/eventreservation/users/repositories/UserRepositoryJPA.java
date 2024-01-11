package com.univbuc.eventreservation.users.repositories;

import com.univbuc.eventreservation.users.model.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Qualifier(value = "jpa")
@Primary
@Repository
public interface UserRepositoryJPA extends CrudRepository<User, Integer>, UserRepository {
    @Override
    User findByUserName(String userName);
}
