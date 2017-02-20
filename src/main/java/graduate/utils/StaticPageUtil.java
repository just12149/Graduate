package graduate.utils;
import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
/**
 * Created by ${niuting} on 2017/2/9.
 */
public class StaticPageUtil {
    static Log log = LogFactory.getLog(StaticPageUtil.class);
    private static String webappname = "/";
    private static final String proPath = "/staticFiles/html/";
    private static final String HTTP_ACTION_URL = "/cms/main/previewMainContent.do";

    /**
     * 获取项目访问根目录
     *
     * @param request
     * @return
     */
    public static String getWebRootUrl(HttpServletRequest request) {
        String scheme = request.getScheme();
        String serverName = request.getServerName();
        int serverPort = request.getServerPort();
        String basePath = scheme + "://" + serverName;
        if (serverPort != 80) {
            basePath += ":" + serverPort;
        }
        if (StringUtils.isNotBlank(request.getContextPath())) {
            basePath += "/" + request.getContextPath();
        }
        basePath += "/";
        return basePath;
    }

    /**
     * 根据模版及参数产生静态页面
     *
     * @param request
     * @param mainId
     * @param lang
     * @return
     * @throws Exception
     */
    public static Map<String, Object> createHtmlPage(HttpServletRequest request, Integer mainId, String lang) throws Exception {
        StaticPageUtil.webappname = getWebRootUrl(request);
        log.info("项目访问根目录:" + StaticPageUtil.webappname);
        //存储路径
        String rootPath = request.getSession(true).getServletContext().getRealPath(proPath);
        //文件名称
        String fileName = String.valueOf(IDGenerate.getId()) + ".html";
        //http访问路径
        String httpUrl = StaticPageUtil.webappname + proPath + fileName;
        log.info("http访问路径:" + httpUrl);
        // 文件保存路径
        String filePath = rootPath + "/" + fileName;
        log.info("文件保存路径:" + filePath);
        //拼接访问url
        String actionUrl = StaticPageUtil.webappname + HTTP_ACTION_URL + "?mainId=" + mainId + "&lang=" + lang;
        log.info("action访问url:" + actionUrl);
        String page = null;
        HttpClient httpClient = null;
        GetMethod getMethod = null;
        BufferedReader br = null;
        InputStream in = null;
        StringBuffer sb = null;
        String line = null;
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("success", false);
        int statusCode = 0;
        //创建一个HttpClient实例充当模拟浏览器
        httpClient = new HttpClient();
        //设置httpclient读取内容时使用的字符集
        httpClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
        //创建GET方法的实例
        getMethod = new GetMethod(actionUrl);
        //使用系统提供的默认的恢复策略，在发生异常时候将自动重试3次
        getMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler());
        //设置Get方法提交参数时使用的字符集
        getMethod.addRequestHeader("Content-Type", "text/html;charset=UTF-8");
        //执行Get方法并取得返回状态码，200表示正常，其它代码为异常
        statusCode = httpClient.executeMethod(getMethod);
        if (statusCode != 200) {
            //"静态页面引擎在解析" + actionUrl + "产生静态页面" + htmlFileName + "时出错"
            map.put("message", statusCode);
            log.error("访问url,失败,访问状态码:" + statusCode + ",url:" + actionUrl);
        } else {
            //读取解析结果
            sb = new StringBuffer();
            in = getMethod.getResponseBodyAsStream();
            br = new BufferedReader(new InputStreamReader(in, "UTF-8"));
            while ((line = br.readLine()) != null) {
                sb.append(line + "\n");
            }
            if (br != null) br.close();
            page = sb.toString();
            page = formatPage(page);
            writeHtml(filePath, page);
            map.put("success", true);
            map.put("filePath", filePath);
            map.put("httpUrl", httpUrl);
        }
        getMethod.releaseConnection();
        return map;
    }

    /**
     * 将解析结果写入指定的静态HTML文件中
     *
     * @param htmlFileName
     * @param content
     * @throws Exception
     */
    private synchronized static String writeHtml(String htmlFileName, String content) throws Exception {
        BufferedWriter fw = null;
        File file = new File(htmlFileName);
        file.delete();
        file.createNewFile();
        fw = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "UTF-8"));
        String url = file.getAbsolutePath();
        fw.write(content);
        if (fw != null) fw.close();
        fw = null;
        return url;
    }


    /**
     * 将页面中的相对路径替换成绝对路径，以确保页面资源正常访问
     *
     * @param page
     * @return
     */
    private static String formatPage(String page) {
        page = page.replaceAll("\\.\\./\\.\\./\\.\\./", StaticPageUtil.webappname);
        page = page.replaceAll("\\.\\./\\.\\./", StaticPageUtil.webappname);
        page = page.replaceAll("\\.\\./", StaticPageUtil.webappname);
        return page;
    }


    //测试方法
    public static void main(String[] args) throws Exception {

//       StaticPageUtil page = new StaticPageUtil();
       /* String fileUrl = "";
        try {
            System.out.println(page.showURL());
            fileUrl = page.showURL();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("----" + page.getName());
        page.createHtmlPage("http://china.huanqiu.com/article/2017-02/10092099.html?from=bdwz");
        String fileName = StaticPageUtil.class.getClass().getResource("/").getPath() + "staticFiles/" + StaticPageUtil.getFileName() + ".html";
        String file = StaticPageUtil.class.getClass().getResource("/").getPath();
        String fileName = file.substring(file.indexOf("/") + 1) + StaticPageUtil.getFileName() + ".html";
        System.out.println(fileName);
        System.out.println(StaticPageUtil.createHtmlPage("http://china.huanqiu.com/article/2017-02/10092099.html?from=bdwz", fileName));*/
    }
}
