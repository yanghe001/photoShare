package core.service.impl;

import core.dao.ImageDao;
import core.dao.LoveDao;
import core.dao.SortDao;
import core.pojo.Sort;
import core.results.PageInfo;
import core.service.SortService;
import core.utils.FileUntil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SortServiceImpl implements SortService {
    @Autowired
    SortDao sortDao;
    @Autowired
    ImageDao imageDao;
    @Autowired
    LoveDao loveDao;

    @Override
    public int insertSort(String name) {
        return sortDao.insertSort(name);
    }

    @Override
    public boolean deleteSortByName(String name) {
        FileUntil.deleteFolder(name);
        imageDao.deleteImageBySortName(name);
        loveDao.deleteLoveBySortName(name);
        int result=sortDao.deleteSortByName(name);
        return result>0?true:false;
    }

    @Override
    public List<Sort> findAllSort() {
        return sortDao.findAllSort();
    }

}
