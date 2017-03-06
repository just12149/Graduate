/*
package graduate.user.action;

import graduate.user.model.News;
import graduate.user.service.NewsService;
import graduate.utils.page.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.portlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

*/
/**
 * Created by ${niuting} on 2017/2/3.
 *//*

@Controller
@RequestMapping("/news")
public class NewsAction {
    @Resource
    private NewsService newsService;

    @RequestMapping("/New.do")
    public ModelAndView PageRequest(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("news/New");
        return modelAndView;
    }

    */
/**
     * 使用json查询数据
     *//*

    @ResponseBody
    @RequestMapping("/indexPageJson.do")
    public Map<String, Object> findPageAction(Page page, Integer newstype) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<News> newsList;

        newsList = newsService.findAll(page, newstype);
        map.put("totalNum", page.getTotalNum());
        map.put("newsList", newsList);
        map.put("success", true);
        return map;
    }


    @ResponseBody
    @RequestMapping("/updateJson.do")
    public Map<String, Object> updateAction(News news) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (news == null) {
            map.put("success", false);
        } else {
            int state = newsService.updNews(news);
            System.out.println(state);
            if (state > 0) {
                map.put("success", true);
            } else {
                map.put("success", false);
            }
        }

        return map;
    }

    @ResponseBody
    @RequestMapping("/delJson.do")
    public Map<String, Object> delAction(Integer delnewsId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (delnewsId == null) {
            map.put("success", false);
        } else {
            int state = newsService.delNews(delnewsId);
            System.out.println(state);
            if (state > 0) {
                map.put("success", true);
            } else {
                map.put("success", false);
            }
        }
        return map;
    }

    @RequestMapping("newsdata.do")
    public ModelAndView goNews() {
        return new ModelAndView("news/newsdata");
    }

    */
/**
     * 新闻内容
     *
     * @param newsId
     * @return
     *//*

    @ResponseBody
    @RequestMapping("/newsData.do")
    public Map<String, Object> queryNewsContent(Integer newsId, HttpServletRequest request) {
        String path = request.getSession().getServletContext().getRealPath("upload");//文件路径
        Map<String, Object> map = new HashMap<>();
        News news = newsService.queryById(newsId);
        if (news != null) {
            map.put("news", news);
            map.put("success", true);
        }

        return map;
    }

    @RequestMapping("newstypedata.do")
    public ModelAndView goNewtitle() {
        return new ModelAndView("news/newstypedata");
    }

    */
/**
     * 根据新闻类型查询该类型所有新闻
     *
     * @param catalogId
     * @return
     *//*

    @ResponseBody
    @RequestMapping("/newsType.do")
    public Map<String, Object> findNewByType(Integer catalogId) {

        Map<String, Object> map = new HashMap<String, Object>();
        if (catalogId == null) {
            map.put("success", false);
        }
        List newsList = newsService.findNewsByType(catalogId);
        map.put("success", true);
        map.put("newsList", newsList);
        return map;

    }

}
*/
