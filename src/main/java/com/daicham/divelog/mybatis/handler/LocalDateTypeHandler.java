package com.daicham.divelog.mybatis.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedTypes;

import java.sql.*;
import java.time.LocalDate;

/**
 * @author daicham
 */
@MappedTypes(LocalDate.class)
public class LocalDateTypeHandler extends BaseTypeHandler<LocalDate> {
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, LocalDate localDate,
                                    JdbcType jdbcType) throws SQLException {
        preparedStatement.setDate(i, Date.valueOf(localDate));
    }

    @Override
    public LocalDate getNullableResult(ResultSet resultSet, String s) throws SQLException {
        Date date = resultSet.getDate(s);
        if (date == null) {
            return null;
        }
        return date.toLocalDate();
    }

    @Override
    public LocalDate getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return resultSet.getDate(i).toLocalDate();
    }

    @Override
    public LocalDate getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return callableStatement.getDate(i).toLocalDate();
    }
}
