/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.edu.iftm.crud.bean;

import br.edu.iftm.crud.entity.Cliente;
import br.edu.iftm.crud.logic.ClienteLogic;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author danilo
 */
@Named
@SessionScoped
public class ClienteBean extends CrudBean<Cliente, ClienteLogic>{

    @Inject
    private ClienteLogic logic;
    
    public ClienteBean() {
        super(Cliente.class);
    }
    
    @Override
    public ClienteLogic getLogic() {
        return logic;
    }
    
}
