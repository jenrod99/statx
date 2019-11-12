/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.SolicitudEmpleo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Marie
 */
@Stateless
public class SolicitudEmpleoFacade extends AbstractFacade<SolicitudEmpleo> implements SolicitudEmpleoFacadeLocal {

    @PersistenceContext(unitName = "statxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public SolicitudEmpleoFacade() {
        super(SolicitudEmpleo.class);
    }
    @Override
    public List<Object> lstSolEmPen() {
        try {
            List<Object> lstServicio = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT `idAfiliacion`,`fecha_solicitud`, concat_ws(' ',primer_nombre, segundo_nombre, primer_apellido), `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `numero_identificacion`, `numero_licencia`,`id_usuario` FROM usuario INNER JOIN `solicitud_empleo` on (usuario.id_usuario = solicitud_empleo.usuario_id_usuario) WHERE estado_solicitud != 'Aceptado' AND estado_solicitud != 'Rechazado';");
            lstServicio = q1.getResultList();
            return (lstServicio);
        } catch (Exception e) {
        return null;
        }
    }
    @Override
    public List<Object> lstSolEm() {
        try {
            List<Object> lstServicio = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT `idAfiliacion`,`fecha_solicitud`, concat_ws(' ',primer_nombre, segundo_nombre, primer_apellido), `primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `numero_identificacion`, `numero_licencia`,estado_solicitud FROM usuario INNER JOIN `solicitud_empleo`on (usuario.id_usuario = solicitud_empleo.usuario_id_usuario) WHERE estado_solicitud = 'Aceptado';");
            lstServicio = q1.getResultList();
            return (lstServicio);
        } catch (Exception e) {
        return null;
        }
    }
    @Override
    public void CambioEstadoSol(int EstSol){
        try {
            Query q1 = em.createNativeQuery("UPDATE `solicitud_empleo` SET `estado_solicitud` = 'Aceptado' WHERE `solicitud_empleo`.`idAfiliacion` = ?;");
            q1.setParameter(1, EstSol);
            q1.executeUpdate();
        } catch (Exception e) {
        }
    }
    @Override
    public void CambioEstadoSolDen(int EstSol){
        try {
            Query q1 = em.createNativeQuery("UPDATE `solicitud_empleo` SET `estado_solicitud` = 'Rechazado' WHERE `solicitud_empleo`.`idAfiliacion` = ?;");
            q1.setParameter(1, EstSol);
            q1.executeUpdate();
            
            PrimeFaces.current().executeScript("confirmarCambioEstado('  ')");
        } catch (Exception e) {
        }
    }
}
