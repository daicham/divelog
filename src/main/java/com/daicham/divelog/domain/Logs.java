package com.daicham.divelog.domain;

import lombok.ToString;

import java.util.*;

/**
 * @author daicham
 */
@ToString
public class Logs implements Iterable<Log> {
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

    public boolean isEmpty() {
        return logs.isEmpty();
    }

    @Override
    public Iterator<Log> iterator() {
        return logs.iterator();
    }
}
