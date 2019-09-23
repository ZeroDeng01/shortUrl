package com.zerodeng.shorturl.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName:ShortUrl
 * @Description:TODO
 * @Author:ZeroDeng
 * @Date:2019/9/23 10:41
 * @Version:1.0
 **/
public class ShortUrlEntity implements Serializable {

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getShort_code() {
        return short_code;
    }

    public void setShort_code(String short_code) {
        this.short_code = short_code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    private int id;
    private String short_code;
    private String url;
    private Date create_time;
}
