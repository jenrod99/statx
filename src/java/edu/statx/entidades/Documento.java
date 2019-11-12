/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author X Force
 */
@Entity
@Table(name = "documento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Documento.findAll", query = "SELECT d FROM Documento d")})
public class Documento implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_documento")
    private Integer idDocumento;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_documento")
    @Temporal(TemporalType.DATE)
    private Date fechaDocumento;
    @Lob
    @Column(name = "tarjeta_propiedad")
    private byte[] tarjetaPropiedad;
    @Size(max = 45)
    @Column(name = "tecnomecanica")
    private String tecnomecanica;
    @Size(max = 45)
    @Column(name = "seguro")
    private String seguro;
    @Size(max = 45)
    @Column(name = "soat")
    private String soat;
    @Column(name = "tarjeton")
    private Integer tarjeton;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "documentoIdDocumento", fetch = FetchType.LAZY)
    private Collection<Vehiculo> vehiculoCollection;

    public Documento() {
    }

    public Documento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Documento(Integer idDocumento, Date fechaDocumento) {
        this.idDocumento = idDocumento;
        this.fechaDocumento = fechaDocumento;
    }

    public Integer getIdDocumento() {
        return idDocumento;
    }

    public void setIdDocumento(Integer idDocumento) {
        this.idDocumento = idDocumento;
    }

    public Date getFechaDocumento() {
        return fechaDocumento;
    }

    public void setFechaDocumento(Date fechaDocumento) {
        this.fechaDocumento = fechaDocumento;
    }

    public byte[] getTarjetaPropiedad() {
        return tarjetaPropiedad;
    }

    public void setTarjetaPropiedad(byte[] tarjetaPropiedad) {
        this.tarjetaPropiedad = tarjetaPropiedad;
    }

    public String getTecnomecanica() {
        return tecnomecanica;
    }

    public void setTecnomecanica(String tecnomecanica) {
        this.tecnomecanica = tecnomecanica;
    }

    public String getSeguro() {
        return seguro;
    }

    public void setSeguro(String seguro) {
        this.seguro = seguro;
    }

    public String getSoat() {
        return soat;
    }

    public void setSoat(String soat) {
        this.soat = soat;
    }

    public Integer getTarjeton() {
        return tarjeton;
    }

    public void setTarjeton(Integer tarjeton) {
        this.tarjeton = tarjeton;
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
        hash += (idDocumento != null ? idDocumento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Documento)) {
            return false;
        }
        Documento other = (Documento) object;
        if ((this.idDocumento == null && other.idDocumento != null) || (this.idDocumento != null && !this.idDocumento.equals(other.idDocumento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "edu.statx.entidades.Documento[ idDocumento=" + idDocumento + " ]";
    }
    
}
