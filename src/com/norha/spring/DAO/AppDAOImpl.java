package com.norha.spring.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.norha.spring.model.User;

public class AppDAOImpl implements AppDAO {
	
	private DataSource dataSource;

	public AppDAOImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public List<User> listUsers() {
		String sql = "Select * From user";
		List<User> listUsers = new ArrayList<User>();
		Connection connection = null;
		try {
			connection = dataSource.getConnection();
			PreparedStatement preparedStatement = connection.prepareStatement(sql);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()) {
				User temp = new User(
						resultSet.getInt(1),
						resultSet.getString(2),
						resultSet.getString(3)
						);
				listUsers.add(temp);
			}
			resultSet.close();
			connection.close();
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}finally {
			
		}
		return listUsers;
	}

	public void addUser(User user) {
		String sql = "INSERT INTO user "+
						"(name,email) VALUES (?,?)";
		
		Connection con = null;
		try {
			con = dataSource.getConnection();
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getEmail());
			System.out.println(ps.execute());
			ps.close();
			
		}catch(SQLException e ) {
			e.printStackTrace();
		}finally {
			if(con!=null) {
				try {
					con.close();
				}catch(SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
	}
}
