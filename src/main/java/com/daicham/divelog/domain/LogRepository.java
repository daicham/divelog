package com.daicham.divelog.domain;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author daicham
 */
@Repository
public interface LogRepository {
    @Select("select * from log")
    List<Log> findAll();

    @Select("select * from log where id = #{id}")
    Log findById(long id);

    @Insert("insert into log(place) values(#{place})")
    @SelectKey(statement="call identity()", keyProperty="id", before=false, resultType=long.class)
    void insert(Log log);

    @Update("update log set place = #{place} where id = #{id}")
    void update(Log log);

    @Delete("delete from log where id = #{id}")
    void deleteById(long id);
}
