package ru.learnings.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.learnings.entities.Log;
import ru.learnings.services.LogServiceImpl;

import java.util.Optional;

@RequiredArgsConstructor
@RequestMapping("/logs")
@RestController
public class LogController {

    private final LogServiceImpl logService;

    @GetMapping("/{logId}")
    public Log getLogById(@PathVariable String logId){
        Optional<Log> currLog = logService.findLogById(Long.parseLong(logId));
        return currLog.orElse(null);
    }

    @PostMapping("/{logId}/change")
    public void updateLog(@PathVariable String logId, @RequestBody Log updLog){
        Optional<Log> currLog = logService.findLogById(Long.parseLong(logId));
        if (currLog.isPresent()){
            currLog.get().setMessage(updLog.getMessage());
            logService.saveLog(currLog.get());
        }
    }
}
