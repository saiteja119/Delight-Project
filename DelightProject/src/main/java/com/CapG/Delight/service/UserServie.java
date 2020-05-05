package com.CapG.Delight.service;

import com.CapG.Delight.entity.Users;
import com.CapG.Delight.repo.UserRepoInterface;

public class UserServie {
	
	UserRepoInterface  userRepo;

	public Users userLoginService(Users user1) {
		Users user2=userRepo.userLogin(user1);
		return user2;	
	}
}