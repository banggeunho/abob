import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.lang.*;

public class DB {
	void DB(int a_time) {
		int result;
		Connection con = null;
		try
		{
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    String url="jdbc:mysql://localhost:3306/abob?serverTimezone=UTC&useSSL=false";
		    String user = "root", passwd = "1234";
		    con = DriverManager.getConnection(url, user, passwd);
		    System.out.println(con);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet prs = null;
		try {
			//stmt = con.createStatement();
			String psql = "select str_name, loc, name, cost,cook_time from store natural join menu where cook_time < ?";
			
			pstmt= con.prepareStatement(psql);
			a_time = a_time*60; //분단위를 초단위로 계산
			pstmt.setInt(1, a_time); //query문에 사용.
			rs = pstmt.executeQuery();
			
	        System.out.println();	        			
			while(rs.next()) {
				String str_name = rs.getString(1);
				if(rs.wasNull()) str_name = "null";
				String str_loc = rs.getString(2);
				if(rs.wasNull()) str_loc = "null";
				String name = rs.getString(3);
				if(rs.wasNull()) name = "null";
				String cost  = rs.getString(4);
				if(rs.wasNull()) cost = "null";
				String cook_time = rs.getString(5);
				if(rs.wasNull()) cook_time = "null";
				System.out.println("<"+str_name + ">\t\t\n" +"장소: "+ str_loc +
											"\n 메뉴: "+ name + "\n비용: " + cost + "\n조리시간: " + cook_time);
			}
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		// --------------------------------- //

		try {
			if(con != null && !con.isClosed()) con.close();
			if(rs != null && !rs.isClosed()) rs.close();			
		} catch(SQLException e) {
			e.printStackTrace();
		}		
	}
}