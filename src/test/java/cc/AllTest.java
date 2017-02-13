package cc;

import graduate.dao.CatalogDao;
import graduate.dao.NewsDao;
import graduate.dao.UserDao;
import graduate.model.Catalog;
import graduate.service.CatalogService;
import graduate.service.NewsService;
import graduate.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class AllTest {


    @Resource
    CatalogDao catalogDao;
    @Resource
    CatalogService catalogService;




   /* @Resource
    HUserService hUserService;
    @Resource
    HUserDao huserdao;*/

    @Test
    public void test() {
/*        Map map = new HashMap<String, Object>();
        Date utilDate = new Date();
        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        User user = new User();

        user.setUserId(49l);
        user.setUserName("just12149");
        user.setSex(1);
        user.setBirthDay(sqlDate);
        user.setGroupNum(3);
        user.setDescription("female");
        userService.updUser(user);
        userDAO.selectUserById(1);


        user.setLoginName("1234567890");
        // userDAO.insertUser(user);
        userService.saveUser(user);
        System.out.print("------------------------");
        System.out.print(user.getUserId());*/


        /*HUser huser = new HUser();
        huserdao.delUser(52);
        huserdao.findUser(1, 3, 2);*/


//        News news = new News();

//
//        newsDAO.findNews(1, 3, 1);
        //newsDAO.delNews(1);

        //   newsDAO.delNews(45);
       /* Page page = new Page();
        page.setTotalNum(33);
        page.setRowPerPage(5);
        page.setCurrentPage(1);


        System.out.println("-------------" + newsDAO.findCount(5));
        System.out.println(JSONObject.toJSONString(newsService.findAll(page, 5)));
        System.out.println(JSONObject.toJSONString(newsDAO.findAll(1, 6)));*/


     /*News news= new News();

        news.setAuthor("just");
        news.setNewstype(1);
        news.setTitle("HelloWorld");
        newsService.updNews(news);
       // newsDAO.insertNews(news);

        News news1= new News();

        news1.setAuthor("just12149");
        news1.setTitle("这是第二条新闻");
        news1.setNewstype(5);
        news1.setNewsId(news.getNewsId());
        newsService.updNews(news1);
       // newsDAO.updNews(news1);*/
        // newsService.queryById(2);


       /* catalogDao.findCatalogByName("科技新闻");
        catalogDao.findCatalogAll(1, 2);
        catalogDao.removeCatalog(10);

        Catalog catalog = new Catalog();
        catalog.setCatalogId(17);
        catalog.setCatalogName("大秦网");
        catalog.setCreatedTime("2017-2-10");
        catalogDao.saveCatalog(catalog);
       catalogDao.updateCatalog(catalog);*/


    }
}