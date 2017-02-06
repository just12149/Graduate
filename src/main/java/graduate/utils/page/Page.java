package graduate.utils.page;

/**
 * Created by Administrator on 2016/10/12.
 */
public class Page {

    private Integer rowPerPage=5;//每页显示多少条
    private Integer totalNum=0;//数据总条数
    private Integer currentPage=1;//当前页
    /**
    * 获取分页起始位置
    * */
    public int getStart(){
        int start =(currentPage-1)*rowPerPage;
        if(start<0){
            return 0;
        }
        return start;
    }
    /**
     * 获取总页数
     * */
    public int getPageNum(){
        int  page=totalNum/rowPerPage;
        if(totalNum%rowPerPage>0){
            page++;
        }
        return page;
    }


    /**
     * 获取结尾位置
     * */

    public int getEnd(){
     int end =getStart()+rowPerPage;
     return  Math.min(end,totalNum);//得到计算得到页数(end)和总页数(totalNum)两者中最小的
    }

    public Integer getTotalNum() {
        return totalNum;
    }

    public void setTotalNum(Integer totalNum) {
        this.totalNum = totalNum;
    }

    public Integer getRowPerPage() {
        return rowPerPage;
    }

    public void setRowPerPage(Integer rowPerPage) {
        this.rowPerPage = rowPerPage;
    }

    public Integer getCurrentPage() {
     return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

}
