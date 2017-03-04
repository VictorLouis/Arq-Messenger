package Business.Logic ; 
import DataAccess.DAO.ConversationDAO; 
import DataAccess.Entity.Conversation;
import java.sql.Timestamp;




/**
 *
 * @author arqsoft2017i
 */ 
public class ConversationHandler {
     
    public String CreateConversation ( ) { 
        Conversation conversation = new Conversation ( ) ; 

        java.util.Date date= new java.util.Date();
        conversation. setDate (new Timestamp(date.getTime()));
        ConversationDAO conversationDAO = new ConversationDAO ( ) ;      
        Conversation conversationE = conversationDAO. persist (conversation) ;
      
      
        
        if ( conversationE != null ) 
            return "La conversacion ha sido creado con id = " + conversation.getId();
        else
            return "LA conversacion no ha sido creada revisar" ;  
    } 

   
    
    
    
}
   


    

