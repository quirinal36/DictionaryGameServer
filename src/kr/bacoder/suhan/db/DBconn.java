package kr.bacoder.suhan.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;
import java.util.logging.Logger;

import org.json.JSONArray;
import org.json.JSONObject;

import kr.bacoder.suhan.bean.GameUser;

public class DBconn {
Logger logger = Logger.getLogger(DBconn.class.getSimpleName());
	
	private String userName 	= "dev";
	private String password 	= "789gagul";
	private String dbms 		= "mysql";
	private String dbName 		= "new_schema";
	private String serverName 	= "35.234.23.104";
	private int portNumber 		= 3306;
	
	public Connection getConnection() throws SQLException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	    Connection conn = null;
	    Properties connectionProps = new Properties();
	    connectionProps.put("user", this.userName);
	    connectionProps.put("password", this.password);

	    if (this.dbms.equals("mysql")) {
	        conn = DriverManager.getConnection(
	                   "jdbc:" + this.dbms + "://" +
	                   this.serverName +
	                   ":" + this.portNumber + "/" +
	                   this.dbName + "?" +
	                   "useSSL=false",
	                   connectionProps);
	    }
	    return conn;
	}
	
	public int signupUser(GameUser user) {
		int result = 0;
		try(Connection conn = getConnection()){
			String sql = "INSERT INTO GameUser "
					+ "(username, login, pwd) "
					+ "VALUES (?,?,?)"; 
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getUsername());
			pstmt.setString(2, user.getLogin());
			pstmt.setString(3, user.getPwd());
			result= pstmt.executeUpdate();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	public JSONArray getUser(GameUser user) {
		JSONArray result = new JSONArray();
		try(Connection conn = getConnection()){
			String sql = "SELECT * FROM GameUser WHERE login = ? and pwd = ?";
			logger.info(sql);
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user.getLogin());
			pstmt.setString(2, user.getPwd());
			
			ResultSet rs = pstmt.executeQuery();
			while(rs.next()) {
				JSONObject json = new JSONObject(GameUser.parseUser(rs));
				result.put(json);
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
