package com.drd.interceptor.web;

import com.drd.interceptor.service.PersonService;
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
 * Created by dr-d on 22/09/15
 */
public class InterceptorServlet extends HttpServlet {

    private final static Logger log = LoggerFactory.getLogger(InterceptorServlet.class);

    @EJB
    PersonService personService;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter();
        String person = personService.getById(1L).toString();

        writer.write("<html><body><h1>Testing interceptor</h1></br><h1>" +
               person + "</h1></html>");
    }
}
