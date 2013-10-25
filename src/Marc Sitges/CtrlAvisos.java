

package agendainteligente;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
/*
 * Descripcio: Controlador de Avisos, es como el controlador de horarios pero con
 * algunos cambios a niveles de nombres para poder crear avisos.
 * author Marc Sitges
 *
 */



/**
 *
 * @author UserXP
 */
public class CtrlAvisos implements Serializable {

    private Hashtable hashAvisos;
    private int indiceAviso;
    /*operacion constructora de Avisos*/
    /**
     *
     */
    public CtrlAvisos(){

        hashAvisos= new Hashtable();
        indiceAviso=0;
    }//fin operacion

    /**
     *
     * @param aviso
     * @param idActividad
     * @return
     */
    public boolean insertarAviso(Aviso aviso, int idActividad){
    /* Dado un Aviso, la almacena en el hashtable */
    /*faltaria anadir las actividades pero no hay tiempo, se hara
     para la tercera entrega*/

        this.indiceAviso++;
        int a = getIndiceAviso();
        boolean asignado=false;
        if (aviso !=null){
            TCtrlAviso tav = new TCtrlAviso();
            tav.tAviso=aviso;
            tav.tActividad=new ArrayList<Integer> ();
            tav.tActividad.add(new Integer(idActividad));
            tav.tAviso.setIdAviso(a);
            hashAvisos.put(new Integer(a), tav);
            asignado = true;
        }
        return asignado;

      }

    /**
     *
     * @param fecha
     * @param idActividad
     * @param titulo
     * @return
     */
    public int crearAviso(Date fecha, int idActividad,String titulo) {

        Aviso avis = new Aviso();
        avis.setFechaAviso(fecha);
        avis.setTextoAviso(titulo);
        insertarAviso(avis,idActividad);
        return avis.getIdAviso();
    }



    /*operacion que elimina un aviso*/
    /**
     *
     * @param idAviso
     * @return
     */
    public boolean eliminarAviso(int idAviso) {

        boolean result=false;
        /*buscamos el id de aviso en su hash, si esta lo borramos y avisamos
         que se ha borrado*/
        if(hashAvisos.containsKey(new Integer(idAviso))){

            hashAvisos.remove(new Integer(idAviso));
            result=true;
        }//fin if

        return result;
    }//fin operacion

    /**/
    /**
     *
     * @param idAviso
     * @return
     */
    public Aviso buscarAvisos(int idAviso){
        //Busca el horario con id=idHorario y lo devuelve, sino null.
        TCtrlAviso tav = (TCtrlAviso) hashAvisos.get(idAviso);
        Aviso avi=null;
        if(tav!=null){
            avi=tav.tAviso;
        }//fin if
        return avi;
    }//fin operacion

    /**
     *
     * @param idActividad
     * @param idAviso
     * @return
     */
    public boolean asignarActividad(int idActividad, int idAviso) {
        //inserta la actividad con id=idActividad al Arralist de el Horario con id=idHorario
        //Pre existe el Horario con id=idHorario
        boolean result=false;
        TCtrlAviso tav = (TCtrlAviso) hashAvisos.get(idAviso);
        if(tav!=null){
            if (!existeActividadEnHorarioAviso(tav.tActividad, idActividad)){
                 ArrayList<Integer> tAct=tav.tActividad;
                 tAct.add(idAviso);
                 result=true;
            }//fin if2
        }//fin if1
        return result;
    }//fin operacion
    
    /**
     *
     * @param tActividad
     * @param idActividad
     * @return
     */
    public boolean existeActividadEnHorarioAviso(ArrayList<Integer> tActividad, int idActividad) {
        boolean result=false;
        result=tActividad.contains(idActividad);
        return result;
    }//fin operacion

    /**
     *
     * @param idActividad
     * @param idAviso
     */
    public void borrarActividad(int idActividad, int idAviso){
    /*
     * Pre: idActividad existe dentro de Aviso
     * Post: se borra el id idActividad del Aviso
     */
        TCtrlAviso tav = (TCtrlAviso) hashAvisos.get(new Integer(idAviso));
        if(tav!=null){
            if (existeActividadEnHorarioAviso(tav.tActividad, idActividad)){

                tav.tActividad.remove(new Integer(idActividad));
                if (tav.tActividad.isEmpty()){eliminarAviso(idAviso);}
            }//fin if2
        }//fin if1
    }//fin operacion

    /**
     *
     * @param idAviso
     * @return
     */
    public ArrayList<Integer> dameIdActividades(int idAviso){
   //retorna una lista de idActividades del aviso con idAviso
        ArrayList<Integer> listaActividades=null;
        TCtrlAviso tav = (TCtrlAviso) hashAvisos.get(idAviso);
        if(tav!=null){
            listaActividades=tav.tActividad;
        }//fin if
        return listaActividades;
    }//fin operacion

    /**
     *
     * @return
     */
    public Hashtable getCtrlHorarioAviso() {
		return hashAvisos;
	}//fin operacion

    /*operacion que dada una data, obtenemos su id*/
    /**
     *
     * @param data
     * @return
     */
    public ArrayList<Integer> obtenerIdAviso(Date data){

        ArrayList<Integer> listaAv = new ArrayList<Integer>() ;
        @SuppressWarnings("unchecked")
        Enumeration<TCtrlAviso> enu = hashAvisos.elements();
        TCtrlAviso elemento = null;
        boolean hayAlgo=false;
        while(enu.hasMoreElements()){
            elemento = enu.nextElement();
            if(fechasIguales(data,elemento.tAviso.getFechaAviso())){
                listaAv.add(new Integer(elemento.tAviso.getIdAviso()));
                hayAlgo = true;
            }
        }

        if (!hayAlgo)return null;
        return listaAv;
    }
    private boolean fechasIguales(Date dataH, Date data0) {

        return (dataH.getDate() == data0.getDate() && dataH.getMonth() == data0.getMonth()
                && dataH.getYear() == data0.getYear());
    }
    /**
     *
     * @param a
     */
    public void setCtrlHorarioAviso(Hashtable a) {
	 hashAvisos=a;
	}//fin operacion

    /**
     *
     * @param idAviso
     * @param fechaN
     */
    public void modificarAviso(int idAviso, Date fechaN){

        TCtrlAviso tAv = (TCtrlAviso) hashAvisos.get(idAviso);
        tAv.tAviso.setFechaAviso(fechaN);
    }

    /**
     * @return the indiceAviso
     */
    public int getIndiceAviso() {
        return indiceAviso;
    }

    /**
     * @param indiceAviso the indiceAviso to set
     */
    public void setIndiceAviso(int indiceAviso) {
        this.indiceAviso = indiceAviso;
    }

}
