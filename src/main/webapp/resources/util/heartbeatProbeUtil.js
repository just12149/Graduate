/**
 * Created by Administrator on 2016/2/1.
 */
var callbackObj;
$(function () {
    //心跳监测1分钟一次
    window.setInterval(function () {
        if(callbackObj) {
            callbackObj.heartbeatProbe(siteId);
        }
    }, 1000 * 60);
})