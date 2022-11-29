package br.edu.iftm.crud.dao;

import br.edu.iftm.crud.entity.Categoria;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CategoriaDAO implements Serializable {
    
    public Categoria salvar(Categoria categoria) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "bancoTestePU" );
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        categoria = em.merge(categoria);
        em.getTransaction().commit();
        em.close();
        return categoria;
    }
    
    public void remover(Categoria categoria) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "bancoTestePU" );
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        categoria = em.find(Categoria.class, categoria.getId());
        em.remove(categoria);
        em.getTransaction().commit();
        em.close();
    }
    
    public List<Categoria> listar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "bancoTestePU" );
        EntityManager em = factory.createEntityManager();
        List<Categoria> categorias = em.createQuery("select categoria from Categoria categoria").getResultList();
        return categorias;
    }
}
