package com.example.office_web.service.impl;

import com.example.office_web.entity.Sys_menu;
import com.example.office_web.mapper.Sys_menuMapper;
import com.example.office_web.mapper.UserMapper;
import com.example.office_web.service.ISys_menuService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author ywk
 * @since 2019-05-26
 */
@Service
public class Sys_menuServiceImpl extends ServiceImpl<Sys_menuMapper, Sys_menu> implements ISys_menuService {


    @Autowired
    private Sys_menuMapper sys_menuMapper;


    /**
     * 获取菜单列表接口,先从缓存获取
     * @return
     */
    public List<Sys_menu> getSysMenuList(){
        List<Sys_menu>  menuList  = sys_menuMapper.selectMenuList();
        List<Sys_menu> resultList = handlerChildren(menuList);
        return resultList;
    }


    /**
     * 组装父子级菜单
     * @param sysMenuList 菜单数据源
     * @return
     */
    public List<Sys_menu> handlerChildren(List<Sys_menu> sysMenuList){
       if(sysMenuList == null || sysMenuList.size() == 0){
           return new ArrayList<>();
       }

       List<Sys_menu> resultList = new ArrayList<>();//此列表保留一级菜单
       Map<String, Sys_menu> menuMap = new HashMap<>();
       for(Sys_menu sysMenu : sysMenuList){
           menuMap.put(sysMenu.getId(), sysMenu);
       }

        for(Sys_menu sysMenu : sysMenuList){
           if(StringUtils.isBlank(sysMenu.getMenu_parent_url())){
               resultList.add(sysMenu);
           }else {
               Sys_menu parentMenu =  menuMap.get(sysMenu.getMenu_parent_url());
               parentMenu.getChildrenMenuList().add(sysMenu);
           }
        }


        //菜单排序
        sortMenu(resultList);

       return resultList;
    }


    /**
     * 对菜单进行递归排序,按sort升序排序
     * @param sysMenuList
     */
    public void sortMenu(List<Sys_menu> sysMenuList){
      if(sysMenuList == null || sysMenuList.size() == 0){
          return;
      }

      Collections.sort(sysMenuList, new Comparator<Sys_menu>() {
          @Override
          public int compare(Sys_menu o1, Sys_menu o2) {
              if(o1.getSort() - o2.getSort() > 0){
                  return 1;
              }else if(o1.getSort() - o2.getSort() < 0){
                  return -1;
              }else {
                  return 0;
              }

          }
      });

      for(Sys_menu sysMenu : sysMenuList){
          sortMenu(sysMenu.getChildrenMenuList());
      }
    }


}
