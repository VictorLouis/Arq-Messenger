package Business.Logic ; 
import DataAccess.DAO.MessageDAO; 
import DataAccess.DAO.UserDAO;
import DataAccess.DAO.ConversationDAO; 
import DataAccess.Entity.Message;
import DataAccess.Entity.User;
import DataAccess.Entity.Conversation;
import java.util.concurrent.ThreadLocalRandom;
import java.util.List;


/**
 *
 * @author arqsoft2017i
 */ 
public class MessageHandler { 
     
    public String createMessage (String text, int IdConversation, int IdUser) {
        
        Message message = new Message ( ) ;
        
        UserDAO userD = new UserDAO();
        User userM = userD.searchUserById(IdUser);
        
        ConversationDAO convD = new ConversationDAO();
        Conversation convM = convD.searchConversationByID(IdConversation);
        
        //java.util.Date date= new java.util.Date();
        //message. setDate (new Timestamp(date.getTime()));
        
        message.setText ( text ) ; 
        message.setIdConversation(convM);
        message.setUserId(userM);
        //message.setId(ThreadLocalRandom.current().nextInt(7,900));
        
        System.out.println(text);
        System.out.println(convM);
        System.out.println(userM);
        
        
        MessageDAO messageDAO = new MessageDAO ( ) ;      
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
   
