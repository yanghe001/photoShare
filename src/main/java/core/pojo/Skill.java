package core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;
import java.util.Date;

public class Skill implements Serializable {
    private int id;
    private String title;
    private String image_url;
    private String skill_url;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date create_time;

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", image_url='" + image_url + '\'' +
                ", skill_url='" + skill_url + '\'' +
                ", create_time=" + create_time +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getImage_url() {
        return image_url;
    }

    public String getSkill_url() {
        return skill_url;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public void setSkill_url(String skill_url) {
        this.skill_url = skill_url;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
