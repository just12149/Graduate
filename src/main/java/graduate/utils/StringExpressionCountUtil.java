package graduate.utils;

import org.apache.commons.lang.StringUtils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * 功能：
 * 作者：Zhang_XinGang
 * 时间：2016/3/7 13:56
 */
public class StringExpressionCountUtil {
    /**
     *
     * @param x
     * @param expression
     * @return
     */
    public static Integer expressionCount(Integer x,String expression){
        if(StringUtils.isEmpty(expression)){
            return null;
        }
        if(x == null){
            return null;
        }
        ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        Object obj = null;
        try {
            obj = se.eval(expression.replace("x",String.valueOf(x)).replace("X", String.valueOf(x)));
        } catch (ScriptException e) {
            //e.printStackTrace();
            return null;
        }
        return Integer.parseInt(new java.text.DecimalFormat("0").format(obj));
    }
    public static String expressionCount(Integer x,Integer y,String expression){
        if(StringUtils.isEmpty(expression)){
            return null;
        }
        if(x == null){
            return null;
        }
        if(y == null){
            return null;
        }
        ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        Object obj = null;
        try {
            obj = se.eval(expression.replace("x",String.valueOf(x)).replace("y",String.valueOf(y)).replace("X", String.valueOf(x)).replace("Y",String.valueOf(y)));
        } catch (ScriptException e) {
            //e.printStackTrace();
            return null;
        }
        return String.valueOf(obj);
    }
    public static Double expressionCount(Double x,String expression){
        if(StringUtils.isEmpty(expression)){
            return null;
        }
        if(x == null){
            return null;
        }
        ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        Object obj = null;
        try {
            obj = se.eval(expression.replace("x", String.valueOf(x)).replace("X", String.valueOf(x)));
        } catch (ScriptException e) {
            //e.printStackTrace();
            return null;
        }
        return (Double)obj;
    }
    public static Double expressionCount(Double x,Double y,String expression){
        if(StringUtils.isEmpty(expression)){
            return null;
        }
        if(x == null){
            return null;
        }
        if(y == null){
            return null;
        }
        ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        Object obj = null;
        try {
            obj = se.eval(expression.replace("x",String.valueOf(x)).replace("y",String.valueOf(y)).replace("X", String.valueOf(x)).replace("Y",String.valueOf(y)));
        } catch (ScriptException e) {
            //e.printStackTrace();
            return null;
        }
        return (Double)obj;
    }
    public static Long expressionCount(Long x,String expression){
        if(StringUtils.isEmpty(expression)){
            return null;
        }
        if(x == null){
            return null;
        }
        ScriptEngine se = new ScriptEngineManager().getEngineByName("JavaScript");
        Object obj = null;
        try {
            obj = se.eval(expression.replace("x",String.valueOf(x)).replace("X", String.valueOf(x)));
        } catch (ScriptException e) {
            //e.printStackTrace();
            return null;
        }
        return Long.parseLong(new java.text.DecimalFormat("0").format(obj));
    }
    public static void main(String[] a){
        String exp = "(x+5-(2-4)*2)/24";
        Integer y = StringExpressionCountUtil.expressionCount(10,exp);
        String doublexy = StringExpressionCountUtil.expressionCount(10,30,"x+x/(x+y)");
        System.out.println(StringExpressionCountUtil.expressionCount(5.05,"x+10/5"));
        System.out.println(y);
        System.out.println(doublexy);
    }
}
