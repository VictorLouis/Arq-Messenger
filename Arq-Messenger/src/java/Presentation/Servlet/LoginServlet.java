/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Servlet;

import java.io.IOException;
import java.io.PrintWriter;

import Business.Logic.UserHandler;
import DataAccess.Entity.Authentication;
import DataAccess.Entity.User; 
import DataAccess.DAO.AuthenticationDAO;
import java.io.Serializable;

import javax.servlet.RequestDispatcher;
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
/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet implements Serializable{
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

		// get request parameters for userID and password
		String loginMail = request.getParameter("loginEmail");
		String passw = request.getParameter("loginPwd");
                
                AuthenticationDAO accountDAO = new AuthenticationDAO ( ); 
                Authentication accountE = accountDAO.searchUserLogin(loginMail, passw);
                
                UserHandler uh = new UserHandler();
                User loginUser = uh.searchByEmail(loginMail);
                
		if(accountE != null){
                        HttpSession session = request.getSession(); 
                        
                        session.setAttribute("userId", loginUser.getId()); 
                        session.setAttribute("userName", loginUser.getName());  
                        session.setAttribute("userEmail", loginMail);  
                        
                        response.sendRedirect("messenger.jsp");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}

	}
}
