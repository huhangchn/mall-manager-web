package com.github.huhangchn.typehandler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 0,1 to true,false 的类型转换器
 * null: null
 * 1 : true
 * 0 : false
 */
public class TrueFalseTypeHandler extends BaseTypeHandler<Boolean> {

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType)
            throws SQLException {
        ps.setInt(i, parameter == null ? null : parameter ? 1 : 0);
    }

    @Override
    public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int b = rs.getInt(columnName);
        return rs.wasNull() ? null : b == 1;
    }

    @Override
    public Boolean getNullableResult(ResultSet rs, int i) throws SQLException {
        int b = rs.getInt(i);
        return rs.wasNull() ? null : b == 1;
    }

    @Override
    public Boolean getNullableResult(CallableStatement cs, int i) throws SQLException {
        int b = cs.getInt(i);
        return cs.wasNull() ? null : b == 1;
    }
}
