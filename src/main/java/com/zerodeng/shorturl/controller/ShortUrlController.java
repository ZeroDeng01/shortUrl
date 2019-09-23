package com.zerodeng.shorturl.controller;


import com.alibaba.fastjson.JSON;
import com.zerodeng.shorturl.mapper.ShortUrlMapper;
import com.zerodeng.shorturl.entity.ShortUrlEntity;
import com.zerodeng.shorturl.utils.Common;
import com.zerodeng.shorturl.utils.ConversionUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName:ShortUrlController
 * @Description:TODO
 * @Author:ZeroDeng
 * @Date:2019/9/23 11:02
 * @Version:1.0
 **/
@Controller
public class ShortUrlController {
    @Autowired
    private ShortUrlMapper shortUrlMapper;

    /**
    * @Author ZeroDeng
    * @Description TODO 页面跳转
    * @Date 11:52 2019/9/23
    * @Param [response, code]
    * @return void
    * @Version 1.0
    **/
    @RequestMapping(value = "/{code}")
    public void Redirect(HttpServletResponse response,@PathVariable("code") String code) throws IOException {
        ShortUrlEntity shortUrlEntity = shortUrlMapper.getOneForShortCode(code);
        response.sendRedirect(shortUrlEntity.getUrl());
    }

    @RequestMapping(value = "/api/getUrl",method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String getShortUrlAPI(@RequestParam("url") String Url){
        Map<String,Object> map = new HashMap<String,Object>();
        if(Url.isEmpty()){
            map.put("code",1001);
            map.put("msg","域名为空");
            String JsonString = JSON.toJSONString(map);
            return JsonString;
        }
        if(!Common.isHttpUrl(Url)){
            map.put("code",1002);
            map.put("msg","域名格式不正确");
            String JsonString = JSON.toJSONString(map);
            return JsonString;
        }
        ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
        shortUrlEntity.setUrl(Url);
        shortUrlEntity.setCreate_time(new Date());
        int insRow = shortUrlMapper.insert(shortUrlEntity);
        if(insRow<=0){
            map.put("code",1001);
            map.put("msg","插入失败");
            String JsonString = JSON.toJSONString(map);
            return JsonString;
        }
        map.put("code",0);
        map.put("msg","success");
        int id = shortUrlEntity.getId();
        String shortCode = ConversionUtil.encode(id+1000000000);
        shortUrlEntity.setShort_code(shortCode);
        shortUrlMapper.update(shortUrlEntity);
        map.put("shortCode",shortCode);
        map.put("url",Url);
        String JsonString = JSON.toJSONString(map);
        return JsonString;
    }


    @RequestMapping(value = "/form/getUrl",method = RequestMethod.POST)
    public String getShortUrlForm(HttpServletRequest request, @RequestParam("MakeShort_LongUrl") String Url , Model model){
        if(Url.isEmpty()){
            model.addAttribute("code",1001);
            model.addAttribute("msg","域名为空");
            return "index";
        }
        if(!Common.isHttpUrl(Url)){
            model.addAttribute("code",1002);
            model.addAttribute("msg","域名格式不正确");
            return "index";
        }
        ShortUrlEntity shortUrlEntity = new ShortUrlEntity();
        shortUrlEntity.setUrl(Url);
        shortUrlEntity.setCreate_time(new Date());
        int insRow = shortUrlMapper.insert(shortUrlEntity);
        Map<String,Object> map = new HashMap<String,Object>();
        if(insRow<=0){
            model.addAttribute("code",5001);
            model.addAttribute("msg","插入失败");
            return "index";
        }
        model.addAttribute("code",0);
        model.addAttribute("msg","success");
        int id = shortUrlEntity.getId();
        String shortCode = ConversionUtil.encode(id+1000000000);
        shortUrlEntity.setShort_code(shortCode);
        shortUrlMapper.update(shortUrlEntity);
        model.addAttribute("shortCode",shortCode);
        model.addAttribute("url",Url);
        if(request.getServerPort()==80||request.getServerPort()==443){
            model.addAttribute("shortUrl",request.getScheme()+"://"+request.getServerName()+"/"+shortCode);
        }else{
            model.addAttribute("shortUrl",request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+"/"+shortCode);
        }
        model.addAttribute("url",Url);
        return "index";
    }


}
