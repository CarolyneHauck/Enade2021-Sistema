/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package enade.dao;

import enade.model.Questao;
import enade.util.PersistenceUtil;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author carolyne.carreira
 */
public class QuestaoDao {

    public static QuestaoDao questaoDao;

    public static QuestaoDao getInstance() {
        if (questaoDao == null) {
            questaoDao = new QuestaoDao();
        }
        return questaoDao;
    }

    public Questao buscar(int codigo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("select t from Questao t where t.idQuestao =:id ");
        query.setParameter("id", codigo);

        List<Questao> questao = query.getResultList();
        if (!questao.isEmpty()) {
            return questao.get(0);
        }

        return null;
    }

    public List<Questao> buscarTodas() {
        EntityManager em = PersistenceUtil.getEntityManager();
        Query query = em.createQuery("from Questao t");
        return query.getResultList();
    }

    public void remover(Questao questao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        em.remove(questao);
        em.getTransaction().commit();
    }

    public Questao atualizar(Questao questao) {
        System.out.println(questao);
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        try {
            questao = em.merge(questao);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();

        }
        return questao;
    }

    public void persistir(Questao questao) {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(questao);
        em.getTransaction().commit();
    }

    public void removeAll() {
        EntityManager em = PersistenceUtil.getEntityManager();
        em.getTransaction().begin();
        Query query = em.createQuery("delete from Questao");
        query.executeUpdate();
        em.getTransaction().commit();
    }

}