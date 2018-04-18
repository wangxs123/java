package com.wxs.demo.service;

import com.wxs.demo.entity.Area;

import java.util.List;

public interface AreaService {
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
    boolean addArea(Area area);

    /**
     * 更新区域信息
     * @param area
     * @return
     */
    boolean modifyArea(Area area);

    /**
     * 删除区域信息
     * @param areaId
     * @return
     */
    boolean deleteArea(int areaId);
}
