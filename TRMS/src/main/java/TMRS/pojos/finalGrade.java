package TMRS.pojos;

public class finalGrade {
	
	private int requestId;
	private String passingGrade;
	private String gradingFormat;
	private String gradeEarned;


	public finalGrade(int requestId, String passingGrade, String gradingFormat, String gradeEarned) {
		super();
		this.requestId = requestId;
		this.passingGrade = passingGrade;
		this.gradingFormat = gradingFormat;
		this.gradeEarned = gradeEarned;		
		
	}
	
	public finalGrade() {
		super();
	}
	
	public int getRequestId() {
		return requestId;
	}

	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}

	public String getPassingGrade() {
		return passingGrade;
	}

	public void setPassingGrade(String passingGrade) {
		this.passingGrade = passingGrade;
	}

	public String getGradingFormat() {
		return gradingFormat;
	}

	public void setGradingFormat(String gradingFormat) {
		this.gradingFormat = gradingFormat;
	}

	public String getGradeEarned() {
		return gradeEarned;
	}

	public void setGradeEarned(String gradeEarned) {
		this.gradeEarned = gradeEarned;
	}
	

}
