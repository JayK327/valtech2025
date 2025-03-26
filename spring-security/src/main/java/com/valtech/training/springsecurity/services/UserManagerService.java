package com.valtech.training.springsecurity.services;

import com.valtech.training.springsecurity.entities.User;
import com.valtech.training.springsecurity.vos.ChangePasswordVO;

public interface UserManagerService {

//	void saveUser(User user);

	void registerUser(User user);

	void changePassword(String username, ChangePasswordVO changePassword);

	

	

}