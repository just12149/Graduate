<%--
  User: wangchong
  Date: 2017/2/6
  Time: 17:39
  Email:   wangchong@nowledgedata.com.cn
  Company: NowledgeData
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html ng-app="showApp" ng-controller="showCtrl">
<head>
    <title>新闻内容</title>
  <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/jsp/include/angular.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/jsp/include/ngTable.jsp"></jsp:include>
  <jsp:include page="/WEB-INF/jsp/include/boostrap3.jsp"></jsp:include>
  <script src="${pageContext.request.contextPath}/resources/javascript/showController.js"></script>
  <script src="${pageContext.request.contextPath}/resources/javascript/showService.js"></script>
</head>
<body ng-repeat="list in groupList">

<table width="40%" align="center" cellpadding="20px" cellspacing="20px">
   <tr>
     <td>
       <h3 align="center" ng-bind="list.title" style="color: #4247c2"></h3>
     </td>
   </tr>
  <tr>
    <td>
      <span style="margin-left: 90px;">{{list.author}}</span>
      <span style="padding-left: 16px;">{{list.createdTime}}</span>
    </td>
  </tr>
  <tr>
    <td>
      <img style="padding:20px 20px 30px 50px" width="570px" height="360px" src="${pageContext.request.contextPath}/upload/{{list.url}}">
    </td>
  </tr>
  <tr style="padding-top: 10px;text-indent:30px;">
    <td>
    <span ng-bind="list.content" style="font-size: 16px;letter-spacing: 1px; "></span>
    </td>
  </tr>
</table>
</body>
</html>
