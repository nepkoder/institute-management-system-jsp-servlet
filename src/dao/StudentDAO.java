package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.catalina.tribes.util.Arrays;

import model.StudentModel;

public class StudentDAO {
	
	public static boolean Insert(StudentModel sm) {
		Connection conn = DBUtils.MyConnection();
		PreparedStatement ps = null;
		boolean status = false;
		
		try {
			ps = conn.prepareStatement("insert into student_tbl(name, gender, country, hobbies) values(?,?,?,?)");
			ps.setString(1, sm.getName());
			ps.setString(2, sm.getGender());
			ps.setString(3, sm.getCountry());
			ps.setString(4, Arrays.toString(sm.getHobbies()));
//			ps.setNString(4, sm.getHobbies());
			
//			ps.executeQuery();
			
			int j = ps.executeUpdate();
			if (j == 1) {
				System.out.println("row affected.");
			status = true;
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			// TODO: handle exception
		}
		return status;
	}

}
