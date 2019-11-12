/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.controlador;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author HP-
 */
@Named(value = "idiomaSession")
@SessionScoped
public class IdiomaSession implements Serializable {

    /**
     * Creates a new instance of IdiomaSession
     */
    public IdiomaSession() {
    }
    
     private String idioma = "espaniol";

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }
   
    
    public void cambiarIdioma (String idm) {
        System.out.println(idm);
        
        if (!idm.equals("Español")) {
            this.idioma = "ingles";
            
        } else {
            this.idioma ="espaniol";
        }
    }
    
}
