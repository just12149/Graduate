package graduate.utils;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;
import java.util.Properties;

/**
 * 功能：读取资源文件工具类
 * 作者：Zhang_XinGang
 * 时间：2015/12/2 13:33
 */
public class Config {

  private static Log log = LogFactory.getLog(Config.class);

  public static Properties properties = new Properties();

  static {
    try {
      properties.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("jdbc.properties"));
      log.info("load config :" + properties);
    } catch (IOException e) {
      log.error(e);
      log.error("cls.properties 加载失败");
    }
  }

  public static String get(String k) {
    return properties.getProperty(k);
  }

  public static String get(String k,String defaultValue) {
	    return properties.getProperty(k,defaultValue);
	  }
  public final static boolean enableEtlDataListener = BooleanUtils.toBoolean(get("enableEtlDataListener"));
}
