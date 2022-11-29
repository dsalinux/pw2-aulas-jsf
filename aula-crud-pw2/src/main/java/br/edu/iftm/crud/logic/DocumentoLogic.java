/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.crud.logic;

import br.edu.iftm.crud.dao.DocumentoDAO;
import br.edu.iftm.crud.dao.DocumentoDAO;
import br.edu.iftm.crud.entity.Documento;
import br.edu.iftm.crud.entity.Documento;
import br.edu.iftm.crud.util.exception.ErroSistemaException;
import br.edu.iftm.crud.util.exception.ErroUsuarioException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class DocumentoLogic implements CrudLogic<Documento>{

    @Inject
    private DocumentoDAO dao;
    
    @Override
    public Documento salvar(Documento documento) throws ErroUsuarioException, ErroSistemaException {
        if("".equals(documento.getNome())){
            throw new ErroUsuarioException("O nome é obrigatório.");
        }
       
        documento = dao.salvar(documento);
        return documento;
    }

    @Override
    public void deletar(Documento documento) {
        System.out.println("\n\nDeletou o "+documento.getClass().getName()+"\n\n");
    }

    public Documento buscarPorID(Integer id){
	return dao.buscarPorID(id);
    }
    
    @Override
    public List<Documento> buscar() {
        List<Documento> documentos = new ArrayList<>();
        documentos = dao.listar();
        return documentos;
    }
    
}
