package com.lty.model;

public class City {

    private  Integer id;

    private   String cityName;


    private  Integer provenceId;

    public Integer getId() {
        return id;
    }

    public String getCityName() {
        return cityName;
    }

    public Integer getProvenceId() {
        return provenceId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public void setProvenceId(Integer provenceId) {
        this.provenceId = provenceId;
    }
}
