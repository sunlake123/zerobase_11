package com.example;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/load-wifi")
public class LoadWifiController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("doGet");
        req.setAttribute("totalCount", service.insertWifi());
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/load-wifi.jsp");
        requestDispatcher.forward(req, resp);
    }
}
