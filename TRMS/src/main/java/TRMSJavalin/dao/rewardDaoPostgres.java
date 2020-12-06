package TRMSJavalin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TMRS.pojos.reward;
import TRMSJavalin.util.ConnectionUtil;

public class rewardDaoPostgres implements rewardDao{
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public void makeReward(reward reward) {
		String sql = "insert into award(requestid,employeeid,award_amount) "
				+ " (select a.requestid, "
				+ " employeeid,"
				+ " case when description = 'University' then training_cost * .8 "
				+ " when description = 'Seminar' then training_cost * .6"
				+ " when description = 'Certification' then training_cost * 1"
				+ " when description = 'Certification Prep' then training_cost * .75"
				+ " when description = 'Technical Training' then training_cost *.9"
				+ " when description = 'Other' then training_cost * .3 end as award_amount"
				+ " from request a where a.requestid = ?"
				+ " and final_approval ='Approved'"
				+ " and a.requestid not in (select distinct requestid"
				+ " from award))";
		
		String sql2 = "update request set final_approval = ? where requestid =?";
		
		try (Connection conn = connUtil.createConnection()) {
			
			PreparedStatement pstmt2 = conn.prepareStatement(sql2);
			pstmt2.setString(1, reward.getFinalApproval());
			pstmt2.setInt(2, reward.getRequestId());
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, reward.getRequestId());
			
			pstmt2.executeUpdate();
			pstmt.executeUpdate();
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	@Override
	public List<reward> getReward(int employeeId) {
		List<reward> getReward = new ArrayList<>();
		
		try (Connection conn = connUtil.createConnection()) {
			
			String sql = "select a.requestid,"
					+ " b.description,"
					+ " a.award_amount"
					+ " from award a"
					+ " inner join request b"
					+ " on a.requestid=b.requestid"
					+ " where a.employeeid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, employeeId);
			
			ResultSet rs = pstmt.executeQuery();
			
			while (rs.next()) {
				
				reward reward = new reward();
				
				reward.setRequestId(rs.getInt("requestId"));
				reward.setCourseDescription(rs.getString("description"));
				reward.setRewardAmount(rs.getDouble("award_amount"));
				
				getReward.add(reward);
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return getReward;
	}

}
