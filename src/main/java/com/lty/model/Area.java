package com.lty.model;

public class Area {

    private  Integer id;

    private  String  areaName;

    private Integer cityId;

    public Integer getId() {
        return id;
    }

    public String getAreaName() {
        return areaName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }
}
