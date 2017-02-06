package graduate.action;

import graduate.model.News;
import graduate.service.NewsService;
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

/**
 * Created by ${niuting} on 2017/2/3.
 */
@Controller
@RequestMapping("/news")
public class NewsAction {


@Resource
private NewsService newsService;


    @RequestMapping("/query.do")
    public ModelAndView PageRequest(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("news/query");
        return modelAndView;
    }


    /**
     * 使用json查询数据
     */
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
    public Map<String, Object> updateAction(News updateNews) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (updateNews == null) {
            map.put("success", false);
        } else {
            int state =newsService.updNews(updateNews);
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
}
