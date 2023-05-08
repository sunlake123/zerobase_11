package com.example.controller;

import com.example.DTO.BookmarkGroupDTO;
import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/detail")
public class DetailController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String mgrNo = req.getParameter("mgrNo");
        req.setAttribute("detail", service.selectOne(mgrNo));
        List<BookmarkGroupDTO> bookmarkGroupDTOS = service.selectGroups();
        req.setAttribute("bookmarkDTOS", bookmarkGroupDTOS);
        req.getRequestDispatcher("/detail.jsp").forward(req, resp);
    }
}
