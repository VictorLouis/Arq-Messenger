/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccess.DAO;

import DataAccess.Entity.Event;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

/**
 *
 * @author arqsoft2017i
 */
public class EventDAO {

    public EntityManagerFactory emf1 = Persistence.createEntityManagerFactory("MessengerUNPU");
    public Event persist(Event event) {
        EntityManager em = emf1.createEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(event);
            em.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
        return event;
    }
    public Event searchEvent(String nombre, String descripcion) {
           EntityManager em = emf1.createEntityManager();
           Event event = null;
           String peticion = "select e from Event e where e.nombre = " + nombre + " AND e.descripcion = '"+descripcion+"'";
           Query q = em.createQuery(peticion);
           try {
               event = (Event) q.getSingleResult();
           } catch (Exception e){
           } finally {
               em.close();
               return event;
           }
}
}
