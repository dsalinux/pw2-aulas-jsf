package br.edu.iftm.crud.bean;

import br.edu.iftm.crud.entity.Categoria;
import br.edu.iftm.crud.logic.CategoriaLogic;
import br.edu.iftm.crud.util.JSFUtil;
import br.edu.iftm.crud.util.exception.ErroSistemaException;
import br.edu.iftm.crud.util.exception.ErroUsuarioException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;

@Named
@SessionScoped
public class CategoriaBean extends JSFUtil{
    
    @Getter
    private String estadoTela = "busca";//busca, inseri e edita
    @Getter
    private Categoria categoria;
    @Getter
    private List<Categoria> categorias = new ArrayList<>();
    
    @Inject
    private CategoriaLogic logic;
    
    public void novo(){
        categoria = new Categoria();
        estadoTela = "inseri";
    }
    
    public void salvar(){
        try {
            Categoria categoriaSalva = logic.salvar(categoria);
            categorias.add(categoriaSalva);
            addInfoMensagem("Salvo com sucesso.");
            estadoTela = "busca";
        } catch (ErroSistemaException ex) {
            Logger.getLogger(CategoriaBean.class.getName()).log(Level.SEVERE, null, ex);
            addErroMensagem(ex);
        } catch (ErroUsuarioException ex) {
            Logger.getLogger(CategoriaBean.class.getName()).log(Level.SEVERE, null, ex);
            addAvisoMensagem(ex);
        }
    }
    
    public void remover(Categoria categoria) {
        logic.remover(categoria);
        categorias.remove(categoria);
        addInfoMensagem("Removido com sucesso.");
    }
    
    public void editar(Categoria categoria) {
        this.categoria = categoria;
        estadoTela = "edita";
    }
    
    public void buscar() {
        categorias = logic.listar();
        estadoTela = "busca";
    }
    
    public List<Categoria> getCategoriasSuperiores() {
        return logic.listar();
    }
}
