package com.daicham.divelog.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.LocalTime;

/**
 * @author daicham
 */
@MappedTypes(LocalTime.class)
public class LocalTimeTypeHandler extends BaseTypeHandler<LocalTime> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, LocalTime localTime,
                                    JdbcType jdbcType) throws SQLException {
        preparedStatement.setTime(i, Time.valueOf(localTime));
    }

    @Override
    public LocalTime getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Time time = resultSet.getTime(s);
        if (time == null) {
            return null;
        }
        return time.toLocalTime();
    }

    @Override
    public LocalTime getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getTime(i).toLocalTime();
    }

    @Override
    public LocalTime getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getTime(i).toLocalTime();
    }
}

