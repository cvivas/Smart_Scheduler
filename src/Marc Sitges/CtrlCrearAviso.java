

package agendainteligente;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
/**
 * desripcion: controladora para crear avisos y asignarselos a las actividades
 * author Marc Sitges
 */



public class CtrlCrearAviso {


    int idAvis;
    CtrlDominio3 CD3=  new CtrlDominio3();

    /**
     *
     * @param fecha
     * @param idActividad
     * @return
     */
    public int crearAviso(Date fecha, int idActividad) {

        idAvis=CD3.crearAviso(fecha, idActividad);
        return idAvis;

    }//fin operacion

    /**
     *
     * @param fecha
     * @param idActividad
     * @return
     */
    public int crearAvisoDeadline(Date fecha, int idActividad) {

        idAvis=CD3.crearAvisoDeadline(fecha, idActividad);
        return idAvis;

    }//fin operacion

    
}//fin clase
