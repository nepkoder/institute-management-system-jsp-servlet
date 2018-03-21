package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.Answer;
import model.ExamModel;

public class ExamDAO {
	
	public static boolean insert(ExamModel em) {
		boolean status = false;
		Connection conn = DBUtils.MyConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("insert into exam_tbl values(?,?,?,?,?,?);");
			ps.setString(1, em.getQuestion());
			ps.setString(2, em.getAnswer().getAnswer1());
			ps.setString(3, em.getAnswer().getAnswer2());
			ps.setString(3, em.getAnswer().getAnswer3());
			ps.setString(4, em.getAnswer().getAnswer4());
			ps.setString(4, em.getAnswer().getRight());
			
			int i = ps.executeUpdate();
			if(i == 1) {
				status = true;
			}
			
		} catch (SQLException e) {
			
			e.printStackTrace();// TODO: handle exception
		}
		return status;
	}
	
	public static ArrayList<ExamModel> getExamDetails() {
		
		ArrayList<ExamModel> al = new ArrayList<>();
		
		Connection conn = DBUtils.MyConnection();
		try {
			PreparedStatement ps = conn.prepareStatement("Select  *from exam_tbl");
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int id = rs.getInt("id");
				String q = rs.getString("question");
				String a1 = rs.getString("ans1");
				String a2 = rs.getString("ans2");
				String a3 = rs.getString("ans3");
				String a4 = rs.getString("ans4");
				String right = rs.getString("rightAns");
				Answer ans = new Answer(a1, a2, a3, a4, right);
				ExamModel em = new ExamModel(id, q,ans);
				al.add(em);
			}
		} catch (SQLException e) {
			e.getMessage();
			// TODO: handle exception
		}
		
		return al;
		
	}

}
