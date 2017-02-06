package graduate.utils;

import org.springframework.context.ApplicationContext;

/**
 * 功能：spring工具类
 * 作者：Zhang_XinGang
 * 时间：2015/12/2 13:43
 */
public class SpringUtil {

	private static ApplicationContext applicationContext;

	/**
	 * 设置spring上下文
	 * @param context
	 */
	public static void setApplicationContext(ApplicationContext context) {
		applicationContext = context;
	}

	/**
	 *	获取spring上下文
	 * @return
	 */
	public static ApplicationContext getContext() {
		return applicationContext;
	}

	/**
	 * 根据类型获取该类型的实现类实例
	 * @param o
	 * @return
	 */
	public static Object getServiceByClass(Class o){
		return applicationContext.getBean(o);
	}

	/**
	 * 根据benId获取实现类实例
	 * @param beanId
	 * @return
	 */
	public static Object getBean(String beanId) {
		Object service = null;
		service = applicationContext.getBean(beanId);
		return service;
	}
}
