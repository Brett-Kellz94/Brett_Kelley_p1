package TRMSJavalin.dao;

import java.util.List;

import TMRS.pojos.reward;

public interface rewardDao {
	
	public void makeReward(reward reward);

	public List<reward> getReward(int employeeId);
}
