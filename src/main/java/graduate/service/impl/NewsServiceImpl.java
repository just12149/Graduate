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
    private NewsDao newsDAO;
    List<News> newsList = null;
    /**
     * 查找新闻列表
     * */
    @Override
    public   List<News> findAll(Page page,Integer newstype) {
       // List<News> newsList = null;
        if(newstype==null) {
            newsList = newsDAO.findAll(page.getStart(), page.getRowPerPage());
        }else {
            newsList = newsDAO.findNews(page.getStart(), page.getRowPerPage(), newstype);
    }
        Integer count = newsDAO.findCount(newstype);

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
            state = newsDAO.insertNews(news);
        }else {
            state = newsDAO.updNews(news);
        }

        return state;
    }

    //删除数据方法
    @Override
    public int delNews(Integer delnewsId) {
        int state = newsDAO.delNews(delnewsId);
        return state;
    }

    @Override
    public List<News> queryById(Integer newsId) {
        List list=newsDAO.queryByid(newsId);
        return list;
    }
}
