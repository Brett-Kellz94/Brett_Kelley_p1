package TMRS.pojos;

public class reward {

	private int requestId;
	private int employeeId;
	private String courseDescription;
	private double rewardAmount;
	private String finalApproval;
	
	
	public reward(int requestId, String finalApproval) {
		super();
		this.requestId = requestId;
		this.finalApproval = finalApproval;
	}
	
	public reward() {
		super();
	}
	
	
	public int getRequestId() {
		return requestId;
	}
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public double getRewardAmount() {
		return rewardAmount;
	}
	public void setRewardAmount(double d) {
		this.rewardAmount = d;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public String getFinalApproval() {
		return finalApproval;
	}
	public String setFinalApproval(String finalApproval) {
		this.finalApproval = finalApproval;
		return finalApproval;
	}
	
}
