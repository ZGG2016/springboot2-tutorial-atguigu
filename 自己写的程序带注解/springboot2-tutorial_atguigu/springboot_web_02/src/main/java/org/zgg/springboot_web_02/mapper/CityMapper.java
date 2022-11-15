package org.zgg.springboot_web_02.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.zgg.springboot_web_02.bean.City;

//@Mapper
public interface CityMapper {

    @Select("select * from city where id = #{id}")
    public City getCityById(Integer id);

    @Insert("insert into city(`name`,`state`,`country`) values (#{name},#{state},#{country})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public void insert(City city);
}
