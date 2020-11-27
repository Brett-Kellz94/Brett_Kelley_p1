package TRMSJavalin.controller;

import java.util.List;

import TMRS.pojos.finalGrade;
import TRMSJavalin.service.finalGradeFullstack;
import TRMSJavalin.service.finalGradeService;
import io.javalin.http.Context;

public class finalGradeController {

	finalGradeService grade = new finalGradeFullstack();
	
	public void makeFinalGrade(Context ctx) {
		
		int requestId = Integer.parseInt(ctx.formParam("requestId"));
		
		String passingGrade = ctx.formParam("minimumGrade");
		
		String gradingFormat = ctx.formParam("gradingFormat");
		
		String achieved = ctx.formParam("grade");
		
		finalGrade newGrade = new finalGrade(requestId, passingGrade, gradingFormat, achieved);
		
		grade.makeFinalGrade(newGrade);
		
		System.out.println("it worked!");
		
		ctx.redirect("finalGrade.html");
		
	}
	
	public void getGrades(Context ctx) {
		
		List <finalGrade> grades = grade.getFinalGrade();
		
		
		System.out.print("hey!");
		ctx.json(grades);
		
		
	}
	
}
