package TRMSJavalin.dao;

import java.util.List;



public interface loginDao {

	public List<String> getPassword(int username);
	public List<String> getEmployeeType(int username);
	
}
