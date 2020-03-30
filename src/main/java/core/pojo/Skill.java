package core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Skill implements Serializable {
    private int id;
    private String url;
    private String sort_name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date create_time;

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", url='" + url + '\'' +
                ", sort_name='" + sort_name + '\'' +
                ", create_time=" + create_time +
                '}';
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

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
