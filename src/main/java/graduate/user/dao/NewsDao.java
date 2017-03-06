/*
package graduate.user.dao;

import graduate.user.model.News;

import org.apache.ibatis.annotations.Param;

import java.util.List;

*/
/**
 * Created by ${niuting} on 2017/2/10.
 *//*

public interface NewsDao {

    */
/**
     * 查询所有新闻
     * @param pageStart
     * @param pageEnd
     * @retur
     *//*

    List<News> findAll(@Param("pageStart") Integer pageStart, @Param("pageEnd") Integer pageEnd);

    int findCount(@Param("newsType") Integer newsType);

    List<News> findNews(@Param("pageStart") Integer pageStart, @Param("pageEnd") Integer pageEnd, @Param("newstype") int newstype);

    public List<News> findNewsByType(@Param("newsType") Integer newsType);

    int insertNews(@Param("news") News news);
    int delNews(@Param("delnewsId") Integer delnewsId);
    int updNews(@Param("news") News news);
    public  News   queryByid(@Param("newsId") Integer newsId);
}

*/
