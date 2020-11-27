package TRMSJavalin.dao;

import java.sql.Connection;
import java.sql.SQLException;

import TMRS.pojos.reward;
import TRMSJavalin.util.ConnectionUtil;

public class rewardDaoPostgres implements rewardDao{
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public void makeReward(reward reward) {
		String sql = "update award set award_amount = ? where requestid =? ";
		
		try (Connection conn = connUtil.createConnection()) {
			
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
