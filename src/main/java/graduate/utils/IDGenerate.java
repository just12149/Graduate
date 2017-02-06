package graduate.utils;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能：生成字符串类型主键
 * 作者：Zhang_XinGang
 * 时间：2015/9/17 17:17
 */
public class IDGenerate {
    private static final AtomicInteger integer = new AtomicInteger(0);

    /**
     * 生成字符串类型主键
     * @return
     */
    public static Long getId(){
        long time = System.currentTimeMillis();
        StringBuilder str = new StringBuilder(20);
        str.append(time);
        int intValue = integer.getAndIncrement();
        if (integer.get() >= 10000) {
            integer.set(0);
        }
        str.append(intValue);
        return Long.parseLong(str.toString());
    }
    public static void main(String[] a) {
        //System.out.println(getId());
        Long aaa = null;
        for(int i=0;i<10;i++){
            System.out.println(getId());
        }

    }
}
