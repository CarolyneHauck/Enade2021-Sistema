/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enade.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import enade.model.Prova;
import enade.util.PersistenceUtil;

/**
 *
 * @author carolyne.carreira
 */
public class ProvaDao {

    public static ProvaDao provaDao;

    public static ProvaDao getInstance() {
        if (provaDao == null) {
            provaDao = new ProvaDao();
        }
        return provaDao;
    }

    public Prova buscar(int codigo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select t from Prova t where t.idProva =:id ");
        query.setParameter("id", codigo);

        List<Prova> prova = query.getResultList();
        if (prova != null && prova.size() > 0) {
            return prova.get(0);
        }

        return null;
    }

    public List<Prova> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Prova t");
        return query.getResultList();
    }

    public void remover(Prova prova) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(prova)) {
            prova = em.merge(prova);
        }
        em.remove(prova);
        em.getTransaction().commit();
    }

    public Prova atualizar(Prova prova) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            prova = em.merge(prova);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return prova;
    }

    public void persistir(Prova prova) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            em.persist(prova);
            em.getTransaction().commit();
        } catch (Exception e) {

        }
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from Prova");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
