/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author X Force
 */
@Entity
@Table(name = "usuario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_usuario")
    private Integer idUsuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "primer_nombre")
    private String primerNombre;
    @Size(max = 20)
    @Column(name = "segundo_nombre")
    private String segundoNombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "primer_apellido")
    private String primerApellido;
    @Size(max = 20)
    @Column(name = "segundo_apellido")
    private String segundoApellido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "numero_identificacion")
    private int numeroIdentificacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefono")
    private int telefono;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "numero_celular")
    private String numeroCelular;
    @Size(max = 45)
    @Column(name = "genero")
    private String genero;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correo")
    private String correo;
    @Size(max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Size(max = 11)
    @Column(name = "numero_licencia")
    private String numeroLicencia;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "contrasenia")
    private String contrasenia;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @Size(max = 15)
    @Column(name = "tipo_usu")
    private String tipoUsu;
    @Size(max = 15)
    @Column(name = "tipo_afiliacion")
    private String tipoAfiliacion;
    @Column(name = "tipoIdentificacion")
    private Boolean tipoIdentificacion;
    @ManyToMany(mappedBy = "usuarioCollection", fetch = FetchType.LAZY)
    private Collection<Rol> rolCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario", fetch = FetchType.LAZY)
    private Collection<Cuota> cuotaCollection;
    @OneToMany(mappedBy = "usuarioIdTesorero", fetch = FetchType.LAZY)
    private Collection<Cuota> cuotaCollection1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario", fetch = FetchType.LAZY)
    private Collection<SolicitudEmpleo> solicitudEmpleoCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuarioIdUsuario", fetch = FetchType.LAZY)
    private Collection<Vehiculo> vehiculoCollection;

    public Usuario() {
    }

    public Usuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public Usuario(Integer idUsuario, String primerNombre, String primerApellido, int numeroIdentificacion, int telefono, String numeroCelular, String correo, String contrasenia) {
        this.idUsuario = idUsuario;
        this.primerNombre = primerNombre;
        this.primerApellido = primerApellido;
        this.numeroIdentificacion = numeroIdentificacion;
        this.telefono = telefono;
        this.numeroCelular = numeroCelular;
        this.correo = correo;
        this.contrasenia = contrasenia;
    }

    public Integer getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Integer idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public int getNumeroIdentificacion() {
        return numeroIdentificacion;
    }

    public void setNumeroIdentificacion(int numeroIdentificacion) {
        this.numeroIdentificacion = numeroIdentificacion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getNumeroCelular() {
        return numeroCelular;
    }

    public void setNumeroCelular(String numeroCelular) {
        this.numeroCelular = numeroCelular;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getNumeroLicencia() {
        return numeroLicencia;
    }

    public void setNumeroLicencia(String numeroLicencia) {
        this.numeroLicencia = numeroLicencia;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipoUsu() {
        return tipoUsu;
    }

    public void setTipoUsu(String tipoUsu) {
        this.tipoUsu = tipoUsu;
    }

    public String getTipoAfiliacion() {
        return tipoAfiliacion;
    }

    public void setTipoAfiliacion(String tipoAfiliacion) {
        this.tipoAfiliacion = tipoAfiliacion;
    }

    public Boolean getTipoIdentificacion() {
        return tipoIdentificacion;
    }

    public void setTipoIdentificacion(Boolean tipoIdentificacion) {
        this.tipoIdentificacion = tipoIdentificacion;
    }

    @XmlTransient
    public Collection<Rol> getRolCollection() {
        return rolCollection;
    }

    public void setRolCollection(Collection<Rol> rolCollection) {
        this.rolCollection = rolCollection;
    }

    @XmlTransient
    public Collection<Cuota> getCuotaCollection() {
        return cuotaCollection;
    }

    public void setCuotaCollection(Collection<Cuota> cuotaCollection) {
        this.cuotaCollection = cuotaCollection;
    }

    @XmlTransient
    public Collection<Cuota> getCuotaCollection1() {
        return cuotaCollection1;
    }

    public void setCuotaCollection1(Collection<Cuota> cuotaCollection1) {
        this.cuotaCollection1 = cuotaCollection1;
    }

    @XmlTransient
    public Collection<SolicitudEmpleo> getSolicitudEmpleoCollection() {
        return solicitudEmpleoCollection;
    }

    public void setSolicitudEmpleoCollection(Collection<SolicitudEmpleo> solicitudEmpleoCollection) {
        this.solicitudEmpleoCollection = solicitudEmpleoCollection;
    }

    @XmlTransient
    public Collection<Vehiculo> getVehiculoCollection() {
        return vehiculoCollection;
    }

    public void setVehiculoCollection(Collection<Vehiculo> vehiculoCollection) {
        this.vehiculoCollection = vehiculoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUsuario != null ? idUsuario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.idUsuario == null && other.idUsuario != null) || (this.idUsuario != null && !this.idUsuario.equals(other.idUsuario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.statx.entidades.Usuario[ idUsuario=" + idUsuario + " ]";
    }
    
}
