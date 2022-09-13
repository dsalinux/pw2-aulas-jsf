package br.edu.iftm.crud.bean;

import br.edu.iftm.crud.entity.Cliente;
import br.edu.iftm.crud.logic.ClienteLogic;
import br.edu.iftm.crud.logic.CrudLogic;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import lombok.Setter;


public abstract class CrudBean<E, L extends CrudLogic<E> > implements Serializable{
    
    public enum EstadoTela {
        BUSCANDO,
        INSERINDO,
        EDITANDO
    }
    
    @Getter
    private EstadoTela estadoTela = EstadoTela.BUSCANDO;

    @Getter @Setter
    private E entidade;
    private Class<E> classeEntidade;
    @Getter
    private List<E> entidades;
    
    
    public CrudBean(Class<E> classeEntidade) {
        this.classeEntidade = classeEntidade;
    }
    
    public void novaInstancia(){
        try {
            entidade = classeEntidade.getDeclaredConstructor().newInstance();
        } catch (NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public void novo(){
        novaInstancia();
        estadoTela = EstadoTela.INSERINDO;
    }
    public void salvar(){
        getLogic().salvar(entidade);
        novaInstancia();
    }
    public void editar(E endidade){
        this.entidade = endidade;
        estadoTela = EstadoTela.EDITANDO;
    }
    
    public void buscar() {
        if(!estadoTela.equals(EstadoTela.BUSCANDO)) {
            estadoTela = EstadoTela.BUSCANDO;
            return;
        }
        this.entidades = getLogic().buscar();
    }

    public abstract L getLogic();
    
}
