
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.facade;

import edu.statx.entidades.Documento;
import edu.statx.entidades.Rol;
import edu.statx.entidades.Usuario;
import edu.statx.entidades.Vehiculo;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Paula Gomez
 */
@Stateless
public class UsuarioFacade extends AbstractFacade<Usuario> implements UsuarioFacadeLocal {

    @PersistenceContext(unitName = "statxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UsuarioFacade() {
        super(Usuario.class);
    }

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;

    @Override
    public Usuario validarUsuario(String correoIn, String claveIn) {
        try {
            Query ql = em.createNativeQuery("SELECT * FROM `usuario` WHERE correo = ? AND contrasenia = ? ", Usuario.class);
            ql.setParameter(1, correoIn);
            ql.setParameter(2, claveIn);

            List<Usuario> listaUsu = ql.getResultList();
            if (listaUsu.isEmpty()) {
                return null;
            } else {
                return listaUsu.get(0);
            }

        } catch (Exception e) {
            return null;
        }

    }
    @Override
    public boolean ingresarUsuarioAfiliacionDueño(Usuario usuario) {
        try {

            Query qt = em.createNativeQuery("INSERT INTO `usuario` (`primer_nombre`, `segundo_nombre`, `primer_apellido`, `segundo_apellido`, `numero_identificacion`, `telefono`, `numero_celular`, `correo`, `direccion`, `numero_licencia`, `contrasenia`, `tipo_usu`, `tipo_afiliacion`,`estado`) VALUES (?, ?, ?, ?, ? , ?, ?, ?, ?, ?, ?, ?, ?, ?);");
            qt.setParameter(1, usuario.getPrimerNombre());
            qt.setParameter(2, usuario.getSegundoNombre());
            qt.setParameter(3, usuario.getPrimerApellido());
            qt.setParameter(4, usuario.getSegundoApellido());
            qt.setParameter(5, usuario.getNumeroIdentificacion());
            qt.setParameter(6, usuario.getTelefono());
            qt.setParameter(7, usuario.getNumeroCelular());
            qt.setParameter(8, usuario.getCorreo());
            qt.setParameter(9, usuario.getDireccion());
            qt.setParameter(10, usuario.getNumeroLicencia());
            qt.setParameter(11, usuario.getContrasenia());
            qt.setParameter(12, usuario.getTipoUsu());
            qt.setParameter(13, usuario.getTipoAfiliacion());
            qt.setParameter(14, "Inactivo");

            qt.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    }

    @Override
    public Usuario buscarPorCorreo(String correo) {
        try {
            Query q1 = em.createNativeQuery("SELECT * FROM `usuario` WHERE correo = ?", Usuario.class);
            q1.setParameter(1, correo);

            List<Usuario> listaUsu = q1.getResultList();
            if (listaUsu.isEmpty()) {
                return null;
            } else {
                return listaUsu.get(0);
            }

        } catch (Exception e) {

            return null;

        }
    }

    @Override
    public List<Object> listaConductores() {
        try {
            List<Object> lstcon = new ArrayList();
            Query qt = em.createNativeQuery("SELECT CONCAT (primer_nombre,' ', segundo_nombre,' '), `telefono`,`numero_identificacion`,`estado`, concat_ws(' ',primer_nombre, segundo_nombre),concat_ws(' ', primer_apellido, segundo_apellido), numero_licencia , placa, soat, tecnomecanica, tarjeton, fecha_documento, `id_usuario`, id_documento FROM `usuario` INNER JOIN vehiculo ON (usuario.id_usuario = vehiculo.usuario_id_usuario) INNER JOIN documento on (vehiculo.documento_id_documento = documento.id_documento) INNER JOIN `rol_has_usuario` ON (usuario.id_usuario = rol_has_usuario.usuario_id_usuario) INNER JOIN `rol` ON (rol_has_usuario.rol_idrol = rol.idrol) WHERE `idrol` = 5 GROUP BY `id_usuario`;");
            lstcon = qt.getResultList();
            return (lstcon);
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public List<Object> listaTesoreros() {
        try {
            List<Object> lstcon = new ArrayList();
            Query qt = em.createNativeQuery("SELECT CONCAT (primer_nombre,' ', segundo_nombre,' '),concat_ws(' ', primer_apellido, segundo_apellido), `id_usuario`FROM `usuario` INNER JOIN vehiculo ON (usuario.id_usuario = vehiculo.usuario_id_usuario) INNER JOIN documento on (vehiculo.documento_id_documento = documento.id_documento) INNER JOIN `rol_has_usuario` ON (usuario.id_usuario = rol_has_usuario.usuario_id_usuario) INNER JOIN `rol` ON (rol_has_usuario.rol_idrol = rol.idrol) WHERE `idrol` = 3 GROUP BY `id_usuario`;");
            lstcon = qt.getResultList();
            return (lstcon);
        } catch (Exception e) {
            return null;
        }
    }
    @Override
    public List<Object> lstActPen() {
        try {
            List<Object> lstcon = new ArrayList();
            Query qt = em.createNativeQuery("SELECT `id_usuario`,concat_ws(' ',`primer_nombre`,`segundo_nombre`,`primer_apellido`,`segundo_apellido`),`estado_solicitud`,`contrasenia`, usuario.tipo_afiliacion, `tipoIdentificacion`,`numero_identificacion`,`numero_licencia`, usuario.direccion,`telefono`,`placa` FROM usuario INNER JOIN solicitud_empleo on (solicitud_empleo.usuario_id_usuario = usuario.id_usuario) INNER JOIN vehiculo on (usuario.id_usuario = vehiculo.usuario_id_usuario) where usuario.estado = 'Inactivo' AND solicitud_empleo.estado_solicitud = 'Aceptado';");
            lstcon = qt.getResultList();
            return (lstcon);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<Object> lstAsigVehi() {
        try {
            List<Object> lstcon = new ArrayList();
            Query qt = em.createNativeQuery("SELECT `id_usuario`,concat_ws(' ',`primer_nombre`,`segundo_nombre`,`primer_apellido`,`segundo_apellido`),`estado_solicitud`,`contrasenia`, usuario.tipo_afiliacion, `tipoIdentificacion`,`numero_identificacion`,`numero_licencia`, usuario.direccion,`telefono` FROM usuario INNER JOIN solicitud_empleo on (solicitud_empleo.usuario_id_usuario = usuario.id_usuario) where usuario.estado = 'Inactivo' AND solicitud_empleo.estado_solicitud = 'Aceptado';");
            lstcon = qt.getResultList();
            return (lstcon);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void CambioEstadoSol(int idUsu) {
        try {
            Query q1 = em.createNativeQuery("UPDATE `usuario` SET `estado` = 'Activo' WHERE `usuario`.`id_usuario` = ?;");
            q1.setParameter(1, idUsu);
            q1.executeUpdate();
        } catch (Exception e) {
        }
    }
    @Override
    public void actCon(int idUsu, int idDoc, Usuario usu, Documento doc) {
        try {
            Query q1 = em.createNativeQuery("call statx.actualizarUsuario(?, ?, ?, ?, ?, ?);");
            q1.setParameter(1, idUsu);
            q1.setParameter(2, idDoc);
            q1.setParameter(3, usu.getNumeroLicencia());
            q1.setParameter(4, doc.getTarjeton());
            q1.setParameter(5, doc.getSoat());
            q1.setParameter(6, doc.getTecnomecanica());
            q1.executeUpdate();
        } catch (Exception e) {
            
        }
    }
    
    @Override
    public boolean cambiarContrasenia (String newContrasenia, int idUsu) {
    
        try {
            Query qr = em.createNamedQuery("UPDATE `usuario` SET `contrasenia` = ? WHERE `usuario`.`id_usuario` = ?");
            qr.setParameter(1, newContrasenia);
            qr.setParameter(2, idUsu);
            qr.executeUpdate();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
