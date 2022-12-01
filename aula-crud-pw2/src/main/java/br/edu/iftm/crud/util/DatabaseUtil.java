//<editor-fold defaultstate="collapsed" desc=" License Apache 2.0 ">
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
//</editor-fold>

package br.edu.iftm.crud.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author danilo
 */
public class DatabaseUtil {

    private static EntityManagerFactory factory = Persistence.createEntityManagerFactory( "bancoTestePU" );

    public static EntityManagerFactory getFactory() {
	return factory;
    }
    
}
