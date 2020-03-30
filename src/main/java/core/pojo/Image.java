package core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.util.Date;

public class Image  implements Serializable {
    private int id;
    private String url;
    private String sort_name;
    private String user_name;
    private int  praise_count;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date create_time;
    private boolean flag;

    @Override
    public String toString() {
        return "Image{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", sort_name='" + sort_name + '\'' +
                ", user_name='" + user_name + '\'' +
                ", praise_count=" + praise_count +
                ", create_time=" + create_time +
                ", flag=" + flag +
                '}';
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public int getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public String getSort_name() {
        return sort_name;
    }

    public String getUser_name() {
        return user_name;
    }

    public int getPraise_count() {
        return praise_count;
    }


    public Date getCreate_time() {
        return create_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setSort_name(String sort_name) {
        this.sort_name = sort_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setPraise_count(int praise_count) {
        this.praise_count = praise_count;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
