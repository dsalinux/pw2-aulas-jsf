package br.edu.iftm.crud.dao;

import br.edu.iftm.crud.entity.Cliente;
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

public class ClienteDAO implements Serializable {
    
    public Cliente salvarJPA(Cliente cliente) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "bancoTestePU" );
        EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        cliente = em.merge(cliente);
        em.getTransaction().commit();
        em.close();
        return cliente;
    }
    
    public void salvar(Cliente cliente) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao =
                    DriverManager.getConnection("jdbc:mysql://localhost/aula_db_pw2", "root", "root");
            String sql;
            PreparedStatement ps;
            if(cliente.getId() != null) {
                sql = "update cliente set nome = ?, endereco = ? where id = ?";
                ps = conexao.prepareStatement(sql);
                ps.setInt(3, cliente.getId());
            } else {
                sql = "insert into cliente (nome, endereco) values (?,?)";
                ps = conexao.prepareStatement(sql);
            }
            conexao.setAutoCommit(false);
            
            ps.setString(1, cliente.getNome());
            ps.setString(2, cliente.getEndereco());
            ps.execute();
            conexao.rollback();
            conexao.close();
            
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Cliente> listar(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexao =
                    DriverManager.getConnection("jdbc:mysql://localhost/aula_db_pw2", "root", "root");
            String sql = "select * from cliente";
            PreparedStatement ps = conexao.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            List<Cliente> clientes = new ArrayList<>();
            while(rs.next()){
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEndereco(rs.getString("endereco"));
                clientes.add(cliente);
            }
            return clientes;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public List<Cliente> listarJPA(){
        EntityManagerFactory factory = Persistence.createEntityManagerFactory( "bancoTestePU" );
        EntityManager em = factory.createEntityManager();
        List<Cliente> clientes = em.createQuery("select cli from Cliente cli").getResultList();
        return clientes;
    }
}
