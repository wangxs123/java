package com.wxs.demo.web;

import com.wxs.demo.entity.Area;
import com.wxs.demo.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @RestController相当于@Controller加@ResponseBody
 *
 * @RequestMapping("")指定一个路由
 */
@RestController
@RequestMapping("/superadmin")
public class AreaController {
    @Autowired
    private AreaService areaService;

    @RequestMapping(value = "/listarea",method = RequestMethod.GET)
    private Map<String,Object> listArea(){

        Map<String,Object> map = new HashMap<>();
        List<Area> list = areaService.queryArea();
        map.put("areaList",list);
        return map;
    }

    @RequestMapping(value = "/queryareabyid",method = RequestMethod.GET)
    private Map<String,Object> queryAreaById(Integer areaId){
        Map<String,Object> map = new HashMap<>();
        Area area = areaService.queryAreaById(areaId);
        map.put("area",area);
        return map;
    }

    @RequestMapping(value = "/addarea",method = RequestMethod.POST)
    private Map<String,Object> addArea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<>();
        map.put("success",areaService.addArea(area));
        return map;
    }

    @RequestMapping(value = "/modifyarea",method = RequestMethod.POST)
    private Map<String,Object> modifyArea(@RequestBody Area area){
        Map<String,Object> map = new HashMap<>();
        map.put("success",areaService.modifyArea(area));
        return map;
    }

    @RequestMapping(value = "/removearea",method = RequestMethod.GET)
    private Map<String,Object> removeArea(Integer areaId){
        Map<String,Object> map = new HashMap<>();
        map.put("success",areaService.deleteArea(areaId));
        return map;
    }

}
