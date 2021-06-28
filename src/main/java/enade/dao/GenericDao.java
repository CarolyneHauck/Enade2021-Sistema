/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package enade.dao;

import enade.util.PersistenceUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

/**
 *
 * @author carolyne.carreira
 */
public abstract class GenericDao<T, I> {
	
	private EntityManager manager = PersistenceUtil.getEntityManager();
	
	private Class<T> persistedClass;
	
	protected GenericDao(){
	}
	
	protected GenericDao(Class<T> persistedClass){
		this();
		this.persistedClass = persistedClass;
	}
	
	public boolean salvar(T entity) {
		try {
		   EntityTransaction t = getManager().getTransaction();
		   t.begin();
		   getManager().persist(entity);
		   getManager().flush();
		   t.commit();
		   return true;
		} catch (Exception e) {
			return false;
		}
		   
	   }

	   public T atualizar(T entity) {
                EntityTransaction t = getManager().getTransaction();
               try{
		   t.begin();
		   getManager().merge(entity);
		   getManager().flush();
	       t.commit();
	       return entity;
	   }catch (Exception e) {
               t.rollback();
               return entity;
           }
           }

	   public void remover(I id) {
	       T entity = buscarPorId(id);
	       EntityTransaction t = getManager().getTransaction();
		   t.begin();
	       T mergedEntity = getManager().merge(entity);
	       getManager().remove(mergedEntity);
	       getManager().flush();
	       t.commit();
	   }

	   public List<T> buscarTodos() {
	       CriteriaBuilder builder = getManager().getCriteriaBuilder();
	       CriteriaQuery<T> query = builder.createQuery(persistedClass);
	       query.from(persistedClass);
	       return getManager().createQuery(query).getResultList();
	   }

	   public T buscarPorId(I id) {
	       return getManager().find(persistedClass, id);
	   }

    /**
     * @return the manager
     */
    public EntityManager getManager() {
        return manager;
    }
}