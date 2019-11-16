package com.lty.mapper;

import com.lty.model.Area;
import com.lty.model.City;
import com.lty.model.Province;

public interface UserMapper {

    void saveProvince(Province province);

    void saveCity(City city);

    void saveArea(Area area1);
}
