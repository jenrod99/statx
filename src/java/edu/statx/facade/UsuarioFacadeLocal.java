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
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Marie
 */
@Local
public interface UsuarioFacadeLocal {

    void create(Usuario usuario);

    void edit(Usuario usuario);

    void remove(Usuario usuario);

    Usuario find(Object id);

    List<Usuario> findAll();

    List<Usuario> findRange(int[] range);

    int count();

    public Usuario validarUsuario(String correoIn, String claveIn);

    public boolean ingresarUsuarioAfiliacionDueño(Usuario usuario);
    
    public Usuario buscarPorCorreo(String correo);  

    public List<Object> listaConductores();

    public List<Object> lstActPen();

    public List<Object> lstAsigVehi();

    public void CambioEstadoSol(int idUsu);

    public void actCon(int idUsu, int idDoc, Usuario usu, Documento doc);

    public List<Object> listaTesoreros();

    public boolean cambiarContrasenia(String newContrasenia, int idUsu);
   }
