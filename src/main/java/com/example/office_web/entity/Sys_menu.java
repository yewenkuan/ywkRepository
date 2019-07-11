package com.example.office_web.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 
 * </p>
 *
 * @author ywk
 * @since 2019-05-26
 */
public class Sys_menu extends Model<Sys_menu> {

    private static final long serialVersionUID = 1L;

    private String id;

    private Integer sort;//排序

    /**

     * 菜单链接
     */
    private String menu_url;

    /**
     * 父级菜单名称
     */
    private String menu_parent_url;

    /**
     * 菜单名称
     */
    private String menu_name;

    List<Sys_menu> childrenMenuList = new ArrayList<>();// 子菜单列表

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getMenu_url() {
        return menu_url;
    }

    public void setMenu_url(String menu_url) {
        this.menu_url = menu_url;
    }
    public String getMenu_parent_url() {
        return menu_parent_url;
    }

    public void setMenu_parent_url(String menu_parent_url) {
        this.menu_parent_url = menu_parent_url;
    }
    public String getMenu_name() {
        return menu_name;
    }

    public void setMenu_name(String menu_name) {
        this.menu_name = menu_name;
    }

    public List<Sys_menu> getChildrenMenuList() {
        return childrenMenuList;
    }

    public void setChildrenMenuList(List<Sys_menu> childrenMenuList) {
        this.childrenMenuList = childrenMenuList;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "Sys_menu{" +
        "id=" + id +
        ", menu_url=" + menu_url +
        ", menu_parent_url=" + menu_parent_url +
        ", menu_name=" + menu_name +
        "}";
    }



}
