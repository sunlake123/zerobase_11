package com.example.controller;

import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookmark-delete-submit")
public class BookmarkDeleteSubmitController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookmark_no = req.getParameter("bookmark_no");
        service.deleteBookmark(bookmark_no);
        resp.sendRedirect("bookmark-delete-submit.jsp");
    }
}
