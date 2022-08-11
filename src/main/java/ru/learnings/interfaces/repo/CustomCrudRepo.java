package ru.learnings.interfaces.repo;

import ru.learnings.entities.User;

import java.util.List;
import java.util.Optional;

public interface CustomCrudRepo <T, ID>{

    void save(T entity);

    Iterable<T> findAll();

    Optional<T> findById(ID id);

    void deleteById(ID id);

    void delete(T entity);



}
