/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.controlador;

import edu.statx.entidades.Usuario;
import edu.statx.entidades.Vehiculo;
import edu.statx.facade.VehiculoFacadeLocal;
import edu.statx.facade.UsuarioFacadeLocal;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.servlet.http.Part;

/**
 *
 * @author JENNY
 */
@Named(value = "cargarArchivos")
@RequestScoped
public class CargarArchivos {

    /**
     * Creates a new instance of CargarArchivos
     */
    public CargarArchivos() {
    }

    @EJB
    UsuarioFacadeLocal usuarioFacadeLocal;
    
    @EJB
    VehiculoFacadeLocal vehiculoFacadeLocal;

    private Part datosConductor;
    private Part datosVehiculo;

    // VALIDAR ARCHIVO .txt
    public void validarArchivo(FacesContext ctx, UIComponent comp, Object value) throws IOException {

        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
        Part file = (Part) value;
        if (file.getSize() > 10024) {
            msgs.add(new FacesMessage("El archivo es muy grande"));
        }
        if (!"text/plain".equals(file.getContentType())) {
            msgs.add(new FacesMessage("No es un documento .txt"));
        }
        if (!msgs.isEmpty()) {
            throw new ValidatorException(msgs);
        }

    }

    // INGRESAR LOS DATOS A LA BASE DE DATOS
    public void ingresarConductor() {

        List<FacesMessage> msgs = new ArrayList<FacesMessage>();

        try {
            InputStreamReader lector = new InputStreamReader(this.datosConductor.getInputStream());
            BufferedReader lectorDoc = new BufferedReader(lector);
            String line;
            //StreamTokenizer palabra = new StreamTokenizer (lector);

            while ((line = lectorDoc.readLine()) != null) {

                Usuario condIn = new Usuario();
                condIn.setPrimerNombre(line);
                condIn.setSegundoNombre(lectorDoc.readLine());
                condIn.setPrimerApellido(lectorDoc.readLine());
                condIn.setSegundoApellido(lectorDoc.readLine());
                condIn.setNumeroIdentificacion(1019765890);
                condIn.setTelefono(7550921);
                condIn.setNumeroCelular(lectorDoc.readLine());
                condIn.setGenero(lectorDoc.readLine());
                condIn.setCorreo(lectorDoc.readLine());
                condIn.setDireccion(lectorDoc.readLine());
                condIn.setNumeroLicencia(lectorDoc.readLine());
                condIn.setContrasenia(lectorDoc.readLine());
                condIn.setEstado("Inactivo");
                condIn.setTipoUsu(lectorDoc.readLine());
                condIn.setTipoAfiliacion(lectorDoc.readLine());

                usuarioFacadeLocal.ingresarUsuarioAfiliacionDueño(condIn);
                System.out.println(line);
                System.out.println("Aquí si debe llegar c:");

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            System.out.println("Aquí no debe llegar :c");
        }
    }

    //INGRESAR VEHICULOS A LA BASE DE DATOS
//    public void ingresarVehiculo() {
//        List<FacesMessage> msgs = new ArrayList<FacesMessage>();
//
//        try {
//            InputStreamReader lector = new InputStreamReader(this.datosVehiculo.getInputStream());
//            BufferedReader lectorDoc = new BufferedReader(lector);
//            String lineRead;
//            //StreamTokenizer palabra = new StreamTokenizer (lector);
//
//            while ((lineRead = lectorDoc.readLine()) != null) {
//
//                Vehiculo vehInd = new Vehiculo();
//                
//              vehInd.setModelo(lectorDoc.readLine());
//              vehInd.setMarca(lectorDoc.readLine());
//              vehInd.setDueño(lectorDoc.readLine());
//              
//              vehiculoFacadeLocal.ingresarVehiculo(vehInd);
//              
//              System.out.println(lineRead);
//              System.out.println("Aquí si debe llegar c:");
//
//          }
//      } catch (Exception e) {
//          System.out.println(e.getMessage());
//          System.out.println("Aquí no debe llegar :c");
//        }
//    }
//
   public Part getDatosConductor() {
        return datosConductor;
    }
//
    public void setDatosConductor(Part datosConductor) {
        this.datosConductor = datosConductor;
    }
//
    public Part getDatosVehiculo() {
        return datosVehiculo;
    }
//
    public void setDatosVehiculo(Part datosVehiculo) {
        this.datosVehiculo = datosVehiculo;
    }
//
}
