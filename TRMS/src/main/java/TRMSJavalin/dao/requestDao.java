package TRMSJavalin.dao;

import java.util.List;

import TMRS.pojos.request;

public interface requestDao {
	
	public void createRequest(request request);
	
	public List<request> getAllRequests();
	
	public List<request> getEmplRequests(int employeeId);
	
	public request supApproval(int requestId, request request);
	
	public request dhApproval(int requestId, request request);
	
	public request bencoApproval(int requestId, request request);

}
