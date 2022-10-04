package br.edu.iftm.crud.bean;

import br.edu.iftm.crud.logic.CrudLogic;
import br.edu.iftm.crud.util.JSFUtil;
import br.edu.iftm.crud.util.exception.ErroSistemaException;
import br.edu.iftm.crud.util.exception.ErroUsuarioException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import lombok.Getter;
import lombok.Setter;

public abstract class CrudBean<E, L extends CrudLogic<E> > extends JSFUtil{
    
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
        try {
            getLogic().salvar(entidade);
            novaInstancia();
            addInfoMensagem("Cliente salvo com sucesso.");
        } catch (ErroUsuarioException ex) {
            addAvisoMensagem(ex);
        } catch (ErroSistemaException ex) {
            Logger.getLogger(CrudBean.class.getName()).log(Level.SEVERE, null, ex);
            addErroMensagem(ex);
        }
        
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
