/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.crud.bean;

import br.edu.iftm.crud.entity.Documento;
import br.edu.iftm.crud.entity.TipoPessoa;
import br.edu.iftm.crud.logic.DocumentoLogic;
import br.edu.iftm.crud.logic.TipoPessoaLogic;
import java.util.List;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import lombok.Getter;
import org.primefaces.event.FileUploadEvent;

/**
 *
 * @author danilo
 */
@Named
@SessionScoped
public class DocumentoBean extends CrudBean<Documento, DocumentoLogic>{

    @Inject
    private DocumentoLogic logic;
    
    @Inject
    private TipoPessoaLogic tipoPessoaLogic;
    
    @Getter
    private Documento docVisualiza;
    
    public DocumentoBean() {
        super(Documento.class);
    }
    
    public void enviarArquivo(FileUploadEvent event){
	String nome = event.getFile().getFileName();
	byte[] documento = event.getFile().getContent();
	getEntidade().setDocumento(documento);
	getEntidade().setNome(nome);
    }
    
    public void visuzaliaDoc(Documento doc){
	docVisualiza = doc;
    }
    
    public void fechaVisualizacao(){
	System.out.println("\n\n\n Fechando visualização \n\n\n");
	docVisualiza = null;
    }
    
    @Override
    public DocumentoLogic getLogic() {
        return logic;
    }
    
    public List<TipoPessoa> getListaTipoPessoa(){
        return tipoPessoaLogic.buscar();
    }
    
}
