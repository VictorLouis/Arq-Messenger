/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;
import DataAccess.Entity.Conversation;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author arqsoft2017i
 */
public class ConversationDAO implements Serializable{

    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("MessengerUNPU");
    public Conversation persist(Conversation conversation) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(conversation);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return conversation;
    }
    public Conversation searchConversation(int id, int User_Id) {
           EntityManager em = emf1.createEntityManager();
           Conversation conversation = null;
           String peticion = "select c from Conversation c where c.id = " + id + " AND c.User_id = '"+User_Id+"'";
           Query q = em.createQuery(peticion);
           try {
               conversation = (Conversation) q.getSingleResult();
           } catch (Exception e){
           } finally {
               em.close();
               return conversation;
           }
    }
    /*
    
    public List<Conversation> searchConversationsByConverID(int ConversationId) {
           EntityManager em = emf1.createEntityManager();
           Conversation conversation = null;
           String peticion = "Conversation.findById";
           Query q = em.createQuery(peticion);
           try {
               conversation = (Conversation) q.getResultList();
           } catch (Exception e){
           } finally {
               em.close();
               return (List<Conversation>) conversation;
           }
    }
    */
           
    public Conversation searchConversationByID(int Id) {
           EntityManager em = emf1.createEntityManager();
           Conversation conversation = null;
           Query q = em.createNamedQuery("Conversation.findById");
           q.setParameter("id", Id);
           try {
               conversation = (Conversation) q.getSingleResult();
           } catch (Exception e){
           } finally {
               em.close();
               return (Conversation) conversation;
           }
    
    }
    
    
           
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carlos
 */

 



