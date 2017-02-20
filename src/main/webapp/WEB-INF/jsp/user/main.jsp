<%--
  页面功能:
  作者: Administrator
  创建日期: 2016/1/21
  创建时间: 11:32
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="graduate.model.User" %>
<%
    String context = request.getContextPath();
    String userName = (String) session.getAttribute("userName");

   /* if (session.getAttribute("user") == null) {
        out.println("<script>alert('您还未登录，请先登录。');window.location.href='/user/loginPage.do';</script>");
    }*/
%>

<!doctype html>
<html ng-app="mainApp" ng-controller="mainCtrl">
<head>

    <title>新闻发布管理系统</title>
    <style>
        .media{ border-bottom: 1px dashed #ccc;padding: 5px 0 0 15px}
    </style>
    <jsp:include page="/WEB-INF/jsp/include/jquery.jsp"></jsp:include>
    <%--<jsp:include page="/WEB-INF/jsp/include/boostrap3.jsp"></jsp:include>--%>
    <jsp:include page="/WEB-INF/jsp/include/angular.jsp"></jsp:include>

    <link rel="stylesheet" type="text/css" href="<%=context%>/resources/css/base.css" />
    <link rel="stylesheet" type="text/css" href="<%=context%>/resources/css/styles.css" />
    <script src="<%=context%>/resources/js/jquery.touchSlider.js"></script>
    <script src="<%=context%>/resources/js/js.js"></script>
    <script  src="<%=context%>/resources/js/banner.js"></script>
    <script src="<%=context%>/resources/js/stellar.js"></script>
    <script  src="<%=context%>/resources/js/jquery.event.drag-1.5.min.js"></script>
    <script  src="<%=context%>/resources/js/main.min.js"></script>
    <script src="<%=context%>/resources/javascript/user/mainController.js"></script>
    <script src="<%=context%>/resources/javascript/user/mainService.js"></script>

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
      <%--  <ul class="top_nav ">
            <li><a href="/index"><i class="iconfont icon-home"></i><span >系统首页</span></a></li>

            <li><a ><i class="iconfont icon-yonghu"></i><span><%=userName%></span></a></li>
            <li><a href="javascript:void(0)" onclick="logout()"><i class="iconfont icon-kechengzhuanhuafuwu"></i><span >注销</span></a></li>
        </ul>--%>
    </div>
    <div class="index_con clearfix">
        <div class="index_left">
            <div class="container">

                <div class="leftsidebar_box">
                    <div class="line"></div>
                    <dl class="system_log">
                        <dt><a href="" ng-click="doClick(1)">科技新闻</a><img src="<%=context%>/resources/images/left/select_xl01.png"></dt>
                    </dl>

                    <dl class="channel">
                        <dt><a href="" ng-click="doClick(2)"> 财经新闻</a><img src="<%=context%>/resources/images/left/select_xl01.png"></dt>
                    </dl>

                    <dl class="app">
                        <dt><a href="" ng-click="doClick(3)">体育新闻</a><img src="<%=context%>/resources/images/left/select_xl01.png"></dt>
                    </dl>

                    <dl class="custom">
                        <dt><a href="" ng-click="doClick(4)">民生新闻</a><img src="<%=context%>/resources/images/left/select_xl01.png"></dt>
                    </dl>

                    <dl class="cloud">
                        <dt><a href="" ng-click="doClick(5)">娱乐新闻</a><img src="<%=context%>/resources/images/left/select_xl01.png"></dt>
                    </dl>
                    <dl class="syetem_management">
                        <dt><a href="" ng-click="doClick(6)">教育新闻</a><img src="<%=context%>/resources/images/left/select_xl01.png"></dt>
                    </dl>

                    <dl class="statistics">
                        <dt>用户管理<img src="<%=context%>/resources/images/left/select_xl01.png"></dt>
                        <dd class="first_dd"><a href="<%=context%>/user/userInfoPage.do">个人信息</a></dd>
                        <dd><a href="<%=context%>/user/updatePwdPage.do">修改密码</a></dd>
                        <dd><a href="<%=context%>/user/PwdGetBackPage.do">密码找回</a></dd>
                        <dd><a href="<%=context%>/Echarts.jsp">数据支撑</a></dd>
                        <dd><a href="#">角色管理</a></dd>


                    </dl>
                    <dl class="statistics">
                        <dt>系统管理<img src="<%=context%>/resources/images/left/select_xl01.png"></dt>
                        <dd class="first_dd"><a href="#"></a></dd>
                        <dd><a href="<%=context%>/error.jsp">配置信息</a></dd>
                        <dd><a href="#">意见反馈</a></dd>
                    </dl>
                </div>
            </div>
        </div>
        <div class="index_center" style="text-align: left;position: absolute;margin-top:5px;margin-left: 230px; width: 60%;">
                <table  ng-repeat="news in newsList" style="width: 100%;background-color:white;font-size: 20px;">
                    <tr>
                        <td ng-bind="news.title"></td>
                        <td ng-bind="news.createdTime"></td>
                    </tr>

                    <tr>

                       <td ><a href="/news/newsdata.do" ><font  color="#8DB6CD">查看详情</font></a></td>

                        <td ng-bind="news.newsId"></td>
                        <%--<td ng-bind="news.url"   ></td>--%>
                        <%--<td><button style="width:50px;height: 20px; background-color: #0074d9;color:white;border: 0; font-size: 14px;">READ</button></td>--%>
                    </tr>
                </table>
        </div>
        <div class="index_right">
            <div class="inedx_news">
                <p></p>
                <ul>
                    <li><i></i><span>2016-12-09</span><a target="_blank" href="/qltk/fangzhapian.html">【头条】这3个福建人少损失7万多元，就是因为有了这个…</a></li>
                    <li><i></i><span>2016-12-09</span><a target="_blank"  href="/qltk/jcdt.html">【视点】“法治福建进行时”——基层政法工作动态</a></li>
                    <li><i></i><span>2016-12-09</span><a target="_blank"  href="/qltk/kaimo.html">【楷模】一个民警温暖一座城，他是这样定义不忘初心......</a></li>
                </ul>
            </div>
            <div class="wechat">
                <h2>扫一扫关注我们</h2>
                <i></i>
                <p>“晴朗天空”微信公众号</p>
            </div>
        </div>
    </div>



</div>

<div class="footer">Copyright@2012 小型新闻发布管理系统<span>|</span>陕ICP备11007473号</div>
</div>

<script type="text/javascript">
    $(".leftsidebar_box dt").css({"background-color":"#3992d0"});
    $(".leftsidebar_box dt img").attr("src","<%=context%>/resources/images/left/select_xl01.png");
    $(function(){
        $(".leftsidebar_box dd").hide();
        $(".leftsidebar_box dt").click(function(){
            $(".leftsidebar_box dt").css({"background-color":"#3992d0"})
            $(this).css({"background-color": "#317eb4"});
            $(this).parent().find('dd').removeClass("menu_chioce");
            $(".leftsidebar_box dt img").attr("src","<%=context%>/resources/images/left/select_xl01.png");
            $(this).parent().find('img').attr("src","<%=context%>/resources/images/left/select_xl.png");
            $(".menu_chioce").slideUp();
            $(this).parent().find('dd').slideToggle();
            $(this).parent().find('dd').addClass("menu_chioce");
        });
    })
</script>
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
