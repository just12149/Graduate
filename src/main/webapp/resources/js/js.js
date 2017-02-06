
//锚链接
$(function(){
	$('.service_a').click(function(){
		//滚动到对应的div
		var clsName = $(this).data('nav');
		$("body,html").animate({scrollTop:$('div.'+clsName).first().offset().top-80},400);
	});
});
$(function(){
	$('.title').click(function(){
		//滚动到对应的div
		var clsName = $(this).data('nav');
		$("body,html").animate({scrollTop:$('div.'+clsName).first().offset().top-80},400);
	});
});

$(function(){
	
	$('div.nav>a').click(function(){
		
		//样式切换
		$(this).addClass('current').siblings().removeClass('current');
		//滚动到对应的div
		var clsName = $(this).data('nav');
		$("body,html").animate({scrollTop:$('div.'+clsName).first().offset().top-80},400);
	});
	
	$(window).scroll(function () {
		var t = $(window).scrollTop();
		var current = null;
		$('div.nav>a').each(function(i){
			var clsName = $(this).data('nav');
			var divTop = $('div.'+clsName).first().offset().top-80;
			if(t>=divTop){
				current = this;
			}
		});
		if(current){
			$(current).addClass('current').siblings().removeClass('current');
		}
	});
});

//浮动导航
$(function(){
	$(window).bind('scroll resize',function(){
		if($(window).scrollTop()>10){
			$(".top").addClass('top2');
		}else{
			$(".top").removeClass('top2');
		}	
	})
})

//返回顶部
$(document).ready(function()
{//首先将#back-to-top隐藏 
$("#back-to-top").hide();
//当滚动条的位置处于距顶部100像素以下时，跳转链接出现，否则消失
$(function () {
	$(window).scroll(function(){
		if ($(window).scrollTop()>100){
			$("#back-to-top").fadeIn(800);
			}
		else{$("#back-to-top").fadeOut(800);}
});
//当点击跳转链接后，回到页面顶部位置
$("#back-to-top").click(function(){
	$('body,html').animate({scrollTop:0},800)
	;return false;
	});
	});
});
//导航点击
$(function(){
  var sytag = 0;
  $("#showSy").click(function() {
    if(sytag==0) {
      sytag = 1;
      $(".index_sy").show();
      $(".btn-box p").addClass("current");
    }else{
      sytag = 0;
      $(".index_sy").hide();
      $(".btn-box p").removeClass("current");
    }
  })
  
  $(".index_sy a").click(function() {
    $(this).parent().parent().find("a").removeClass("current");
    $(this).addClass("current");
  })
 });
 
