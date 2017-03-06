/*
package graduate.user.action;

import graduate.user.model.Catalog;
import graduate.user.service.CatalogService;
import graduate.utils.DateUtils;
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
 * Created by ${niuting} on 2017/2/10.
 *//*

@Controller
@RequestMapping("/news")
public class CatalogAction {

    @Resource
    private CatalogService catalogService;

    @RequestMapping("/Catalog.do")
    public ModelAndView catalogPage(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView("news/Catalog");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/queryCatalog.do")
    public Map<String, Object> findCatalogAll(Page page) {
        Map<String, Object> map = new HashMap<String, Object>();
        List<Catalog> catalogList;
        catalogList = catalogService.findCalalogAll(page);
        map.put("totalNum", page.getTotalNum());
        map.put("catalogList", catalogList);
        map.put("success", true);
        return map;

    }

    @ResponseBody
    @RequestMapping("/updateCatalog.do")
    public Map<String, Object> updateAction(Catalog catalog) {
        Map<String, Object> map = new HashMap<String, Object>();
        int state=0;
        if (catalog.getCatalogName() == null) {
            map.put("success", false);
            return map;
        }
        if(catalog.getId()==null){
            catalog.setCreatedTime(DateUtils.getCurrentTime(DateUtils.FORMAT_19));
            state = catalogService.saveCatalog(catalog);
        }else{
            state = catalogService.updateCatalog(catalog);
        }
        if (state > 0) {
            map.put("success", true);
        } else {
            map.put("success", false);
        }
        return map;

    }



    @ResponseBody
    @RequestMapping("/delCatalog.do")
    public Map<String, Object> delCatalog(int delCatalogId) {
        Map<String, Object> map = new HashMap<String, Object>();
        if (delCatalogId < 0) {
            map.put("success", false);
        }
        int state = catalogService.deleteCataLog(delCatalogId);
        if (state > 0) {
            map.put("success", true);
        } else {
            map.put("success", false);
        }
        return map;

    }
}
*/
