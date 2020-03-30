package core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Dynamic  implements Serializable {
    private Integer id;
    private String user_name;
    private String content;
    private String images;
    private Integer praise_counts;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date create_time;
    private boolean flag; //判断是否点赞
    private List<String> imageUrlList; //展示图片 改成集合展示

    @Override
    public String toString() {
        return "Dynamic{" +
                "id=" + id +
                ", user_name='" + user_name + '\'' +
                ", content='" + content + '\'' +
                ", images='" + images + '\'' +
                ", praise_counts=" + praise_counts +
                ", create_time=" + create_time +
                ", flag=" + flag +
                ", imageUrlList=" + imageUrlList +
                '}';
    }

    public List<String> getImageUrlList() {
        return imageUrlList;
    }

    public void setImageUrlList(List<String> imageUrlList) {
        this.imageUrlList = imageUrlList;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Integer getPraise_counts() {
        return praise_counts;
    }

    public void setPraise_counts(Integer praise_counts) {
        this.praise_counts = praise_counts;
    }

    public Integer getId() {
        return id;
    }

    public String getUser_name() {
        return user_name;
    }

    public String getContent() {
        return content;
    }

    public String getImages() {
        return images;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
