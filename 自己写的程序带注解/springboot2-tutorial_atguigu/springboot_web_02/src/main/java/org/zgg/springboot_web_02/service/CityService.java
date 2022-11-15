package org.zgg.springboot_web_02.service;

import org.zgg.springboot_web_02.bean.City;

public interface CityService {

    City getCityById(Integer id);

    void insert(City city);
}
