/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.crud.dao;

import br.edu.iftm.crud.entity.Cliente;
import br.edu.iftm.crud.entity.TipoPessoa;
import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author danilo
 */
public class TipoPessoaDAO implements Serializable{
    
    public List<TipoPessoa> listar(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "bancoTestePU" );
        EntityManager em = factory.createEntityManager();
        List<TipoPessoa> tiposPessoa = em.createQuery("select tipo from TipoPessoa tipo").getResultList();
        return tiposPessoa;
    }
    
}
