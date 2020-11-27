package TRMSJavalin.controller;

import java.util.List;

import TRMSJavalin.dao.loginDao;
import TRMSJavalin.dao.loginDaoPostgres;
import TRMSJavalin.service.AuthService;
import TRMSJavalin.service.AuthServiceImpl;
import io.javalin.http.Context;

public class authController {
	private AuthService auth = new AuthServiceImpl();
	
	public void login(Context ctx) {
		int username = Integer.parseInt(ctx.formParam("username"));
		String password = ctx.formParam("password");
		//String password = ctx.formParam("password");
		boolean authenticated = auth.authenticateUser(username, password);
		if (authenticated) {
			//ctx.status(200);
			//ctx.cookieStore("security", auth.createToken(username));
			//get employee type
			loginDao newLogin = new loginDaoPostgres();
			
			List<String> list = newLogin.getEmployeeType(username);
			String emplType = list.get(0).toString();
			
			if (emplType.equals("1")) {
				ctx.redirect("homePage.html");
				//ctx.html("you've logged in!");
			}
			    
			//ctx.status(200);
			if (emplType.equals("2")) {
				ctx.redirect("supervisorHomePage.html");
			}
			
			
			if(emplType.equals("3")) {
				ctx.redirect("DHeadHomePage.html");
			}
			
            if(emplType.equals("4")) {
            	ctx.redirect("BenCoHomePage.html");
			}
			
			
		} else {
			//ctx.status(401);
			ctx.redirect("login.html?error=failed-login");
		}
	}
	
//	public void checkUser(Context ctx) {
//		ctx.html(auth.validateToken(ctx.cookieStore("security")));
//	}
}
