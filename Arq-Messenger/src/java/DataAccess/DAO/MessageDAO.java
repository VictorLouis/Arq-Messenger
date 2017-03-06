/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;
import DataAccess.Entity.Message;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import static javax.persistence.TemporalType.DATE;

/**
 *
 * @author arqsoft2017i
 */
public class MessageDAO {

    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("MessengerUNPU");
    public Message persist(Message message) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(message);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return message;
    }
    public Message searchMessage(int id) {
           EntityManager em = emf1.createEntityManager();
           Message message = null;
           String peticion = "Message.findById";
           Query q = em.createQuery(peticion);
           try {
               message = (Message) q.getSingleResult();
           } catch (Exception e){
           } finally {
               em.close();
               return message;
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
