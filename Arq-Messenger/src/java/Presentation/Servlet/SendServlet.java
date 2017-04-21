/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Servlet;

import Business.Logic.MessageHandler;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet("/SendServlet")
public class SendServlet extends HttpServlet implements Serializable{
    
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
		Integer userID = Integer.parseInt(request.getParameter("idUser"));
                Integer convID = Integer.parseInt(request.getParameter("idConv"));
                String textmsg = request.getParameter("msg");
                
                MessageHandler msgH = new MessageHandler();
                String res = msgH.createMessage(textmsg, convID, userID);
                
                RequestDispatcher rd = getServletContext().getRequestDispatcher("/conversation.jsp");
		PrintWriter out= response.getWriter();
		out.println("<font color=red>" + res + "</font>");
		rd.include(request, response);
		

	}
    
}
