package com.example;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/")
public class ShowWifiController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("옴?");
        double lat = Double.parseDouble(req.getParameter("lat"));
        System.out.println("lat = " + lat);
        double lnt = Double.parseDouble(req.getParameter("lnt"));
        System.out.println("lnt = " + lnt);
        
        req.setAttribute("wifi", service.showWifi(lat, lnt));
        req.getRequestDispatcher("/").forward(req, resp);
    }
}
