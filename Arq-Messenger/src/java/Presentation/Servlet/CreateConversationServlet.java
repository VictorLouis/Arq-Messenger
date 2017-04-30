/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Servlet;

import Business.Logic.ConversationHandler;
import java.io.IOException;
import java.io.Serializable;

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
@WebServlet("/CreateConversationServlet")
public class CreateConversationServlet extends HttpServlet implements Serializable{
    
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
		Integer currentUserID = Integer.parseInt(request.getParameter("idUserC"));
                Integer targetUserID = Integer.parseInt(request.getParameter("idUserT"));
                String convName = request.getParameter("nameC");
                
                ConversationHandler handC = new ConversationHandler();
                String res = handC.CreateConversation(currentUserID, targetUserID, convName);
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/messenger.jsp");
		rd.include(request, response);

	}
    
}
