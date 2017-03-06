/*
package graduate.user.service.impl;


import graduate.user.dao.NewsDao;
import graduate.user.model.News;
import graduate.user.service.NewsService;
import graduate.utils.StaticPageUtil;
import graduate.utils.page.Page;

import org.springframework.stereotype.Service;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Map;

*/
/**
 * Created by ${niuting} on 2017/2/3.
 *//*

@Service
public class NewsServiceImpl implements NewsService {

    @Resource
    private NewsDao newsDao;


    private StaticPageUtil staticPageUtil;


    List<News> newsList = null;

    */
/**
     * 查找新闻列表
     *
     * @param page
     * @param newstype
     * @return
     *//*

    @Override
    public List<News> findAll(Page page, Integer newstype) {
        // List<News> newsList = null;
        if (newstype == null) {
            newsList = newsDao.findAll(page.getStart(), page.getRowPerPage());
        } else {
            newsList = newsDao.findNews(page.getStart(), page.getRowPerPage(), newstype);
        }
        Integer count = newsDao.findCount(newstype);

        page.setTotalNum(count);
        return newsList;
    }

    */
/**
     * 添加新闻
     * @param news
     * @return
     *//*

    @Override
    public int saveNews(News news) {
        int state = newsDao.insertNews(news);
        return state;
    }

*/
/**
     * 添加新闻
     *
     * @return
     *//*

 */
/*
   public int saveNews(HttpServletRequest request, Integer newsId) {
        int state = 0;
        News news = this.queryById(newsId);
        if (news != null) {
            try {
                Map<String, Object> newsPageMap = this.getStaticPage(request, newsId);
                if ((Boolean) newsPageMap.get("success")) {
                    news.setHttpUrl((String) newsPageMap.get("httpUrl"));
                    news.setFilePath((String) newsPageMap.get("filePath"));
                    state = this.saveNews(news);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return state;
    }*//*


    */
/*更新新闻
     * @param news
     * @return
     *//*

    @Override
    public int updNews(News news) {
        int state = 0;
        if (news.getNewsId() == null) {
            state = newsDao.insertNews(news);
        } else {
            state = newsDao.updNews(news);
        }

        return state;
    }

    //删除数据方法
    @Override
    public int delNews(Integer delnewsId) {
        int state = newsDao.delNews(delnewsId);
        return state;
    }

    @Override
    */
/**
     * 根据Id查询新闻
     *//*

    public News queryById(Integer newsId) {
        return newsDao.queryByid(newsId);

    }

    @Override
*/
/**
 * 根据栏目查询新闻
 *//*

    public List<News> findNewsByType(Integer newsType) {
        List list = newsDao.findNewsByType(newsType);

        return list;
    }


    */
/**静态化页面
     * @param request
     * @param newsId
     * @return
     * @throws Exception
     *//*

    public Map<String, Object> getStaticPage(HttpServletRequest request, Integer newsId) throws Exception {

        Map<String, Object> map = staticPageUtil.createHtmlPage(request, newsId);
        return map;

    }
}
*/
