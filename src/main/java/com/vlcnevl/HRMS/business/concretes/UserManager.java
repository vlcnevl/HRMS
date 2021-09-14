  package com.vlcnevl.HRMS.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vlcnevl.HRMS.business.abstracts.UserService;
import com.vlcnevl.HRMS.core.dataAccess.abstracts.UserDao;
import com.vlcnevl.HRMS.core.entities.concretes.User;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.ErrorDataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;
import com.vlcnevl.HRMS.core.utilities.results.SuccessDataResult;
import com.vlcnevl.HRMS.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

	private UserDao userDao;
	
	@Autowired
	public UserManager(UserDao userDao) {
		super();
		this.userDao = userDao;
	}

	@Override
	public DataResult<User> getByEmail(String email) {
		
	
		var result = this.userDao.getByEmail(email);
		if(result!=null)
		{
			return new SuccessDataResult<User>(this.userDao.getByEmail(email),"user");
		}
		return new ErrorDataResult<User>();
	
	}

	@Override
	public Result add(User user) {
		this.userDao.save(user);
		return new SuccessResult("User added");
	}

	@Override
	public boolean existsByEmail(String email) {
		return this.userDao.existsByEmail(email);
	}
}
