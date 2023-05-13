package dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Dbconn {
	
	private static ComboPooledDataSource dataSource = null;
	
	static {
		dataSource = new ComboPooledDataSource();
	}

	public static Connection getConnection() throws Exception {
		
		
		
		
		 String driver = "com.mysql.cj.jdbc.Driver";
	        
	        //���ʱ�����mysql���ݿ�,��ʽ jdbc:���ݿ�://���ض˿�3306/���ݿ���?��ʱ������
	        String url = "jdbc:mysql://localhost:3306/students?serverTimezone=Asia/Shanghai";
	        String username = "root";
	        String password = "327724";

	        Class.forName(driver);
	        
	        //��ȡ�����ݿ�����
	        Connection connection = DriverManager.getConnection(url, username, password);
		
//		return dataSource.getConnection();
	        return connection;
	}
	
	public static void close(Connection connection, PreparedStatement preparedStatement, ResultSet resultSet) {
		if(connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			connection = null;
		}
		
		if(preparedStatement != null) {
			try {
				preparedStatement.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			preparedStatement = null;
		}
		
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			resultSet = null;
		}
	}
	public static void close(Connection connection, Statement statement, ResultSet resultSet) {
		if(connection != null) {
			try {
				connection.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			connection = null;
		}
		
		if(statement != null) {
			try {
				statement.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			statement = null;
		}
		
		if(resultSet != null) {
			try {
				resultSet.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			resultSet = null;
		}
	}
	
	
}
