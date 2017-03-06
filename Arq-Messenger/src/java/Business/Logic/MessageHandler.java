package Business.Logic ; 
import DataAccess.DAO.MessageDAO; 
import DataAccess.Entity.Message;
import java.sql.Timestamp;




/**
 *
 * @author arqsoft2017i
 */ 
public class MessageHandler { 
     
    public String createMessage ( String text) { 
        Message message = new Message ( ) ; 
        message. setText ( text ) ; 
        java.util.Date date= new java.util.Date();
        message. setDate (new Timestamp(date.getTime()));
        MessageDAO messageDAO = new MessageDAO ( ) ;      
        Message messageE = messageDAO. persist (message) ;
      
      
        
        if ( messageE != null ) 
            return "EL mensaje ha sido creado con id = " + message.getId();
        else
            return "EL mensjae no ha sido creado revisar" ;  
    } 

   
    
    
    
}
   
