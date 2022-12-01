//<editor-fold defaultstate="collapsed" desc=" License Apache 2.0 ">
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//</editor-fold>

package br.edu.iftm.crud.dao;

import br.edu.iftm.crud.util.DatabaseUtil;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;

/**
 *
 * @author danilo
 */
public abstract class GenericDAO<E, ID> implements Serializable {

    private Class<E> classeEntidade;
    
    public GenericDAO(Class<E> classeEntidade) {
	this.classeEntidade = classeEntidade;
    }
    
    
    public E salvar(E entidade) {
	EntityManager em = DatabaseUtil.getFactory().createEntityManager();
	em.getTransaction().begin();
	entidade = em.merge(entidade);
	em.getTransaction().commit();
	em.close();
	return entidade;
    }
    
    public void remover(ID id){
	EntityManager em = DatabaseUtil.getFactory().createEntityManager();
	em.getTransaction().begin();
	Object entidade = em.find(classeEntidade, id);
	em.remove(entidade);
	em.getTransaction().commit();
	em.close();
    }
    
    public List<E> listar() {
	EntityManager em = DatabaseUtil.getFactory().createEntityManager();
	return em.createQuery("from "+classeEntidade.getCanonicalName(), classeEntidade).getResultList();
    }
}
