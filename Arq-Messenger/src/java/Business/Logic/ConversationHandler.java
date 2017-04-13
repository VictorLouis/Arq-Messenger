package Business.Logic ; 
import DataAccess.DAO.ConversationDAO; 
import DataAccess.Entity.Conversation;
import DataAccess.Entity.UserConversation;
import java.sql.Timestamp;
import java.util.Random;
import DataAccess.DAO.UserConversationDAO;
import DataAccess.DAO.UserDAO;
import DataAccess.Entity.User;
import java.util.List;

public class ConversationHandler {
     
    public String CreateConversation (int idUserCurrent, int idUserTarget, int idConversation, String Nombre ) { 
        Conversation conversation = new Conversation ( ) ; 

        UserConversation userConversation1 = new UserConversation(idUserCurrent, idConversation);
        UserConversation userConversation2 = new UserConversation(idUserTarget, idConversation);
        userConversation1.setNombreConversacion(Nombre);
        
        UserDAO userD = new UserDAO();
        User userC = userD.searchUserById(idUserCurrent);
        User userT = userD.searchUserById(idUserTarget);
        
        ConversationDAO convD = new ConversationDAO();
        Conversation convM = convD.searchConversationByID(idConversation);

        
        java.util.Date date= new java.util.Date();
        conversation. setDate (new Timestamp(date.getTime()));
        Random r = new Random();
        conversation. setId( r.nextInt(100));
        UserConversationDAO userConversationDAO = new UserConversationDAO();
        
        ConversationDAO conversationDAO = new ConversationDAO ( ) ; 
        
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
   


    

