package graduate.service.impl;

import graduate.dao.CatalogDao;
import graduate.model.Catalog;
import graduate.service.CatalogService;
import graduate.utils.page.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ${niuting} on 2017/2/10.
 */
@Service
public class CatalogServiceImpl implements CatalogService {
    @Resource
    private  CatalogDao catalogDao;

    public CatalogDao getCatalogDao() {
        return catalogDao;
    }

    public void setCatalogDao(CatalogDao catalogDao) {
        this.catalogDao = catalogDao;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int  saveCatalog(Catalog catalog) {
        int state=0;
        state=catalogDao.saveCatalog(catalog);
        return  state;
    }
    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int  updateCatalog(Catalog catalog) {
        int state=0;
            state=catalogDao.updateCatalog(catalog);
        return  state;
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public int  deleteCataLog(Integer  Id) {
        int state=catalogDao.removeCatalog(Id);
      return  state ;
    }
    @Override
    public Catalog findCatalogByName(String catalogName) {
        return catalogDao.findCatalogByName(catalogName);
    }

    public List<Catalog> findCalalogAll(Page page) {
        return catalogDao.findCatalogAll(page.getStart(), page.getRowPerPage());
    }

}
