package com.zerodeng.shorturl.mapper;

import com.zerodeng.shorturl.entity.ShortUrlEntity;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ShortUrlMapper {
    @Select("select * from ZD_ShortUrl")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "short_code",column = "short_code"),
            @Result(property = "url",column = "url"),
            @Result(property = "create_time",column = "create_time")
    })
    List<ShortUrlEntity> getAll();


    @Select("select * from ZD_ShortUrl WHERE id=#{id}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "short_code",column = "short_code"),
            @Result(property = "url",column = "url"),
            @Result(property = "create_time",column = "create_time")
    })
    ShortUrlEntity getOneForID(int id);

    @Select("select * from ZD_ShortUrl WHERE short_code = #{short_code}")
    @Results({
            @Result(property = "id",column = "id"),
            @Result(property = "short_code",column = "short_code"),
            @Result(property = "url",column = "url"),
            @Result(property = "create_time",column = "create_time")
    })
    ShortUrlEntity getOneForShortCode(String shortCode);

    @Insert("INSERT INTO ZD_ShortUrl(short_code,url,create_time) VALUES(#{short_code}, #{url}, #{create_time})")
    @Options(useGeneratedKeys=true, keyProperty="id")
    int insert(ShortUrlEntity shorturl);

    @Update("UPDATE ZD_ShortUrl SET short_code=#{short_code} WHERE id =#{id}")
    @Options(useGeneratedKeys=true, keyProperty="id")
    void update(ShortUrlEntity shorturl);
}
