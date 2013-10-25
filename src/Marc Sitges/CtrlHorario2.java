

package agendainteligente;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Iterator;

/**
 *descripcion: gestiona las relaciones de horarios con las demas clases
 * author Marc Sitges
 */




public class CtrlHorario2 extends CtrlHorario implements Serializable{
    
    Constantes constante = new Constantes();
    JornadaLaboral JP = new JornadaLaboral();
    private int indiceHorario;

    /**
     *
     */
    public CtrlHorario2() {
    
        indiceHorario=0;
    }


/**
 * Dado un Horario, la almacena en el hashtable
 * @param horario
 * @return
 */
    public boolean insertarHorario(Horario horario){
         
          
        setIndiceHorario(getIndiceHorario() + 1);
        int h = getIndiceHorario();
        boolean asignado=false;
        if (horario !=null){
            TCtrlHorario thor = new TCtrlHorario();
            thor.tHorario=horario;
            thor.tActividad=new ArrayList<Integer> ();
            thor.tHorario.setidHorario(h);
            hashHorario.put(new Integer(h), thor);
            asignado = true;
        }
        return asignado;
      }

    /**
     *  operacion que crea un horario con data "fecha" en el caso en que no exista
     si existe devolvemos su idHorario
     * @param fecha
     * @return
     */
    public int crearHorario(Date fecha) {

        boolean trobat = false;
        int idHorario=-1;

        Enumeration<TCtrlHorario> enu = hashHorario.elements();
        TCtrlHorario elem = null;

        while(enu.hasMoreElements() && !trobat){

            elem = enu.nextElement();
            if(sonIguales(elem.tHorario.data,fecha)){
                idHorario = elem.tHorario.idHorario;
                trobat=true;
            }//fin if
        }//fin while
        if(trobat) return idHorario;
        else{
            Horario hor = new Horario2();
            hor.setData(fecha);
            insertarHorario(hor);
            return hor.getidHorario();
        }
    }//fin operacion

    /**
     *
     *
     * @param idHorario
     * @param iniJ
     * @param finJ
     * @return
     */
    int buscarSlot(int idHorario, int iniJ, int finJ) {
        
        Horario2 h2 = (Horario2) buscarHorario(idHorario);
        ArrayList<TCtrlHorSlot> lista = h2.getSlots();
        Iterator<TCtrlHorSlot> Iter = lista.iterator();
        TCtrlHorSlot elem = null;

        boolean dia[] = new boolean[24];
        int i;
        /*Inicializamos el array dia a falso*/
        for(i=0;i<dia.length;i++){
            dia[i]=false;
        }
        /*si hay slots ocupados ponemos su posicion en el array en true*/
        while(Iter.hasNext()){
            dia[Iter.next().slot]=true;
        }//fin while

        for(i=iniJ;i<=finJ;i++)if(!dia[i])return i;
        return -1;
    }
    void insertarConSlot(int idH, int slot, int idActividad) {
        Horario2 horario2 = (Horario2) buscarHorario(idH);
        horario2.insertarSlot(slot,idActividad);

    }
/**
 *
 * @param idh
 * @return
 */
    public ArrayList<TCtrlHorSlot> obtenerSlots(int idh){

        Horario2 hor2 = (Horario2)buscarHorario(idh);
        ArrayList<TCtrlHorSlot> ths= new ArrayList<TCtrlHorSlot>();
        if(hor2==null)return null;
        else ths=hor2.getSlots();
        return ths;

    }

    /**
     *
     * @param idHorario
     * @param idActividad
     * @return
     */
    public ArrayList<TCtrlHorSlot> obtenerSlotsDeActividad(int idHorario, int idActividad){

        Horario2 hor2 = (Horario2)buscarHorario(idHorario);
        ArrayList<TCtrlHorSlot> ths= null;
        if (hor2!=null) ths = hor2.obtenerSlotsDeActividad(idActividad);

        return ths;
    }

    /*cuando hemos eliminado/modificar una actividad eliminamos su slot*/
    /**
     *
     * @param idH
     * @param slot
     * @return
     */
    public boolean quitarSlot(int idH, int slot){
        
        Horario2 horario2 = (Horario2) buscarHorario(idH);
        return horario2.quitarSlot(slot);
    
    }

    /**
     *
     * @param idH
     */
    public void listarHorario(int idH){

        Horario2 hor2 = (Horario2) buscarHorario(idH);
        hor2.listar();

    }

    /**
     * dada una fecha, obtenemos un idHorario, si no existe devolvemos -1
     * 
     * @param data
     * @return
     */
    public int obtenerIdHorario(Date data) {

        int idHorario=-1;
        boolean trobat = false;
        Enumeration<TCtrlHorario> enu = hashHorario.elements();
        TCtrlHorario elem = null;

        while(enu.hasMoreElements() && !trobat){

            elem = (TCtrlHorario) enu.nextElement();
            if(sonIguales(elem.tHorario.data,data)){
                idHorario = elem.tHorario.idHorario;
                trobat=true;
            }//fin if
        }//fin while
        return idHorario;
    }//fin operacion

    /**
     *
     * @param idActividad
     * @param idHorario
     */
    public void borrarActividadConSlot(int idActividad,int idHorario){
        
        ArrayList<TCtrlHorSlot> lista = obtenerSlotsDeActividad(idHorario, idActividad);
        if (lista != null){
            Iterator<TCtrlHorSlot> index = lista.iterator();
            TCtrlHorSlot elem = null;
            while(index.hasNext()){
                elem=index.next();
                quitarSlot(idHorario, elem.slot);
            }
        }

    }

    private boolean sonIguales(Date dataH, Date data0) {

        return (dataH.getDate() == data0.getDate() && dataH.getMonth() == data0.getMonth()
                && dataH.getYear() == data0.getYear());
    }

    /**
     * @return the indiceHorario
     */
    public int getIndiceHorario() {
        return indiceHorario;
    }

    /**
     * @param indiceHorario the indiceHorario to set
     */
    public void setIndiceHorario(int indiceHorario) {
        this.indiceHorario = indiceHorario;
    }

    /**
     *
     * @param idActividad
     * @param idHorario
     * @return
     */
    public boolean borrarActividad2(int idActividad, int idHorario){
    /*
     * Pre: idActividad existe dentro de Horario
     * Post: se borra el id idActividad del Horario
     */
        boolean result=false;
        TCtrlHorario tHor = (TCtrlHorario) hashHorario.get(new Integer(idHorario));
        if(tHor!=null){
            if (existeActividadEnHorario(tHor.tActividad, idActividad)){
                Integer idAct = idActividad;
                tHor.tActividad.remove(idAct);
                result=true;
            }//fi if2
        }//fi if1
        return result;
    }//fi operacio
        
//    public void asignarActividadSinSlot(int idActividad, int idHorario, int iniJor, int finJor){
//
//          ArrayList<TCtrlHorSlot> lista = obtenerSlots(idHorario);
//          Iterator<TCtrlHorSlot> index = lista.iterator();
//          boolean dia[] = new boolean[24];
//          int i;
//          boolean trobat=false;
//
//          /*Inicializamos el array dia a falso*/
//          for(i=0;i<dia.length;i++){
//              dia[i]=false;
//          }
//          /*si hay slots ocupados ponemos su posicion en el array en true*/
//          while(index.hasNext()){
//              dia[index.next().slot]=true;
//          }
//          i=iniJor;
//          while(i<finJor && !trobat){
//              if(!dia[i]){
//                  trobat=true;
//                  insertarConSlot(idHorario, i, idActividad);
//              }
//              else i++;
//          }
//    }
    /**
     *
     * @param idActividad
     * @param idHorario
     * @return
     */
    @Override
	public boolean asignarActividad (int idActividad, int idHorario) {
        //Añade la actividad con id=idActividad al Arralist de el Horario con id=idHorario
        //Pre existe el Horario con id=idHorario
        boolean result=false;
        TCtrlHorario tHor = (TCtrlHorario) hashHorario.get(new Integer(idHorario));
        if(tHor!=null){
            if (!existeActividadEnHorario(tHor.tActividad, idActividad)){
                 ArrayList<Integer> tAct=tHor.tActividad;
                 tAct.add(new Integer (idActividad));
                 result=true;
            }//fi if2
        }//fi if1
        return result;
    }//fi operacio

    /**
     *
     * @param idHorario
     * @return
     */
    @Override
    public boolean eliminarHorario (int idHorario) {
        boolean result=false;
        if(hashHorario.containsKey(new Integer(idHorario))){
            hashHorario.remove(new Integer(idHorario));
            result=true;
        }//fi if
        return result;
    }//fi operacio


    /**
     *
     * @param idHorario
     * @return
     */
    @Override
    public boolean existeHorario (int idHorario){
        if(hashHorario. containsKey(new Integer(idHorario))){
            return true;
        }else return false;
    }//fi operacio


    /**
     *
     * @param idHorario
     * @return
     */
    @Override
    public Horario buscarHorario (int idHorario){
        //Busca el horario con id=idHorario y lo devuelve, sino null.
        TCtrlHorario tHor = (TCtrlHorario) hashHorario.get(new Integer(idHorario));
        Horario hor=null;
        if(tHor!=null){
            hor=tHor.tHorario;
        }//fi if
        return hor;
    }//fi operacio

    /**
     *
     * @param idHorario
     * @return
     */
    @Override
    public ArrayList<Integer> dameIdActividades(int idHorario){
       //Post: retorna una lista de idActividades del Horario con idHorario
        ArrayList<Integer> listaActividades=null;
        TCtrlHorario tHor = (TCtrlHorario) hashHorario.get(new Integer(idHorario));
        if(tHor!=null){
            if(!tHor.tActividad.isEmpty()){
                listaActividades=tHor.tActividad;
            }
        }//fi if
        return listaActividades;
    }//fi operacio

}
