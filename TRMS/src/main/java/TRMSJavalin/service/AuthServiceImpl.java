package TRMSJavalin.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import TRMSJavalin.dao.loginDao;
import TRMSJavalin.dao.loginDaoPostgres;

import java.util.logging.Logger;


public class AuthServiceImpl implements AuthService{
	
	private static Logger log = Logger.getAnonymousLogger();

	
	//private static byte[] salt = new SecureRandom().getSeed(16);

	private Map<String, String> tokenRepo = new HashMap<>();
	
	@Override
	public boolean authenticateUser(int username, String password) {
		
		loginDao newLogin = new loginDaoPostgres();
		
		List<String> list = newLogin.getPassword(username);
		    String dbPassword = list.get(0).toString();
		    
		if (dbPassword.equals(password)) {
			
			log.info("successful login has occured");
			
			return true;
		}
		
		return false;
	}

//	@Override
//	public String createToken(int username) {
//		String token = simpleHash(username);
//		tokenRepo.put(token, username);
//		return token;
//	}
//
//	@Override
//	public String validateToken(String token) {
//		return tokenRepo.get(token);
//	}
//	
//	private String simpleHash(int username) {
//		
//		String hash = null;
//		
//		MessageDigest md;
//		try {
//			md = MessageDigest.getInstance("SHA-512");
//			md.update(salt);
//			
//			byte[] bytes = md.digest(username.getBytes());
//
//			StringBuilder sb = new StringBuilder();
//			
//			for (int i = 0; i < bytes.length; i++) {
//				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(0));
//			}
//			
//			hash = sb.toString();
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		return hash;
//	}
}
