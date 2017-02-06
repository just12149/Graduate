package graduate.utils.page;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;


public class PageUtil {
	/**
	 * 页大小
	 */
	public static final int pageSize = 15;
	/**
	 * 数据记录总数
	 */
	public long dataCount;
	/**
	 * 页总数
	 */
	public int pageCount;
	/**
	 * 当前页
	 */
	public int currentPage;
	/**
	 * 开始下标位
	 */
	public int startLimit;
	/**
	 * 结束下标位
	 */
	public int endLimit;
	/**
	 * 排序方式， desc或者asc
	 */
	private String sortDir;
	/**
	 * 排序字段
	 */
	private String sortField;
	public PageUtil(){
		super();
	}
	@SuppressWarnings("static-access")
	public PageUtil(long dataCount,int currentPage){
		super();
		if(dataCount > this.pageSize){
			float f = (float)dataCount / (float)this.pageSize;
			this.pageCount = (int)Math.ceil(f);
		}else{
			this.pageCount = 1;
		}
		this.dataCount = dataCount;
		this.currentPage = currentPage;
	}
	public String getSortDir() {
		return sortDir;
	}
	public void setSortDir(String sortDir) {
		this.sortDir = sortDir;
	}
	public String getSortField() {
		return sortField;
	}
	public void setSortField(String sortField) {
		this.sortField = sortField;
	}
	public long getDataCount() {
		return dataCount;
	}
	public void setDataCount(long dataCount) {
		this.dataCount = dataCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getStartLimit() {
		return (this.getCurrentPage() - 1) * this.pageSize;
	}
	public void setStartLimit(int startLimit) {
		this.startLimit = startLimit;
	}
	public int getEndLimit() {
		return this.pageSize;
	}
	public void setEndLimit(int endLimit) {
		this.endLimit = endLimit;
	}
	public Map<String,Object> pushSortParam(Map<String,Object> queryParam){
		if(!StringUtils.isEmpty(this.sortDir) && !StringUtils.isEmpty(this.sortField)){
			if(!(queryParam!=null&&queryParam.size()>0)){
				queryParam = new HashMap<String,Object>();
			}
			queryParam.put("sortDir", this.sortDir);
			queryParam.put("sortField", this.sortField);
		}
		return queryParam;
	}
}
