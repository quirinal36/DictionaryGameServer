<%@page import="org.json.JSONObject"%>
<%@page import="kr.bacoder.suhan.bean.GameUser"%>
<%@page import="kr.bacoder.suhan.db.DBconn"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Locale"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.logging.Logger"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	final String path = getServletContext().getRealPath("/img");
	Logger logger = Logger.getLogger("signup.jsp");
	
	String login = request.getParameter("login");
	String username = request.getParameter("username");
	String pwd = request.getParameter("pwd");
	String sex = request.getParameter("sex");
	String phone = request.getParameter("phone");
	String email = request.getParameter("email");
	
	GameUser user = new GameUser();
	user.setLogin(login);
	user.setUsername(username);
	user.setPwd(pwd);
	user.setSex(sex);
	user.setPhone(phone);
	user.setEmail(email);
	
	String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA).format(new Date());
	
	DBconn dbconn = new DBconn();
	
	JSONObject json = new JSONObject();
	json.put("result", dbconn.signupUser(user));
	
	out.print(json.toString());
%>
