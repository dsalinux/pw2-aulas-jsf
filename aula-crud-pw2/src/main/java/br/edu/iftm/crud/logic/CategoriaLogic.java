/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.crud.logic;

import br.edu.iftm.crud.dao.CategoriaDAO;
import br.edu.iftm.crud.entity.Categoria;
import br.edu.iftm.crud.util.exception.ErroSistemaException;
import br.edu.iftm.crud.util.exception.ErroUsuarioException;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;

public class CategoriaLogic implements Serializable{

    @Inject
    private CategoriaDAO dao;
    
    public Categoria salvar(Categoria categoria) throws ErroSistemaException, ErroUsuarioException{
        if("".equals(categoria.getNome())){
            throw new ErroUsuarioException("Nome é obrigatório.");
        }
        return dao.salvar(categoria);
    }
    
    public void remover(Categoria categoria) {
        dao.remover(categoria);
    }
    
    public List<Categoria> listar() {
        return dao.listar();
    }
    
}
