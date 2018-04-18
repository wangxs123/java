package com.wxs.demo.dao;

import com.wxs.demo.entity.Area;

import java.util.List;

public interface AreaDao {
    /**
     * 列出区域信息
     * @return
     */
    List<Area> queryArea();

    /**
     * 根据区域id查询区域信息
     * @param areaId
     * @return
     */
    Area queryAreaById(int areaId);

    /**
     * 插入区域信息
     * @param area
     * @return
     */
    int insertArea(Area area);

    /**
     * 更新区域信息
     * @param area
     * @return
     */
    int updateArea(Area area);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
    int deleteArea(int areaId);
}
