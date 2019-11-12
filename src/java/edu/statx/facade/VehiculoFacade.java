/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.Documento;
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
public class VehiculoFacade extends AbstractFacade<Vehiculo> implements VehiculoFacadeLocal {

    @PersistenceContext(unitName = "statxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculoFacade() {
        super(Vehiculo.class);
    }

    /**
     *
     * @param vehi
     * @param doc
     * @param Usu
     * @return
     */
    @Override
    public boolean ingresarVehiculoDoc(Vehiculo vehi, Documento doc, Usuario Usu) {
        try {
            
            Query qt = em.createNativeQuery("call statx.crear_vehiculos(?, ?, ?, ?, ?, ?, ?, ?, ?);");
            
            qt.setParameter(1, vehi.getPlaca());
            qt.setParameter(2, vehi.getModelo());
            qt.setParameter(3, vehi.getDueño());
            qt.setParameter(4, vehi.getMarca());
            qt.setParameter(5, Usu.getIdUsuario());
            qt.setParameter(6, doc.getTecnomecanica());
            qt.setParameter(7, doc.getSeguro());
            qt.setParameter(8, doc.getSoat());
            qt.setParameter(9, doc.getTarjeton());
            
            qt.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    } 
    @Override
    public List<Object> listaModelos() {
        try {
            List<Object> lstModelos = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT COUNT(modelo),`modelo` FROM `vehiculo` WHERE `modelo` BETWEEN '2010' AND '2019'GROUP BY `modelo`;");
            lstModelos = q1.getResultList();
            return (lstModelos);
        } catch (Exception e) {
        return null;
        }
    }
    @Override
    public List<Object> lstVehi() {
        try {
            List<Object> lstModelos = new ArrayList();
            Query q1 = em.createNativeQuery("SELECT CONCAT_WS(' ', primer_nombre, segundo_nombre, primer_apellido), placa FROM usuario INNER JOIN vehiculo on (usuario.id_usuario = vehiculo.usuario_id_usuario) WHERE estado_vehi = 'Desocupado';");
            lstModelos = q1.getResultList();
            return (lstModelos);
        } catch (Exception e) {
        return null;
        }
    }
}
