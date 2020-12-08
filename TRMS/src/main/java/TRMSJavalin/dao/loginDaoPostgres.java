package TRMSJavalin.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import TRMSJavalin.util.ConnectionUtil;

public class loginDaoPostgres implements loginDao {
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}
	

	@Override
	public List<String> getPassword(int username) {
		
		List<String> newLogin = new ArrayList<>();
		
		String sql = "select account_password from login_info where employeeid = ?";
		
	    try (Connection conn = connUtil.createConnection()) {
			
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, username /*login.getUsername()*/);
			
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

		newLogin.add(rs.getString("account_password"));

		}
			
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
	    
	    return newLogin;
		
	}

	@Override
	public List<String> getEmployeeType(int username) {
		
		List<String> getType = new ArrayList<>();
		
		String sql = "select employee_type from login_info where employeeid = ?";
		
		try (Connection conn = connUtil.createConnection()) {
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, username);
		
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
		    
		getType.add(rs.getString("employee_type"));

		}
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return getType;
	}

	
	
	
	
}
