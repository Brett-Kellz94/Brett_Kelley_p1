package TRMSJavalin.service;

import java.util.List;

import TMRS.pojos.finalGrade;

public interface finalGradeService {
	
	public void makeFinalGrade(finalGrade grade);
	
	public List<finalGrade> getFinalGrade();
	

}
