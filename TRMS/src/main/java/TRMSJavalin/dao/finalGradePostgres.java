package TRMSJavalin.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import TMRS.pojos.finalGrade;
import TRMSJavalin.util.ConnectionUtil;

public class finalGradePostgres implements finalGradeDao {
	
	private ConnectionUtil connUtil = new ConnectionUtil();
	
	public void setConnUtil(ConnectionUtil connUtil) {
		this.connUtil = connUtil;
	}

	@Override
	public void makeFinalGrade(finalGrade grade) {
		String sql = "insert into final_grade (requestid, grading_format, final_grade, pass_threshold)"
				+ "values(?, ?, ?, ?)";
		
		try (Connection conn = connUtil.createConnection()) {
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1,  grade.getRequestId());
			pstmt.setString(2, grade.getGradingFormat());
			pstmt.setString(3, grade.getGradeEarned());
			pstmt.setString(4, grade.getPassingGrade());
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public List<finalGrade> getFinalGrade() {
		List<finalGrade> Grades = new ArrayList<>();
		
		try (Connection conn = connUtil.createConnection()) {
			
			String sql = "select requestid, grading_format, final_grade, pass_threshold from final_grade";
			
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			
			while (rs.next()) {
				
				finalGrade grade = new finalGrade();
				
				grade.setRequestId(rs.getInt("requestId"));
				grade.setGradingFormat(rs.getString("grading_format"));
				grade.setGradeEarned(rs.getString("final_grade"));
				grade.setPassingGrade(rs.getString("pass_threshold"));
				
				Grades.add(grade);
				
			}
			
			
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		return Grades;
	}

}
