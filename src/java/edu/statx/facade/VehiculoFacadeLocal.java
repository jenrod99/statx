/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.Documento;
import edu.statx.entidades.Usuario;
import edu.statx.entidades.Vehiculo;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marie
 */
@Local
public interface VehiculoFacadeLocal {

    void create(Vehiculo vehiculo);

    void edit(Vehiculo vehiculo);

    void remove(Vehiculo vehiculo);

    Vehiculo find(Object id);

    List<Vehiculo> findAll();

    List<Vehiculo> findRange(int[] range);

    int count();
    
    public List<Object> listaModelos();
    
    public boolean ingresarVehiculoDoc(Vehiculo vehi, Documento doc, Usuario Usu);

    public List<Object> lstVehi();
    
}
