package Business.Logic ; 
import DataAccess.DAO.ConversationDAO; 
import DataAccess.Entity.Conversation;
import DataAccess.Entity.UserConversation;
import java.sql.Timestamp;
import DataAccess.DAO.UserConversationDAO;
import DataAccess.DAO.UserDAO;
import DataAccess.Entity.User;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ConversationHandler {
     
    public String CreateConversation (int idUserCurrent, int idUserTarget, int idConversation, String Nombre ) { 
        
        UserConversation userConversation1 = new UserConversation(idUserCurrent, idConversation);
        UserConversation userConversation2 = new UserConversation(idUserTarget, idConversation);
        userConversation1.setNombreConversacion(Nombre);
        userConversation2.setNombreConversacion(Nombre);
        
        UserConversationDAO userConversationDAO = new UserConversationDAO();
        ConversationDAO conversationDAO = new ConversationDAO ( ) ;
        
        Conversation conversation = new Conversation ( ) ; 
        java.util.Date date= new java.util.Date();
        
        
        Integer convId = ThreadLocalRandom.current().nextInt(7,900);
        while(conversationDAO.searchConversationByID(convId)!=null){
            convId = ThreadLocalRandom.current().nextInt(7,900);
        }
        
        conversation.setId(convId);
        conversation. setDate (new Timestamp(date.getTime()));
        
        Conversation conversationE = conversationDAO. persist (conversation) ;
        UserConversation userConversation1E = userConversationDAO. persist (userConversation1);
        UserConversation userConversation2E = userConversationDAO. persist (userConversation2);
        
        if ( conversationE != null && userConversation1E  != null && userConversation2E != null) 
            return "La conversacion ha sido creado con id = " + conversation.getId();
        else
            return "LA conversacion no ha sido creada revisar" ;  
    } 

   public String addPersonConversation(int idCurrentConv, int idNewUser){
   
       UserConversation userConversation1 = new UserConversation(idNewUser, idCurrentConv);
 
       UserConversationDAO userConversationDAO = new UserConversationDAO();
       UserDAO userD = new UserDAO();
       
       userConversation1.setNombreConversacion(userConversationDAO.searchOneUserConversationByConvID(idCurrentConv).getNombreConversacion());
       
       User userN = userD.searchUserById(idNewUser);
       
       UserConversation result = userConversationDAO.addPerson(userConversation1);
       
       if (result != null) 
           return userN.getName() + "ha sido agregado a la conversacion";
       else
           return userN.getName() + "NO ha sido aregado"; 
   }
   
   public List<UserConversation> searchAllConvsByUserID(int userID){
       
       UserConversationDAO temp = new UserConversationDAO();
       
       return temp.searchConversationsByUserID(userID); 
   }
       
    
}
   


    

