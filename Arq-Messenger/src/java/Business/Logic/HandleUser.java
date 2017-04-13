package Business.Logic ; 
import DataAccess.DAO.UserDAO; 
import DataAccess.DAO.AuthenticationDAO;
import DataAccess.Entity.User ; 
import DataAccess.Entity.Authentication ; 
import java.util.List;
/**
 *
 * @author arqsoft2017i
 */ 
public class HandleUser { 
     
    public String createAccount ( String name, String passwordUser, String passwordUser2, String email ) { 
        User user = new User ( ) ; 
        Authentication authentication = new Authentication();
        user. setName ( name ) ; 
        if (authentication.isValidEmailAddress(email)){
        user. setEmail ( email ) ; 
        }
        else{ 
            return "email invalido";
        }
        if ((passwordUser.length())>=8){
        authentication. setPassword (passwordUser);
        }
        else{
            return "Error la contraseña debe ser de mas de 8 caracteres. ";
        }
        if (passwordUser.equals(passwordUser2)){
        authentication. setPassword (passwordUser);
        }
        else{
            return "Error las contraseña deben ser iguales. ";
        }
        System.out.println(name + passwordUser + passwordUser2 + email);
        
        UserDAO userDAO = new UserDAO ( ) ; 
        AuthenticationDAO authenticationDAO = new AuthenticationDAO ( ) ; 
        
        User userE = userDAO. persist (user) ;
        Authentication authenticationE = authenticationDAO. persist (authentication) ; 
        
        if ( userE != null && authenticationE !=null ) 
            return "la cuenta ha sido creada su Id de Usuario es " + user.getName();
        else
            return "la cuenta no pudo ser creada." ;  
    } 

   
    public List<User> AllUsers(){
        
        UserDAO userDAO = new UserDAO ( ) ; 
            
        return userDAO.searchAllUsers();
    }
    
    public User searchByEmail(String email){
        
        UserDAO userDAO = new UserDAO ( ) ; 
            
        return userDAO.searchUserByEmail(email);
    }
    
    public User searchById(int id){
        
        UserDAO userDAO = new UserDAO ( ) ; 
            
        return userDAO.searchUserById(id);
    }
    
    public User searchByName(String name){
        
        UserDAO userDAO = new UserDAO ( ) ; 
            
        return userDAO.searchUserByName(name);
    }
}
   
