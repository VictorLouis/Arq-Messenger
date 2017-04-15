/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;
import DataAccess.Entity.Message;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


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
           Query q = em.createNamedQuery("Message.findById");
           q.setParameter("id", id);
           try {
               message = (Message) q.getSingleResult();
           } catch (Exception e){
           } finally {
               em.close();
               return message;
           }
    }
           
    public List<Message> searchMessagesByConvID(int id) {
           EntityManager em = emf1.createEntityManager();
           List<Message> messages = null;
           String peticion = "SELECT m FROM Message m WHERE m.idConversation.id = " + id + " ORDER BY m.hora";
           Query q = em.createQuery(peticion);
           
           try {
               messages = (List<Message>) q.getResultList();
           } catch (Exception e){
           } finally {
               em.close();
               return messages;
           }
    }
           
    public List<Message> searchMessagesByTextLikeness(String toSearch){
        EntityManager em = emf1.createEntityManager();
           List<Message> messages = null;
           String peticion = "SELECT m FROM Message m WHERE m.text = " + toSearch;
           Query q = em.createQuery(peticion);
           
           try {
               messages = (List<Message>) q.getResultList();
           } catch (Exception e){
           } finally {
               em.close();
               return messages;
           }
    
    }
}

    

