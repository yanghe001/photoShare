package core.service;

public interface DynamicLoveService {
    //点赞或者取消点赞
    boolean addOrDelDynamicLove(String user_name, Integer dynamic_id);

}
