package com.example.controller;

import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookmark-group-edit-submit")
public class BookmarkGroupEditSubmitController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String bookmark_no = req.getParameter("bookmark_no");
        String bookmark_name = req.getParameter("bookmark_name");
        System.out.println(bookmark_no);
        System.out.println(bookmark_name);
        service.editBookmark(bookmark_no, bookmark_name);

        resp.sendRedirect("bookmark-group-edit-submit.jsp");
    }
}
