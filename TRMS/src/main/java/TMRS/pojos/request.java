package TMRS.pojos;

public class request {
	
	private int employeeId;
	private String requestDate;
	private String eventDate;
	private String description;
	private double cost;
	private String gradingFormat;
	private String justification;
	private int requestId;
	private String supervisorApproval;
	private String departmentHeadApproval;
	private String benCoApproval;
	
	
	public request(int employeeId, String requestDate, String eventDate, String description, double cost,
			 String justification) {
		super();
		this.employeeId = employeeId;
		this.requestDate = requestDate;
		this.eventDate = eventDate;
		this.description = description;
		this.cost = cost;
		this.justification = justification;
		
	}
	
	
	
	public request(int employeeId, String requestDate, String eventDate, String description, double cost,
			String gradingFormat, String justification, String supervisorApproval,  String departmentHeadApproval, String benCoApproval) {
		super();
		this.employeeId = employeeId;
		this.requestDate = requestDate;
		this.eventDate = eventDate;
		this.description = description;
		this.cost = cost;
		this.gradingFormat = gradingFormat;
		this.justification = justification;
		this.supervisorApproval = supervisorApproval;
		this.departmentHeadApproval = departmentHeadApproval;
		this.benCoApproval = benCoApproval;
	}
	
	
	public request(String Approval) {
		super();
        this.supervisorApproval = Approval;
        this.departmentHeadApproval = Approval;
        this.benCoApproval = Approval;
	}
	
	


	
	public request() {
		
	}
	
	
	public  int getEmployeeId() {
		return employeeId;
	}
	public  void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	
	
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	
	
	public String getEventDate() {
		return eventDate;
	}
	
	
	public void setEventDate(String eventDate) {
		this.eventDate = eventDate;
	}
	
	
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public double getCost() {
		return cost;
	}
	
	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	public String getGradingFormat() {
		return gradingFormat;
	}
	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}
	
	
	public String getJustification() {
		return justification;
	}
	public void setJustification(String justification) {
		this.justification = justification;
	}

	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getSupervisorApproval() {
		return supervisorApproval;
	}

	public void setSupervisorApproval(String supervisorApproval) {
		this.supervisorApproval = supervisorApproval;
	}

	public String getDepartmentHeadApproval() {
		return departmentHeadApproval;
	}

	public void setDepartmentHeadApproval(String departmentHeadApproval) {
		this.departmentHeadApproval = departmentHeadApproval;
	}

	public String getBenCoApproval() {
		return benCoApproval;
	}

	public void setBenCoApproval(String benCoApproval) {
		this.benCoApproval = benCoApproval;
	}

}
