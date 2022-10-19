/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.crud.logic;

import br.edu.iftm.crud.dao.TipoPessoaDAO;
import br.edu.iftm.crud.entity.TipoPessoa;
import br.edu.iftm.crud.util.exception.ErroSistemaException;
import br.edu.iftm.crud.util.exception.ErroUsuarioException;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author danilo
 */
public class TipoPessoaLogic implements CrudLogic<TipoPessoa>{

    @Inject
    private TipoPessoaDAO dao;
    
    @Override
    public TipoPessoa salvar(TipoPessoa entidade) throws ErroUsuarioException, ErroSistemaException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void deletar(TipoPessoa entidade) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<TipoPessoa> buscar() {
        return dao.listar();
    }
    
}
