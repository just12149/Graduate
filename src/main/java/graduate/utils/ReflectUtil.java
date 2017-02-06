package graduate.utils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

/**
 * 功能：
 * 作者：Zhang_XinGang
 * 时间：2015/12/2 13:43
 */
public class ReflectUtil {
    private static final Logger LOG = Logger.getLogger(ReflectUtil.class);

    public static void setFieldValue(Object target, String fname, Class<?> ftype,
                                     Object fvalue) {
        if ((target == null)
                || (fname == null)
                || ("".equals(fname))
                || ((fvalue != null) && (!ftype.isAssignableFrom(fvalue
                .getClass())))) {
            return;
        }
        Class<?> clazz = target.getClass();
        try {
            Method method = clazz.getDeclaredMethod("set"
                    + Character.toUpperCase(fname.charAt(0))
                    + fname.substring(1), new Class[] { ftype });
            if (!Modifier.isPublic(method.getModifiers())) {
                method.setAccessible(true);
            }
            method.invoke(target, new Object[] { fvalue });
        } catch (Exception me) {
            LOG.debug(me);
            try {
                Field field = clazz.getDeclaredField(fname);
                if (!Modifier.isPublic(field.getModifiers())) {
                    field.setAccessible(true);
                }
                field.set(target, fvalue);
            } catch (Exception fe) {
                LOG.debug(fe);
            }
        }
    }
}
