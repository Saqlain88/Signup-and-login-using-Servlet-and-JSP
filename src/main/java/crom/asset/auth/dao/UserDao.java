package crom.asset.auth.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import crm.asset.auth.model.User;

public class UserDao {

	public int registerUser(User user) throws ClassNotFoundException {

		String sql = "INSERT INTO user(first_name,last_name,username,password,address,contact) VALUES(?,?,?,?,?,?)";
		int result = 0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");
			PreparedStatement pd = con.prepareStatement(sql);
			pd.setString(1, user.getFirst_name());
			pd.setString(2, user.getLast_name());
			pd.setString(3, user.getUsername());
			pd.setString(4, user.getPassword());
			pd.setString(5, user.getAddress());
			pd.setString(6, user.getContact_no());
			System.out.println(pd);
			result = pd.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public boolean validate(String name, String pass) {
		boolean status = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/servlet", "root", "");

			PreparedStatement ps = con.prepareStatement("select * from user where username=? and password=?");
			ps.setString(1, name);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();
			status = rs.next();

		} catch (Exception e) {
			System.out.println(e);
		}
		return status;
	}

}
