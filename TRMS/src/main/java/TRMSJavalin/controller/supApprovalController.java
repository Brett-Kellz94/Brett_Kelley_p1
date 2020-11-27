package TRMSJavalin.controller;

import TMRS.pojos.request;
import TRMSJavalin.service.requestService;
import TRMSJavalin.service.requestServiceFullstack;
import io.javalin.http.Context;

public class supApprovalController {
	
	requestService getRequest = new requestServiceFullstack();
	
	public void supApproval(Context ctx) {
		
		int requestId = Integer.parseInt(ctx.formParam("requestId"));
	
		
		String supApproval = ctx.formParam("approval");
		
		request newRequest = new request(supApproval);
		
		getRequest.supApproval(requestId, newRequest);
		
		ctx.redirect("/supervisorHomePage.html");

		

	}

}
