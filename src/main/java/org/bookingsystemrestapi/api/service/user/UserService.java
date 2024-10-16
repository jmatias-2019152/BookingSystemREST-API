package org.bookingsystemrestapi.api.service.user;

import org.bookingsystemrestapi.api.model.User;

import java.util.List;

public interface UserService {
    User createUser(User user);
    User getUserById(int id);
    List<User> getAllUsers();
    User updateUser(int id, User user);
    boolean deleteUser(int id);
}
