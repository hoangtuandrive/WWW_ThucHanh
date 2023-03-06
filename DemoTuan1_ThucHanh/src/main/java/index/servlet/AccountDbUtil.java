package index.servlet;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.sql.DataSource;

public class AccountDbUtil {
	private DataSource dataSource;

	public AccountDbUtil(DataSource theDataSource) {
		dataSource = theDataSource;
	}
	
	public void addAccountToDb(Account account) throws Exception {
		Connection myConn = null;
		PreparedStatement myStmt = null;		
		try {
			// get db connection
			myConn = dataSource.getConnection();			
			// create sql for insert
			String sql = "insert into account "
					   + "(name, email, password) "
					   + "values (?, ?, ?)";			
			myStmt = myConn.prepareStatement(sql);			
			// set the param values for the student
			myStmt.setString(1, account.getName());
			myStmt.setString(2, account.getEmail());
			myStmt.setString(3, account.getPassword());			
			// execute sql insert
			myStmt.execute();
		}
		finally {
			// clean up JDBC objects
			close(myConn, myStmt, null);
		}
	}
	
	private void close(Connection myConn, Statement myStmt, ResultSet myRs) {
		try {
			if (myRs != null) {
				myRs.close(); }			
			if (myStmt != null) {
				myStmt.close();	}			
			if (myConn != null) {
				myConn.close();   
				// doesn't really close it ... just puts back in connection pool
			}
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
	}
}
