package TRMSJavalin.dao;

import java.util.List;

import TMRS.pojos.finalGrade;

public interface finalGradeDao {
	
	public void makeFinalGrade(finalGrade grade);
	
	public List<finalGrade> getFinalGrade();

}
