package dao;

import java.sql.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.catalina.tribes.util.Arrays;

import model.CourseModel;
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
			
			String h = String.join(",", sm.getHobbies());
			ps.setString(4, h);
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
	
	

    public static ArrayList<StudentModel> selectAll(){
        ArrayList<StudentModel> al = new ArrayList<>();
        Connection conn = DBUtils.MyConnection();
        PreparedStatement ps = null;
        
        if(conn!=null){
            
            String sql = "select * from student_tbl";
            
            try{
               ps = conn.prepareStatement(sql);
               
               ResultSet rs = ps.executeQuery();
               while(rs.next()){
            	   int i = rs.getInt("id");
            	   String n = rs.getString("name");
            	   String c = rs.getString("country");
            	   String g = rs.getString("gender");
            	   String ho = rs.getString("hobbies");
            	   StudentModel sm = new StudentModel(i,n,c,g,ho);
            	   al.add(sm);
               }
                
            }catch(SQLException se){
                System.out.println(se);
            }
        }
        
        return al;
    }
    
    public static ArrayList<StudentModel> getById(int id){
        ArrayList<StudentModel> arrayList = new ArrayList<>();
        Connection connection = DBUtils.MyConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {

            String selectSQL = "select * from student_tbl where id=?";

            try {
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setInt(1, id);

                ResultSet rs = preparedStatement.executeQuery();
                while (rs.next()) {
                	int i = rs.getInt("id");
            		String n = rs.getString("name");
            		String c = rs.getString("country");
            		String g = rs.getString("gender");
            		String hobby = rs.getString("hobbies");
                    arrayList.add(new StudentModel(i,n,c,g,hobby));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return arrayList;
    }
    
    public static boolean update(StudentModel sm){
        boolean status = false;
        Connection connection = DBUtils.MyConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {

            String updateSQL = "update student_tbl set name=?, country=?, gender=? where id=?";

            try {
                preparedStatement = connection.prepareStatement(updateSQL);
                preparedStatement.setString(1, sm.getName());
                preparedStatement.setString(2, sm.getCountry());
                preparedStatement.setString(3, sm.getGender());
                preparedStatement.setInt(4, sm.getId());

                int i = preparedStatement.executeUpdate();
                if (i == 1) {
                    status = true;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                try {
                    preparedStatement.close();
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return status;
    }

    

    
    public static boolean DeleteContent(int id) {
    	Connection conn = DBUtils.MyConnection();
    	boolean status = false;
    	PreparedStatement ps = null;
    	
    	if (conn!=null) {
    		String query = "delete from student_tbl where id = ?";
    		try {
    		ps = conn.prepareStatement(query);
    		ps.setInt(1, id);
    		int i = ps.executeUpdate();
    		if (i == 1) {
				System.out.println("Record deleted");
				status = true;
			}
    		
    		} catch (SQLException e) {
				e.printStackTrace();
    			// TODO: handle exception
			}
			
		}
 
    	
    	return status;
    }

	

}
