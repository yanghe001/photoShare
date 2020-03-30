package core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

public class Love implements Serializable {
    private int id;
    @NotNull(message = "图片id不能为空")
    private int img_id;
    @NotNull(message = "用户名不能为空")
    private String user_name;
    @NotNull(message = "分类名不能为空")
    private String sort_name;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date create_time;

    @Override
    public String toString() {
        return "Love{" +
                "id=" + id +
                ", img_id=" + img_id +
                ", user_name='" + user_name + '\'' +
                ", sort_name='" + sort_name + '\'' +
                ", create_time=" + create_time +
                '}';
    }

    public int getId() {
        return id;
    }

    public int getImg_id() {
        return img_id;
    }

    public String getUser_name() {
        return user_name;
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

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setSort_name(String sort_name) {
        this.sort_name = sort_name;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
