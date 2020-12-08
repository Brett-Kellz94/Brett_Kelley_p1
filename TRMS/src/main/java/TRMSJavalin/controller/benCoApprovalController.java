package TRMSJavalin.controller;

import TMRS.pojos.request;
import TRMSJavalin.service.requestService;
import TRMSJavalin.service.requestServiceFullstack;
import io.javalin.http.Context;
import java.util.logging.Logger;

public class benCoApprovalController {
	
	private static Logger log = Logger.getAnonymousLogger();
	
requestService getRequest = new requestServiceFullstack();
	
	public void bencoApproval(Context ctx) {
		
		int requestId = Integer.parseInt(ctx.formParam("requestId"));

		String supApproval = ctx.formParam("approval");
		
		request newRequest = new request(supApproval );
		
		getRequest.bencoApproval(requestId, newRequest);
		
		ctx.redirect("/BenCoRequests.html");
		
		log.info("Benefits Coordinator approval has been sent");
		
		

	}


}
