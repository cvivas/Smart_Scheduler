
/**
 ** Descripcio: CtrlActividad contiene un Hashtable con las actividades
 * y una variable para asignar identificadores a las actividades.
 * @author Carlos Vivas Abilahoud
 * Ultima fecha: 24 abril 2009
 *  Relacionada con las clases: CtrlDominio, CtrlDominio2, Actividad ctrlActividad2
 */

/* 
 * ****************************************************************
 * ************LISTA DE FUNCIONES DE LA CLASE**********************
 * ****************************************************************
 * 
 *     public CtrlActividad ();
 *     public boolean insertarActividad(Actividad actividad);
 * 
 *     public boolean eliminarHorariodDeActividad(int idActividad, int idHorarios);
 *     public boolean eliminarActividad(int idActividad);
 * 
 *     public  boolean modificarActividadTitulo(int idActividad,String titulo);
 *     public  boolean modificarActividadDescripcion(int idActividad,String descripcion);
 * 
 *     public  boolean asignarHorario(int idHorario, int idActividad);
 *     public TreeSet<Integer> obtenerHorario(int idActividad);
 *
 *     public  Actividad buscarActividad(int idActividad);
 *     public Hashtable getCtrlActividad();
 *     public void setCtrlActividad(Hashtable a);
 * 
 */


package agendainteligente;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.TreeSet;



public class CtrlActividad implements Serializable{

    protected Hashtable hashAct;
    protected int indiceActividad;

    public CtrlActividad (){
    /*Creadora de CtrlActividad*/

        this.hashAct = new Hashtable();
        indiceActividad = 0;
    
    }//fin operacion

    @SuppressWarnings("unchecked")
    public boolean insertarActividad(Actividad actividad){
         /* Dado una Actividad, la almacena en el hashtable del ctrlActividad
          * nota:no hace comprobaciones, solo inserta.
          */
        indiceActividad++;
       // int h = actividad.hashCode();
        int h = indiceActividad;
        boolean asignado=false;
        if (actividad !=null){
            TCtrlAct tact = new TCtrlAct();
            tact.tAct=actividad;
            tact.tHorario=new TreeSet<Integer> ();
            tact.tAct.setId(h);
            hashAct.put(new Integer(h), tact);
            asignado = true;
        }
        return asignado;

    }



/*xaxi*/
    public boolean eliminarHorariodDeActividad(int idActividad, int idHorario){
    /*dado un idActividad y un idHorario, elimina el idHorario del conjunto de
     *Horarios de una Actividad y devuelve cierto si ha eliminado y falso
     * en el caso de no haber eliminado (porque no estaba presente)
    */
        boolean eliminados=false;
        TreeSet<Integer> TShorarios=obtenerHorarios(idActividad);

        if(!TShorarios.isEmpty()){

            eliminados = TShorarios.remove(new Integer(idHorario));

        }//fin if
        
        return eliminados;
    }//fin operacion


   /*Es xaxi*/
    public boolean eliminarActividad(int idActividad){
    /*elimina por completo una actividad sacandola de la tabla de hash*/

        boolean eliminado = hashAct.containsKey(new Integer(idActividad));
        hashAct.remove(new Integer(idActividad));
        return eliminado;

    }//fin operacion


    /*es xaxi*/
    public  boolean modificarActividadTitulo(int idActividad,String titulo){
        /*modifica el titulo de una actividad y lo reemplaza por titulo*/

        Actividad act = buscarActividad(idActividad);

        if(act!=null){

            act.modificarActividadTitulo(titulo);

        }//fin if

            return act==null;
    }//fin operacion


        /*es xaxi*/
    public  boolean modificarActividadDescripcion(int idActividad,String descripcion){
            /*modifica la descripcion de una actividad*/

        Actividad act = buscarActividad(idActividad);

        if(act!=null){

            act.modificarActividadDescripcion(descripcion);

        }//fin if

        return (act==null);

    }//fin operacion


/*xaxi*/
    public  boolean asignarHorario(int idHorario, int idActividad){
        /*asigna un horario con id=idHorario a una actividad*/

        TCtrlAct tact = (TCtrlAct) hashAct.get(new Integer(idActividad)) ;
        boolean asignado=false;

        if (tact != null && tact.tAct!= null && tact.tAct.getIdActividad()==idActividad
                &&!tact.tHorario.contains(new Integer (idHorario)) ){

                if (tact.tHorario==null){

                    tact.tHorario=new TreeSet<Integer> ();

                }//fin if

            tact.tHorario.add(idHorario);
            asignado = true;

        }//fin if

        return (asignado);
    }//fin operacion


    /*es xaxi*/
    public  Actividad buscarActividad(int idActividad){
        /* Operacion buscarActividad devuelve una Actividad si existe,
         * sino devuelve null */

        TCtrlAct tact = (TCtrlAct) hashAct.get(new Integer(idActividad)) ;
        Actividad act = null;

        if (tact!=null) {

            act = tact.tAct;

        }//fin if

        return act;

    }//fin operacion


    /*Es xaxi*/
    public TreeSet<Integer> obtenerHorarios(int idActividad){
    /*Devuelve los horarios de la actividad con id = idActividad*/

        TCtrlAct tact = (TCtrlAct) hashAct.get(new Integer(idActividad)) ;
        TreeSet<Integer> thorario = null;

        if (tact!=null ) {

            thorario = tact.tHorario;

        }//fin if

        return thorario;

    }//fin operacion




    public Hashtable getCtrlActividad() {
		return hashAct;
	}//fin operacion


    public void setCtrlActividad(Hashtable a) {
	 hashAct=a;
	}//fin operacion



}//fin clase
