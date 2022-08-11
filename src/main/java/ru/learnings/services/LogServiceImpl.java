package ru.learnings.services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.learnings.entities.Log;
import ru.learnings.interfaces.serv.LogService;
import ru.learnings.repositories.LogRepositoryImpl;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@EnableAspectJAutoProxy(proxyTargetClass = true)
@Transactional
@Service
public class LogServiceImpl implements LogService {

    private final LogRepositoryImpl logRepository;

    @Override
    public void saveLog(Log logg) {
        log.info("saving new log: {}", logg);
        logRepository.save(logg);
    }

    @Override
    public List<Log> getLogsByUserId(long userId) {
        log.info("getting logs of userId: {}", userId);
        return logRepository.findAllByUserId(userId);
    }

    @Override
    public List<Log> getAll() {
        log.info("getting all logs");
        return logRepository.findAll();
    }

    @Override
    public Optional<Log> findLogById(Long id) {
        return logRepository.findById(id);
    }


}
