package core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class DynamicLove implements Serializable {
    private Integer id;
    private Integer dynamic_id;
    private String user_name;
    private Integer flag;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date create_time;

    @Override
    public String toString() {
        return "DynamicLove{" +
                "id=" + id +
                ", dynamic_id=" + dynamic_id +
                ", user_name='" + user_name + '\'' +
                ", flag=" + flag +
                ", create_time=" + create_time +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Integer getDynamic_id() {
        return dynamic_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public Integer getFlag() {
        return flag;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDynamic_id(Integer dynamic_id) {
        this.dynamic_id = dynamic_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
