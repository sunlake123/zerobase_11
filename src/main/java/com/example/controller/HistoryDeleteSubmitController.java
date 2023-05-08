package com.example.controller;

import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/history-delete-submit")
public class HistoryDeleteSubmitController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String history_id = req.getParameter("history_id");
        service.deleteHistory(history_id);
        resp.sendRedirect("history-delete-submit.jsp");
    }
}
