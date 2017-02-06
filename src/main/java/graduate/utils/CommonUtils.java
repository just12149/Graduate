package graduate.utils;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2016/1/6.
 */
public class CommonUtils {
    /**
     * 获取时间列表
     * @param startDate 开始时间
     * @param endDate 结束时间
     * @param dimension 时间维度 Y:年，MON:月，D:日，H:小时(24) ，MIN:分钟
     * @param step 时间间隔
     * @param format 输出格式
     * @return
     */
    public static List<String> dateList(Date startDate,Date endDate,String dimension,Integer step,String format ){
        Calendar cStart = Calendar.getInstance();
        cStart.setTime(startDate);
        Calendar cEnd = Calendar.getInstance();
        cEnd.setTime(endDate);
        int field = getCalendarField(dimension);
        List<String> list = new ArrayList<String>();
        SimpleDateFormat df = new SimpleDateFormat(format);
        do{
            list.add(df.format(cStart.getTime()));
            cStart.add(field,step);
        }while(cStart.before(cEnd));
        list.add(df.format(cEnd.getTime()));
        return list;
    }
    public static Integer getCalendarField(String dimension) {
        Integer field = null;
        if("Y".equals(dimension)){
            field = Calendar.YEAR;
        }
        if("MON".equals(dimension)){
            field = Calendar.MONTH;
        }
        if("D".equals(dimension)){
            field = Calendar.DAY_OF_YEAR;
        }
        if("H".equals(dimension)){
            field = Calendar.HOUR_OF_DAY;
        }
        if("MIN".equals(dimension)){
            field = Calendar.MINUTE;
        }
        return field;
    }

    /**
     * 根据时差td 获取特定时间点
     * @param base
     * @param td
     * @param dimension 时间维度 Y:年，MON:月，D:日，H:小时(24) ，MIN:分钟
     * @return
     */
    public static Date addDate(Date base,Integer td,String dimension){
        Integer field = getCalendarField(dimension);
        if(td == null && td == 0){
            return base;
        }
        Calendar c = Calendar.getInstance();
        c.setTime(base);
        c.add(field,td);
        return c.getTime();
    }

    /**
     * 时间转字符串
     * @param date
     * @param format
     * @return
     */
    public static String date2Str(Date date,String format){
        if(date == null ){
            return null;
        }
        return new SimpleDateFormat(format).format(date);
    }

    /**
     * 字符串转时间
     * @param str
     * @param format
     * @return
     */
    public static Date str2Date(String str,String format) throws ParseException {
        return new SimpleDateFormat(format).parse(str);
    }
    public static Long getLong(Object obj,Long def){
        if(obj == null) return def;
        return Long.parseLong(String.valueOf(obj));
    }
    public static Long getLong(Object obj){
        return getLong(obj, 0L);
    }
    public static Integer getInteger(Object obj,Integer def){
        if(obj == null)return def;
        return Integer.parseInt(String.valueOf(obj));
    }
    public static Integer getInteger(Object obj){
        return getInteger(obj,0);
    }

    /**
     * 格式化数字
     * @param num
     * @param format
     * @return
     */
    public static String nf(Object num,String format){
        num = num == null?0:num;
        NumberFormat nf = new DecimalFormat(format);
        return nf.format(num);
    }
    public static Double getDouble(Object obj,Double def){
        if(obj == null){
            return def;
        }
        if(obj instanceof Double){
            return (Double)obj;
        }else{
            return Double.parseDouble(String.valueOf(obj));
        }
    }
    public static Double getDouble(Object obj){
        return getDouble(obj,0.0);
    }

    public static Date getDate(Object obj){
        Date date = null;
        try{
            date = (Date)obj;
        }catch (Exception e){
            e.printStackTrace();
        }
        return date;
    }

    /**
     * 给数字补10  到10位
     * @param data
     * @return
     */
    public static Long getAddData(Long data){
        String proId = String.valueOf(data);
        while (proId.length() < 9) {
            proId = 0 + proId;
        }
        proId=1+proId;
        Long cId=Long.valueOf(proId);
        return cId;
    }
}
