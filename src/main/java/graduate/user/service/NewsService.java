/*
package graduate.user.service;

import graduate.user.model.News;
import graduate.utils.page.Page;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

*/
/**
 * Created by ${niuting} on 2017/2/3.
 *//*

public interface NewsService {


    public   List<News> findAll(Page page, Integer newsType);

    */
/**更新新闻内容
     *
     * @param news
     * @return
     *//*

    public int updNews(News news);

    */
/**
     * 删除新闻
     * @param delnewsId
     * @return
     *//*

    public int delNews(Integer delnewsId);

    */
/** 添加新闻基础内容
     *
     * @param news
     * @return
     *//*

    public int saveNews(News news);

    */
/**添加新闻全部内容
     *
     * @param request
     * @param newsId
     * @return
     *//*

    public int SaveNews(HttpServletRequest request,Integer newsId);



    */
/**
     * 根据Id查询新闻
     * @param newsId
     * @return
     *//*

    public News queryById(Integer newsId);

    */
/**
     * 根据栏目查询新闻
     * @param newsType
     * @return
     *//*

    public List<News>  findNewsByType(Integer newsType);


    */
/**
     * 静态化页面
     * @param request
     * @param newsId
     * @return filePath(存储路径)  httpUrl(访问路径)
     * @throws Exception
     *//*

    Map<String,Object> getStaticPage(HttpServletRequest request,Integer newsId)throws Exception;
}
*/
