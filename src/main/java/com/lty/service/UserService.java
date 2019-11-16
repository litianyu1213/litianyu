package com.lty.service;

import com.lty.model.Area;
import com.lty.model.City;
import com.lty.model.Province;

public interface UserService {


    void saveProvince(Province province);

    void saveCity(City city);

    void saveArea(Area area1);
}
