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
public class LoginServlet extends HttpServlet{
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
		String user = request.getParameter("user");
		String pwd = request.getParameter("pwd");
                
                AuthenticationDAO accountDAO = new AuthenticationDAO ( ); 
                Authentication accountE = accountDAO.searchUserLogin(user, pwd );
                
                UserHandler uh = new UserHandler();
                User loginUser = uh.searchByEmail(user);
                
		if(accountE != null){
			/*Cookie loginCookie = new Cookie("user",user);
			//setting cookie to expiry in 30 mins
			loginCookie.setMaxAge(30*60);
			response.addCookie(loginCookie);
			response.sendRedirect("messenger.jsp");
                        */
                        
                        HttpSession session=request.getSession();  
                        session.setAttribute("name", user);  
                        session.setAttribute("sessionId", loginUser.getId()); 
                        response.sendRedirect("messenger.jsp");
		}else{
			RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
			PrintWriter out= response.getWriter();
			out.println("<font color=red>Either user name or password is wrong.</font>");
			rd.include(request, response);
		}

	}
}
