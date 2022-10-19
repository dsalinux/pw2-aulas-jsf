package br.edu.iftm.crud.logic;

import br.edu.iftm.crud.dao.ClienteDAO;
import br.edu.iftm.crud.entity.Cliente;
import br.edu.iftm.crud.util.exception.ErroSistemaException;
import br.edu.iftm.crud.util.exception.ErroUsuarioException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

public class ClienteLogic implements CrudLogic<Cliente>{

    @Inject
    private ClienteDAO dao;
    
    @Override
    public Cliente salvar(Cliente cliente) throws ErroUsuarioException, ErroSistemaException {
        if("".equals(cliente.getNome())){
            throw new ErroUsuarioException("O nome é obrigatório.");
        }
       
        cliente = dao.salvarJPA(cliente);
        return cliente;
    }

    @Override
    public void deletar(Cliente cliente) {
        System.out.println("\n\nDeletou o "+cliente.getClass().getName()+"\n\n");
    }

    @Override
    public List<Cliente> buscar() {
        List<Cliente> clientes = new ArrayList<>();
        clientes = dao.listarJPA();
        return clientes;
    }

    
}
