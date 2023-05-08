package com.example;

import com.example.DTO.*;
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

    public void addGroup(String bookmarkName) {
        wifiDAO.addGroup(bookmarkName);
    }

    public List<BookmarkGroupDTO> selectGroups() {
        return wifiDAO.selectGroups();
    }

    public void editGroup(String bookmark_no, String bookmark_name) {
        wifiDAO.editGroup(bookmark_no, bookmark_name);
    }

    public BookmarkGroupDTO selectGroup(String bookmarkNo) {
        return wifiDAO.selectGroup(bookmarkNo);
    }

    public void deleteGroup(String bookmarkNo) {
        wifiDAO.deleteGroup(bookmarkNo);
    }

    public void addBookmark(String wifiName, String bookmark_name) {
        wifiDAO.addBookmark(wifiName, bookmark_name);
    }

    public List<BookmarkDTO> selectBookmarks() {
        return wifiDAO.selectBookmarks();
    }

    public BookmarkDTO selectBookmark(String bookmark_no) {
        return wifiDAO.selectBookmark(bookmark_no);
    }

    public void deleteBookmark(String bookmarkNo) {
        wifiDAO.deleteBookmark(bookmarkNo);
    }

    public void addHistory(String lat, String lnt) {
        wifiDAO.addHistory(lat, lnt);
    }

    public List<HistoryDTO> selectAllHistory() {
        return wifiDAO.selectAllHistory();
    }

    public HistoryDTO selectHistory(String historyId) {
        return wifiDAO.selectHistory(historyId);
    }

    public void deleteHistory(String historyId) {
        wifiDAO.deleteHistory(historyId);
    }
}
