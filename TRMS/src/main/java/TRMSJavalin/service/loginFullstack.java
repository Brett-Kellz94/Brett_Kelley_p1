package TRMSJavalin.service;

import java.util.List;

import TMRS.pojos.login;
import TRMSJavalin.dao.loginDao;
import TRMSJavalin.dao.loginDaoPostgres;

public class loginFullstack implements loginService{
	
	loginDao logDao = new loginDaoPostgres();


	@Override
	public List<String> getPassword(int username) {
		return logDao.getPassword(username);
	}


	@Override
	public List<String> getEmployeeType(int username) {
		// TODO Auto-generated method stub
		return null;
	}}
