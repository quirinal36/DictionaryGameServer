package kr.bacoder.suhan.bean;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class GameUser {
	private int id;
	private String username;
	private String pwd;
	private String login;
	private String sex;
	private String phone;
	private String email;
	private Date signupDate;

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
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getSignupDate() {
		return signupDate;
	}
	public void setSignupDate(Date signupDate) {
		this.signupDate = signupDate;
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
		try {
			result.setSex(rs.getString("sex"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			result.setPhone(rs.getString("phone"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			result.setEmail(rs.getString("email"));
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//		result.setSignupDate(new Date(rs.getTimetamp("signupDate")));
		return result;
	}
}
