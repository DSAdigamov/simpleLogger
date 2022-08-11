package ru.learnings.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.learnings.entities.Log;
import ru.learnings.entities.User;
import ru.learnings.services.LogServiceImpl;
import ru.learnings.services.UserServiceImpl;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RequestMapping("/users")
@RestController
public class UserController {

    private final UserServiceImpl userService;
    private final LogServiceImpl logService;

    @GetMapping("/")
    public List<User> getAllUsers(){
        return userService.getAllUsers();
    }

    @GetMapping("/{userId}")
    public User getUserById(@PathVariable String userId){
        Optional<User> user = userService.findUserById(Long.parseLong(userId));
        return user.orElse(null);
    }

    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public void addNewUser(@RequestBody User newUser){
        //Чтобы не добавлять юзера, если он укажет свой айдишник
        newUser.setUserId(null);
        userService.saveUser(newUser);
    }

    @DeleteMapping("/{userId}/delete")
    public void deleteUser(@PathVariable String userId){
        userService.deleteUserById(Long.parseLong(userId));
    }

    @GetMapping("/{userId}/logs")
    public List<Log> getUsersLogs(@PathVariable String userId){
        return logService.getLogsByUserId(Long.parseLong(userId));
    }

    @PostMapping("/{userId}/logs/add")
    @ResponseStatus(HttpStatus.CREATED)
    public void addLogToUser(@PathVariable String userId, @RequestBody Log log){
        Optional<User> currUser = userService.findUserById(Long.parseLong(userId));

        if (currUser.isPresent()){
            currUser.get().getLogs().add(new Log(currUser.get(), log.getMessage()));
            userService.saveUser(currUser.get());
        }

    }

}
