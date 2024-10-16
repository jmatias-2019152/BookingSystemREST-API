package org.bookingsystemrestapi.api.service.user;

import org.bookingsystemrestapi.api.model.User;
import org.bookingsystemrestapi.api.service.user.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    private final Map<Integer, User> userMap = new HashMap<>();

    @Override
    public User createUser(User user) {
        userMap.put(user.getId(), user);
        return user;
    }

    @Override
    public User getUserById(int id) {
        return userMap.get(id);
    }

    @Override
    public List<User> getAllUsers() {
        return new ArrayList<>(userMap.values());
    }

    @Override
    public User updateUser(int id, User user) {
        if (userMap.containsKey(id)) {
            User existingUser = userMap.get(id);
            existingUser.setNombre(user.getNombre());
            existingUser.setEmail(user.getEmail());
            existingUser.setContraseña(user.getContraseña());
            return existingUser;
        }
        return null; // o lanzar una excepción si prefieres
    }

    @Override
    public boolean deleteUser(int id) {
        return userMap.remove(id) != null;
    }
}