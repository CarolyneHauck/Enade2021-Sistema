/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enade.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import enade.model.TipoUsuario;
import enade.util.PersistenceUtil;

/**
 *
 * @author carolyne.carreira
 */
public class TipoUsuarioDao{

    public static TipoUsuarioDao tipoUsuarioDao;

    public static TipoUsuarioDao getInstance() {
        if (tipoUsuarioDao == null) {
            tipoUsuarioDao = new TipoUsuarioDao();
        }
        return tipoUsuarioDao;
    }

    public TipoUsuario buscar(int codigo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select t from TipoUsuario t where t.idtipoUsuario =:id ");
        query.setParameter("id", codigo);

        List<TipoUsuario> tipoUsuario = query.getResultList();
        if (!tipoUsuario.isEmpty()) {
            return tipoUsuario.get(0);
        }

        return null;
    }

    public List<TipoUsuario> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from TipoUsuario t");
        return query.getResultList();
    }

    public void remover(TipoUsuario tipoUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        if (!em.contains(tipoUsuario)) {
            tipoUsuario = em.merge(tipoUsuario);
        }
        em.remove(tipoUsuario);
        em.getTransaction().commit();
    }

    public TipoUsuario atualizar(TipoUsuario tipoUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            tipoUsuario = em.merge(tipoUsuario);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

        }
        return tipoUsuario;
    }

    public void persistir(TipoUsuario tipoUsuario) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(tipoUsuario);
        em.getTransaction().commit();
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from TipoUsuario");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}
