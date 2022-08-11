package ru.learnings.interfaces.repo;

import ru.learnings.entities.User;

import java.util.List;

public interface UserRepository extends CustomCrudRepo<User, Long>{

    List<User> findAll();
}
