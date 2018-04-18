package com.wxs.demo.service.impl;

import com.wxs.demo.dao.AreaDao;
import com.wxs.demo.entity.Area;
import com.wxs.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@Service
public class AreaServiceImpl implements AreaService{

    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area queryAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    @Transactional
    @Override
    public boolean addArea(Area area) {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        if(area.getAreaName() != null && !"".equals(area.getAreaName())){
            area.setCreateTime(sdf.format(new Date()));
            area.setLastEditTime(sdf.format(new Date()));
            try {
                int effectNum = areaDao.insertArea(area);
                if (effectNum>0){
                    return true;
                }else {
                    throw new RuntimeException("插入区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("插入区域信息失败:"+e.getMessage());
            }

        }else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean modifyArea(Area area) {
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //空值判断，主要是areaId不能为空
        if (area.getAreaId() != null && !"".equals(area.getAreaId())){
            area.setLastEditTime(sdf.format(new Date()));
            try {
                int effectNum = areaDao.updateArea(area);
                if (effectNum>0){
                    return true;
                }else {
                    throw new RuntimeException("更新区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("更新区域信息失败:"+e.toString());
            }

        }else {
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteArea(int areaId) {
        if (areaId >0){
            try {
                int effectNum = areaDao.deleteArea(areaId);
                if (effectNum>0){
                    return true;
                }else {
                    throw new RuntimeException("删除区域信息失败！");
                }
            }catch (Exception e){
                throw new RuntimeException("删除区域信息失败:"+e.toString());
            }

        }else {
            throw new RuntimeException("区域id不能为空！");
        }
    }
}
