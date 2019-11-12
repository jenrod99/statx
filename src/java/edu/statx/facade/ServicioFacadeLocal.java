/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.Servicio;
import edu.statx.entidades.Vehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marie
 */
@Local
public interface ServicioFacadeLocal {

    void create(Servicio servicio);

    void edit(Servicio servicio);

    void remove(Servicio servicio);

    Servicio find(Object id);

    List<Servicio> findAll();

    List<Servicio> findRange(int[] range);

    int count();

    public List<Object> cargaServicio(int mes, int anio);

    public List<Object> lstServicioperdia();

    public void actCon(Servicio ser, Vehiculo vehi);
    
}
