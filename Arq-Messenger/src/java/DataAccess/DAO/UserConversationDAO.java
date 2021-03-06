/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;
import DataAccess.Entity.UserConversation;
import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;


/**
 *
 * @author carlos
 */
public class UserConversationDAO implements Serializable{
   
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
    
    
    public List<UserConversation> searchAllConversations() {
           EntityManager em = emf1.createEntityManager();
           List<UserConversation> userConversation = null;
           Query q = em.createNamedQuery("UserConversation.findAll");
           try {
               userConversation = (List<UserConversation>) q.getResultList();
           } catch (Exception e){
           } finally {
               em.close();
               return (List<UserConversation>) userConversation;
           }
    }
           
    public List<UserConversation> searchConversationsByUserID(int id) {
           EntityManager em = emf1.createEntityManager();
           List<UserConversation> userConversation = null;
           Query q = em.createNamedQuery("UserConversation.findByIdUser");
           q.setParameter("idUser", id);
           try {
               userConversation = (List<UserConversation>) q.getResultList();
           } catch (Exception e){
           } finally {
               em.close();
               return (List<UserConversation>) userConversation;
           }
    
    }
    
    public List<UserConversation> searchConversationsByConvID(int ConvId) {
           EntityManager em = emf1.createEntityManager();
           List<UserConversation> userConversation = null;
           Query q = em.createNamedQuery("UserConversation.findByIdConversation");
           q.setParameter("idConversation", ConvId);
           try {
               userConversation = (List<UserConversation>) q.getResultList();
           } catch (Exception e){
           } finally {
               em.close();
               return (List<UserConversation>) userConversation;
           }
    
    }
    
    public UserConversation addPerson(UserConversation userConversation) {
        
        return persist(userConversation);
    }
 }

