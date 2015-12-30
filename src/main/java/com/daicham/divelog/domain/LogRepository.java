package com.daicham.divelog.domain;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author daicham
 */
@Repository
public interface LogRepository {
    @Select("select * from logs order by no")
    List<Log> findAll();

    @Select("select * from logs order by no desc")
    List<Log> findAllOrderByNoDesc();

    @Select("select * from logs where id = #{id}")
    Log findById(long id);

    @Insert("insert into logs(no, date, location, time_in, time_out, bar_in, bar_out, max_depth, avg_depth, weight, air_temp, surface_temp, bottom_temp, visibility, notes)" +
            " values(#{no}, #{date}, #{location}, #{timeIn}, #{timeOut}, #{barIn}, #{barOut}, #{maxDepth}, #{avgDepth}, #{weight}, #{airTemp}, #{surfaceTemp}, #{bottomTemp}, #{visibility}, #{notes})")
    @Options(useGeneratedKeys = true)
    void insert(Log log);

    @Update("update logs set no = #{no}, date = #{date}, location = #{location}, time_in = #{timeIn}, time_out = #{timeOut}," +
            " bar_in = #{barIn}, bar_out = #{barOut}, max_depth = #{maxDepth}, avg_depth = #{avgDepth}, weight = #{weight}," +
            " air_temp = #{airTemp}, surface_temp = #{surfaceTemp}, bottom_temp = #{bottomTemp}, visibility = #{visibility}, notes = #{notes}" +
            " where id = #{id}")
    void update(Log log);

    @Delete("delete from logs where id = #{id}")
    void deleteById(long id);
}
