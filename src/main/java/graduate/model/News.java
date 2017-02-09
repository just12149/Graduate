package graduate.model;

import java.sql.Date;

/**
 * Created by ${niuting} on 2017/2/3.
 */
public class News {

    private Long newsId;//新闻id
    private String title;//新闻标题
    private String author;//作者
    private Date createdTime;//创建时间
    private String url;// 正文
    private int newstype;//新闻类别
    private String content;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getNewsId() {
        return newsId;
    }

    public void setNewsId(Long newsId) {
        this.newsId = newsId;
    }

    public int getNewstype() {
        return newstype;
    }

    public void setNewstype(int newstype) {
        this.newstype = newstype;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
