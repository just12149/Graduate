package graduate.service;

import graduate.model.News;
import graduate.utils.page.Page;

import java.util.List;

/**
 * Created by ${niuting} on 2017/2/3.
 */
public interface NewsService {
    public   List<News> findAll(Page page, Integer newsType);

    /**
     *
     * @param news
     * @return
     */
    public int updNews(News news);
    public int delNews(Integer delnewsId);

    public List<News> queryById(Integer newsId);
}
