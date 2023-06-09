package com.example.controller;

import com.example.DTO.BookmarkDTO;
import com.example.DTO.BookmarkGroupDTO;
import com.example.WifiService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookmarkGroup")
public class BookmarkGroupController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookmarkGroupDTO> bookmarkGroupDTOS = service.selectGroups();
        req.setAttribute("bookmarkGroup", bookmarkGroupDTOS);
        req.getRequestDispatcher("bookmark-group.jsp").forward(req, resp);
    }
}
