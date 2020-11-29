package TRMSJavalin.service;

import java.util.List;

import TMRS.pojos.reward;

public interface rewardService {
	
	public void makeReward(reward reward);

	public List<reward> getReward(int employeeId);

}
