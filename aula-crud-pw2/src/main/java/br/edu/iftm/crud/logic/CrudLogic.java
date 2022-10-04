package br.edu.iftm.crud.logic;

import br.edu.iftm.crud.util.exception.ErroSistemaException;
import br.edu.iftm.crud.util.exception.ErroUsuarioException;
import java.io.Serializable;
import java.util.List;

public interface CrudLogic<E> extends Serializable{
    
    public E salvar(E entidade) throws ErroUsuarioException, ErroSistemaException;
    public void deletar(E entidade);
    public List<E> buscar();
}
