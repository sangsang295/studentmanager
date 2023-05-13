package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbutil.Dbconn;
import entity.Student;

public class Model {

	public static List<Student> getAllStudents() {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;
		
		

		try {

			// 获取数据库连接对象
			connection = Dbconn.getConnection();
			// 定义数据库SQL语句
			String sql = "select * from student order by sid desc";
			// 获取SQL执行对象
			preparedStatement = connection.prepareStatement(sql);
			// 获取数据集
			resultSet = preparedStatement.executeQuery();

			List<Student> students = new ArrayList<Student>();
			while (resultSet.next()) {
				Integer sid = resultSet.getInt("sid");
				String sname = resultSet.getString("sname");
				String sphone = resultSet.getString("sphone");
				int sage = resultSet.getInt("sage");
				String ssex = resultSet.getString("ssex");
				String sclass = resultSet.getString("sclass");
				String scollege = resultSet.getString("scollege");
				String simg = resultSet.getString("simg");
				Student student = new Student(sid, sname, sphone, sage, ssex, sclass, scollege, simg);
				students.add(student);
			}

			return students;
		} catch (Exception e) {
			// TODO: handle exception
		} finally {
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		int i=0;
		return null;
	}

	public static Student getByID(Integer id) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			// 获取数据库连接对象
			connection = Dbconn.getConnection();
			// 定义数据库SQL语句
			String sql = "select * from student where sid = ?";
			// 获取SQL执行对象
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数值
			preparedStatement.setInt(1, id);
			// 获取数据集
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Integer sid = resultSet.getInt("sid");
				String sname = resultSet.getString("sname");
				String sphone = resultSet.getString("sphone");
				int sage = resultSet.getInt("sage");
				String ssex = resultSet.getString("ssex");
				String sclass = resultSet.getString("sclass");
				String scollege = resultSet.getString("scollege");
				String simg = resultSet.getString("simg");
				
				return new Student(sid, sname, sphone, sage, ssex, sclass, scollege, simg);
			}

			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return null;
	}
	
	public static boolean deleByID(Integer id) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			// 获取数据库连接对象
			connection = Dbconn.getConnection();
			// 定义数据库SQL语句
			String sql = "delete from student where sid = ?";
			// 获取SQL执行对象
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数值
			preparedStatement.setInt(1, id);
			

			int flag = preparedStatement.executeUpdate();
			
			if(flag > 0) return true;
			
			return false;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return false;
	}

	public static Student getByPhone(String phone) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			// 获取数据库连接对象
			connection = Dbconn.getConnection();
			// 定义数据库SQL语句
			String sql = "select * from student where sphone = ?";
			// 获取SQL执行对象
			preparedStatement = connection.prepareStatement(sql);
			// 设置参数值
			preparedStatement.setString(1, phone);
			// 获取数据集
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				Integer sid = resultSet.getInt("sid");
				String sname = resultSet.getString("sname");
				String sphone = resultSet.getString("sphone");
				int sage = resultSet.getInt("sage");
				String ssex = resultSet.getString("ssex");
				String sclass = resultSet.getString("sclass");
				String scollege = resultSet.getString("scollege");
				String simg = resultSet.getString("simg");
				return new Student(sid, sname, sphone, sage, ssex, sclass, scollege, simg);
			}

			return null;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return null;
	}
	
	
	public static boolean updateImg(Integer id, String imgUrl) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			connection = Dbconn.getConnection();
			String sql = "update student set simg = ? where sid = ?";
			preparedStatement = connection.prepareStatement(sql);
			preparedStatement.setString(1, imgUrl);
			System.out.println(id);
			System.out.println(imgUrl);
			preparedStatement.setInt(2, id);
		
			int flag = preparedStatement.executeUpdate();

			if (flag > 0)
				return true;

			return false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return false;
	}

	public static boolean insertstudent(String sname, String sphone, String ssex, int sage, String sclass, String scollege, String simg) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			connection = Dbconn.getConnection();
			String sql = "";
			if(simg != null) {
				sql = "insert into student(sname, sphone, ssex, sage, sclass, scollege, simg) values(?, ?, ?, ?, ?, ?,?)";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, sname);
				preparedStatement.setString(2, sphone);
				preparedStatement.setString(3, ssex);
				preparedStatement.setInt(4, sage);
				preparedStatement.setString(5, sclass);
				preparedStatement.setString(6, scollege);
				preparedStatement.setString(7, simg);
			}else {
				sql = "insert into student(sname, sphone, ssex, sage, sclass, scollege) values(?, ?, ?, ?, ?, ?)";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, sname);
				preparedStatement.setString(2, sphone);
				preparedStatement.setString(3, ssex);
				preparedStatement.setInt(4, sage);
				preparedStatement.setString(5, sclass);
				preparedStatement.setString(6, scollege);
			}
			

			int flag = preparedStatement.executeUpdate();

			if (flag > 0)
				return true;

			return false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return false;
	}
	
	public static boolean updateByID(Integer sid, String sname, String sphone, String ssex, int sage, String sclass, String scollege, String simg) {
		Connection connection = null;

		PreparedStatement preparedStatement = null;

		ResultSet resultSet = null;

		try {

			connection = Dbconn.getConnection();
			String sql = "";
			if (simg != null) {
				sql = "update student set sname = ?,  sphone = ?, ssex = ?, sage = ?, sclass=?,scollege=?,simg=? where sid = ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, sname);
				preparedStatement.setString(2, sphone);
				preparedStatement.setString(3, ssex);
				preparedStatement.setInt(4, sage);
				preparedStatement.setString(5, sclass);
				preparedStatement.setString(6, scollege);
				preparedStatement.setString(7, simg);
				preparedStatement.setInt(8, sid);
			}else {
				sql = "update student set sname = ?,  sphone = ?, ssex = ?, sage = ?, sclass=?,scollege=? where sid = ?";
				preparedStatement = connection.prepareStatement(sql);
				preparedStatement.setString(1, sname);
				preparedStatement.setString(2, sphone);
				preparedStatement.setString(3, ssex);
				preparedStatement.setInt(4, sage);
				preparedStatement.setString(5, sclass);
				preparedStatement.setString(6, scollege);
				preparedStatement.setInt(7, sid);
			}

			int flag = preparedStatement.executeUpdate();

			if (flag > 0)
				return true;

			return false;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} finally {
			// TODO: handle finally clause
			Dbconn.close(connection, preparedStatement, resultSet);
		}

		return false;
	}

}
