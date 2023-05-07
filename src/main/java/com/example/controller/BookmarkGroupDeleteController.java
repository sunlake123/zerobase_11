package com.example.controller;

import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookmark-group-delete")
public class BookmarkGroupDeleteController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookmark_no = req.getParameter("bookmark_no");
        String bookmark_name = service.selectGroup(bookmark_no).getBookmark_name();
        req.setAttribute("bookmark_name", bookmark_name);
        req.setAttribute("bookmark_no", bookmark_no);
        req.getRequestDispatcher("/bookmark-group-delete.jsp").forward(req, resp);
    }
}
