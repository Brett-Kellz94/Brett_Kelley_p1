package TRMSJavalin.service;

import java.util.List;

import TMRS.pojos.finalGrade;
import TRMSJavalin.dao.finalGradeDao;
import TRMSJavalin.dao.finalGradePostgres;

public class finalGradeFullstack implements finalGradeService {
	
	finalGradeDao gradeDao = new finalGradePostgres();

	@Override
	public void makeFinalGrade(finalGrade grade) {
		gradeDao.makeFinalGrade(grade);
		
	}

	@Override
	public List<finalGrade> getFinalGrade() {
		return gradeDao.getFinalGrade();
	}}
