package graduate.utils;

/**
 * 功能：
 * 作者：Zhang_XinGang
 * 时间：2016/3/30 14:13
 */
public class ForeignKeyUtil {
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
