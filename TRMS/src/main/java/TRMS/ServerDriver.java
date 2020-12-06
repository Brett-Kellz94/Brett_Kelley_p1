package TRMS;
import io.javalin.Javalin;
import TRMSJavalin.controller.approvedController;
import TRMSJavalin.controller.authController;
import TRMSJavalin.controller.benCoApprovalController;
import TRMSJavalin.controller.dhApprovalController;
import TRMSJavalin.controller.finalGradeController;
import TRMSJavalin.controller.getAllRequestsController;
import TRMSJavalin.controller.requestController;
import TRMSJavalin.controller.supApprovalController;
import TRMSJavalin.controller.awardController;

public class ServerDriver {

	private static authController authController = new authController();
	public static requestController reqController = new requestController();
	public static approvedController appController = new approvedController();
	public static getAllRequestsController allReqController = new getAllRequestsController();
	public static supApprovalController supController = new supApprovalController();
	public static dhApprovalController dhController = new dhApprovalController();
	public static benCoApprovalController bencoController = new benCoApprovalController();
	public static finalGradeController gradeController = new finalGradeController();
	public static awardController awardController = new awardController();
	
	
	private static  String LOGIN_PATH = "/login";
	private static  String REQUEST_PATH = "/request";
	private static  String APPROVED_PATH = "/approvedRequests";
	private static  String ALL_REQUEST_PATH = "/allRequests";
	private static  String SAPPROVAL_PATH = "/supApproval";
	private static  String DHAPPROVAL_PATH = "/dhApproval";
	private static  String BENCOAPPROVAL_PATH = "/bencoApproval";
	private static  String GRADE_PATH = "/finalGrade";
	private static  String AWARD_PATH = "/reward";
	
	
public static void main(String[] args) {
		Javalin app = Javalin.create(config -> {config.addStaticFiles("/public"); }).start(9090); //sets up and starts our server
		app.post(LOGIN_PATH, ctx -> authController.login(ctx));
		//app.get(LOGIN_PATH, ctx -> authController.checkUser(ctx));
		app.post(REQUEST_PATH, ctx -> reqController.createRequest(ctx));
		app.get(REQUEST_PATH, ctx -> reqController.getEmplRequests(ctx));
		app.get(APPROVED_PATH,  ctx -> appController.getApprovedRequests(ctx));
		app.get(ALL_REQUEST_PATH, ctx -> allReqController.getAllRequests(ctx));
		app.post(SAPPROVAL_PATH, ctx -> supController.supApproval(ctx));
		app.post(DHAPPROVAL_PATH, ctx -> dhController.dhApproval(ctx));
		app.post(BENCOAPPROVAL_PATH, ctx -> bencoController.bencoApproval(ctx));
		app.post(GRADE_PATH, ctx -> gradeController.makeFinalGrade(ctx));
		app.get(GRADE_PATH, ctx -> gradeController.getGrades(ctx));
		app.post(AWARD_PATH, ctx -> awardController.sendReward(ctx));
		app.get(AWARD_PATH, ctx -> awardController.getReward(ctx));
	}
}
