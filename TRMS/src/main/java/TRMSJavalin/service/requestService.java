package TRMSJavalin.service;

import java.util.List;

import TMRS.pojos.request;


public interface requestService {
	
public void createRequest(request request);

public List<request> getEmplRequests(int employeeId);
	
public List<request> getAllRequests();
	
public void supApproval(int requestId, request request);

public void dhApproval(int requestId, request request);

public void bencoApproval(int requestId, request request);

}
