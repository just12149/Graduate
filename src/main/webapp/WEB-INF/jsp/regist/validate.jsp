<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2016/12/28
  Time: 10:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; charset=UTF-8" language="java" import="java.sql.*" errorPage="" %>
<%
  String rand = (String)session.getAttribute("rand");
  String input = request.getParameter("rand");
  if(rand.equals(input)){
    out.print("<script>alert('验证通过！');</script>");
  } else{
    out.print("<script>alert('请输入正确的验证码！');location.href='login.jsp';</script>");
  }
%>
