package com.example.office_web.web;

import java.util.HashMap;
import java.util.Map;

public class BaseController {


    /**
     * 成功返回
     * @param content
     * @return
     */
    public Map ajaxSucess(Object content){
        Map map = new HashMap();
        map.put("success", true);
        map.put("content", content);
        return map;
    }

    /**
     * 异常返回
     * @param content
     * @return
     */
    public Map ajaxFail(Object content){
        Map map = new HashMap();
        map.put("success", false);
        map.put("content", content);
        return map;
    }
}
