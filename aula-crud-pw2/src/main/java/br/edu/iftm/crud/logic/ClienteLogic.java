package br.edu.iftm.crud.logic;

import br.edu.iftm.crud.entity.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteLogic implements CrudLogic<Cliente>{

    @Override
    public Cliente salvar(Cliente cliente) {
        System.out.println("\n\nSalvou o "+cliente.getClass().getName()+"\n\n");
        return null;
    }

    @Override
    public void deletar(Cliente cliente) {
        System.out.println("\n\nDeletou o "+cliente.getClass().getName()+"\n\n");
    }

    @Override
    public List<Cliente> buscar() {
        List<Cliente> clientes = new ArrayList<>();
        Cliente c = new Cliente();
        c.setNome("Danilo");
        c.setEmail("daniloalmeida@iftm.edu.br");
        clientes.add(c);
        return clientes;
    }

    
}
