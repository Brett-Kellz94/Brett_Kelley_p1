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
		String sql = "insert into request (employeeid, request_date, event_date, description, training_cost, grading_format, type_of_event )"
			    	+ "values(?,date(?),date(?),?,?,?,?)";
		
		try (Connection conn = connUtil.createConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  request.getEmployeeId());
			pstmt.setString(2, request.getRequestDate());
			pstmt.setString(3, request.getEventDate());
			pstmt.setString(4, request.getDescription());
			pstmt.setDouble(5, request.getCost());
			pstmt.setString(6, request.getGradingFormat());
			pstmt.setString(7, request.getJustification());
			//attachment
			//pstmt.setString(8, request.getRequestDate());
		
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
		
	    String sql = "select requestid, employeeid, request_date, event_date, description, training_cost, grading_format, type_of_event, supervisor_approval, department_head_approval, benco_approval from request";
		
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
			request.setGradingFormat(rs.getString("grading_format"));
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
		
		try (Connection conn = connUtil.createConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  request.getDepartmentHeadApproval());
			pstmt.setInt(2, requestId);
			
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public request bencoApproval(int requestId, request request) {
String sql = "update request set benco_approval = ? where requestid = ?";
		
		try (Connection conn = connUtil.createConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,  request.getBenCoApproval());
			pstmt.setInt(2, requestId);
			
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	
	
}
