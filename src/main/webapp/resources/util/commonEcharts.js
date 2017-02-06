/**
 * Created by Administrator on 2015/8/18.
 */
(function($){
    $.commonEcharts={
        start:function(){
            require.config({
                paths: {
                    echarts: '/resources/frame/echarts-2.2.7/js'
                }
            })
        },
        //当前访客柱状图
        currentVisitorVolumeBar:function(obj){
            var option = {
                tooltip : {
                    trigger: 'axis'
                },
                /*legend: {
                    data:['当前访问','昨日同比'],
                    y:'bottom',
                    orient:'vertical',
                    itemWidth:8,
                    itemHeight:10,
                    textStyle : textStyle
                },*/
                grid:{
                    x:80,
                    y:0
                },

                xAxis : [
                    {
                        show:true,
                        type : 'category',
                        axisTick:{
                            show:false
                        },
                        axisLabel:{
                            show:false
                        },
                        data : obj.xAxis_curCnt_data
                    }
                ],

                yAxis : [
                    {
                        show:false,
                        type : 'value'
                    }
                ],
                series :
                    [
                    {
                        name:'当前访问',
                        type:'bar',
                        itemStyle: {
                            normal: {
                                color:'#DC6364'
                            },
                            emphasis: {
                                color:'#DC6364'
                            }
                        },
                        data:obj.curData_today,
                        barWidth : 10
                    }

                ]
            };
            return option;
        },
        //当前访客柱状图（手机）
        currentVisitorVolumeBarMobile:function(obj){
            var option = {
                tooltip : {
                    trigger: 'axis'
                },
                /*legend: {
                    data:['当前访问','昨日同比'],
                    y:'bottom',
                    orient:'vertical',
                    itemWidth:8,
                    itemHeight:10,
                    textStyle:{
                        color:'#8d94c9'
                    }
                },*/
                grid:{
                    x:'23%',
                    x2:'21%',
                    y:'1%'
                },
                xAxis : [
                    {
                        show:true,
                        type : 'category',
                        axisTick:{
                            show:false
                        },
                        axisLabel:{
                            show:false
                        },
                        data : obj.xAxis_curCnt_data
                    }
                ],
                yAxis : [
                    {
                        show:false,
                        type : 'value'
                    }
                ],
                series :
                    [
                        {
                            name:'当前访问',
                            type:'bar',
                            itemStyle: {
                                normal: {
                                    color:'#DC6364'
                                },
                                emphasis: {
                                    color:'#DC6364'
                                }
                            },
                            data:obj.curData_today
                        }/*,
                        {
                            name:'昨日同比',
                            type:'bar',
                            itemStyle: {
                                normal: {
                                    color:'#3590E2'
                                },
                                emphasis: {
                                    color:'#3590E2'
                                }
                            },
                            data:obj.curData_yesterday
                        }*/
                    ]
            };
            return option;
        },
        //当前访客量折线图
        currentVisitorLine:function(obj){
            var option = {
                tooltip : {
                    trigger: 'axis'
                },
                legend: {
                    itemWidth:16,
                    itemHeight:10,
                    data:[{
                        name : '当前访客量',
                        textStyle : textStyle
                    }, {
                        name : '新访客量',
                        textStyle : textStyle
                    }]

                },
                dataZoom : {
                    show : false,
                    start : 0,
                    end : 100
                },
                grid:{
                    x:40,
                    y:20,
                    y2:60
                },
                calculable : true,
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : true,
                        data : obj.xAxis_Cnt_data,
                        axisLabel:{
                            interval:1,
                            rotate:0
                        }
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        scale:true
                    }
                ],
                series :
                [
                    {
                        name:'当前访客量',
                        type:'line',
                        data:obj.curCnt_data
                    },
                    {
                        name:'新访客量',
                        type:'line',
                        data:obj.newCnt_data
                    }
                ]
            };
            return option;
        },
        //当前访客量折线图（手机）
        currentVisitorLineMobile:function(obj){
            var option = {
                tooltip : {
                    trigger: 'axis'
                },

                legend: {
                    itemWidth:16,
                    itemHeight:10,
                    textStyle:{
                        color:'#8d94c9'
                    },
                    data:['当前访客量', '新访客量']
                },
                dataZoom : {
                    show : false,
                    start : 0,
                    end : 100
                },
                grid:{
                    x:'15%',
                    x2:'8%',
                    y:'20%',
                    y2:'20%'
                },
                calculable : false,
                xAxis : [
                    {
                        type : 'category',
                        boundaryGap : true,
                        data : obj.xAxis_Cnt_data,
                        axisLabel : {
                            show : true,
                            textStyle : {
                                color : '#8d94c9',
                                align : 'left'
                            }
                        },
                    }
                ],
                yAxis : [
                    {
                        type : 'value',
                        scale:true,
                        axisLabel : {
                            show : true,
                            textStyle : {
                                color : '#8d94c9',
                                align : 'left'
                            }
                        },
                    }
                ],
                series :
                    [
                        {
                            name:'当前访客量',
                            type:'line',
                            data:obj.curCnt_data
                        },
                        {
                            name:'新访客量',
                            type:'line',
                            data:obj.newCnt_data
                        }
                    ]
            };
            return option;
        },
        //当前用户性别分布
        currentUserSexDistriPie:function(obj){
            var option = {
                tooltip : {
                    trigger: 'item',
                    formatter: "{a} <br/>{b} : {c} ({d}%)"
                },
                legend: {
                    orient : 'vertical',
                    y:'bottom',
                    x:'center',
                    itemWidth:8,
                    itemHeight:10,
                    data:[{
                            icon:'bar',
                            name: obj.man_data,
                            textStyle : textStyle
                        },
                        {
                            icon:'bar',
                            name: obj.woman_data,
                            textStyle : textStyle
                        }]
                },
                series : [
                    {
                        type:'pie',
                        radius : ['40%', '75%'],
                        center: ['50%', '40%'],
                        data:obj.sex_data
                    }
                ],
                color:['RGB(53,144,226)', 'RGB(220,99,100)']

            };
            return option;
        },
        //当前用户性别分布（手机）
        currentUserSexDistriPieMobile:function(obj){
            var option = {
                legend: {
                    orient : 'vertical',
                    x:'center',
                    y:'bottom',
                    itemWidth:8,
                    itemHeight:10,
                    textStyle:{
                        color:'#8d94c9'
                    },
                    data:[
                        {
                            icon:'bar',
                            name: obj.man_data
                        },
                        {
                            icon:'bar',
                            name: obj.woman_data
                        }
                    ]
                },
                calculable : false,
                series : [
                    {
                        type:'pie',
                        radius : ['30%', '60%'],
                        center: ['50%', '30%'],
                        data:obj.sex_data
                    }
                ],
                color:['RGB(53,144,226)', 'RGB(220,99,100)']
            };
            return option;
        },
        //来自地域分布(地图)
        regionDistributionMap:function(obj){
            var option = {
                backgroundColor: 'rgba(0,0,0,0)',
                series : obj.region_data
            };
            return option;
        }
    }
})(jQuery);
