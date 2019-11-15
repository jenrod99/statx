/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Windows
 */
@Entity
@Table(name = "solicitud_empleo")
@NamedQueries({
    @NamedQuery(name = "SolicitudEmpleo.findAll", query = "SELECT s FROM SolicitudEmpleo s")})
public class SolicitudEmpleo implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idAfiliacion")
    private Integer idAfiliacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_afiliacion")
    private String tipoAfiliacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado_solicitud")
    private String estadoSolicitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_solicitud")
    @Temporal(TemporalType.DATE)
    private Date fechaSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "licencia")
    private String licencia;
    @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario usuarioIdUsuario;

    public SolicitudEmpleo() {
    }

    public SolicitudEmpleo(Integer idAfiliacion) {
        this.idAfiliacion = idAfiliacion;
    }

    public SolicitudEmpleo(Integer idAfiliacion, String tipoAfiliacion, String estadoSolicitud, Date fechaSolicitud, String direccion, String licencia) {
        this.idAfiliacion = idAfiliacion;
        this.tipoAfiliacion = tipoAfiliacion;
        this.estadoSolicitud = estadoSolicitud;
        this.fechaSolicitud = fechaSolicitud;
        this.direccion = direccion;
        this.licencia = licencia;
    }

    public Integer getIdAfiliacion() {
        return idAfiliacion;
    }

    public void setIdAfiliacion(Integer idAfiliacion) {
        this.idAfiliacion = idAfiliacion;
    }

    public String getTipoAfiliacion() {
        return tipoAfiliacion;
    }

    public void setTipoAfiliacion(String tipoAfiliacion) {
        this.tipoAfiliacion = tipoAfiliacion;
    }

    public String getEstadoSolicitud() {
        return estadoSolicitud;
    }

    public void setEstadoSolicitud(String estadoSolicitud) {
        this.estadoSolicitud = estadoSolicitud;
    }

    public Date getFechaSolicitud() {
        return fechaSolicitud;
    }

    public void setFechaSolicitud(Date fechaSolicitud) {
        this.fechaSolicitud = fechaSolicitud;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLicencia() {
        return licencia;
    }

    public void setLicencia(String licencia) {
        this.licencia = licencia;
    }

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAfiliacion != null ? idAfiliacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SolicitudEmpleo)) {
            return false;
        }
        SolicitudEmpleo other = (SolicitudEmpleo) object;
        if ((this.idAfiliacion == null && other.idAfiliacion != null) || (this.idAfiliacion != null && !this.idAfiliacion.equals(other.idAfiliacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.statx.entidades.SolicitudEmpleo[ idAfiliacion=" + idAfiliacion + " ]";
    }
    
}
