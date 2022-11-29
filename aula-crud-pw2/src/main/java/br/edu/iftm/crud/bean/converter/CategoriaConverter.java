/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.crud.bean.converter;

import br.edu.iftm.crud.entity.Categoria;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author danilo
 */
@FacesConverter(forClass = Categoria.class, value = "categoriaConverter")
public class CategoriaConverter implements Converter<Categoria>{

    @Override
    public Categoria getAsObject(FacesContext fc, UIComponent uic, String identificador) {
        if(identificador != null){
            Categoria categoria = (Categoria) uic.getAttributes().get(identificador);
            return categoria;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Categoria t) {
        if(t != null){
            String identificador = "categoria_"+t.getId();
            uic.getAttributes().put(identificador, t);
            return identificador;
        }
        return "";
    }
    
}
