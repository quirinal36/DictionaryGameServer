<%@page import="kr.bacoder.suhan.bean.MyInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
String newvalue ="helloworld";
MyInfo info = new MyInfo();

%>

<html>
		<body>

		인삿말<%=newvalue %>
		<br/>
		<table>
			<tr>
				<td>이름</td>
				<td><%=info.getName() %>
				</td>
			</tr>
			<tr>
				<td>나이</td>
				<td><%=info.getAge() %>
				</td>
			</tr>
			<tr>
				<td>직업</td>
				<td><%=info.getJob() %>
				</td>
			</tr>
		</table>
		</body>
</html>