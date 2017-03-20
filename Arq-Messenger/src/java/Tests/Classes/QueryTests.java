/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Tests.Classes;
import DataAccess.Entity.Message;
import DataAccess.DAO.MessageDAO;
import java.util.List;


/**
 *
 * @author arqsoft2017i
 */
public class QueryTests {
    
    
    
    public static void main(String [] args)
	{
		System.out.println("Ini :3");
                MessageDAO mdao = new MessageDAO();
                List<Message> tm = mdao.searchMessagesByConvID(1);
                System.out.println(tm);
                
	}
    

           
    
}
