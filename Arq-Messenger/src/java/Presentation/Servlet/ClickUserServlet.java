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
@WebServlet("/ClickUserS")
public class ClickUserServlet extends HttpServlet implements Serializable{
    
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
        
        Integer currentUserID = Integer.parseInt(request.getParameter("currentU"));
        Integer targetUserID = Integer.parseInt(request.getParameter("targetU"));
        String convName = request.getParameter("convN");
        
        System.out.println(currentUserID);
        System.out.println(targetUserID);
        System.out.println(convName);        
    }
    
}
