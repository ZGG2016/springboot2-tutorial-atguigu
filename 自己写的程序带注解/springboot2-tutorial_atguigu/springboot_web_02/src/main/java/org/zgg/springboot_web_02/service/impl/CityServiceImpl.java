package org.zgg.springboot_web_02.service.impl;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zgg.springboot_web_02.bean.City;
import org.zgg.springboot_web_02.mapper.CityMapper;
import org.zgg.springboot_web_02.service.CityService;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    CityMapper cityMapper;

    Counter counter;

    public CityServiceImpl(MeterRegistry meterRegistry){
        counter = meterRegistry.counter("cityService.saveCity.count");
    }

    @Override
    public City getCityById(Integer id) {
        return cityMapper.getCityById(id);
    }

    @Override
    public void insert(City city) {
        counter.increment();
        cityMapper.insert(city);
    }
}
