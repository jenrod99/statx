/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.Mantenimiento;
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
public class MantenimientoFacade extends AbstractFacade<Mantenimiento> implements MantenimientoFacadeLocal {

    @PersistenceContext(unitName = "statxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MantenimientoFacade() {
        super(Mantenimiento.class);
    }
        public List<Object> lstMant() {
        try {
            List<Object> lstMant = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT concat_ws(' ', primer_nombre, segundo_nombre, primer_apellido), placa, tipo, descripcion, fechaMantenimiento,valor FROM `mantenimiento`  INNER JOIN vehiculo on (vehiculo.placa = mantenimiento.vehiculo_placa) INNER JOIN usuario on (vehiculo.usuario_id_usuario = usuario.id_usuario);");
            lstMant = q1.getResultList();
            return (lstMant);
        } catch (Exception e) {
        return null;
        }
    }
}
