/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.User;
import java.io.Serializable;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.util.List;
/**
 *
 * @author arqsoft2017i
 */
public class UserDAO implements Serializable{

    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("MessengerUNPU");
    public User persist(User account) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(account);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return account;
    }
    public User searchUser(String email, String password) {
           EntityManager em = emf1.createEntityManager();
           User account = null;
           String peticion = "select u from User u where u.email = " + email + " AND a.password = '"+password+"'";
           Query q = em.createQuery(peticion);
           try {
               account = (User) q.getSingleResult();
           } catch (Exception e){
           } finally {
               em.close();
               return account;
           }
    }
    public User searchUserByEmail(String email) {
           EntityManager em = emf1.createEntityManager();
           User account = null;
           Query q = em.createNamedQuery("User.findByEmail");
           q.setParameter("email", email);
           try {
               account = (User) q.getSingleResult();
           } catch (Exception e){
           } finally {
               em.close();
               return account;
           }
    }
    
    public User searchUserById(int id) {
           EntityManager em = emf1.createEntityManager();
           User account = null;
           Query q = em.createNamedQuery("User.findById");
           q.setParameter("id", id);
           try {
               account = (User) q.getSingleResult();
           } catch (Exception e){
           } finally {
               em.close();
               return account;
           }
    }  
    
    public User searchUserByName(String name) {
           EntityManager em = emf1.createEntityManager();
           User account = null;
           Query q = em.createNamedQuery("User.findByName");
           q.setParameter("name", name);
           try {
               account = (User) q.getSingleResult();
           } catch (Exception e){
           } finally {
               em.close();
               return account;
           }
    }
    
   public List<User> searchAllUsers() {
           EntityManager em = emf1.createEntityManager();
           List<User> accounts = null;
           Query q = em.createNamedQuery("User.findAll");
           try {
               accounts = (List<User>) q.getResultList();
           } catch (Exception e){
           } finally {
               em.close();
               return accounts;
           }
    }
   
   public List<User> searchUsersByNameLikeness(String UserNameLike) {
           EntityManager em = emf1.createEntityManager();
           List<User> accounts = null;
           String peticion = "select u from User u where u.name = '" + UserNameLike + "'";
           Query q = em.createQuery(peticion);
           try {
               accounts = (List<User>) q.getResultList();
           } catch (Exception e){
           } finally {
               em.close();
               return accounts;
           }
    }
}