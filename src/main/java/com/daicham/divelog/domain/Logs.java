package com.daicham.divelog.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * @author daicham
 */
public class Logs {
    private List<Log> logs;

    public Logs(List<Log> logs) {
        this.logs = new ArrayList<>(logs);
    }

    public int size() {
        return logs.size();
    }

    public Log get(int index) {
        return logs.get(index);
    }
}
