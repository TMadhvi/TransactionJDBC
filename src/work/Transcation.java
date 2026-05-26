package work;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transcation {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/bank";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "madhvi1320";
	
	
	public static Connection makeConnection() {
		Connection con = null;
		
		try {
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
	
	public static void main(String[] args) {
		Connection con = makeConnection();
		PreparedStatement pst1 = null;
		PreparedStatement pst2 = null;
		
		double amount = 1000;
		try {
			con.setAutoCommit(false);
			pst1 = con.prepareStatement("update account set balance = balance-? where id=?");
			pst1.setDouble(1, amount);
			pst1.setInt(2, 1);
			
			pst2 = con.prepareStatement("update account set balance = balance+? where id=?");
		    pst2.setDouble(1, amount);
		    pst2.setInt(2, 2);
		    
		    int i = pst1.executeUpdate();
		    int j = pst2.executeUpdate();
		    
		    if(i != 0 && j != 0) {
		    	con.commit();
		    	System.out.println("Transaction Successfully...");
		    }
		
		} catch (SQLException e) {
			e.printStackTrace();
			
			if(con != null) {
				try {
					con.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
				
		}
			
	}

}
