/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.Notificacion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Windows
 */
@Stateless
public class NotificacionFacade extends AbstractFacade<Notificacion> implements NotificacionFacadeLocal {

    @PersistenceContext(unitName = "statxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public NotificacionFacade() {
        super(Notificacion.class);
    }
    @Override
    public List<Notificacion> listaNotificaciones(int idUsu) {
        try {
            List<Notificacion> lstcon = new ArrayList();
            Query qt = em.createNativeQuery("SELECT COUNT(*), concat_ws (' ', primer_nombre, segundo_nombre, primer_apellido, segundo_apellido),`descripcion` FROM `notificacion` INNER JOIN usuario on (notificacion.usuario_id_usuario = usuario.id_usuario) WHERE `usuario_id_usuario_receptor` = ? GROUP BY `id_notificacion`;");
            qt.setParameter(1, idUsu);
            
            lstcon = qt.getResultList();
            return (lstcon);
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public List<Notificacion> listaNotificacion(int idUsu) {
        try {
            List<Notificacion> lstcon = new ArrayList();
            Query qt = em.createNativeQuery("SELECT COUNT(`id_notificacion`) FROM `notificacion` WHERE `usuario_id_usuario_receptor` = ?;");
            qt.setParameter(1, idUsu);
            
            lstcon = qt.getResultList();
            return (lstcon);
        } catch (Exception e) {
            return null;
        }
    }
}
