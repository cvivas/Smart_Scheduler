/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agendainteligente;

/**
 *
 * @author Marc Sitges
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CtrlModificarAvisos {

    CtrlDominio3 CD3 = new CtrlDominio3();

    /**
     *
     * @param fecha
     * @param idAviso
     */
    public void modificarAviso(String fecha, int idAviso){
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fechaN;
        try {
            fechaN = formato.parse(fecha);
        } catch (ParseException ex) {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }//fin try catch
       // CD3.modificarAviso(idAviso,fechaN);
    }//fin operacion
}
