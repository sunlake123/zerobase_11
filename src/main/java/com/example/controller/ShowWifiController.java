package com.example.controller;

import com.example.DTO.ShowWifiDTO;
import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class ShowWifiController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String lat = req.getParameter("lat");
        String lnt = req.getParameter("lnt");
        if (lat != null && lat != "" && lnt != null && lnt != "") {
            service.addHistory(lat, lnt);
        }
        double latDouble = Double.parseDouble(req.getParameter("lat"));
        double lntDouble = Double.parseDouble(req.getParameter("lnt"));
        List<ShowWifiDTO> showWifiDTOS = service.showWifi(latDouble, lntDouble);
        req.setAttribute("wifi", showWifiDTOS);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
