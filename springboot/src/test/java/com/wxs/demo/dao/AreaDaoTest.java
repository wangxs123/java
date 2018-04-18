package com.wxs.demo.dao;

import com.wxs.demo.entity.Area;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class AreaDaoTest {
    private static final Logger logger = LoggerFactory.getLogger(AreaDaoTest.class);
    //创建成员变量
    @Autowired
    private AreaDao areaDao;

    @Test
    public void queryArea() {
        List<Area> areaList = areaDao.queryArea();
        for (Area vo: areaList) {
            logger.info(vo.toString());
        }
        //assertEquals(2,areaList.size());
    }

    @Test
    public void queryAreaById() {
        Area area= areaDao.queryAreaById(1);
    }

    @Test
    public void insertArea() {
        Area area = new Area();
        area.setAreaName("北苑");
        area.setPriority(1);
        int num = areaDao.insertArea(area);
        logger.info(area.toString());
        logger.info("新增了"+num+"行");
    }

    @Test
    public void updateArea() {
        Area area = new Area();
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        area.setAreaName("东苑");
        area.setAreaId(1);
        area.setLastEditTime(sdf.format(new Date()));
        int num = areaDao.updateArea(area);
        logger.info("修改了"+num+"行");
    }

    @Test
    public void deleteArea() {
        Integer id = 11;
        int num = areaDao.deleteArea(id);
        logger.info("删除了"+num+"行");
    }
}