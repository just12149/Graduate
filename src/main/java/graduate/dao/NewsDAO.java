package graduate.dao;

import graduate.model.News;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by ${niuting} on 2017/2/3.
 */
@Service
public interface NewsDAO {

    /**
     * 查询所有新闻
     * @param pageStart
     * @param pageEnd
     * @return
     */
    public List<News> findAll(@Param("pageStart") Integer pageStart, @Param("pageEnd") Integer pageEnd);

    public int findCount(@Param("newsType") Integer newsType);

    public List<News> findNews(@Param("pageStart") Integer pageStart, @Param("pageEnd") Integer pageEnd, @Param("newstype") int newstype);

    public int insertNews(@Param("news") News news);
    public int delNews(@Param("delnewsId") Integer delnewsId);
    public int updNews(@Param("news") News news);
    public List<News> queryByid(@Param("newsId") Integer newsId);
}
