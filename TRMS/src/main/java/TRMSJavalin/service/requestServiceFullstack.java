package TRMSJavalin.service;

import java.util.List;

import TMRS.pojos.request;
import TRMSJavalin.dao.requestDao;
import TRMSJavalin.dao.requestDaoPostgres;

public class requestServiceFullstack implements requestService{
	
	requestDao reqDao = new requestDaoPostgres();

	@Override
	public void createRequest(request request) {
		reqDao.createRequest(request);
	
	}

	@Override
	public List<request> getAllRequests() {
		return reqDao.getAllRequests();
	}

	@Override
	public List<request> getEmplRequests(int employeeId) {
		return reqDao.getEmplRequests(employeeId);
	}

	@Override
	public void supApproval(int requestId, request request) {
		reqDao.supApproval(requestId, request);
		
	}

	@Override
	public void dhApproval(int requestId, request request) {
		reqDao.dhApproval(requestId, request);
		
	}

	@Override
	public void bencoApproval(int requestId, request request) {
		reqDao.bencoApproval(requestId, request);
		
	}

	@Override
	public List<request> getAllRequests(int employeeId) {
		return reqDao.getAllRequests(employeeId);
	}

	@Override
	public List<request> getApprovedRequests(int employeeId) {
		// TODO Auto-generated method stub
		return reqDao.getApprovedRequests(employeeId);
	}

}
