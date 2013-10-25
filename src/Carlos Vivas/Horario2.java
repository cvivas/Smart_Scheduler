
package agendainteligente;
import java.io.Serializable;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
/**
 *descripcion: horarios2 extiende a horarios y añade un arraylist de slots
 * author carlos vivas abilahoud
 */


public class Horario2 extends Horario implements Serializable{

    private ArrayList<TCtrlHorSlot> slots;

    public Horario2() {
        slots=new ArrayList<TCtrlHorSlot>();
    }

    public Horario2(Date date, int idHorario){

        slots=new ArrayList<TCtrlHorSlot>();
        this.data=date;
        this.idHorario=idHorario;
    }

    /*poner en CtrlHorario2*/
    public boolean insertarSlot(int slot,int idAct) {
        boolean b = false;
        TCtrlHorSlot ts = new TCtrlHorSlot();
        ts.slot=slot;
        ts.idActividad=idAct;

        if (!slots.contains(ts)){
            b=this.slots.add(ts);
        }
        return b;
    }

    public boolean quitarSlot(int slot){

        TCtrlHorSlot ts = this.buscarActividadDeSlotConReferencia(slot);
        boolean b = this.slots.remove(ts);
        return b;
    }
    /**
     * @return the slots
     */
    public ArrayList<TCtrlHorSlot> getSlots() {
        return slots;
    }

    /**
     * @param slots the slots to set
     */
    public void setSlots(ArrayList<TCtrlHorSlot> slots) {
        this.slots = slots;
    }

    void listar() {
        System.out.println("idHorario"+this.idHorario);
        System.out.println("fecha horario"+this.data);
    }

    public TCtrlHorSlot buscarActividadDeSlot(int slot){
    /*Devuelve el tCtrlHorSlot con slot = slot*/

        boolean encontrado=false;
        TCtrlHorSlot ts = null;
        Iterator<TCtrlHorSlot> it = slots.iterator();
        while (!encontrado && it.hasNext()){

            TCtrlHorSlot actual = it.next();

            if ( actual.slot==slot){

                encontrado = true;
                ts = new TCtrlHorSlot();
                ts.slot=actual.slot;
                ts.idActividad = actual.idActividad;

            }//fin if

        }//fin while
    return ts;
    }//fin operacion

    public TCtrlHorSlot buscarActividadDeSlotConReferencia(int slot){
    /*Devuelve el tCtrlHorSlot con slot = slot*/

        boolean encontrado=false;
        TCtrlHorSlot ts = null;
        Iterator<TCtrlHorSlot> it = slots.iterator();
        while (!encontrado && it.hasNext()){

            TCtrlHorSlot actual = it.next();

            if ( actual.slot==slot){

                encontrado = true;
                ts = actual;

            }//fin if

        }//fin while
    return ts;
    }//fin operacion

        public TCtrlHorSlot buscarSlotDeActividad(int idAct){
    /*Devuelve el tCtrlHorSlot con idActividad = idAct*/

        boolean encontrado=false;
        TCtrlHorSlot ts = null;
        Iterator<TCtrlHorSlot> it = slots.iterator();
        while (!encontrado && it.hasNext()){

            TCtrlHorSlot actual = it.next();

            if ( actual.idActividad==idAct){

                encontrado = true;
                ts = actual;

            }//fin if

        }//fin while

    return ts;
    }//fin operacion

    @Override
    public Horario crearHorario(Date fecha) {

                this.data=fecha;
                slots=new ArrayList<TCtrlHorSlot>();

        return this;
      
    }

    public ArrayList<TCtrlHorSlot> obtenerSlotsDeActividad(int idAct){


        ArrayList<TCtrlHorSlot> ts = new ArrayList<TCtrlHorSlot>();
        Iterator<TCtrlHorSlot> it = slots.iterator();
        while (it.hasNext()){

            TCtrlHorSlot actual = it.next();

            if ( actual.idActividad==idAct){


                ts.add(actual);

            }//fin if

        }//fin while

        return ts;

    }


    




}
