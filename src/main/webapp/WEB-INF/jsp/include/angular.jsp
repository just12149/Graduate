<%--
  页面功能:用来引入angular
  作者: Administrator
  创建日期: 2015/12/2
  创建时间: 9:49
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% String context=request.getContextPath(); %>
<script>
  var context="${pageContext.request.contextPath}";
</script>
<link href="<%=context%>/resources/frame/angular/ui/animate/nga.all.min.css" rel="stylesheet" type="text/css" />
<script src="<%=context%>/resources/frame/angular/base/angular.js" type="text/javascript"></script>
<script type="text/javascript" src="<%=context%>/resources/frame/angular/base/angular-animate.min.js"></script>
<script src="<%=context%>/resources/javascript/ngFilterModule.js" type="text/javascript"></script>
