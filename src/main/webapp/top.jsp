<%--
  页面功能:
  作者: Administrator
  创建日期: 2016/1/21
  创建时间: 11:32
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="graduate.user.model.User" %>
<%
    String context = request.getContextPath();
    String userName = (String) session.getAttribute("userName");

%>

<!doctype html>
<html>
<head>
    <title>新闻发布管理系统</title>
    <style>
        .media{ border-bottom: 1px dashed #ccc;padding: 5px 0 0 15px}
    </style>

    <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>


    <link rel="stylesheet" type="text/css" href="<%=context%>/resources/css/base.css" />
    <link rel="stylesheet" type="text/css" href="<%=context%>/resources/css/styles.css" />
    <script src="<%=context%>/resources/js/jquery.touchSlider.js"></script>
    <script src="<%=context%>/resources/js/js.js"></script>
    <script  src="<%=context%>/resources/js/banner.js"></script>
    <script src="<%=context%>/resources/js/stellar.js"></script>
    <script  src="<%=context%>/resources/js/jquery.event.drag-1.5.min.js"></script>

    <script  src="<%=context%>/resources/js/main.min.js"></script>

    <style>
        .index_city_network ul li a.active{
            background-color:   #3653D5
        }
    </style>
    <style type="text/css">
        .container{height:100%;margin:auto;}
        /*left*/
        .leftsidebar_box{overflow:visible !important;background-color:#3992d0;}
        .line{height:2px;width:100%;background-image:url(<%=context%>/resources/images/left/line_bg.png);background-repeat:repeat-x;}
        .leftsidebar_box dt{padding-left:40px;padding-right:10px;background-repeat:no-repeat;background-position:10px center;color:#f5f5f5;font-size:14px;position:relative;line-height:48px;cursor:pointer;}
        .leftsidebar_box dd{background-color:#317eb4;padding-left:40px;}
        .leftsidebar_box dd a{color:#f5f5f5;line-height:20px;}
        .leftsidebar_box dt img{position:absolute;right:10px;top:20px;}
        .system_log dt{background-image:url(<%=context%>/resources/images/left/system.png)}
        .custom dt{background-image:url(<%=context%>/resources/images/left/custom.png)}
        .channel dt{background-image:url(<%=context%>/resources/images/left/channel.png)}
        .app dt{background-image:url(<%=context%>/resources/images/left/app.png)}
        .cloud dt{background-image:url(<%=context%>/resources/images/left/cloud.png)}
        .syetem_management dt{background-image:url(<%=context%>/resources/images/left/syetem_management.png)}
        .source dt{background-image:url(<%=context%>/resources/images/left/source.png)}
        .statistics dt{background-image:url(<%=context%>/resources/images/left/statistics.png)}
        .leftsidebar_box dl dd:last-child{padding-bottom:10px;}
    </style>

    <%-- <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>--%>
    <jsp:include page="/WEB-INF/jsp/include/angular.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/ngTable.jsp"></jsp:include>
    <jsp:include page="/WEB-INF/jsp/include/boostrap3.jsp"></jsp:include>
    <link href="<%=context%>/resources/frame/bootstrap3/css/test.css" rel="stylesheet" type="text/css"/>

    <script src="<%=context%>/resources/javascript/Catalog/CatalogController.js"></script>
    <script src="<%=context%>/resources/javascript/Catalog/CatalogFilter.js"></script>
    <script src="<%=context%>/resources/javascript/Catalog/CatalogService.js"></script>
    <script src="<%=context%>/resources/frame/bootstrap3/js/bootstrap.min.js"></script>
</head>
<body class="index_body">
<div class="index_head">
    <div class="index_width clearfix">
        <div class="banner">
            <div class="main_visual">
                <div class="main_image">
                    <ul>
                        <li><a href=""><img src="<%=context%>/resources/images/banner1.jpg" /></a></li>
                        <li><a href=""><img src="<%=context%>/resources/images/banner2.jpg" /></a></li>
                        <li><a href=""><img src="<%=context%>/resources/images/banner3.jpg" /></a></li>
                    </ul>
                    <a href="javascript:;" id="btn_prev"></a>
                    <a href="javascript:;" id="btn_next"></a>
                </div>
                <div class="flicking_con">
                    <div class="w clearfix">
                        <ul class="clearfix">
                            <li><a href="#">01</a></li>
                            <li><a href="#">02</a></li>
                            <li><a href="#">03</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>

</div>
<div class="index_main index_width">
    <div class="index_nav">
        <ul class="top_nav ">
            <li><a href="/index"><i class="iconfont icon-home"></i><span >系统首页</span></a></li>

            <li><a ><i class="iconfont icon-yonghu"></i><span><%=userName%></span></a></li>
            <li><a href="javascript:void(0)" onclick="logout()"><i class="iconfont icon-kechengzhuanhuafuwu"></i><span >注销</span></a></li>
        </ul>
    </div>




</div>


</div>


<script>


    function logout() {
        $.ajax({
            url: "/user/logout.do",
            type: 'post',
            dataType: 'json',
            success: function (dataJson) {
                window.location.href = '<%=context%>/user/loginPage.do';
            }
        });
    }
</script>
</body>

</html>
