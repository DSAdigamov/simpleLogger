package ru.learnings.interfaces.serv;

import ru.learnings.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void saveUser(User user);

    List<User> getAllUsers();

    Optional<User> findUserById(Long id);

    void deleteUserById(Long id);

    void deleteUser(User user);
}
