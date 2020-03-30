package core.dao;

import core.pojo.Sort;
import core.results.PageInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SortDao {

    int insertSort(String name);

    int deleteSortByName(String name);

    List<Sort> findAllSort();


}
