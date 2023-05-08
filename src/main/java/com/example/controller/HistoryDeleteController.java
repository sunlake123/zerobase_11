package com.example.controller;

import com.example.DTO.BookmarkDTO;
import com.example.DTO.HistoryDTO;
import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/history-delete")
public class HistoryDeleteController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String history_id = req.getParameter("history_id");
        HistoryDTO historyDTO = service.selectHistory(history_id);
        req.setAttribute("historyDTO", historyDTO);
        req.getRequestDispatcher("history-delete.jsp").forward(req, resp);
    }
}
