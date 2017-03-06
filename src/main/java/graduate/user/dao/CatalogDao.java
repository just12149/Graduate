/*

public interface CatalogDao {
    */
/**
     * 新增栏目
     * @param catalog

     *//*

  int  saveCatalog(@Param("catalog")  Catalog catalog);

    */
/**更改栏目信息
     *
     * @param catalog

     *//*

  int  updateCatalog(@Param("catalog") Catalog catalog);

  */
/**
   * 根据id删除栏目信息
   * @param catalogId
   * @return
   *//*

    int  removeCatalog(@Param("catalogId") Integer  catalogId );

  */
/**
   * 根据栏目名称查询栏目信息
   * @param catalogName
   * @return
   *//*

    Catalog  findCatalogByName(@Param("catalogName") String catalogName);

    */
/**
     * 查询所有栏目信息
     * @param pageStart
     * @param pageEnd
     * @return
     *//*

    List<Catalog> findCatalogAll(@Param("pageStart") Integer pageStart, @Param("pageEnd") Integer pageEnd);


}
*/
