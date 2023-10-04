package com.hemanth.SpringMVCGLDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hemanth.SpringMVCGLDemo.entity.Login;
import com.hemanth.SpringMVCGLDemo.repository.LoginRepo;
@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	LoginRepo loginRepo;

	public Login save(Login login) {
		// TODO Auto-generated method stub
	Login	logine=loginRepo.fingByUserNameAndPassword(login.getUserName(), login.getPassword());
		if(logine==null)
		{
			logine=loginRepo.save(login);
		}
		return logine;
	}

}
