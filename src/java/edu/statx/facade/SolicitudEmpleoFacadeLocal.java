/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.SolicitudEmpleo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marie
 */
@Local
public interface SolicitudEmpleoFacadeLocal {

    void create(SolicitudEmpleo solicitudEmpleo);

    void edit(SolicitudEmpleo solicitudEmpleo);

    void remove(SolicitudEmpleo solicitudEmpleo);

    SolicitudEmpleo find(Object id);

    List<SolicitudEmpleo> findAll();

    List<SolicitudEmpleo> findRange(int[] range);

    int count();

    public List<Object> lstSolEm();

    public List<Object> lstSolEmPen();

    public void CambioEstadoSol(int EstSol);
    
    public void CambioEstadoSolDen(int EstSol);
}
