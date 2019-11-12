/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.Cuota;
import edu.statx.entidades.Usuario;
import edu.statx.entidades.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marie
 */
@Stateless
public class CuotaFacade extends AbstractFacade<Cuota> implements CuotaFacadeLocal {

    @PersistenceContext(unitName = "statxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CuotaFacade() {
        super(Cuota.class);
    }
   @Override
    public List<Object> cargaCuota(int mes, int anio) {
        try {
            List<Object> lstCuota = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT SUM(cuotaEntregada), `primer_nombre` FROM `cuota` INNER JOIN usuario ON (cuota.usuario_id_usuario = usuario.id_usuario) WHERE MONTH(fechaCuota) = ? AND YEAR(fechaCuota) = ? GROUP BY `primer_nombre`;");
            q1.setParameter(1, mes);
            q1.setParameter(2, anio);
            lstCuota = q1.getResultList();
            return (lstCuota);
        } catch (Exception e) {
        return null;
        }
    }
    @Override
    public List<Object> cargaCuotaperanio(int anio) {
        try {
            List<Object> lstCuota = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT SUM(cuotaEntregada), `primer_nombre` FROM `cuota` INNER JOIN usuario ON (cuota.usuario_id_tesorero = usuario.id_usuario) WHERE YEAR(fechaCuota) = ? GROUP BY `primer_nombre`;");
            q1.setParameter(1, anio);
            lstCuota = q1.getResultList();
            return (lstCuota);
        } catch (Exception e) {
        return null;
        }
    }
    @Override
    public List<Object> cargaCuotaF(int mes, int anio) {
        try {
            List<Object> lstCuota = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT SUM(cuotaEntregada), ABS(SUM(cuotaEntregada) - SUM(`cantidad`) ) AS Faltante,`primer_nombre` FROM `cuota` INNER JOIN usuario ON (cuota.usuario_id_usuario = usuario.id_usuario) WHERE MONTH(fechaCuota) = ? AND YEAR(fechaCuota) = ? GROUP BY `primer_nombre`;");
            q1.setParameter(1, mes);
            q1.setParameter(2, anio);
            lstCuota = q1.getResultList();
            return (lstCuota);
        } catch (Exception e) {
        return null;
        }
    }
    @Override
    public List<Object> lstCuotaF() {
        try {
            List<Object> lstCuota = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT concat_ws(' ', primer_nombre, segundo_nombre, primer_apellido),cantidad, ABS(SUM(cuotaEntregada) - SUM(`cantidad`) ) AS 'Faltante' FROM `cuota` INNER JOIN usuario on (cuota.usuario_id_usuario = usuario.id_usuario) GROUP BY primer_nombre HAVING ABS(SUM(cuotaEntregada) - SUM(`cantidad`) ) > 0;");
            lstCuota = q1.getResultList();
            return (lstCuota);
        } catch (Exception e) {
        return null;
        }
    }
    
    @Override
    public List<Object> lstCuotaTes() {
        try {
            List<Object> lstCuota = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT concat_ws(' ', primer_nombre, segundo_nombre, primer_apellido),cantidad, ABS(SUM(cuotaEntregada) - SUM(`cantidad`) ) AS 'Faltante', `cuotaEntregada`,placa FROM `cuota` INNER JOIN usuario on (cuota.usuario_id_usuario = usuario.id_usuario) INNER JOIN vehiculo on (vehiculo.usuario_id_usuario = usuario.id_usuario) GROUP BY primer_nombre;");
            lstCuota = q1.getResultList();
            return (lstCuota);
        } catch (Exception e) {
        return null;
        }
    }
    @Override
    public void actCon(Cuota cuo, Usuario usu, Usuario Usuario) {
        try {
            Query q1 = em.createNativeQuery("INSERT INTO `cuota` (`cantidad`, `fechaCuota`, `cuotaEntregada`, `usuario_id_usuario`, `usuario_id_tesorero`) VALUES (100000, CURRENT_DATE, ?, ?, ?);");
            q1.setParameter(1, cuo.getCuotaEntregada());
            q1.setParameter(2, usu.getIdUsuario());
            q1.setParameter(3, Usuario.getIdUsuario());
            
            q1.executeUpdate();
        } catch (Exception e) {
            
        }
    }
}
