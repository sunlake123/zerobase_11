package com.example;

import com.example.DTO.ShowWifiDTO;
import com.example.DTO.WifiDTO;
import com.example.api.Calculator;

import java.io.IOException;
import java.util.*;

public class WifiService {

    WifiDAO wifiDAO = new WifiDAO();
    public int insertWifi() throws IOException {
        System.out.println("insertWifi()");
        return wifiDAO.insert();
    }
    public List<ShowWifiDTO> showWifi(double lat, double lnt) {
        List<ShowWifiDTO> showWifiDTOS = wifiDAO.selectAll();
        for (ShowWifiDTO wifi : showWifiDTOS) {
            wifi.setDistance(Calculator.distance(lat, lnt, wifi.getLat(), wifi.getLnt(), "kilometer"));
        }
        return showWifiDTOS;
    }
}
