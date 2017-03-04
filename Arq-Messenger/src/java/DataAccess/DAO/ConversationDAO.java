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
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author arqsoft2017i
 */
public class ConversationDAO {

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
           String peticion = "select m from Conversation m where m.id = " + id + " AND m.User_id = '"+User_Id+"'";
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
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author carlos
 */

    
}


