package TRMSJavalin.controller;

import java.util.List;

import TMRS.pojos.finalGrade;
import TRMSJavalin.service.finalGradeFullstack;
import TRMSJavalin.service.finalGradeService;
import io.javalin.http.Context;
import java.util.logging.Logger;

public class finalGradeController {

	finalGradeService grade = new finalGradeFullstack();
	
	private static Logger log = Logger.getAnonymousLogger();
	
	public void makeFinalGrade(Context ctx) {
		
		int requestId = Integer.parseInt(ctx.formParam("requestId"));
		
		String passingGrade = ctx.formParam("minimumGrade");
		
		String gradingFormat = ctx.formParam("gradingFormat");
		
		String achieved = ctx.formParam("grade");
		
		finalGrade newGrade = new finalGrade(requestId, passingGrade, gradingFormat, achieved);
		
		grade.makeFinalGrade(newGrade);
		
		ctx.redirect("finalGrade.html");
		
		log.info("FInal grade has been submitted");
		
	}
	
	public void getGrades(Context ctx) {
		
		List <finalGrade> grades = grade.getFinalGrade();

		ctx.json(grades);
		
		log.info("Final grade has been retrieved");
		
		
	}
	
}
