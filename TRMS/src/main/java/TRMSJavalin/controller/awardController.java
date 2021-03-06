package TRMSJavalin.controller;

import TRMSJavalin.service.rewardFullstack;
import TRMSJavalin.service.rewardService;
import io.javalin.http.Context;

import java.util.List;

import TMRS.pojos.reward;
import java.util.logging.Logger;

public class awardController {
	
	private static Logger log = Logger.getAnonymousLogger();
	
	rewardService reward = new rewardFullstack();
	
	public void sendReward(Context ctx) {
		
		int requestId = Integer.parseInt(ctx.formParam("requestId"));
		
		String approval = ctx.formParam("approval");
		
		reward newReward = new reward(requestId, approval);
		
		reward.makeReward(newReward);
		
		ctx.redirect("finalGradeForApproval.html");
		
		log.info("Reward has been sent to employee");

	}
	
	
	public void getReward(Context ctx){
		
		int employeeId= Integer.parseInt(ctx.queryParam("employeeId"));
		
		List<reward> rewards = reward.getReward(employeeId);
		
		ctx.json(rewards);
		
		log.info("Reward has been retrieved");
	}
	

}
