package com.daicham.divelog.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author daicham
 */
@Data
public class Log {
    private long id;
    private int no;
    private LocalDate date;
    private String location;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private int barIn;
    private int barOut;
    private float maxDepth;
    private float avgDepth;
    private int weight;
    private float airTemp;
    private float surfaceTemp;
    private float bottomTemp;
    private int visibility;
    private String notes;
}
