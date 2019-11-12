/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.controlador;

import edu.statx.facade.CuotaFacadeLocal;
import edu.statx.facade.ServicioFacadeLocal;
import edu.statx.facade.VehiculoFacadeLocal;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;

/**
 *
 * @author Paula Gomez
 */
@Named(value = "cargaGraficaRequest")
@RequestScoped
public class CargaGraficaRequest {

    /**
     * Creates a new instance of CargaGraficaRequest
     */
private String anio = "";
    private String mes = "";
    private String graficaCuota = "";
    private String graficaCuotaF = "";
    private String graficaServicio = "";
    private String graficaModelos = "";
    @EJB
    CuotaFacadeLocal cfl;
    @EJB
    ServicioFacadeLocal sfl;
    @EJB
    VehiculoFacadeLocal vfl;

    public CargaGraficaRequest() {
    }

    public String getGraficaCuota() {
        return graficaCuota;
    }

    public void setGraficaCuota(String graficaCuota) {
        this.graficaCuota = graficaCuota;
    }

    public void cuota() {
        List<Object> ob = cfl.cargaCuota(Integer.parseInt(mes), Integer.parseInt(anio));
        for (int i = 0; i < ob.size(); i++) {
            Object[] recovered = (Object[]) ob.get(i);
            graficaCuota += "{y: " + recovered[0] + ", name: '" + recovered[1] + "'},";
        }
    }

    public void cuotaFaltante() {
        List<Object> ob = cfl.cargaCuotaF(Integer.parseInt(mes), Integer.parseInt(anio));
        for (int i = 0; i < ob.size(); i++) {
            Object[] recovered = (Object[]) ob.get(i);
            graficaCuota += "{label: '" + recovered[2] + "', y: " + recovered[0] + "},";
            graficaCuotaF += "{label: '" + recovered[2] + "', y: " + recovered[1] + "},";
        }
    }

    public void cuotaperanio() {
        List<Object> ob = cfl.cargaCuotaperanio(Integer.parseInt(anio));
        for (int i = 0; i < ob.size(); i++) {
            Object[] recovered = (Object[]) ob.get(i);
            graficaCuota += "{y: " + recovered[0] + ", name: '" + recovered[1] + "'},";
        }
    }

    public void servicios() {
        List<Object> ob = sfl.cargaServicio(Integer.parseInt(mes), Integer.parseInt(anio));
        for (int i = 0; i < ob.size(); i++) {
            Object[] recovered = (Object[]) ob.get(i);
            graficaServicio += "{y: " + recovered[0] + ", label: '" + recovered[1] + "'},";
        }
    }

    public void modelo() {
        List<Object> ob = vfl.listaModelos();
        for (int i = 0; i < ob.size(); i++) {
            Object[] recovered = (Object[]) ob.get(i);
            graficaModelos += "{y: " + recovered[0] + ", label: '" + recovered[1] + "'},";
        }
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAnio() {
        return anio;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public String getGraficaServicio() {
        return graficaServicio;
    }

    public void setGraficaServicio(String graficaServicio) {
        this.graficaServicio = graficaServicio;
    }

    public String getGraficaCuotaF() {
        return graficaCuotaF;
    }

    public void setGraficaCuotaF(String graficaCuotaF) {
        this.graficaCuotaF = graficaCuotaF;
    }

    public String getGraficaModelos() {
        return graficaModelos;
    }

    public void setGraficaModelos(String graficaModelos) {
        this.graficaModelos = graficaModelos;
    }
  
}
