/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author arqsoft2017i
 */
@WebServlet("/LogoutServlet")
public class LogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
        
     /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override    
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
        response.setContentType("text/html");
   
              
        // request.getRequestDispatcher("link.html").include(request, response);  
              
        HttpSession session =request.getSession();  
        session.invalidate();  
        
        /*
        PrintWriter out=response.getWriter();  
        out.print("You are successfully logged out!");        
        out.close(); 
        */
    	response.sendRedirect("index.jsp");
    }

}

