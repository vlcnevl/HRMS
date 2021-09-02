package com.vlcnevl.HRMS.business.abstracts;

import com.vlcnevl.HRMS.core.entities.concretes.User;
import com.vlcnevl.HRMS.core.utilities.results.DataResult;
import com.vlcnevl.HRMS.core.utilities.results.Result;

public interface UserService {
	DataResult<User> getByEmail(String email);
	Result add(User user);
}
