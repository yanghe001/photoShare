package core.results;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageInfo{

    private static final long serialVersionUID = 1L;

    private int totalNumber;//当前表中总条目数量
    private int currentPage;//当前页码位置

    private int totalPage;//总页数
    private int pageSize =30;//页面大小

}
