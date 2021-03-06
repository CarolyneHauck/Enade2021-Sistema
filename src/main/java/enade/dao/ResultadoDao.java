/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enade.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import enade.model.Resultado;
import enade.util.PersistenceUtil;

/**
 *
 * @author carolyne.carreira
 */
public class ResultadoDao {

    public static ResultadoDao resultadoDao;

    public static ResultadoDao getInstance() {
        if (resultadoDao == null) {
            resultadoDao = new ResultadoDao();
        }
        return resultadoDao;
    }

    public Resultado buscar(int codigo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select t from Resultado t where t.idResultado =:id ");
        query.setParameter("id", codigo);

        List<Resultado> resultado = query.getResultList();
        if (!resultado.isEmpty()) {
            return resultado.get(0);
        }

        return null;
    }

    public List<Resultado> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Resultado t");
        return query.getResultList();
    }

    public void remover(Resultado resultado) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(resultado)) {
            resultado = em.merge(resultado);
        }
        em.remove(resultado);
        em.getTransaction().commit();
    }

    public Resultado atualizar(Resultado resultado) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            resultado = em.merge(resultado);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
        return resultado;
    }

    public void persistir(Resultado resultado) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(resultado);
        em.getTransaction().commit();
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from Resultado");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
