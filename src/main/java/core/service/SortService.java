package core.service;

import core.pojo.Sort;
import java.util.List;

public interface SortService {
    int insertSort(String name);

    boolean deleteSortByName(String name);

    List<Sort> findAllSort();

}
