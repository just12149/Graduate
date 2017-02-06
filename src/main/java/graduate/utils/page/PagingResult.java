package graduate.utils.page;

import java.util.List;

/**
 * 功能：分页结果集公用类
 * 作者：Zhang_XinGang
 * 时间：2015/12/2 13:43
 */
public class PagingResult<T> {
	private long count;
	private List<T> datas;
	private PageUtil page;
	public PagingResult() {
	}
	public PagingResult(long count, List<T> datas,PageUtil page) {
		page = new PageUtil(count,page.getCurrentPage());
		this.count = count;
		this.datas = datas;
		this.page = page;
	}
	public PageUtil getPage() {
		return page;
	}
	public void setPage(PageUtil page) {
		this.page = page;
	}
	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}
	public String toString() {
		return "PagingResult [count=" + count + ", datas=" + datas + "]";
	}
}
