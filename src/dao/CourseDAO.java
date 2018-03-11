package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import model.CourseModel;

public class CourseDAO {
	
	public static boolean insert(CourseModel cm){
        Connection conn = DBUtils.MyConnection();
        PreparedStatement ps = null;
        boolean status = false;
        
        String sql ="insert into course_tbl(title,price,duration) values(?,?,?);";
        
        
        try{
            ps = conn.prepareStatement(sql);
            ps.setString(1, cm.getTitle());
            ps.setFloat(2, cm.getPrice());
            ps.setString(3, cm.getDuration());
            
            
            int i = ps.executeUpdate();
            if(i==1){
                System.out.println("Inserted a row");
                status = true;
            }
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
        return status;
    }
    
    public static ArrayList<CourseModel> selectAll(){
        ArrayList<CourseModel> al = new ArrayList<>();
        Connection conn = DBUtils.MyConnection();
        PreparedStatement ps = null;
        
        if(conn!=null){
            
            String sql = "select * from course_tbl";
            
            try{
               ps = conn.prepareStatement(sql);
               
               ResultSet rs = ps.executeQuery();
               
               while(rs.next()){
                   al.add(new CourseModel(
                           rs.getInt("id"), 
                           rs.getString("title"),
                           rs.getFloat("price"),
                           rs.getString("duration")));
               }
                
            }catch(SQLException se){
                System.out.println(se);
            }
        }
        
        return al;
    }
    
    public static ArrayList<CourseModel> getById(int id){
        ArrayList<CourseModel> arrayList = new ArrayList<>();
        Connection connection = DBUtils.MyConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {

            String selectSQL = "select * from course_tbl where id=?";

            try {
                preparedStatement = connection.prepareStatement(selectSQL);
                preparedStatement.setInt(1, id);

                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int cId = resultSet.getInt("id");
                    String cTitle = resultSet.getString("title");
                    float cPrice = resultSet.getFloat("price");
                    String cDuration = resultSet.getString("duration");

                    arrayList.add(new CourseModel(cId, cTitle, cPrice, cDuration));
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
    
    public static boolean update(CourseModel courseModel){
        boolean status = false;
        Connection connection = DBUtils.MyConnection();
        PreparedStatement preparedStatement = null;

        if (connection != null) {

            String updateSQL = "update course_tbl set course_tbl=?, price=?, duration=? where id=?";

            try {
                preparedStatement = connection.prepareStatement(updateSQL);
                preparedStatement.setString(1, courseModel.getTitle());
                preparedStatement.setFloat(2, courseModel.getPrice());
                preparedStatement.setString(3, courseModel.getDuration());
                preparedStatement.setInt(4, courseModel.getId());

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
    		String query = "delete from course_tbl where id = ?";
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
