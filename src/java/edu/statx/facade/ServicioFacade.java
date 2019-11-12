/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.Documento;
import edu.statx.entidades.Servicio;
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
public class ServicioFacade extends AbstractFacade<Servicio> implements ServicioFacadeLocal {

    @PersistenceContext(unitName = "statxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicioFacade() {
        super(Servicio.class);
    }
    
    @Override
    public List<Object> cargaServicio(int mes, int anio) {
        try {
            List<Object> lstServicio = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT COUNT(vehiculo_placa), `primer_nombre` FROM servicio INNER JOIN vehiculo ON (servicio.vehiculo_placa = vehiculo.placa) INNER JOIN usuario on (vehiculo.usuario_id_usuario = usuario.id_usuario) WHERE MONTH(fecha_servicio) = ? AND YEAR(fecha_servicio) = ? GROUP BY `primer_nombre`");
            q1.setParameter(1, mes);
            q1.setParameter(2, anio);
            lstServicio = q1.getResultList();
            return (lstServicio);
        } catch (Exception e) {
        return null;
        }
    }
    
    @Override
    public List<Object> lstServicioperdia() {
        try {
            List<Object> lstServicio = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT `id_servicio`,`origen`,`destino`, CONCAT(usuario.primer_nombre, ' ', usuario.segundo_nombre, usuario.primer_apellido) FROM `servicio` INNER JOIN vehiculo ON (vehiculo.placa = servicio.vehiculo_placa) INNER JOIN usuario ON (usuario.id_usuario = vehiculo.usuario_id_usuario) WHERE `fecha_servicio` = CURRENT_DATE;");
            lstServicio = q1.getResultList();
            return (lstServicio);
        } catch (Exception e) {
        return null;
        }
    }
    @Override
    public void actCon(Servicio ser, Vehiculo vehi) {
        try {
            Query q1 = em.createNativeQuery("INSERT INTO `servicio` (`destino`, `origen`, `valor`, `observaciones`, `estado_ser`, `vehiculo_placa`, `fecha_servicio`) VALUES (?, ?, ?, ?,'Pendiente', ?,CURRENT_DATE);");
            q1.setParameter(1, ser.getDestino());
            q1.setParameter(2, ser.getOrigen());
            q1.setParameter(3, ser.getValor());
            q1.setParameter(4, ser.getObservaciones());
            q1.setParameter(5, vehi.getPlaca());
            
            q1.executeUpdate();
        } catch (Exception e) {
            // Esto es una prueba
        }
    }
    
}
