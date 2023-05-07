package com.example.controller;

import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookmark-group-add-submit")
public class BookmarkGroupAddSubmitController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String bookmarkName = req.getParameter("bookmark_name");
        service.addBookmark(bookmarkName);

        resp.sendRedirect("bookmark-group-add-submit.jsp");
    }
}
