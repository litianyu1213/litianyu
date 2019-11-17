package com.lty.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.lty.model.Area;
import com.lty.model.City;
import com.lty.model.Province;


import com.lty.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.Iterator;


@Controller
public class UserController {



    @Autowired
    private UserService userService;

    //测试666666
    //5555555
    //ffff
    //ggg
    //dddddd
    //hhhhhhh
    //sdf
    //rwerwe
    //2345
    //erc
    @RequestMapping("queryTest")
    @ResponseBody
    public  String queryTest(String[] args){
        String json = "null";
        try {
            json = readJsonData("D:\\bbb.txt");
         readTxt(json);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        System.out.println(json);
        return  "完了";
    }

    public static String readJsonData(String pactFile) throws IOException {
        // 读取文件数据
        //System.out.println("读取文件数据util");

        StringBuffer strbuffer = new StringBuffer();
        File myFile = new File(pactFile);//"D:"+File.separatorChar+"DStores.json"
        if (!myFile.exists()) {
            System.err.println("Can't Find " + pactFile);
        }
        try {
            FileInputStream fis = new FileInputStream(pactFile);
            InputStreamReader inputStreamReader = new InputStreamReader(fis, "UTF-8");
            BufferedReader in  = new BufferedReader(inputStreamReader);

            String str;
            while ((str = in.readLine()) != null) {
                strbuffer.append(str);  //new String(str,"UTF-8")
            }
            in.close();
        } catch (IOException e) {
            e.getStackTrace();
        }
        //System.out.println("读取文件结束util");
        return strbuffer.toString();
    }


    private  void readTxt(String s){
        //先转成array数组
        JSONArray provencesList = JSON.parseArray(s);
        Iterator<Object> province = provencesList.iterator();
        while (province.hasNext()){
            //获取每个省
            JSONObject p = (JSONObject)province.next();
            String provinceName = p.getString("name");
            Province p2 = new Province();
            p2.setProvenceName(provinceName);
            //先把省 新增进去
            userService.saveProvince(p2);
            Integer id = p2.getId();
            //获取市级 集合
            JSONArray cityList = p.getJSONArray("cityList");
            //循环 市
            Iterator<Object> iterator = cityList.iterator();
            while (iterator.hasNext()){
                JSONObject next = (JSONObject)iterator.next();
                //获取市的名字
                String cityName = next.getString("name");
                City city = new City();
                city.setCityName(cityName);
                city.setProvenceId(id);
                //新增市
                userService.saveCity(city);
                Integer cid = city.getId();
                //获取区集合
                JSONArray areaList = next.getJSONArray("areaList");
                //循环 区
                Iterator<Object> area = areaList.iterator();
                while (area.hasNext()){
                    JSONObject next2 = (JSONObject)area.next();
                    String areaName = next2.getString("name");
                    Area area1 = new Area();
                    area1.setAreaName(areaName);
                    area1.setCityId(cid);
                    //新增区
                    userService.saveArea(area1);
                }

            }
        }


    }

}
