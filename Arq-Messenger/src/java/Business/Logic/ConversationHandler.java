package Business.Logic ; 
import DataAccess.DAO.ConversationDAO; 
import DataAccess.Entity.Conversation;
import DataAccess.Entity.UserConversation;
import java.sql.Timestamp;
import DataAccess.DAO.UserConversationDAO;
import DataAccess.DAO.UserDAO;
import DataAccess.Entity.User;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.EntityManager;

public class ConversationHandler implements Serializable{
     
    public String CreateConversation (int idUserCurrent, int idUserTarget, String Nombre ) { 
        
        UserConversationDAO userConversationDAO = new UserConversationDAO();
        ConversationDAO conversationDAO = new ConversationDAO ( ) ;
        UserDAO userD = new UserDAO();
        
        Conversation conversation = new Conversation ( ) ; 
        java.util.Date date= new java.util.Date();
        
        EntityManager useR = userD.emf1.createEntityManager();
        EntityManager emC = conversationDAO.emf1.createEntityManager();
        
        Integer convId = ThreadLocalRandom.current().nextInt(7,900);
        while(conversationDAO.searchConversationByID(convId)!=null){
            convId = ThreadLocalRandom.current().nextInt(7,900);
        }
        
        conversation.setId(convId);
        conversation. setDate (new Timestamp(date.getTime()));
        Conversation conversationE = conversationDAO. persist (conversation) ;
        
        UserConversation userConversation1 = new UserConversation(idUserCurrent, convId);
        UserConversation userConversation2 = new UserConversation(idUserTarget, convId);
        
        userConversation1.setNombreConversacion(Nombre);
        userConversation1.setConversation(emC.find(Conversation.class, convId));
        userConversation1.setUser(useR.find(User.class, idUserCurrent));
        userConversation2.setNombreConversacion(Nombre);
        userConversation2.setConversation(emC.find(Conversation.class, convId));
        userConversation2.setUser(useR.find(User.class, idUserTarget));
        
        
        UserConversation userConversation1E = userConversationDAO. persist (userConversation1);
        UserConversation userConversation2E = userConversationDAO. persist (userConversation2);
        
        if ( conversationE != null && userConversation1E  != null && userConversation2E != null) 
            return "La conversacion ha sido creado con id = " + conversation.getId();
        else
            return "La conversacion NO ha sido creada" ;  
    } 

   public String addPersonConversation(int idCurrentConv, int idNewUser){
       
       UserConversationDAO ucDAO = new UserConversationDAO();
       ConversationDAO conversationDAO = new ConversationDAO ( ) ;
       UserDAO userD = new UserDAO();
       
       EntityManager useR = userD.emf1.createEntityManager();
       EntityManager emC = conversationDAO.emf1.createEntityManager();
   
       UserConversation userConversation1 = new UserConversation(idNewUser, idCurrentConv);
       
       User userN = useR.find(User.class, idNewUser);
       Conversation currentConv = emC.find(Conversation.class, idCurrentConv);
       
       userConversation1.setNombreConversacion(ucDAO.searchConversationsByConvID(idCurrentConv).get(1).getNombreConversacion());
       userConversation1.setConversation(currentConv);
       userConversation1.setUser(userN);
       
       UserConversation result = ucDAO.addPerson(userConversation1);
       
       if (result != null) 
           return userN.getName() + "ha sido agregado a la conversacion";
       else
           return userN.getName() + "NO ha sido aregado"; 
   }
   
   public List<UserConversation> searchAllConvsByUserID(int userID){
       
       UserConversationDAO temp = new UserConversationDAO();
       
       return temp.searchConversationsByUserID(userID); 
   }
   
   public String searchConvNameByID(int convID){
       
       UserConversationDAO ucDAO = new UserConversationDAO();
       
       return ucDAO.searchConversationsByConvID(convID).get(1).getNombreConversacion();
   }
       
   
}
   


    

