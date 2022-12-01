package br.edu.iftm.crud.dao;

import br.edu.iftm.crud.entity.Categoria;
import java.io.Serializable;

public class CategoriaDAO extends GenericDAO<Categoria, Integer>{
    
    public CategoriaDAO() {
	super(Categoria.class);
    }
    
    
}
