package graduate.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 功能：ibatis分页用工具类
 * 作者：Zhang_XinGang
 * 时间：2015/12/2 13:43
 */
public class SqlUtil {

	public static String genarateSqlForPage(String sql) {
		if (sql.toLowerCase().indexOf("with") < 0) {
			if ("oracle".equals(DatabaseUtil.getDatabaseType())) {
				return sql;
			}
			if ("mySql".equals(DatabaseUtil.getDatabaseType())) {
				return sql;
			}
			if ((sql.toLowerCase().indexOf("union") > -1)
					|| (sql.toLowerCase().indexOf("expect") > -1)) {
				Map<String, Object> map = getSelectContent(sql);
				String selectcontentNoAsDot = (String) map
						.get("selectcontentNoAsDot");
				String selectcontentNoDot = (String) map
						.get("selectcontentNoDot");
				StringBuffer newsql = new StringBuffer();
				if ("oracle".equals(DatabaseUtil.getDatabaseType()))
					newsql.append("with yuanbiao \r\n");
				else if ("db2".equals(DatabaseUtil.getDatabaseType())) {
					newsql.append("with yuanbiao(" + selectcontentNoAsDot
							+ ") " + "\r\n");
				}

				newsql.append("as( \r\n");
				newsql.append(sql + "\r\n");
				newsql.append(") \r\n");
				newsql.append("select " + selectcontentNoDot + " " + "\r\n");
				newsql.append("  from yuanbiao \r\n");
				return newsql.toString();
			}
		}
		return sql;
	}

	public static Map<String, Object> getSelectContent(String sql) {
		Map<String, Object> map = new HashMap<String, Object>();
		String selectContent = sql.substring(sql.toLowerCase()
				.indexOf("select") + 6, sql.toLowerCase().indexOf("from"));

		String selectcontentNoAsDot = "";
		String selectcontentHasA = "";
		String selectcontentNoDot = "";
		String[] selectContentArr = selectContent.split(",");

		List<Object> selectcontentDb = new ArrayList<Object>();

		List<Object> selectcontentJava = new ArrayList<Object>();
		int listSize = -1;
		for (int i = 0; i < selectContentArr.length; i++) {
			String selectContentTemp = selectContentArr[i].trim();
			if (selectContentTemp.indexOf(".") > -1) {
				if (selectContentTemp.indexOf(")") > -1) {
					selectContentTemp = selectContentTemp.substring(
							selectContentTemp.indexOf(".") + 1,
							selectContentTemp.indexOf(")"));
				} else
					selectContentTemp = selectContentTemp.substring(
							selectContentTemp.indexOf(".") + 1,
							selectContentTemp.length());
			}

			if (selectContentTemp.toLowerCase().indexOf(" as ") > -1) {
				String column = selectContentTemp.substring(0,
						selectContentTemp.toLowerCase().indexOf(" as ")).trim();
				String field = selectContentTemp.substring(
						selectContentTemp.toLowerCase().indexOf(" as ") + 4,
						selectContentTemp.length()).trim();
				listSize++;
				if ((selectcontentDb.contains(column))
						|| (selectcontentNoAsDot.indexOf(column) > -1)) {
					selectcontentDb.add(field);
					selectcontentJava.add(field);
				} else {
					selectcontentDb.add(column);
					selectcontentJava.add(field);
				}
				if (i == 0) {
					selectcontentNoDot = (String) selectcontentDb.get(listSize)
							+ " as " + (String) selectcontentJava.get(listSize);
					String dbstr = (String) selectcontentDb.get(listSize);
					if (dbstr.contains("'")) {
						selectcontentNoAsDot = (String) selectcontentJava
								.get(listSize);
						selectcontentHasA = "a."
								+ (String) selectcontentJava.get(listSize);
					} else {
						selectcontentNoAsDot = (String) selectcontentDb
								.get(listSize);
						selectcontentHasA = "a."
								+ (String) selectcontentDb.get(listSize)
								+ " as "
								+ (String) selectcontentJava.get(listSize);
					}
				} else {
					selectcontentNoDot = selectcontentNoDot + ","
							+ (String) selectcontentDb.get(listSize) + " as "
							+ (String) selectcontentJava.get(listSize);
					String dbstr = (String) selectcontentDb.get(listSize);
					if (dbstr.contains("'")) {
						selectcontentHasA = selectcontentHasA + ",a."
								+ (String) selectcontentJava.get(listSize);
						selectcontentNoAsDot = selectcontentNoAsDot + ","
								+ (String) selectcontentJava.get(listSize);
					} else {
						selectcontentHasA = selectcontentHasA + ",a."
								+ (String) selectcontentDb.get(listSize)
								+ " as "
								+ (String) selectcontentJava.get(listSize);
						selectcontentNoAsDot = selectcontentNoAsDot + ","
								+ (String) selectcontentDb.get(listSize);
					}
				}
			} else if (i == 0) {
				selectcontentHasA = "a." + selectContentTemp;
				selectcontentNoDot = selectContentTemp;
				selectcontentNoAsDot = selectContentTemp;
			} else {
				selectcontentHasA = selectcontentHasA + ",a."
						+ selectContentTemp;
				selectcontentNoDot = selectcontentNoDot + ","
						+ selectContentTemp;
				selectcontentNoAsDot = selectcontentNoAsDot + ","
						+ selectContentTemp;
			}
		}

		map.put("selectContent", selectContent);
		map.put("selectcontentNoAsDot", selectcontentNoAsDot);
		map.put("selectcontentHasA", selectcontentHasA);
		map.put("selectcontentNoDot", selectcontentNoDot);
		return map;
	}

	public static String getOrderByContent(String sql) {
		String orderByContent = sql;
		String orderBycontentHasA = "";
		Pattern p = Pattern.compile(".*order\\s+by", 2);
		Matcher m = p.matcher(orderByContent);
		while (m.find()) {
			orderByContent = orderByContent.replace(m.group(), "");
			m.reset(orderByContent);
		}

		if (orderByContent.equals(sql)) {
			return "";
		}

		String[] orderByContentArr = orderByContent.split(",");
		for (int i = 0; i < orderByContentArr.length; i++) {
			String orderByContentTemp = orderByContentArr[i].trim();
			if (orderByContentTemp.indexOf(".") > -1) {
				if (i == 0)
					orderBycontentHasA = orderBycontentHasA
							+ " order by a."
							+ orderByContentTemp.substring(orderByContentTemp
									.indexOf(".") + 1, orderByContentTemp
									.length());
				else {
					orderBycontentHasA = orderBycontentHasA
							+ ",a."
							+ orderByContentTemp.substring(orderByContentTemp
									.indexOf(".") + 1, orderByContentTemp
									.length());
				}
			} else if (i == 0)
				orderBycontentHasA = orderBycontentHasA + " order by a."
						+ orderByContentTemp.trim();
			else {
				orderBycontentHasA = orderBycontentHasA + ",a."
						+ orderByContentTemp.trim();
			}
		}
		return orderBycontentHasA;
	}
}
