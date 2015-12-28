package com.daicham.divelog.domain;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author daicham
 */
@Data
public class Log {
    private Long id;
    private Integer no;
    private LocalDate date;
    private String location;
    private LocalTime timeIn;
    private LocalTime timeOut;
    private Integer barIn;
    private Integer barOut;
    private Float maxDepth;
    private Float avgDepth;
    private Integer weight;
    private Float airTemp;
    private Float surfaceTemp;
    private Float bottomTemp;
    private Integer visibility;
    private String notes;
}
