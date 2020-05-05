package com.CapG.Delight.repo;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import com.CapG.Delight.entity.Users;

public class UserRepo {
	
	@PersistenceContext
	EntityManager entityManager;
	
	public Users userLogin(Users user1) {
		String Qstr="SELECT user from Users user WHERE :name=user.userName AND :pass=user.password";
		TypedQuery<Users> query=entityManager.createQuery(Qstr,Users.class);
		query.setParameter("name",user1.getUserName());
		query.setParameter("pass",user1.getPassword());
		if(query.getSingleResult()!=null)
		{
			return query.getSingleResult();
		}
		else
		{
			return null;
		}	
	}
}