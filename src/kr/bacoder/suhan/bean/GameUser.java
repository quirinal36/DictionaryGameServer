package kr.bacoder.suhan.bean;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class GameUser {
	private int id;
	private String username;
	private String pwd;
	private String login;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}
	public static GameUser parseUser(ResultSet rs) {
		GameUser result = new GameUser();
		try {
			result.setId(rs.getInt("id"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			result.setLogin(rs.getString("login"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			result.setUsername(rs.getString("username"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
