package com.daicham.divelog.domain;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author daicham
 */
@Repository
public interface LogRepository {
    @Select("select * from log")
    List<Log> findAll();

    @Insert("insert into log(place) values(#{place})")
    void insert(Log log);
}
