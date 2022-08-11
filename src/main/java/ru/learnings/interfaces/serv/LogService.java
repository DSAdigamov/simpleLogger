package ru.learnings.interfaces.serv;

import ru.learnings.entities.Log;

import java.util.List;
import java.util.Optional;

public interface LogService {

    void saveLog(Log logg);

    List<Log> getLogsByUserId(long userId);

    List<Log> getAll();

    Optional<Log> findLogById(Long id);

}
