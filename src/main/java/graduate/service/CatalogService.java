package graduate.service;

import graduate.model.Catalog;
import graduate.utils.page.Page;

import java.util.List;

/**
 * Created by ${niuting} on 2017/2/10.
 */

public interface CatalogService {
    /**添加栏目信息
     * @param catalog

     */
    int  saveCatalog(Catalog catalog);

    /**更改栏目信息
     * @param catalog

     */
    int  updateCatalog(Catalog catalog);

    /**根据id删除栏目信息(物理删除)
     * @param Id

     */
    int  deleteCataLog(Integer  Id);

    /**根据栏目名查询栏目信息
     * @param CatalogName

     * @return
     */

    Catalog findCatalogByName(String CatalogName);

    /**查询所有栏目信息

     * @return
     */

    List<Catalog> findCalalogAll(Page page );
}
