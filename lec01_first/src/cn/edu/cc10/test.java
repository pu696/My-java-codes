package cn.edu.cc10;

import java.sql.*;

public class test {

	public static void main(String[] args) {
		Connection con=null;
		Statement sql;
		ResultSet rs;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(Exception e) {
			System.out.println("驱动加载失败"+e);
		}
		String uri = "jdbc:mysql://localhost:3306/studentdb?useUnicode=true&useSSL=false&characterEncoding=utf8&serverTimezone=UTC";
		String user = "root";
		String password = "123456";
		try {
		    con = DriverManager.getConnection(uri, user, password);
		}
		catch(SQLException e) {}
		try {
			sql = con.createStatement();
			rs  = sql.executeQuery("select * from student");
			while(rs.next()) {
				String sid = rs.getString(1);
				String sname = rs.getString(2);
				int sage = rs.getInt(3);
				String gender = rs.getString(4);
				System.out.printf("%s\t",sid);
				System.out.printf("%s\t",sname);
				System.out.printf("%d\n",sage);
				System.out.printf("%s\t",gender);
			}
			con.close();
		}
		catch(SQLException e) {
			System.out.println(e);
		}
	} 

}
