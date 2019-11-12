/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.Rol;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Marie
 */
@Stateless
public class RolFacade extends AbstractFacade<Rol> implements RolFacadeLocal {

    @PersistenceContext(unitName = "statxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RolFacade() {
        super(Rol.class);
    }
    
}
