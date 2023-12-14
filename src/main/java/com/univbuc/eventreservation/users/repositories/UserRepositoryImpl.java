package com.univbuc.eventreservation.users.repositories;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import com.univbuc.eventreservation.users.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository {
    Set<User> users = new HashSet<>();
    int id = 0;
    @Override
    public User save(User user) {
        user.setId(id++);
        users.add(user);
        return user;
    }

    @Override
    public User findByUserName(String userName) {
        return users.stream().filter(user -> user.getUserName().equals(userName)).findFirst().orElseThrow();
    }

    @Override
    public Optional<User> findById(Integer id) {
        return users.stream().filter(user -> user.getId() == id).findFirst();
    }

}
