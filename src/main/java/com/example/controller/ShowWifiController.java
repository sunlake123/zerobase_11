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
        System.out.println("옴?");
        double lat = Double.parseDouble(req.getParameter("lat"));
        System.out.println("lat = " + lat);
        double lnt = Double.parseDouble(req.getParameter("lnt"));
        System.out.println("lnt = " + lnt);
        List<ShowWifiDTO> showWifiDTOS = service.showWifi(lat, lnt);
        req.setAttribute("wifi", showWifiDTOS);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }
}
