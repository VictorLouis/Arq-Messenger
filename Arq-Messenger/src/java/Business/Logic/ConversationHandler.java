package Business.Logic ; 
import DataAccess.DAO.ConversationDAO; 
import DataAccess.Entity.Conversation;
import DataAccess.Entity.UserConversation;
import java.sql.Timestamp;
import java.util.Random;
import DataAccess.DAO.UserConversationDAO;
import DataAccess.DAO.UserDAO;
import DataAccess.Entity.User;

public class ConversationHandler {
     
    public String CreateConversation ( int idUser, int idConversation, String Nombre ) { 
        Conversation conversation = new Conversation ( ) ; 

        UserConversation userConversation = new UserConversation(idUser, idConversation);
        userConversation.setNombreConversacion(Nombre);
        
        UserDAO userD = new UserDAO();
        User userM = userD.searchUserById(idUser);
        
        ConversationDAO convD = new ConversationDAO();
        Conversation convM = convD.searchConversationByID(idConversation);

        
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
   


    

