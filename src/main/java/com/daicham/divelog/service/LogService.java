package com.daicham.divelog.service;

import com.daicham.divelog.domain.Log;
import com.daicham.divelog.domain.LogRepository;
import com.daicham.divelog.domain.Logs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author daicham
 */
@Service
public class LogService {
    @Autowired
    private LogRepository repository;

    public Logs findAll() {
        return new Logs(repository.findAll());
    }

    public void regsit(Log log) {
        repository.insert(log);
    }
}
