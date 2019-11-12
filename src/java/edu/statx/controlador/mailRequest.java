/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.statx.controlador;

import javax.ejb.EJB;
import javax.inject.Named;
import javax.enterprise.context.RequestScoped;
import edu.statx.entidades.Usuario;
import edu.statx.facade.UsuarioFacadeLocal;
import edu.statx.modelo.Mailer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.primefaces.PrimeFaces;

/**
 *
 * @author Paula Gomez
 */
@Named(value = "mailRequest")
@RequestScoped

public class mailRequest {

    /**
     * Creates a new instance of mailRequest
     */
    public mailRequest() {
    }

    @EJB

    UsuarioFacadeLocal usuarioFacadeLocal;

    UsuarioSession ususession = new UsuarioSession();

    /* VARIABLE/S ENVIO DE CORREO */
    private String destinatario = "";
    private String mensaje = "";
    private String asunto = "Bienvenido a su sistema de informacion de confianza";

    /* METODO ENVIO DE CORREO, POR MEDIO DE UNA CONSULTA EN LA BASE DE DATOS */
    public String enviarCorreo() {
        Usuario usuCorreo = usuarioFacadeLocal.buscarPorCorreo(destinatario);
        if (usuCorreo == null) {
            destinatario = "NO ENCONTRADO";
        } else {
            mensaje = "<!DOCTYPE html>\n"
                    + "<html>\n"
                    + "<head>\n"
                    + "<title></title>\n"
                    + "<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n"
                    + "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n"
                    + "<meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\" />\n"
                    + "<style type=\"text/css\">\n"
                    + "\n"
                    + "body, table, td, a { -webkit-text-size-adjust: 100%; -ms-text-size-adjust: 100%; }\n"
                    + "table, td { mso-table-lspace: 0pt; mso-table-rspace: 0pt; }\n"
                    + "img { -ms-interpolation-mode: bicubic; }\n"
                    + "\n"
                    + "img { border: 0; height: auto; line-height: 100%; outline: none; text-decoration: none; }\n"
                    + "table { border-collapse: collapse !important; }\n"
                    + "body { height: 100% !important; margin: 0 !important; padding: 0 !important; width: 100% !important; }\n"
                    + "\n"
                    + "a[x-apple-data-detectors] {\n"
                    + "    color: inherit !important;\n"
                    + "    text-decoration: none !important;\n"
                    + "    font-size: inherit !important;\n"
                    + "    font-family: inherit !important;\n"
                    + "    font-weight: inherit !important;\n"
                    + "    line-height: inherit !important;\n"
                    + "}\n"
                    + "\n"
                    + "@media screen and (max-width: 480px) {\n"
                    + "    .mobile-hide {\n"
                    + "        display: none !important;\n"
                    + "    }\n"
                    + "    .mobile-center {\n"
                    + "        text-align: center !important;\n"
                    + "    }\n"
                    + "}\n"
                    + "\n"
                    + "div[style*=\"margin: 16px 0;\"] { margin: 0 !important; }\n"
                    + "</style>\n"
                    + "<body style=\"margin: 0 !important; padding: 0 !important; background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\n"
                    + "\n"
                    + "<div style=\"display: none; font-size: 1px; color: #fefefe; line-height: 1px; font-family: Open Sans, Helvetica, Arial, sans-serif; max-height: 0px; max-width: 0px; opacity: 0; overflow: hidden;\">\n"
                    + "Lorem ipsum dolor sit amet, consectetur adipisicing elit. Natus dolor aliquid omnis consequatur est deserunt, odio neque blanditiis aspernatur, mollitia ipsa distinctio, culpa fuga obcaecati!\n"
                    + "</div>\n"
                    + "\n"
                    + "<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\">\n"
                    + "    <tr>\n"
                    + "        <td align=\"center\" style=\"background-color: #eeeeee;\" bgcolor=\"#eeeeee\">\n"
                    + "        <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n"
                    + "            <tr>\n"
                    + "                <td align=\"center\" valign=\"top\" style=\"font-size:0; padding: 35px;\" bgcolor=\"#C5C5C7\">\n"
                    + "                <div style=\"display:inline-block; max-width:50%; min-width:100px; vertical-align:top; width:100%;\">\n"
                    + "                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n"
                    + "                        <tr>\n"
                    + "                            <td align=\"left\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 36px; font-weight: 800; line-height: 48px;\" class=\"mobile-center\">\n"
                    + "                                <h1 style=\"font-size: 36px; font-weight: 800; margin: 0; color: #ffffff;\">STATX</h1>\n"
                    + "                                <img src=\"https://live.staticflickr.com/65535/48760494378_2555635c16.jpg\">\n"
                    + "                            </td>\n"
                    + "                        </tr>\n"
                    + "                    </table>\n"
                    + "                </div>\n"
                    + "                <div style=\"display:inline-block; max-width:50%; min-width:100px; vertical-align:top; width:100%;\" class=\"mobile-hide\">\n"
                    + "                    <table align=\"left\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:300px;\">\n"
                    + "                        <tr>\n"
                    + "                            <td align=\"right\" valign=\"top\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 48px; font-weight: 400; line-height: 48px;\">\n"
                    + "                                <table cellspacing=\"0\" cellpadding=\"0\" border=\"0\" align=\"right\">\n"
                    + "                                    <tr>\n"
                    + "                                        <td style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 18px; font-weight: 400;\">\n"
                    + "                                            \n"
                    + "                                        </td>\n"
                    + "                                    </tr>\n"
                    + "                                </table>\n"
                    + "                            </td>\n"
                    + "                        </tr>\n"
                    + "                    </table>\n"
                    + "                </div>\n"
                    + "                </td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td align=\"center\" style=\"padding: 35px 35px 20px 35px; background-color: #ffffff;\" bgcolor=\"#ffffff\">\n"
                    + "                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\">\n"
                    + "                    <tr>\n"
                    + "                        <td align=\"center\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 25px;\">\n"
                    + "                            <br>                          \n"
                    + "                            <h4 style=\"font-size: 25px; font-weight: 800; line-height: 36px; color: #333333; margin: 0;\">\n"
                    + "                                Gracias por ponerse en contacto con el Soporte de STATX.\n"
                    + "                            </h4>\n"
                    + "                        </td>\n"
                    + "                    </tr>\n"
                    + "                    <tr>\n"
                    + "                        <td align=\"left\" style=\"font-family: Open Sans, Helvetica, Arial, sans-serif; font-size: 16px; font-weight: 400; line-height: 24px; padding-top: 10px;\">\n"
                    + "                            <p style=\"font-size: 16px; font-weight: 400; line-height: 24px; color: #777777;\">\n"
                    + "                                Hemos recibido su solicitud para recuperar su cuenta de STATX<br>\n"
                    + "                                El número de incidencia para este pedido 403569880.<br/>\n"
                    + "                                <br/><br>\n"
                    + "                              \n"
                    + "                                <label style=\"margin:0 15px 0 15px;\">Su contraseña es: </label>" + usuCorreo.getContrasenia() + "<br><br><br>\n"
                    + "                                Muchas gracias, Equipo de Soporte de STATX.\n"
                    + "                            </p>\n"
                    + "                        </td>\n"
                    + "                    </tr>        \n"
                    + "                </table>\n"
                    + "                </td>\n"
                    + "            </tr>\n"
                    + "            <tr>\n"
                    + "                <td align=\"center\" style=\" padding: 35px; background-color: #1b9ba3; color: #fff;\" bgcolor=\"#1b9ba3\">\n"
                    + "                <table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" style=\"max-width:600px;\" color=\"#fff\">\n"
                    + "                    <tr style=\"color: #fff;\" >\n"
                    + "                        STATX<br/>\n"
                    + "                        Developers in process<br/>\n"
                    + "                        COLOMBIA\n"
                    + "                        \n"
                    + "                        <br/><br/>\n"
                    + "                        Por favor no responda a este mensaje.<br/>\n"
                    + "                        Las respuestas a este mensaje seran dirigidas a un buzón de correo sin supervisión.\n"
                    + "                    </tr>\n"
                    + "                </table>\n"
                    + "                </td>\n"
                    + "            </tr>\n"
                    + "        </table>\n"
                    + "        </td>\n"
                    + "    </tr>\n"
                    + "</table>\n"
                    + "</body>\n"
                    + "</html>";
            Mailer.send(destinatario, asunto, mensaje);

        }
        destinatario = "";
        asunto = "";
        mensaje = "";
        try {
        } catch (Exception e) {
            return "index";
        }
        PrimeFaces.current().executeScript("emailEnviado('  ')");
        return "index";
    }

    public String enviarMasivo() throws SQLException {
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/statx?zeroDateTimeBehavior=convertToNull", "root", "");

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT `correo` FROM `statx`.`usuario`");
            while (rs.next()) {
                destinatario = rs.getString("correo");

                mensaje = "Bienvenido a STATX Este correo es enviado de manera masiva para informar que usted esta en el sistema de informacion STATX";
                Mailer.send(destinatario, asunto, mensaje);

            }
            destinatario = "";
            asunto = "";
            mensaje = "";
        } catch (Exception e) {

            return "index";
        }
        PrimeFaces.current().executeScript("emailEnviado('  ')");
        return "index";
    }  

    /* GETTERS AND SETTERS */
    public String getDestinatario() {
        return destinatario;
    }

    public void setDestinatario(String destinatario) {
        this.destinatario = destinatario;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

}
