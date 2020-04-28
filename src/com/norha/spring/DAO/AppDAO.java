
package com.norha.spring.DAO;

import java.util.List;

import com.norha.spring.model.User;

public interface AppDAO {
	public List<User>listUsers();

	public void addUser(User user);

}
