
package agendainteligente;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.Date;
/**
 *Controladora que nos permitira crear los horarios para ser asignados a las actividades
 * author carlos
 */


public class CtrlCrearHorario2 {

      CtrlDominio3 CD3 = new CtrlDominio3();
    int idH=0;

    
    public int crearHorario(Date fecha, int idActividad) {

//        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
//        Date fechaH;
//        try {
//            fechaH = formato.parse(fecha);
//        } catch (ParseException ex) {
//            ex.printStackTrace();
//            throw new RuntimeException(ex);
//        }
        idH=CD3.crearHorario(fecha, idActividad);
        return idH;

    }

    public void insertarConSlot(int numSlot, int idAct){

        CD3.insertarConSlot(idH,numSlot,idAct);


    }

        public void insertarConSlot(int idHora,int numSlot, int idAct){

        CD3.insertarConSlot(idHora,numSlot,idAct);


    }




}
