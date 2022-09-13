package br.edu.iftm.crud.bean;

import br.edu.iftm.crud.entity.Cliente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;


@Named
@SessionScoped
public class ClienteBean implements Serializable{
    
    public enum EstadoTela {
        BUSCANDO,
        INSERINDO,
        EDITANDO
    }
    
    @Getter
    private EstadoTela estadoTela = EstadoTela.BUSCANDO;

    @Getter @Setter
    private Cliente cliente = new Cliente();
    @Getter
    private List<Cliente> clientes = new ArrayList<>();
    
    public void novo(){
        cliente = new Cliente();
        estadoTela = EstadoTela.INSERINDO;
    }
    public void salvar(){
        clientes.add(cliente);
        cliente = new Cliente();
    }
    public void editar(Cliente cli){
        cliente = cli;
        estadoTela = EstadoTela.EDITANDO;
    }
    
    public void buscar() {
        if(!estadoTela.equals(EstadoTela.BUSCANDO)) {
            estadoTela = EstadoTela.BUSCANDO;
            return;
        }
        //Buscar no banco de dados
    }

}
