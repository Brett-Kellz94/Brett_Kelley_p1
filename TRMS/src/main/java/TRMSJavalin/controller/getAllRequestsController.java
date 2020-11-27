package TRMSJavalin.controller;

import java.util.List;

import TMRS.pojos.request;
import TRMSJavalin.service.requestService;
import TRMSJavalin.service.requestServiceFullstack;
import io.javalin.http.Context;

public class getAllRequestsController {
	
	requestService request = new requestServiceFullstack();

	public void getAllRequests(Context ctx) {

		
		List<request> requests = request.getAllRequests();
		
		 ctx.json(requests);
		
	}
	
}
