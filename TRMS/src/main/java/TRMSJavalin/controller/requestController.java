package TRMSJavalin.controller;

import TRMSJavalin.service.requestService;
import TRMSJavalin.service.requestServiceFullstack;
import io.javalin.http.Context;

import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import TMRS.pojos.request;

public class requestController {

	requestService request = new requestServiceFullstack();
	
	public void createRequest(Context ctx) {
		
		int employeeId = Integer.parseInt(ctx.formParam("employeeId"));
	
		String requestDate = ctx.formParam("requestDate");
		
		String eventDate = ctx.formParam("eventDate");
		
		String description = ctx.formParam("description");
		
		double cost = Double.parseDouble(ctx.formParam("cost"));
		
		String gradingFormat = ctx.formParam("gradingFormat");
		
		String justification = ctx.formParam("justification");
		
		request newRequest = new request(employeeId, requestDate, eventDate, description, cost, gradingFormat, justification );
		
		request.createRequest(newRequest);
		
		ctx.redirect("checkStatus.html");

		
	}
	
	public void getEmplRequests(Context ctx) {
		
		System.out.println();
		
		System.out.println(ctx.queryParam("employeeId"));
		
		int employeeId= Integer.parseInt(ctx.queryParam("employeeId"));
		
		List<request> requests = request.getEmplRequests(employeeId);
		
			
		 ctx.json(requests);
		
		
	}
	
	
}
