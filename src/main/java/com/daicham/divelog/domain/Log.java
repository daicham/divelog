package com.daicham.divelog.domain;

import lombok.Data;

import java.sql.Time;
import java.util.Date;

/**
 * @author daicham
 */
@Data
public class Log {
    private long id;
    private int no;
    private Date date;
    private String location;
    private Time timeIn;
    private Time timeOut;
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
