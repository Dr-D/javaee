package com.drd.servlets;

import com.drd.myejbs.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Author: darren 2017-07-15
 */
public class MyServlet extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(MyServlet.class);

    @EJB
    private Test testEJB;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.debug("Servlet GET");

        testEJB.add();
        int count = testEJB.getCount();
        log.debug("CountEJB: '{}'", count);

        PrintWriter writer = resp.getWriter();
        writer.printf("Count: '%d'\n", count);
        writer.printf("Session: '%s'\n", req.getSession().getId());
    }
}
