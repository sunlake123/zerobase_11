package com.example.controller;

import com.example.DTO.BookmarkGroupDTO;
import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookmark-add-submit")
public class BookmarkAddSubmitController extends HttpServlet {
    WifiService service = new WifiService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String wifi_name = req.getParameter("wifi_name");
        String bookmark_name = req.getParameter("bookmark_name");
        service.addBookmark(wifi_name, bookmark_name);

        resp.sendRedirect("bookmark-add-submit.jsp");
    }
}
