package com.daicham.divelog.domain;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;

/**
 * @author daicham
 */
@Data
public class Log {
    private Long id;
    @NotNull
    @Min(1)
    private Integer no;
    @NotNull
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
