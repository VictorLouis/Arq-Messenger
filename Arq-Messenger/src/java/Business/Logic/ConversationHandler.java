package Business.Logic ; 
import DataAccess.DAO.ConversationDAO; 
import DataAccess.Entity.Conversation;
import DataAccess.Entity.UserConversation;
import java.sql.Timestamp;
import java.util.Random;
import DataAccess.DAO.UserConversationDAO;

public class ConversationHandler {
     
    public String CreateConversation ( int id2, int id3, String Nombre ) { 
        Conversation conversation = new Conversation ( ) ; 

        UserConversation userConversation = new UserConversation(id2, id3);
        
        userConversation.setNombreConversacion(Nombre);

      
        userConversation.setNombreConversacion(Nombre);

        java.util.Date date= new java.util.Date();
        conversation. setDate (new Timestamp(date.getTime()));
        Random r = new Random();
        conversation. setId( r.nextInt(100));
        UserConversationDAO userConversationDAO = new UserConversationDAO();
        
        ConversationDAO conversationDAO = new ConversationDAO ( ) ; 
        
        Conversation conversationE = conversationDAO. persist (conversation) ;

        UserConversation userConversationE = userConversationDAO. persist (userConversation);
      
        
        if ( conversationE != null ) 
            return "La conversacion ha sido creado con id = " + conversation.getId();
        else
            return "LA conversacion no ha sido creada revisar" ;  
    } 

   
    
    
    
}
   


    

