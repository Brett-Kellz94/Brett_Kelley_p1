package TRMSJavalin.service;

import java.util.List;

import TMRS.pojos.reward;
import TRMSJavalin.dao.rewardDao;
import TRMSJavalin.dao.rewardDaoPostgres;

public class rewardFullstack implements rewardService {

    rewardDao reDao = new rewardDaoPostgres();	
	
	@Override
	public void makeReward(reward reward) {
		reDao.makeReward(reward);
		
	}

	@Override
	public List<reward> getReward(int employeeId) {
		return reDao.getReward(employeeId);
	}

}
