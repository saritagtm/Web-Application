package com.example.webapp;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", urlPatterns = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        String UserName = request.getParameter("UserName");
        String Password = request.getParameter("Password");

        if(UserName.equals("Sarita") && Password.equals("Java")) {
            HttpSession session = request.getSession();
            session.setAttribute("Username",UserName);
            Cookie cookie = new Cookie("UserName", UserName);
            response.addCookie(cookie);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("profile.jsp");
            requestDispatcher.forward(request, response);

        } else {
            writer.println("Incorrect Username or Password");

            RequestDispatcher requestDispatcher = request.getRequestDispatcher("index.jsp");
            requestDispatcher.include(request,response);

        }




    }


    public void destroy() {
    }
}