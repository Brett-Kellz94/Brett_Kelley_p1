package TRMSJavalin.controller;

import java.util.List;

import TRMSJavalin.service.requestService;
import TRMSJavalin.service.requestServiceFullstack;
import io.javalin.http.Context;
import TMRS.pojos.request;


public class approvedController {
	
		
		requestService request = new requestServiceFullstack();
		
		public void getApprovedRequests(Context ctx) {
			
			int employeeId= Integer.parseInt(ctx.queryParam("employeeId"));
			
			List<request> requests = request.getApprovedRequests(employeeId);
			
			ctx.json(requests);
			
		}

}
