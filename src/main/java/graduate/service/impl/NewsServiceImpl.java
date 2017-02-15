package graduate.service.impl;

import graduate.dao.NewsDao;
import graduate.model.News;
import graduate.service.NewsService;
import graduate.utils.page.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ${niuting} on 2017/2/3.
 */
@Service
public class NewsServiceImpl implements NewsService {
    @Resource
    private NewsDao newsDao;
    List<News> newsList = null;
    /**
     * 查找新闻列表
     * */
    @Override
    public   List<News> findAll(Page page,Integer newstype) {
       // List<News> newsList = null;
        if(newstype==null) {
            newsList = newsDao.findAll(page.getStart(), page.getRowPerPage());
        }else {
            newsList = newsDao.findNews(page.getStart(), page.getRowPerPage(), newstype);
    }
        Integer count = newsDao.findCount(newstype);

        page.setTotalNum(count);
        return newsList;
    }


    /**
     *
     * @param news
     * @return
     */
    @Override
    public int updNews(News news) {
        int state =0;
        if(news.getNewsId()==null) {
            state = newsDao.insertNews(news);
        }else {
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
    public List<News> queryById(Integer newsId) {
        List list=newsDao.queryByid(newsId);
        return list;
    }

    @Override

    public List<News> findNewsByType(Integer newsType){
        List list=newsDao.findNewsByType(newsType);
        return list;
    }
}
