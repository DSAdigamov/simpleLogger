package ru.learnings.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnings.entities.User;
import ru.learnings.interfaces.serv.UserService;
import ru.learnings.repositories.UserRepositoryImpl;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Transactional
@Service
public class UserServiceImpl implements UserService {

    private final UserRepositoryImpl userRepository;

    @Override
    public void saveUser(User newUser){
        log.info("saving new user: {}", newUser.getName());
        userRepository.save(newUser);
    }

    @Override
    public List<User> getAllUsers() {
        log.info("getting all users");
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById(Long id) {
        log.info("finding user by id: {}", id);
        return userRepository.findById(id);
    }

    @Override
    public void deleteUserById(Long id) {
        log.info("deleting user by id: {}", id);
        userRepository.deleteById(id);
    }

    @Override
    public void deleteUser(User user) {
        log.info("deleting user: {}", user);
        userRepository.delete(user);
    }




}
