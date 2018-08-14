package by.tataranovich.leasingcompany.mybatis;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import by.tataranovich.leasingcompany.model.CarModel;

public class CarModelTypeHandler implements TypeHandler<CarModel> {

    public CarModel getResult(ResultSet rs, String param) throws SQLException {
	return CarModel.getById(rs.getInt(param));
    }

    public CarModel getResult(CallableStatement cs, int col) throws SQLException {
	return CarModel.getById(cs.getInt(col));
    }

    public void setParameter(PreparedStatement ps, int paramInt, CarModel paramType, JdbcType jdbctype)
	    throws SQLException {
	ps.setInt(paramInt, paramType.getId());
    }

    @Override
    public CarModel getResult(ResultSet rs, int columnIndex) throws SQLException {
	throw new java.lang.UnsupportedOperationException("Not supported yet");
    }

}
