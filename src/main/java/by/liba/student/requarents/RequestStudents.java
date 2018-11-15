package by.liba.student.requarents;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import by.liba.student.common.Students;
import by.liba.student.common.Util;
import by.liba.student.utils.ConnectToMysql;

public class RequestStudents implements Request<Students>{

	@Override
	public void createListItemS(List<Students> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void createItem(Students item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteItem(Students item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteListItemS(List<Students> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateItem(Students item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateListItemS(List<Students> items) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Students getById(Integer id){
		 try {  
			    Connection con = null;
			    java.sql.Statement state = null;
	    		ResultSet res = null;
	    		String sql = null;
	    		System.out.println("q");
	            Students student = new Students();
	    		try {                        
	    			con = ConnectToMysql
	            		.getConnectionToMysql();
				sql = String.format("SELECT * FROM BEGANSS.STUDENT WHERE STUDENT_ID = %s", id);
				res = state.executeQuery(sql);
				while (res.next()) {
					student.setFirstName(Util.trim(res.getString("FIRST_NAME")));
					student.setSecondName(Util.trim(res.getString("SECOND_NAME")));
					student.setId(res.getInt("STUDENT_ID"));
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	            
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }
		return null;
	}
    public static void main(String[]args) {
    	RequestStudents rs = new RequestStudents();
//    	System.out.println(rs.getById(1));
        rs.getById2(1);
    }
    
    
    public void getById2(Integer id){
		 try {  
			    Connection con = null;
			    java.sql.Statement state = null;
	    		ResultSet res = null;
	    		String sql = null;
	    		System.out.println("q");
	            Students student = new Students();
	    		try {                        
	    			con = ConnectToMysql
	            		.getConnectionToMysql();
				//sql = String.format("SELECT * FROM BEGANSS.STUDENT WHERE STUDENT_ID = %s", id);
	    			sql = "SELECT * FROM BEGANSS.STUDENT";
				res = state.executeQuery(sql);
				while (res.next()) {
					System.out.println(res.getInt("STUDENT_ID"));
				}
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (con != null) {
					try {
						con.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
	            
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        }

	}
    
    
}
