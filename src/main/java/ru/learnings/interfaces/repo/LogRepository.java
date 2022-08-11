package ru.learnings.interfaces.repo;

import ru.learnings.entities.Log;

import java.util.List;

public interface LogRepository extends CustomCrudRepo<Log, Long>{

    List<Log> findAll();

}
