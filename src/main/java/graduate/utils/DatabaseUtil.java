package graduate.utils;


/**
 * 功能：数据库类型辨别工具类
 * 作者：Zhang_XinGang
 * 时间：2015/12/2 13:33
 */
public class DatabaseUtil {
	public static final String DATABASE_TYPE_MYSQL = "mySql";
	public static final String DATABASE_TYPE_DB2 = "db2";
	public static final String DATABASE_TYPE_ORACLE = "oracle";
	private static final String DATABASE_DRIVER_DB2 = "com.ibm.db2.jcc.DB2Driver";
	private static final String DATABASE_DRIVER_ORACLE = "oracle.jdbc.driver.OracleDriver";
	private static final String DATABASE_DRIVER_MYSQL = "com.mysql.jdbc.Driver";
	private static String currentDriver = "";

	public static String getDatabaseType() {
		if ("".equals(currentDriver)) {
			String drivers = "";
			//PropConfig propConfig = PropConfig.loadConfig("jdbc.properties");
			Config config = new Config();
			if (config != null) {
				drivers = config.get("jdbc.driverClassName").trim();
			}

			if (DATABASE_DRIVER_DB2.equals(drivers)) {
				return DATABASE_TYPE_DB2;
			}
			if (DATABASE_DRIVER_ORACLE.equals(drivers)) {
				return DATABASE_TYPE_ORACLE;
			}
			if (DATABASE_DRIVER_MYSQL.equals(drivers)) {
				return DATABASE_TYPE_MYSQL;
			}

		}
		return currentDriver;
	}
}