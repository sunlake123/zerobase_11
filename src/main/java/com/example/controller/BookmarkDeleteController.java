package com.example.controller;

import com.example.DTO.BookmarkDTO;
import com.example.WifiService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/bookmark-delete")
public class BookmarkDeleteController extends HttpServlet {
    WifiService service = new WifiService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String bookmark_no = req.getParameter("bookmark_no");
        BookmarkDTO bookmarkDTO = service.selectBookmark(bookmark_no);;
        req.setAttribute("bookmarkDTO", bookmarkDTO);
        req.getRequestDispatcher("bookmark-delete.jsp").forward(req, resp);
    }
}
