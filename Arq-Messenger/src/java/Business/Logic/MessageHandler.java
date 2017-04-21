package Business.Logic ; 
import DataAccess.DAO.MessageDAO; 
import DataAccess.DAO.UserDAO;
import DataAccess.DAO.ConversationDAO; 
import DataAccess.Entity.Message;
import DataAccess.Entity.User;
import DataAccess.Entity.Conversation;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import javax.persistence.EntityManager;


/**
 *
 * @author arqsoft2017i
 */ 
public class MessageHandler implements Serializable{ 
               
    public String createMessage (String text, int IdConversation, int IdUser) { 
           
        Message message = new Message ( ) ;
        
        UserDAO userD = new UserDAO();
        EntityManager em1 = userD.emf1.createEntityManager();
        User userM = em1.find(User.class, IdUser);
        
        ConversationDAO convD = new ConversationDAO();
        EntityManager em2 = convD.emf1.createEntityManager();
        Conversation convM = em2.find(Conversation.class, IdConversation);
        
        MessageDAO messageDAO = new MessageDAO ( ) ;  
        java.util.Date date= new java.util.Date();
        
        Integer msgId = ThreadLocalRandom.current().nextInt(7,900);
        while(messageDAO.searchMessage(msgId)!=null){
            msgId = ThreadLocalRandom.current().nextInt(7,900);
        }
        
        message.setId(msgId);
        message.setDate (new Timestamp(date.getTime()));
        message.setHora(new Timestamp(date.getTime()));
        message.setText ( text ) ; 
        message.setIdConversation(convM);
        message.setUserId(userM);
        
        System.out.println(text);
        System.out.println(convM);
        System.out.println(userM);
        
        Message messageE = messageDAO. persist (message) ;
             
        if ( messageE != null ) 
            return "EL mensaje ha sido creado con id = " + message.getId();
        else
            return "EL mensaje NO ha sido creado revisar" ;  
    } 

    public List<Message> searchMsgsByConvID(int convID){
        
        MessageDAO msgDAO = new MessageDAO();
        
        return msgDAO.searchMessagesByConvID(convID);
   
    }
   
    
    
    
}
   
