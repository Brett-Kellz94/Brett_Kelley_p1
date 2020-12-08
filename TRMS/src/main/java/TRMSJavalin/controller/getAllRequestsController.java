package TRMSJavalin.controller;

import java.util.List;

import TMRS.pojos.request;
import TRMSJavalin.service.requestService;
import TRMSJavalin.service.requestServiceFullstack;
import io.javalin.http.Context;
import java.util.logging.Logger;

public class getAllRequestsController {
	
	requestService request = new requestServiceFullstack();
	
	private static Logger log = Logger.getAnonymousLogger();

	
	public void getAllRequests(Context ctx) {
		

		int employeeId= Integer.parseInt(ctx.queryParam("employeeId"));
		
		List<request> requests = request.getAllRequests(employeeId);
		
		 ctx.json(requests);
		
		 log.info("Requests have been retrieved");
	}
	
}
