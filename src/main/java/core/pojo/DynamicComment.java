package core.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class DynamicComment implements Serializable {

    private Integer id;
    private Integer dynamic_id;
    private String content;
    private String from_user;
    private Integer identify_id;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+08")
    private Date create_time;
    List<DynamicReply> dynamicReplyList;

    @Override
    public String toString() {
        return "DynamicComment{" +
                "id=" + id +
                ", dynamic_id=" + dynamic_id +
                ", content='" + content + '\'' +
                ", from_user='" + from_user + '\'' +
                ", identify_id=" + identify_id +
                ", create_time=" + create_time +
                ", dynamicReplyList=" + dynamicReplyList +
                '}';
    }

    public List<DynamicReply> getDynamicReplyList() {
        return dynamicReplyList;
    }

    public void setDynamicReplyList(List<DynamicReply> dynamicReplyList) {
        this.dynamicReplyList = dynamicReplyList;
    }

    public Integer getIdentify_id() {
        return identify_id;
    }

    public void setIdentify_id(Integer identify_id) {
        this.identify_id = identify_id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getDynamic_id() {
        return dynamic_id;
    }

    public String getContent() {
        return content;
    }

    public String getFrom_user() {
        return from_user;
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

    public void setContent(String content) {
        this.content = content;
    }

    public void setFrom_user(String from_user) {
        this.from_user = from_user;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }
}
