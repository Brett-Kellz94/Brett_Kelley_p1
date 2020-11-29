package TRMSJavalin.controller;

import TMRS.pojos.request;
import TRMSJavalin.service.requestService;
import TRMSJavalin.service.requestServiceFullstack;
import io.javalin.http.Context;

public class dhApprovalController {

requestService getRequest = new requestServiceFullstack();
	
	public void dhApproval(Context ctx) {
		
		int requestId = Integer.parseInt(ctx.formParam("requestId"));

		String dhApproval = ctx.formParam("approval");
		
		request newRequest = new request(dhApproval);
		
		getRequest.dhApproval(requestId, newRequest);
		
		ctx.redirect("/dHeadRequests.html");
		
		
		

	}

	
}
