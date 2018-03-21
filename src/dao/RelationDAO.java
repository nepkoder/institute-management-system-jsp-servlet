package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CourseStudent;

public class RelationDAO {

	public static boolean AddRelation(int sid, int cid) {
		Connection conn = DBUtils.MyConnection();
		boolean status = false;
		try {
			PreparedStatement ps = conn.prepareStatement("insert into course_student values(?,?)");
			ps.setInt(1, sid);
			ps.setInt(2, cid);
			int i = ps.executeUpdate();
			if (i == 1) {
				status = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return status;

	}

	public static ArrayList<CourseStudent> GetRelation() {

		ArrayList<CourseStudent> al = new ArrayList<>();

		String query = "select cs.id, c.id, c.title, s.id, s.name from course_student as cs, course_tbl as c, student_tbl as s where c.id=cs.cid and s.id =cs.sid";
		Connection conn = DBUtils.MyConnection();
		try {
			PreparedStatement ps = conn.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				al.add(new CourseStudent(
						rs.getInt(1),
						rs.getInt(2),
						rs.getString(3),
						rs.getInt(4),
						rs.getString(5)					));
			}
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return al;
	}

}
