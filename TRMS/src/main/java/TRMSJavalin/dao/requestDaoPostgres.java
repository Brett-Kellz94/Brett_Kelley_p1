package TRMSJavalin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TMRS.pojos.request;
import TRMSJavalin.util.ConnectionUtil;

public class requestDaoPostgres implements requestDao {

	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public void createRequest(request request) {                                                                           //attachment
		String sql = "insert into request (employeeid, request_date, event_date, description, training_cost, type_of_event )"
			    	+ "values(?,date(?),date(?),?,?,?)";
		
		try (Connection conn = connUtil.createConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  request.getEmployeeId());
			pstmt.setString(2, request.getRequestDate());
			pstmt.setString(3, request.getEventDate());
			pstmt.setString(4, request.getDescription());
			pstmt.setDouble(5, request.getCost());
			pstmt.setString(6, request.getJustification());
		
			pstmt.executeUpdate();
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<request> getEmplRequests(int employeeId) {
		
		List<request> getRequest = new ArrayList<>();
		
		
		try (Connection conn = connUtil.createConnection()) {
			
		String sql = "select requestid, request_date, training_cost, supervisor_approval, department_head_approval, benco_approval from request where employeeid = ?";
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, employeeId);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while (rs.next()) {
			
			request request = new request();
			
			request.setRequestId(rs.getInt("requestid"));
			request.setRequestDate(rs.getString("request_date"));
			request.setCost(rs.getDouble("training_cost"));
			request.setSupervisorApproval(rs.getString("supervisor_approval"));
			request.setDepartmentHeadApproval(rs.getString("department_head_approval"));
			request.setBenCoApproval(rs.getString("benco_approval"));
			
			getRequest.add(request);

		}
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return getRequest;
	}

	@Override
	public List<request> getAllRequests() {
	    
		List<request> getRequest = new ArrayList<>();
		
	    String sql = "select requestid,"
	    		+ " employeeid,"
	    		+ " request_date,"
	    		+ " event_date,"
	    		+ " description,"
	    		+ " training_cost,"
	    		+ " type_of_event,"
	    		+ " supervisor_approval,"
	    		+ " department_head_approval,"
	    		+ " benco_approval"
	    		+ " from request"
	    		+ " where benco_approval is null";
		
		try (Connection conn = connUtil.createConnection()) {
			
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		//pstmt.setInt(1, employeeId);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while (rs.next()) {
			
			
			request request = new request();
			
			request.setRequestId(rs.getInt("requestid"));
			request.setEmployeeId(rs.getInt("employeeid"));
			request.setRequestDate(rs.getString("request_date"));
			request.setEventDate(rs.getString("event_date"));
			request.setDescription(rs.getString("description"));
			request.setCost(rs.getDouble("training_cost"));
			request.setJustification(rs.getString("type_of_event"));
			request.setSupervisorApproval(rs.getString("supervisor_approval"));
			request.setDepartmentHeadApproval(rs.getString("department_head_approval"));
			request.setBenCoApproval(rs.getString("benco_approval"));
			
			getRequest.add(request);

		}
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return getRequest;
	}

	@Override
	public request supApproval(int requestId, request request) {
		String sql = "update request set supervisor_approval = ? where requestid = ?";
		
		try (Connection conn = connUtil.createConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  request.getSupervisorApproval());
			pstmt.setInt(2, requestId);
			
			
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public request dhApproval(int requestId, request request) {
    String sql = "update request set department_head_approval = ? where requestid = ?";
    String sql2 = "update request set supervisor_approval = department_head_approval where requestid = ?";
		
		try (Connection conn = connUtil.createConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			pstmt.setString(1,  request.getDepartmentHeadApproval());
			pstmt.setInt(2, requestId);
			pstmt2.setInt(1, requestId);
			
			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public request bencoApproval(int requestId, request request) {
String sql = "update request set benco_approval = ? where requestid = ?";
String sql2 = "update request set supervisor_approval = benco_approval, department_head_approval = benco_approval where requestid = ?";
		
		try (Connection conn = connUtil.createConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			
			pstmt.setString(1,  request.getBenCoApproval());
			pstmt.setInt(2, requestId);
			pstmt2.setInt(1, requestId);
			
			pstmt.executeUpdate();
			pstmt2.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<request> getAllRequests(int employeeId) {
    
		List<request> getRequest = new ArrayList<>();
		
	    String sql = "select a.requestid,"
	    		+ " a.employeeid,"
	    		+ " a.request_date,"
	    		+ " a.event_date,"
	    		+ " a.description,"
	    		+ " a.training_cost,"
	    		+ " a.type_of_event,"
	    		+ " a.supervisor_approval,"
	    		+ " a.department_head_approval,"
	    		+ " a.benco_approval"
	    		+ " from request a"
	    		+ " left join employee b"
	    		+ " on a.employeeid = b.employeeid"
         		+ " left join employee c"
	    		+ " on b.supervisorid=c.employeeid"
	    		+ " left join employee d"
	    		+ " on c.supervisorid=d.employeeid"
	    		+ " where (? in (select employeeid from login_info where employee_type = 4) and a.department_head_approval is not null and a.benco_approval is null)"
	    		+ " or ("
	    		+ " case when (c.employeeid = ? and ? in (select employeeid from login_info where employee_type = 2) and a.supervisor_approval is null) then 1"
	    		+ " when d.employeeid = ? and a.supervisor_approval is not null and a.department_head_approval is null and ? in (select employeeid from login_info where employee_type = 3) then 1"
	    		+ " when c.employeeid = ? and a.department_head_approval is null and ? in (select employeeid from login_info where employee_type = 3) then 1"
	    		+ " else 0 end = 1)";
		
		try (Connection conn = connUtil.createConnection()) {
			
		
		PreparedStatement pstmt = conn.prepareStatement(sql);
		
		
		pstmt.setInt(1, employeeId);
		pstmt.setInt(2, employeeId);
		pstmt.setInt(3, employeeId);
		pstmt.setInt(4, employeeId);
		pstmt.setInt(5, employeeId);
		pstmt.setInt(6, employeeId);
		pstmt.setInt(7, employeeId);
		
		ResultSet rs = pstmt.executeQuery();
		
		
		while (rs.next()) {
			
			
			request request = new request();
			
			request.setRequestId(rs.getInt("requestid"));
			request.setEmployeeId(rs.getInt("employeeid"));
			request.setRequestDate(rs.getString("request_date"));
			request.setEventDate(rs.getString("event_date"));
			request.setDescription(rs.getString("description"));
			request.setCost(rs.getDouble("training_cost"));
			request.setJustification(rs.getString("type_of_event"));
			request.setSupervisorApproval(rs.getString("supervisor_approval"));
			request.setDepartmentHeadApproval(rs.getString("department_head_approval"));
			request.setBenCoApproval(rs.getString("benco_approval"));
			
			getRequest.add(request);

		}
		
		
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return getRequest;
	}
	
	
	
	
}
