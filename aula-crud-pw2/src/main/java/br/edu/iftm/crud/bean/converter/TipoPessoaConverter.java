/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.crud.bean.converter;

import br.edu.iftm.crud.entity.TipoPessoa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author danilo
 */
@FacesConverter(forClass = TipoPessoa.class, value = "tipoPessoaConverter")
public class TipoPessoaConverter implements Converter<TipoPessoa>{

    @Override
    public TipoPessoa getAsObject(FacesContext fc, UIComponent uic, String identificador) {
        if(identificador != null){
            TipoPessoa tipoPessoa = (TipoPessoa) uic.getAttributes().get(identificador);
            return tipoPessoa;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, TipoPessoa t) {
        if(t != null){
            String identificador = "tipoPessoa_"+t.getId();
            uic.getAttributes().put(identificador, t);
            return identificador;
        }
        return "";
    }
    
}
