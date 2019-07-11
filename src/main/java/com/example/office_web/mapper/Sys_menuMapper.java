package com.example.office_web.mapper;

import com.example.office_web.entity.Sys_menu;
import com.baomidou.mybatisplus.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author ywk
 * @since 2019-05-26
 */
public interface Sys_menuMapper extends BaseMapper<Sys_menu> {


    /**
     * 获取菜单列表（不分页)
     * @return
     */
    public List<Sys_menu> selectMenuList();
}
