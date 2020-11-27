package TRMSJavalin.service;

import java.util.List;

public interface loginService {
	
	public List<String> getPassword(int username);
	public List<String> getEmployeeType(int username);

}
