/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Business.Logic;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arqsoft2017i
 */
@WebServlet("/CreateAccountServlet")
public class CreateAccountServlet extends HttpServlet{
    
    private static final long serialVersionUID = 1L;
    
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		// get request parameters for userID and password
		String user = request.getParameter("userR");
		String email = request.getParameter("emailR");
                String pwd = request.getParameter("pwdR");
                String pwd2 = request.getParameter("pwd2R");
                
                HandleUser createUser = new HandleUser();
                String message = createUser.createAccount(user, pwd, pwd2, email);
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/index.jsp");
		PrintWriter out= response.getWriter();
		out.println("<font color=red>" + message + "</font>");
		rd.include(request, response);
		

	}
    
    
}
