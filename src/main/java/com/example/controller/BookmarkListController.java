package com.example.controller;

import com.example.DTO.BookmarkDTO;
import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/bookmark-list")
public class BookmarkListController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<BookmarkDTO> bookmarkDTOS = service.selectBookmarks();
        req.setAttribute("bookmarkDTOS", bookmarkDTOS);
        req.getRequestDispatcher("bookmark-list.jsp").forward(req, resp);
    }
}
