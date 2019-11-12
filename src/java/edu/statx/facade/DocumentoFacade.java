
package edu.statx.facade;

import edu.statx.entidades.Documento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Marie
 */
@Stateless
public class DocumentoFacade extends AbstractFacade<Documento> implements DocumentoFacadeLocal {

    @PersistenceContext(unitName = "statxPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DocumentoFacade() {
        super(Documento.class);
    }
    @Override
    public boolean ingresarDocumentoAfiliacionDueño(Documento doc) {
        try {    
                
            Query qt = em.createNativeQuery("INSERT INTO documento (tarjeta_propiedad,tecnomecanica,soat,seguro,tarjeton)VALUES(?,?,?,?,?);");
            qt.setParameter(16, doc.getTarjetaPropiedad());
            qt.setParameter(17, doc.getTecnomecanica());
            qt.setParameter(18, doc.getSoat());
            qt.setParameter(19, doc.getSeguro());
            qt.setParameter(20, doc.getTarjeton());            
            
            qt.executeUpdate();

            return true;

        } catch (Exception e) {
            return false;
        }

    }    
}
