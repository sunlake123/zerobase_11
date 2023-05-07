package com.example;

import com.example.DTO.BookmarkDTO;
import com.example.DTO.Row;
import com.example.DTO.ShowWifiDTO;
import com.example.api.Calculator;

import java.awt.print.Book;
import java.io.IOException;
import java.util.*;

public class WifiService {

    WifiDAO wifiDAO = new WifiDAO();
    public int insertWifi() throws IOException {
        System.out.println("insertWifi()");
        wifiDAO.createTable();
        return wifiDAO.insert();
    }
    public List<ShowWifiDTO> showWifi(double lat, double lnt) {
        List<ShowWifiDTO> tmp = wifiDAO.selectAll();
        for (ShowWifiDTO wifi : tmp) {
            wifi.setDistance(Math.round(Calculator.distance(lat, lnt, wifi.getLat(), wifi.getLnt(), "kilometer") * 1000 ) / 1000.0);
        }
        Collections.sort(tmp, Comparator.comparingDouble(ShowWifiDTO::getDistance));
        List<ShowWifiDTO> showWifiDTOS = new ArrayList<ShowWifiDTO>();
        for (int i = 0; i < 20; i++) {
            showWifiDTOS.add(tmp.get(i));
        }
        return showWifiDTOS;
    }
    public Row selectOne(String xSwifiMgrNo) {
        return wifiDAO.selectOne(xSwifiMgrNo);
    }

    public void addBookmark(String bookmarkName) {
        wifiDAO.addBookmark(bookmarkName);
    }

    public List<BookmarkDTO> selectGroups() {
        return wifiDAO.selectGroups();
    }

    public void editBookmark(String bookmark_no, String bookmark_name) {
        wifiDAO.editBookmark(bookmark_no, bookmark_name);
    }

    public BookmarkDTO selectGroup(String bookmarkNo) {
        return wifiDAO.selectGroup(bookmarkNo);
    }

    public void deleteBookmark(String bookmarkNo) {
        wifiDAO.deleteGroup(bookmarkNo);
    }
}
