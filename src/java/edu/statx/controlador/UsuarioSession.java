/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.controlador;

import edu.statx.entidades.Cuota;
import edu.statx.entidades.Documento;
import edu.statx.entidades.Notificacion;
import edu.statx.entidades.Rol;
import edu.statx.entidades.Servicio;
import edu.statx.entidades.Usuario;
import edu.statx.entidades.Vehiculo;
import edu.statx.facade.MantenimientoFacadeLocal;
import edu.statx.facade.CuotaFacadeLocal;
import edu.statx.facade.UsuarioFacadeLocal;
import edu.statx.facade.VehiculoFacadeLocal;
import edu.statx.facade.DocumentoFacadeLocal;
import edu.statx.facade.NotificacionFacadeLocal;
import edu.statx.facade.ServicioFacadeLocal;
import edu.statx.facade.SolicitudEmpleoFacadeLocal;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;


/**
 *
 * @author Paula Gomez
 */
@Named(value = "usuarioSession")
@SessionScoped
public class UsuarioSession implements Serializable {

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    @EJB
    DocumentoFacadeLocal documentoFacadeLocal;
    @EJB
    VehiculoFacadeLocal vehiculoFacadeLocal;
    @EJB
    ServicioFacadeLocal sfl;
    @EJB
    CuotaFacadeLocal cfl;
    @EJB
    SolicitudEmpleoFacadeLocal sefl;
    @EJB
    MantenimientoFacadeLocal man1;
    @EJB
    NotificacionFacadeLocal nfl;
    
    
    
    private String correo;
    private String clave;
    private String primer_nombre;
    private String segundo_nombre;
    private String primer_apellido;
    private String segundo_apellido;
    private String tipoIdentificacion;
    private int numero_identificacion;
    private int telefono;
    private String numero_celular;
    private String genero;
    private String direccion;
    private String placa;
    private String modelo;
    private String dueño;
    private String marca;
    private String tarjeta_propiedad;
    private String tecnomecanica;
    private String soat;
    private String seguro;
    private int tarjeton;
    private String licencia;
    private Usuario usuarioLog;
    private int idUsuario;
    private int idUsu;
    private String nombreRol;
    private String tipo_usu;
    String tipo_afiliacion;
    private String numnero_licencia;
    private String destino;
    private String obs;
    private int valor;
    private String clavedos;
    private String newclave = "";
    private String newdosclave = "";
    /**
     * Creates a new instance of UsuarioSession
     *
     * @return
     */
    public Usuario getUsuarioLog() {
        return usuarioLog;
    }

    public void setUsuarioLog(Usuario usuarioLog) {
        this.usuarioLog = usuarioLog;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public UsuarioSession() {
    }

    public String getPrimer_nombre() {
        return primer_nombre;
    }

    public void setPrimer_nombre(String primer_nombre) {
        this.primer_nombre = primer_nombre;
    }

    public String getPrimer_apellido() {
        return primer_apellido;
    }

    public void setPrimer_apellido(String primer_apellido) {
        this.primer_apellido = primer_apellido;
    }

    public String getSegundo_nombre() {
        return segundo_nombre;
    }

    public void setSegundo_nombre(String segundo_nombre) {
        this.segundo_nombre = segundo_nombre;
    }

    public String getSegundo_apellido() {
        return segundo_apellido;
    }

    public void setSegundo_apellido(String segundo_apellido) {
        this.segundo_apellido = segundo_apellido;
    }

    public String getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(String tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    public int getNumero_identificacion() {
        return numero_identificacion;
    }

    public void setNumero_identificacion(int numero_identificacion) {
        this.numero_identificacion = numero_identificacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNumeroCelular() {
        return numero_celular;
    }

    public void setNumeroCelular(String numero_celular) {
        this.numero_celular = numero_celular;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getDueño() {
        return dueño;
    }

    public void setDueño(String dueño) {
        this.dueño = dueño;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getTarjeta_propiedad() {
        return tarjeta_propiedad;
    }

    public void setTarjeta_propiedad(String tarjeta_propiedad) {
        this.tarjeta_propiedad = tarjeta_propiedad;
    }

    public String getTecnomecanica() {
        return tecnomecanica;
    }

    public void setTecnomecanica(String tecnomecanica) {
        this.tecnomecanica = tecnomecanica;
    }

    public String getSoat() {
        return soat;
    }

    public void setSoat(String soat) {
        this.soat = soat;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public int getTarjeton() {
        return tarjeton;
    }

    public void setTarjeton(int tarjeton) {
        this.tarjeton = tarjeton;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreRol() {
        return nombreRol;
    }

    public void setNombreRol(String nombreRol) {
        this.nombreRol = nombreRol;
    }
    public void registroCou(){
        try {
            Cuota cuo = new Cuota();
            Usuario usu = new Usuario();
            Usuario usuario = new Usuario();
            cuo.setCuotaEntregada(valor);
            
            usu.setIdUsuario(idUsuario);
            usuario.setIdUsuario(idUsu);
            cfl.actCon(cuo, usu, usuario);
        } catch (Exception e) {
        }
    }
    public void registroSol(){
        try {
            Servicio ser = new Servicio();
            Vehiculo vehi = new Vehiculo();
            
            ser.setOrigen(direccion);
            ser.setDestino(destino);
            ser.setValor(valor);
            ser.setObservaciones(obs);
            
            vehi.setPlaca(placa);
            
            sfl.actCon(ser, vehi);
        } catch (Exception e) {
        }
    }

    public String ingresaUsuarioConductor() {

        try {
            this.tipo_usu = "Conductor";
            this.tipo_afiliacion = "Dueño";
            Usuario usuario = new Usuario();
            usuario.setPrimerNombre(primer_nombre);
            usuario.setSegundoNombre(segundo_nombre);
            usuario.setPrimerApellido(primer_apellido);
            usuario.setSegundoApellido(segundo_apellido);
            usuario.setNumeroIdentificacion(numero_identificacion);
            usuario.setTelefono(telefono);
            usuario.setNumeroCelular(numero_celular);
            usuario.setNumeroLicencia(numero_celular);
            usuario.setNumeroLicencia(numnero_licencia);
            usuario.setDireccion(direccion);
            usuario.setCorreo(correo);
            usuario.setTipoUsu(tipo_usu);
            usuario.setTipoAfiliacion(tipo_afiliacion);
            usuario.setContrasenia(usuario.getPrimerNombre() + usuario.getNumeroIdentificacion());
            
            usuarioFacadeLocal.ingresarUsuarioAfiliacionDueño(usuario);

            return "";

        } catch (Exception e) {

            return "SI/Secretaria/solicitud-empleo.";

        }

    }
    public  void cambioUsuEs(int idUsu){
        try {
            usuarioFacadeLocal.CambioEstadoSol(idUsu);
            
        } catch (Exception e) {
            
        }
    }
    public  void actCon(int idUsu, int idDoc){
        try {
            Usuario usu = new Usuario();
            usu.setNumeroLicencia(numnero_licencia);
            
            Documento doc = new Documento();
            doc.setTarjeton(tarjeton);
            doc.setSoat(soat);
            doc.setTecnomecanica(tecnomecanica);
            
            usuarioFacadeLocal.actCon(idUsu, idDoc, usu, doc);
        } catch (Exception e) {
            
        }
    }
    public String ingresaUsuarioConductorAfiliado() {

        try {
            this.tipo_usu = "Conductor";
            this.tipo_afiliacion = "Afiliación";
            Usuario usuario = new Usuario();
            usuario.setPrimerNombre(primer_nombre);
            usuario.setSegundoNombre(segundo_nombre);
            usuario.setPrimerApellido(primer_apellido);
            usuario.setSegundoApellido(segundo_apellido);
            usuario.setNumeroIdentificacion(numero_identificacion);
            usuario.setTelefono(telefono);
            usuario.setNumeroCelular(numero_celular);
            usuario.setNumeroLicencia(numero_celular);
            usuario.setNumeroLicencia(numnero_licencia);
            usuario.setDireccion(direccion);
            usuario.setCorreo(correo);
            usuario.setTipoUsu(tipo_usu);
            usuario.setTipoAfiliacion(tipo_afiliacion);
            usuario.setContrasenia(usuario.getPrimerNombre() + usuario.getNumeroIdentificacion());
            
            usuarioFacadeLocal.ingresarUsuarioAfiliacionDueño(usuario);

            return "";

        } catch (Exception e) {

            return "SI/Secretaria/solicitud-empleo.";

        }

    }
    public String ingresaUsuarioConductorVinculacion() {

        try {
            this.tipo_usu = "Conductor";
            this.tipo_afiliacion = "Vinculacion";
            Usuario usuario = new Usuario();
            usuario.setPrimerNombre(primer_nombre);
            usuario.setSegundoNombre(segundo_nombre);
            usuario.setPrimerApellido(primer_apellido);
            usuario.setSegundoApellido(segundo_apellido);
            usuario.setNumeroIdentificacion(numero_identificacion);
            usuario.setTelefono(telefono);
            usuario.setNumeroCelular(numero_celular);
            usuario.setNumeroLicencia(numero_celular);
            usuario.setNumeroLicencia(numnero_licencia);
            usuario.setDireccion(direccion);
            usuario.setCorreo(correo);
            usuario.setTipoUsu(tipo_usu);
            usuario.setTipoAfiliacion(tipo_afiliacion);
            usuario.setContrasenia(usuario.getPrimerNombre() + usuario.getNumeroIdentificacion());
            
            usuarioFacadeLocal.ingresarUsuarioAfiliacionDueño(usuario);

            return "";

        } catch (Exception e) {

            return "SI/Secretaria/solicitud-empleo.";

        }

    }
    public String ingresaVehiculoDoc() {

        try {
            
            Usuario usu = new Usuario();
            Vehiculo vehi = new Vehiculo();
            usu.setIdUsuario(idUsuario);
            vehi.setPlaca(placa);
            vehi.setModelo(modelo);
            vehi.setDueño(dueño);
            vehi.setMarca(marca);
            
            Documento doc = new Documento();
            
            doc.setTecnomecanica(tecnomecanica);
            doc.setSeguro(seguro);
            doc.setSoat(soat);
            doc.setTarjeton(tarjeton);
            
            vehiculoFacadeLocal.ingresarVehiculoDoc(vehi, doc, usu);

            return "";

        } catch (Exception e) {

            return "SI/Secretaria/solicitud-empleo.";

        }

    }
    
      
    public String validarUsuario() {
        try {
            usuarioLog = usuarioFacadeLocal.validarUsuario(correo, clave);
            FacesContext context = FacesContext.getCurrentInstance();
            context.getExternalContext().getSessionMap().get("usuarioLog");
            
            if (usuarioLog == null) {
                PrimeFaces.current().executeScript("ValidarUsuOK('  ')");
            } 
            
            if (usuarioLog !=null) {
                String ruta = "SI/";
                for (Rol rol : usuarioLog.getRolCollection()) {
                    ruta += rol.getNombreRol();
                    
                    System.out.println(ruta);
                    break;
                }
                FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuario", usuarioLog);
                return ruta + "/principal.xhtml?faces-redirect=true";  
            }

        } catch (Exception e) {
            return "index";
        }
        return "";
    }

    public void cerrarSession() throws IOException {
        FacesContext.getCurrentInstance().getExternalContext().
                invalidateSession();
        FacesContext.getCurrentInstance().getExternalContext().
                redirect("../../index.xhtml");
    }

    public void verificarSession() {
        try {
            Usuario usuarioLogi = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usuario");
            if (usuarioLogi == null) {
                FacesContext.getCurrentInstance().getExternalContext().redirect("../../index.xhtml");
            }

        } catch (Exception e) {

        }
    }

    public List<Object> listaConductores() {
        try {
            return usuarioFacadeLocal.listaConductores();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Object> listaTesoreros() {
        try {
            return usuarioFacadeLocal.listaTesoreros();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Notificacion> listaNotificacion() {
        try {
            return nfl.listaNotificaciones(usuarioLog.getIdUsuario());
        } catch (Exception e) {
            return null;
        }
    }
    public List<Notificacion> listaNotificaciones() {
        try {
            return nfl.listaNotificacion(usuarioLog.getIdUsuario());
        } catch (Exception e) {
            return null;
        }
    }
    public List<Object> lstServicioPerDia() {
        try {
            return sfl.lstServicioperdia();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Object> lstCuotaf() {
        try {
            return cfl.lstCuotaF();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Object> lstSolEmPen() {
        try {
            return sefl.lstSolEmPen();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Object> lstSolEm() {
        try {
            return sefl.lstSolEm();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Object> lstCuoTes() {
        try {
            return cfl.lstCuotaTes();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Object> lstMante() {
        try {
            return man1.lstMant();
        } catch (Exception e) {
            return null;
        }
    }
    public  String cambioSol(int idUsu){
        try {
            sefl.CambioEstadoSol(idUsu);
            PrimeFaces.current().executeScript("ValidarUsuOk(' ')");

          return "";
        } catch (Exception e) {
            return "";
        }
    }
    public String cambioSolEsDen(int idUsu){
        try {
            
            sefl.CambioEstadoSolDen(idUsu);
          PrimeFaces.current().executeScript("confirmarCambioEstado(' ')");
            return "";
        } catch (Exception e) {
            return "";
        }
        
    }
    public List<Object> lstActPen() {
        try {
            return usuarioFacadeLocal.lstActPen();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Object> lstAsigVehi() {
        try {
            return usuarioFacadeLocal.lstAsigVehi();
        } catch (Exception e) {
            return null;
        }
    }
    public List<Object> lstVehiDes() {
        try {
            return vehiculoFacadeLocal.lstVehi();
        } catch (Exception e) {
            return null;
        }
    }

    public String getTipo_usu() {
        return tipo_usu;
    }

    public void setTipo_usu(String tipo_usu) {
        this.tipo_usu = tipo_usu;
    }

    public String getNumnero_licencia() {
        return numnero_licencia;
    }

    public void setNumnero_licencia(String numnero_licencia) {
        this.numnero_licencia = numnero_licencia;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getObs() {
        return obs;
    }

    public void setObs(String obs) {
        this.obs = obs;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public int getIdUsu() {
        return idUsu;
    }

    public void setIdUsu(int idUsu) {
        this.idUsu = idUsu;
    }

    public String getClavedos() {
        return clavedos;
    }

    public void setClavedos(String clavedos) {
        this.clavedos = clavedos;
    }

    public String getNewclave() {
        return newclave;
    }

    public void setNewclave(String newclave) {
        this.newclave = newclave;
    }

    public String getNewdosclave() {
        return newdosclave;
    }

    public void setNewdosclave(String newdosclave) {
        this.newdosclave = newdosclave;
    }
    
    public void cambiarContrasenia (int idUsuario) {
        try {
            if (this.clavedos.equals(usuarioLog.getContrasenia())) {
            
                if (this.newclave.equals(this.newdosclave)) {
                usuarioFacadeLocal.cambiarContrasenia(newdosclave, idUsuario);
                
                PrimeFaces.current().executeScript("mensajeOK (' " + newdosclave + " ')");
                } else {
                PrimeFaces.current().executeScript("mensajeErrorclave");}
                
                } else {
                        PrimeFaces.current().executeScript("mensajeError('  ')");
                        }
            
        } catch (Exception e) {
        }
    }
}
