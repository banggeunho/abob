import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
	void DB() {
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
		ResultSet rs = null;
		try {
			stmt = con.createStatement();
			String sql = "select str_id, str_name, loc, menu_id, name, cost,cook_time, food_type  from store natural join menu";
			rs = stmt.executeQuery(sql);
	        ResultSetMetaData rsmd = rs.getMetaData();
	        for (int i =1; i<=rsmd.getColumnCount(); i++) {
	        	System.out.print(rsmd.getColumnName(i)+ "(");
	        	System.out.print(rsmd.getColumnTypeName(i)+ ")\t");
	        }
	        System.out.println();
			
			while(rs.next()) {
				String str_name = rs.getString(1);
				if(rs.wasNull()) str_name = "null";
				String str_loc = rs.getString(2);
				if(rs.wasNull()) str_loc = "null";
				String menu_id = rs.getString(3);
				if(rs.wasNull()) menu_id = "null";
				String name = rs.getString(4);
				if(rs.wasNull()) name = "null";
				String cost  = rs.getString(5);
				if(rs.wasNull()) cost = "null";
				String cook_time = rs.getString(6);
				if(rs.wasNull()) cook_time = "null";
				String food_type = rs.getString(7);
				if(rs.wasNull()) food_type = "null";
				System.out.println(str_name + "\t\t" + str_loc + "\t\t" + menu_id
						  			+ "\t\t" + name + "\t\t" + cost + "\t\t" + cook_time
						  			 + "\t\t" + food_type);
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