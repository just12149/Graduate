package graduate.utils;


import org.apache.commons.lang.StringUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * 功能：组件参数校验
 * 作者：Zhang_XinGang
 * 时间：2016/3/14 9:00
 */
public class DisParamCheckUtil {
    /**
     * 校验组件参数值是否合法
     * @param parCode 组件参数编码
     * @param parValue 组件参数值
     * @param templateTypeCode 界面模板类型
     * @return
     */
    public static Map<String,Object> checkParam(String parCode,String parValue,String templateTypeCode){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",true);
        if(StringUtils.isEmpty(parCode)){
            map.put("success",false);
            map.put("msg","组件参数编码不能为空！");
            return map;
        }
        return DisParamCheckUtil.checkValue(parCode, parValue,templateTypeCode);
    }

    /**
     * 校验组件值是否合法
     * @param parCode
     * @param parValue
     * @param templateTypeCode
     * @return
     */
    public static Map<String,Object> checkValue(String parCode,String parValue,String templateTypeCode){
        Map<String,Object> map = null;
        if("HOTTOPIC".equals(templateTypeCode)){
            //校验媒体热点
            map = DisParamCheckUtil.hotTopicCheckParam(parCode,parValue);
        }else if("OFFLINEVISITOR".equals(templateTypeCode)){
            //校验线下客流
            map = DisParamCheckUtil.visitorCheckParam(parCode, parValue);
        }else if("CAMPAIGN".equals(templateTypeCode)){
            //校验线下客流
            map = DisParamCheckUtil.campaignCheckParam(parCode, parValue);
        }else if("COMMUNITY".equals(templateTypeCode)){
            //校验社群画像
            map = DisParamCheckUtil.communityCheckParam(parCode, parValue);
        }else if("WEICHATS".equals(templateTypeCode)){
            //校验微信舆情
            map = DisParamCheckUtil.weiChatsCheckParam(parCode, parValue);
        }else{
            map = new HashMap<String,Object>();
            map.put("success",false);
            map.put("msg","site界面模板未指定！");
        }
        return map;
    }
    /**
     * 校验媒体热点界面组件
     * @param parCode
     * @param parValue
     * @return
     */
    public static Map<String,Object> hotTopicCheckParam(String parCode,String parValue){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",true);
        if(parCode.equals("animationRefRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","媒体热点泡泡切换频率必须为一个数值！");
                return map;
            }
            //校验数字-动画刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","媒体热点泡泡切换频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("hotTopicCount")){
            //校验数字 - 热点话题显示数量
            if(!DisParamCheckUtil.checkNumberRange(parValue)){
                map.put("success",false);
                map.put("msg","媒体热点话题显示数量应该在2-10以内！");
                return map;
            }
        }else if(parCode.equals("mediaHotSpotDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","数据刷新频率必须为一个数值！");
                return map;
            }
            //校验数字 - 数据刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","数据刷新频率必须为一个数值！");
                return map;
            }
        }
        return map;
    }
    /**
     * 校验线下客流界面组件
     * @param parCode
     * @param parValue
     * @return
     */
    public static Map<String,Object> visitorCheckParam(String parCode,String parValue){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",true);
        if(parCode.equals("toDayTotalVisitorsRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当日总访客刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-当日总访客刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当日总访客刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("toDayTotalVisitorsDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当日总访客获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-当日总访客获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当日总访客获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("toDayTotalVisitorsExpression")){
            //校验 当日总访客算数表达式
            if(!DisParamCheckUtil.checkExpression(parValue)){
                map.put("success",false);
                map.put("msg","当日总访客算数表达式不正确！");
                return map;
            }
        }else if(parCode.equals("curVisitorTbExpression")){
            //校验 当日总访客增长率算数表达式
            if(!DisParamCheckUtil.checkExpression(parValue)) {
                map.put("success",false);
                map.put("msg","当日总访客增长率算数表达式不正确！");
                return map;
            }
        }else if(parCode.equals("toDaySatisfactionsRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当日满意度刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-当日满意度刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当日满意度刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("toDaySatisfactionsDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当日满意度获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-当日满意度获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","当日满意度获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("toDaySatisfactionsThresholding")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当日满意度阈值必须为一个数值！");
                return map;
            }
            //校验数字-当日满意度阈值
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","当日满意度阈值必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("toDaySatisfactionsExpression")){
            //校验数字-当日满意度算数表达式
            if(!DisParamCheckUtil.checkExpression(parValue)) {
                map.put("success",false);
                map.put("msg","当日满意度算数表达式不正确！");
                return map;
            }
        }else if(parCode.equals("acsiTbExpression")){
            //校验数字-当日满意度增长率算数表达式
            if(!DisParamCheckUtil.checkExpression(parValue)) {
                map.put("success",false);
                map.put("msg","当日满意度增长率算数表达式不正确！");
                return map;
            }
        }else if(parCode.equals("toDayStayTimeRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","停留时长刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-停留时长刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","停留时长刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("toDayStayTimeDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","停留时长获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-停留时长获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","停留时长获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("toDayStayTimeExpression")){
            //校验数字-停留时长算数表达式
            if(!DisParamCheckUtil.checkExpression(parValue)) {
                map.put("success",false);
                map.put("msg","停留时长算数表达式不正确！");
                return map;
            }
        }else if(parCode.equals("avgTimeTbExpression")){
            //校验数字-停留时长同比增长率算数表达式
            if(!DisParamCheckUtil.checkExpression(parValue)) {
                map.put("success",false);
                map.put("msg","停留时长同比增长率算数表达式不正确！");
                return map;
            }
        }else if(parCode.equals("totalCntRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","累计总访客量刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-累计总访客量刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","累计总访客量刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("totalCntDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","累计总访客量获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-累计总访客量获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","累计总访客量获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("totalCntExpression")){
            //校验数字-累计总访客量算数表达式
            if(!DisParamCheckUtil.checkExpression(parValue)) {
                map.put("success",false);
                map.put("msg","累计总访客量算数表达式不正确！");
                return map;
            }
        }else if(parCode.equals("currentVisitorsBarRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-当前访客量刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","当前访客量刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("currentVisitorsBarDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-当前访客量获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","当前访客量获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("currentVisitorsBarExpression")){
            //校验数字-当前访客量算数表达式
            if(!DisParamCheckUtil.checkExpression(parValue)) {
                map.put("success",false);
                map.put("msg","当前访客量算数表达式不正确！");
                return map;
            }
        }else if(parCode.equals("visitorsTendencyChartRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","访客趋势图刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-访客趋势图刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","访客趋势图刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("visitorsTendencyChartDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","访客趋势图获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-访客趋势图获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","访客趋势图获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("visitorsTendencyChartTimeInterval")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","访客趋势图数据点间隔时间必须为一个数值！");
                return map;
            }
            //校验数字-访客趋势图数据点间隔时间
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","访客趋势图数据点间隔时间必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("visitorsTendencyChartNewCurrenExpression")){
            //校验数字-访客趋势图新访客算数表达式
            if(!DisParamCheckUtil.checkExpression(parValue)) {
                map.put("success",false);
                map.put("msg","访客趋势图新访客算数表达式不正确！");
                return map;
            }
        }else if(parCode.equals("visitorsTendencyChartExpression")){
            //校验数字-访客趋势图当前访客算数表达式
            if(!DisParamCheckUtil.checkExpression(parValue)) {
                map.put("success",false);
                map.put("msg","访客趋势图当前访客算数表达式不正确！");
                return map;
            }
        }else if(parCode.equals("visitorsSexRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当前用户性别刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-当前用户性别刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","当前用户性别刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("visitorsSexDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当前用户性别获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-当前用户性别获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","当前用户性别获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("hotRegionRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","热点区域刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-热点区域刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","热点区域刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("hotRegionDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","热点区域获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-热点区域获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","热点区域获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("hotRegionCount")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","热点区域显示数量应该在2-8以内！");
                return map;
            }
            //校验数字 - 热点区域显示数量
            if(!DisParamCheckUtil.checkNumberRangeHotRegion(parValue)) {
                map.put("success",false);
                map.put("msg","热点区域显示数量应该在2-8以内！");
                return map;
            }
        }else if(parCode.equals("interestPortraitRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","兴趣画像切换频率必须为一个数值！");
                return map;
            }
            //校验数字-兴趣画像切换频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","兴趣画像切换频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("interestPortraitDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","兴趣画像获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-兴趣画像获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","兴趣画像获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("regionalDistributionRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","地域分布刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-地域分布刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","地域分布刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("regionalDistributionDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","地域分布获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-地域分布获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)) {
                map.put("success",false);
                map.put("msg","地域分布获取数据频率必须为一个数值！");
                return map;
            }
        }
        return map;
    }
    /**
     * 校验线上客流界面组件
     * @param parCode
     * @param parValue
     * @return
     */
    public static Map<String,Object> campaignCheckParam(String parCode,String parValue){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",true);
        if(parCode.equals("todayTotalPVRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当日总PV刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-当日总PV刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当日总PV刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("todayTotalPVDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当日总PV获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-当日总PV获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当日总PV获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("todayTotalPVExpression")){
            //校验 当日总PV算术表达式
            if(!DisParamCheckUtil.checkExpression(parValue)){
                map.put("success",false);
                map.put("msg","当日总PV算术表达式不正确！");
                return map;
            }
        }else if(parCode.equals("todayTotalUVRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当日总UV刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-当日总UV刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当日总UV刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("todayTotalUVDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当日总UV获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-当日总UV获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当日总UV获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("todayTotalUVExpression")){
            //校验 当日总UV算术表达式
            if(!DisParamCheckUtil.checkExpression(parValue)){
                map.put("success",false);
                map.put("msg","当日总UV算术表达式不正确！");
                return map;
            }
        }else if(parCode.equals("newVisitorPropRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","新访客占比刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-新访客占比刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","新访客占比刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("newVisitorPropDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","新访客占比获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-新访客占比获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","新访客占比获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("newVisitorPropExpression")){
            //校验 新访客占比算术表达式
            if(!DisParamCheckUtil.checkExpression(parValue)){
                map.put("success",false);
                map.put("msg","新访客占比算术表达式不正确！");
                return map;
            }
        }else if(parCode.equals("totalPVAndUVRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","累计总PV/UV刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-累计总PV/UV刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","累计总PV/UV刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("totalPVAndUVDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","累计总PV/UV获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-累计总PV/UV获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","累计总PV/UV获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("totalPVExpression")){
            //校验 累计总PV算术表达式
            if(!DisParamCheckUtil.checkExpression(parValue)){
                map.put("success",false);
                map.put("msg","累计总PV算术表达式不正确！");
                return map;
            }
        }else if(parCode.equals("totalUVExpression")){
            //校验 累计总UV算术表达式
            if(!DisParamCheckUtil.checkExpression(parValue)){
                map.put("success",false);
                map.put("msg","累计总UV算术表达式不正确！");
                return map;
            }
        }else if(parCode.equals("currentVisitorsRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-当前访客量刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("currentVisitorsDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-当前访客量获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("currentVisitorsExpression")){
            //校验 当前访客量算术表达式
            if(!DisParamCheckUtil.checkExpression(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量算术表达式不正确！");
                return map;
            }
        }else if(parCode.equals("visitorsBarChartRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量柱状图刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-当前访客量柱状图刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量柱状图刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("visitorsBarChartDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量柱状图获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-当前访客量柱状图获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量柱状图获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("visitorsBarChartExpression")){
            //校验 当前访客量柱状图算术表达式
            if(!DisParamCheckUtil.checkExpression(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量柱状图算术表达式不正确！");
                return map;
            }
        }else if(parCode.equals("visitorLineChartRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量曲线图刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-当前访客量曲线图刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量曲线图刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("visitorLineChartDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量曲线图获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-当前访客量曲线图获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量曲线图获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("visitorLineChartExpression")){
            //校验 当前访客量曲线图老访客算术表达式
            if(!DisParamCheckUtil.checkExpression(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量曲线图老访客算术表达式不正确！");
                return map;
            }
        }else if(parCode.equals("visitorLineChartNewExpression")){
            //校验 当前访客量曲线图新访客算术表达式
            if(!DisParamCheckUtil.checkExpression(parValue)){
                map.put("success",false);
                map.put("msg","当前访客量曲线图新访客算术表达式不正确！");
                return map;
            }
        }else if(parCode.equals("userTerminalDistributionRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","用户终端分布刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-用户终端分布刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","用户终端分布刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("userTerminalDistributionDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","用户终端分布获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-用户终端分布获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","用户终端分布获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("userBehaviorStatisticsRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","用户行为统计刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-用户行为统计刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","用户行为统计刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("userBehaviorStatisticsDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","用户行为统计获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-用户行为统计获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","用户行为统计获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("sourceDomainStatisticsRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","来源域名统计滚动速度必须为一个数值！");
                return map;
            }
            //校验数字-来源域名统计滚动速度
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","来源域名统计滚动速度必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("sourceDomainStatisticsDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","来源域名统计获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-来源域名统计获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","来源域名统计获取数据频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("visitorRegionDistributionRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","访客地域分布刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-访客地域分布刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","访客地域分布刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("visitorRegionDistributionDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","访客地域分布获取数据频率必须为一个数值！");
                return map;
            }
            //校验数字-访客地域分布获取数据频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","访客地域分布获取数据频率必须为一个数值！");
                return map;
            }
        }
        return map;
    }
    /**
     * 校验社群画像界面组件
     * @param parCode
     * @param parValue
     * @return
     */
    public static Map<String,Object> communityCheckParam(String parCode,String parValue){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",true);
        if(parCode.equals("ageRangeRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","年龄分布刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-年龄分布刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","年龄分布刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("sexDistributionRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","性别分布刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-性别分布刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","性别分布刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("astrologyLabRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","星座标签刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-星座标签刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","星座标签刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("drawOverViewRefRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","画像总览切换频率必须为一个数值！");
                return map;
            }
            //校验数字-画像总览切换频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","画像总览切换频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("drawOverViewLabIsShow")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","请选择画像总览显示标签！");
                return map;
            }
            //校验数字-画像总览显示标签
            String[] values = parValue.split(",");
            if(values.length>5){
                map.put("success",false);
                map.put("msg","画像总览标签最多只能显示5个！");
                return map;
            }else if(values.length<2){
                map.put("success",false);
                map.put("msg","画像总览标签最少需要选择2个！");
                return map;
            }
        }else if(parCode.equals("headPortraitRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","头像墙切换频率必须为一个数值！");
                return map;
            }
            //校验数字-头像墙切换频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","头像墙切换频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("headPortraitShowNumber")){
            /*if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","头像墙显示数量必须为一个数值！");
                return map;
            }
            //校验数字-头像墙显示数量
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","头像墙显示数量必须为一个数值！");
                return map;
            }
            if(!(Integer.parseInt(parValue) >= 2 && Integer.parseInt(parValue) <= 100)){
                map.put("success",false);
                map.put("msg","头像墙显示数量应该在2-100以内！");
                return map;
            }*/
        }else if(parCode.equals("interestLabRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","兴趣标签刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-兴趣标签刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","兴趣标签刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("interestLabRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","兴趣标签刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-兴趣标签刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","兴趣标签刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("sharedInterestShowNumber")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","共同关注显示数量必须为一个数值！");
                return map;
            }
            //校验数字-共同关注显示数量
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","共同关注显示数量必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("sharedInterestStayTime")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","共同关注滚动速度必须为一个数值！");
                return map;
            }
            //校验数字-共同关注滚动速度
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","共同关注滚动速度必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("visitorAreaDistributionRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","访客地域分布刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-访客地域分布刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","访客地域分布刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("careerLabRefreshRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","职业标签刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-职业标签刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","职业标签刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("careerLabShowNumber")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","职业标签显示数量必须为一个数值！");
                return map;
            }
            //校验数字-职业标签显示数量
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","职业标签显示数量必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("weiboDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","微博社群画像数据获取频率必须为一个数值！");
                return map;
            }
            //校验数字-微博社群画像数据获取频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","微博社群画像数据获取频率必须为一个数值！");
                return map;
            }
        }

        return map;
    }
    /**
     * 校验微信舆情界面组件
     * @param parCode
     * @param parValue
     * @return
     */
    public static Map<String,Object> weiChatsCheckParam(String parCode,String parValue){
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("success",true);
        if(parCode.equals("hotArticlePopRefRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","热度文章泡泡切换频率必须为一个数值！");
                return map;
            }
            //校验数字-热度文章泡泡切换频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","热度文章泡泡切换频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("hotArticlePopCount")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","微信舆情热度文章切换泡泡数量必须为一个数值！");
                return map;
            }
            //校验数字-微信舆情热度文章切换泡泡数量
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","微信舆情热度文章切换泡泡数量必须为一个数值！");
                return map;
            }
            if(!(Integer.parseInt(parValue)>=2 && Integer.parseInt(parValue) <= 28)){
                map.put("success",false);
                map.put("msg","微信舆情热度文章切换泡泡数量必须在2和28以内！");
                return map;
            }
        }else if(parCode.equals("kolRefRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","意见领袖滚动速度必须为一个数值！");
                return map;
            }
            //校验数字-意见领袖滚动速度
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","意见领袖滚动速度必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("kolShowCount")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","意见领袖显示数量必须为一个数值！");
                return map;
            }
            //校验数字-意见领袖滚动速度
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","意见领袖显示数量必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("soundTrendRefRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","声量趋势刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-声量趋势刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","声量趋势刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("wordCloudRefRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","高频词云刷新频率必须为一个数值！");
                return map;
            }
            //校验数字-高频词云刷新频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","高频词云刷新频率必须为一个数值！");
                return map;
            }
        }else if(parCode.equals("wordCloudCount")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","高频词云显示数量必须为一个数值！");
                return map;
            }
            //校验数字-高频词云显示数量
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","高频词云显示数量必须为一个数值！");
                return map;
            }
            if(Integer.parseInt(parValue) < 10){
                map.put("success",false);
                map.put("msg","高频词云显示数量最少是10！");
                return map;
            }
        }else if(parCode.equals("weChatDataRate")){
            if(StringUtils.isEmpty(parValue)){
                map.put("success",false);
                map.put("msg","微信舆情数据获取频率必须为一个数值！");
                return map;
            }
            //校验数字-微信舆情数据获取频率
            if(!DisParamCheckUtil.checkNumber(parValue)){
                map.put("success",false);
                map.put("msg","微信舆情数据获取频率必须为一个数值！");
                return map;
            }
        }
        return map;
    }

    /**
     * 校验数字
     * @param value
     * @return
     */
    private static boolean checkNumber(String value){
        String reg = "^(0|[1-9][0-9]*)$";
        return Pattern.compile(reg).matcher(value).find();
    }

    /**
     * 校验数字范围
     * @param value
     * @return
     */
    private static boolean checkNumberRange(String value){
        if(StringUtils.isEmpty(value)){
            return false;
        }
        boolean result = false;
        String reg = "^(0|[1-9][0-9]*)$";
        result = Pattern.compile(reg).matcher(value).find();
        if(result){
            String reg1 = "^([2-9]|10)$";
            result = Pattern.compile(reg1).matcher(value).find();
        }
        return result;
    }
    private static boolean checkNumberRangeHotRegion(String value){
        boolean result = false;
        String reg = "^([2-8])$";
        result = Pattern.compile(reg).matcher(value).find();
        return result;
    }
    /**
     * 校验算数表达式
     * @param expression
     * @return
     */
    private static boolean checkExpression(String expression){
        Object obj = null;
        ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        try {
            obj = se.eval(expression.replace("x",String.valueOf(10)).replace("X", String.valueOf(10)));
        } catch (ScriptException e) {
            return false;
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(DisParamCheckUtil.checkNumberRangeHotRegion("8.0"));
    }
}
