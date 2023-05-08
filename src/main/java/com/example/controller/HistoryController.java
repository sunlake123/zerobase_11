package com.example.controller;

import com.example.DTO.HistoryDTO;
import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/history")
public class HistoryController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<HistoryDTO> historyDTOS = service.selectAllHistory();
        req.setAttribute("historyDTOS", historyDTOS);
        System.out.println(historyDTOS.size());
        req.setAttribute("size", historyDTOS.size());
        req.getRequestDispatcher("history.jsp").forward(req,resp);
    }
}
