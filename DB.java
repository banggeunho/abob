import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import java.awt.Component;
import java.io.PrintWriter;
import java.lang.*;

public class DB {
	public static Hashtable<Integer, String> menu_set =new Hashtable<Integer, String>();
	public static int menu_cnt=0;
	
	boolean DB(int a_time, int m_time, int rest) {
	    int cnt=0;
	    int food_time;
	     
		Connection con = null;
		try
		{
		    Class.forName("com.mysql.cj.jdbc.Driver");
		    String url="jdbc:mysql://localhost:3306/abob?serverTimezone=UTC&useSSL=false";
		    String user = "root", passwd = "12345";
		    con = DriverManager.getConnection(url, user, passwd);
		   // System.out.println(con);
		} catch(ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
		}
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSet prs = null;		
	//	n.put(name,out); // 위에서 선언한 n이라는 해쉬테이블에 client 정보를 넣어줌.
	//	n.remove(name,out); //n hashTable에서 해당 name 제거
		try {
			//stmt = con.createStatement();
			String psql = "select str_name, str_id, name, cost,cook_time,menu_id from store natural join menu where ?-900>=(cook_time+?) and str_id=?";
			
			pstmt= con.prepareStatement(psql);
			pstmt.setInt(1, a_time*60); //query문에 사용.
			pstmt.setInt(2, m_time*60); //query문에 사용.
			pstmt.setInt(3, rest); //query문에 사용.
			rs = pstmt.executeQuery();
			//System.out.println(pstmt);
	        //System.out.println();	        		
			while(rs.next()) {
				cnt++;
				String str_name = rs.getString(1);
				if(rs.wasNull()) str_name = "null";
				String str_id = rs.getString(2);
				if(rs.wasNull()) str_id = "null";
				String name = rs.getString(3);
				if(rs.wasNull()) name = "null";
				String cost  = rs.getString(4);
				if(rs.wasNull()) cost = "null";
				String cook_time = rs.getString(5);
				if(rs.wasNull()) cook_time = "null";
				String menu_id = rs.getString(6);
				if(rs.wasNull()) menu_id = "null";
				//nt menu_cnt = rs.getInt(7);
				//if(rs.wasNull()) menu_cnt = (Integer) null;
				food_time = a_time - (m_time + Integer.parseInt(cook_time)/60);
				String ab = str_id+"["+name + "] // " + str_name +
						 " // " + cost + "원 // "+food_time+"분#\n";
				DB.menu_set.put(Integer.parseInt(menu_id), ab);
				//menu_cnt += menu_cnt;
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
		if(cnt>=1)return true;
		else return false;
	}
}