package org.zerock.w2.controller;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "servletContextTestController", value = "/test")
public class ServletContextTestController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext servletContext = req.getServletContext();
        req.getRequestDispatcher("/WEB-INF/todo/test.jsp").forward(req, resp);
    }
}
