/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;
import DataAccess.Entity.Message;
import DataAccess.Entity.UserConversation;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author carlos
 */
public class UserConversationDAO {
   
    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("MessengerUNPU");
    public UserConversation persist(UserConversation userConversation) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(userConversation);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return userConversation;
    
    }
    
    
    public List<UserConversation> searchConversationByUserID(int id) {
           EntityManager em = emf1.createEntityManager();
           UserConversation userConversation = null;
           String peticion = "UserConversation.findByIdUser";
           Query q = em.createQuery(peticion);
           try {
               userConversation = (UserConversation) q.getResultList();
           } catch (Exception e){
           } finally {
               em.close();
               return (List<UserConversation>) userConversation;
           }
    
}
}
