/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation.Servlet;
import java.io.IOException;
import java.io.Serializable;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author arqsoft2017i
 * Servlet activates when a conversation is clicked/
 */
@WebServlet("/ConversationS")
public class ClickConversationServlet extends HttpServlet implements Serializable{
    
    private static final long serialVersionUID = 1L;
    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
        
        System.out.println(request.getQueryString());
        System.out.println(request.getParameter("cid"));
        Integer convID = Integer.parseInt(request.getParameter("cid")); 
        request.setAttribute("cid", convID);
        request.getRequestDispatcher("conversation.jsp").forward(request, response);
    }
    
    
}
