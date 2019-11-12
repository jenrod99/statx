/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.Cuota;
import edu.statx.entidades.Usuario;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marie
 */
@Local
public interface CuotaFacadeLocal {

    void create(Cuota cuota);

    void edit(Cuota cuota);

    void remove(Cuota cuota);

    Cuota find(Object id);

    List<Cuota> findAll();

    List<Cuota> findRange(int[] range);

    int count();

 
    public List<Object> cargaCuotaF(int mes, int anio);

    public List<Object> cargaCuotaperanio(int anio);

    public List<Object> cargaCuota(int mes, int anio);

    public List<Object> lstCuotaF();

    public List<Object> lstCuotaTes();

    public void actCon(Cuota cuo, Usuario usu, Usuario Usuario);
    
}
