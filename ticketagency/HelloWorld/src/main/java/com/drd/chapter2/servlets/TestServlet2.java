package com.drd.chapter2.servlets;

import com.drd.chapter2.ejbs.MySingle;
import com.drd.chapter2.ejbs.MyStateful;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author dr-d - 2017-08-11.
 */
@WebServlet("/test2")
public class TestServlet2 extends HttpServlet {
    private static final long servialVersionUID = 1L;

    @EJB
    private
    MySingle mySingle;

/*    private MyStateful myStateful;*/

    private static final String CONTENT_TYPE = "text/html;charset=UTF-8";
   /* private static final String MESSAGE = "<!DOCTYPE	html><html>" +
            "<head><title>Hello!</title></head>" +
            "<body>Hello World WildFly" +
            "<br>" +
            "</body>" +
            "</html>";*/

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        InitialContext ctx;
        MyStateful myStateful = null;
        try {
            ctx = new InitialContext();
            myStateful = (MyStateful) ctx.lookup("java:global/hello-world-1.0-SNAPSHOT/MyStatefulEJB");
        } catch (NamingException e) {
            e.printStackTrace();
        }

        assert myStateful != null;
        final String message = "<!DOCTYPE	html><html>" +
                "<head><title>Hello!</title></head>" +
                "<body>Hello World WildFly" +
                "<br>singleton" + mySingle.getCounter() +
                "<br>stateful" + myStateful.getCount() +
                "</body>" +
                "</html>";

        resp.setContentType(CONTENT_TYPE);
        resp.getWriter().println(message);
        mySingle.setCounter(mySingle.getCounter() + 1);
        myStateful.incrementCount();
    }
}
