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
	Logger logger = Logger.getLogger("login.jsp");
	
	String login = request.getParameter("login");
	String pwd = request.getParameter("pwd");
	GameUser user = new GameUser();
	user.setLogin(login);
	user.setPwd(pwd);
	
	String timeStamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.KOREA).format(new Date());
	
	DBconn dbconn = new DBconn();
	
	JSONObject json = new JSONObject();
	json.put("list", dbconn.getUser(user));
	
	out.print(json.toString());
%>
