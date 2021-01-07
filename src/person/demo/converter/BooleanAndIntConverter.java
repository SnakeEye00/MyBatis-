package person.demo.converter;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

//在此位置的泛型为Java类型
public class BooleanAndIntConverter extends BaseTypeHandler<Boolean>{		
	
	//java（boolean） - > DB（int）
	/*
	 * ps：PreparedStatement对象
	 * i：PreparedStatement对象操作参数的位置
	 * parameter：java值
	 * jdbcType：jdbc操作的数据库类型
	 */
	@Override
	public void setNonNullParameter(PreparedStatement ps, int i, Boolean parameter, JdbcType jdbcType) throws SQLException {
		if(parameter) {
			//1
			ps.setInt(i, 1);
		}else {
			ps.setInt(i, 0);
		}
	}
	
	//get : DB(int) - > java(Boolean)
	@Override
	public Boolean getNullableResult(ResultSet rs, String columnName) throws SQLException {
		int sexNum = rs.getInt(columnName);
		return sexNum ==1 ? true : false;
	}

	@Override
	public Boolean getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
		int sexNum = rs.getInt(columnIndex);
		return sexNum ==1 ? true : false;
	}
	
	
	//CallableStatement --存储过程 存储函数65
	@Override
	public Boolean getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
		int sexNum = cs.getInt(columnIndex);
		return sexNum ==1 ? true : false;
	}

}
