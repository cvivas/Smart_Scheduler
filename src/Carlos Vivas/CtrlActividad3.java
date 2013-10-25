
package agendainteligente;



import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeSet;

/**
 *  Ctrl de la actividad usado en esta practica. relaciona con avisos, horarios
 * temas, y todo lo relacionado con las actividades .
 * author carlos Vivas
 */

public class CtrlActividad3 extends CtrlActividad2 implements Serializable {

    protected Hashtable actAvisos = new Hashtable();

    public CtrlActividad3 (){

    }


    @SuppressWarnings("unchecked")
    public boolean asignarAvisoActividad(int  idAviso, int idActividad){

      boolean exito=false;
      Actividad act = buscarActividad(idActividad);
      TCtrlAct3 temp = null;
      if(act!=null){
          
          temp = (TCtrlAct3) actAvisos.get(new Integer(idActividad));

         // temp.arrayAviso=(ArrayList<Integer>)actAvisos.get(new Integer(idActividad));
          if(temp==null){
              temp.arrayAviso=new ArrayList<Integer>();
              temp.arrayAviso.add(new Integer(idAviso));
              actAvisos.put(new Integer(idActividad),temp);
          }
          else if(!temp.arrayAviso.contains(new Integer(idAviso))){
            temp.arrayAviso.add(new Integer(idAviso));
          }//fin if
          exito=true;
      }//fin if
      return exito;
}//Fin operacion

    @SuppressWarnings("unchecked")
public boolean desasignarAvisoActividad(int idActividad,int idAviso){

        boolean resultado=false;
        Actividad act = buscarActividad(idActividad);
        if(act!=null){
            TCtrlAct3 avisosActualizados= new TCtrlAct3();
            avisosActualizados.arrayAviso=(ArrayList<Integer>)actAvisos.get(idActividad);
            if(avisosActualizados.arrayAviso != null){
                resultado= avisosActualizados.arrayAviso.remove(new Integer(idAviso));
                return resultado;
            } //fin if
        }//Fin if
        return resultado;
}//Fin operacion

public boolean eliminarActividad(int idActividad){

        super.eliminarActividad(idActividad);
        boolean eliminado = hashAct.containsKey(new Integer(idActividad));
        hashAct.remove(new Integer(idActividad));
        return eliminado;
  
}//Fin operacion


public ArrayList<Integer> obtenerAvisos(int idActividad){

        Actividad act = buscarActividad(idActividad);
        if(act != null){
           TCtrlAct3 avisosRecuperados = null;
           avisosRecuperados=(TCtrlAct3)actAvisos.get(new Integer(idActividad)); //MODIFICADO
           return avisosRecuperados.arrayAviso;
        }//Fin if
        else return null;
}//Fin operacion




/*No relativo a aviso a partir de aqui*/




 public Hashtable getCtrlActividad3() {
		return actAvisos;
	}//fin operacion


    public void setCtrlActividad3(Hashtable a) {
	 actAvisos=a;
	}//fin operacion


        public int crearDeadline(String titulo, String descripcion) {
        /*Crea un deadline*/
        Actividad act = new Deadline();
        act.modificarActividadTitulo(titulo);
        act.modificarActividadDescripcion(descripcion);
        insertarEnControladorActividad(act);
        return act.getIdActividad();

    }

    public int crearMemorandum(String titulo, String descripcion) {
        /*Crea un memorandum*/
        Actividad act = new Memorandum();
        act.modificarActividadTitulo(titulo);
        act.modificarActividadDescripcion(descripcion);
        insertarEnControladorActividad(act);
        return act.getIdActividad();

    }

    public int crearAniversario(String titulo, String descripcion) {
        /*crea un aniversario*/
        Actividad act = new Aniversario();
        act.modificarActividadTitulo(titulo);
        act.modificarActividadDescripcion(descripcion);
        insertarEnControladorActividad(act);
        return act.getIdActividad();

    }


    public int crearCita(String titulo, String descripcion) {
        /*Crea una cita*/
        Actividad act = new Cita();
        act.modificarActividadTitulo(titulo);
        act.modificarActividadDescripcion(descripcion);
        insertarEnControladorActividad(act);
        return act.getIdActividad();
    }

    public int crearCitaRepetitiva(String titulo, String descripcion) {
        /*Crea una cita repetitiva*/
        Actividad act = new CitaRepetitiva();
        act.modificarActividadTitulo(titulo);
        act.modificarActividadDescripcion(descripcion);
        insertarEnControladorActividad(act);
        return act.getIdActividad();

    }


    public int crearEnMente(String titulo, String descripcion) {
        /*Crea un EnMente*/
        Actividad act = new EnMente();
        act.modificarActividadTitulo(titulo);
        act.modificarActividadDescripcion(descripcion);
        insertarEnControladorActividad(act);
        return act.getIdActividad();

    }


    public void completarAniversario(int idAct,Date fechaN) {
        /*Completa aniversario una vez creado*/
        Actividad act = buscarActividad(idAct);
        Aniversario ani = (Aniversario)act;
        ani.setFechaNacimiento((Date) fechaN.clone());

    }

    public void completarCitaRepetitiva(int idAct, boolean eslab, int per,Date fechaIniP, Date fechaP) {
        /*completa cita repetitiva una vez creada*/
        Actividad act = buscarActividad(idAct);
        CitaRepetitiva cr = (CitaRepetitiva) act;
        boolean t = true;
        cr.setRepetitiva(t);
        cr.setEsLaboral(eslab);
        cr.setPeriodicidad(per);
        cr.setInicioPeriodicidad(fechaIniP);
        cr.setFinPeriodicidad(fechaP);

    }

    public void completarDeadline(int idAct, Date fechaf, int numHores, int prio, boolean eslab,int horasMin, int horasMax, Date fechaInicio) {

        /*completa deadline una vez creado*/
        Actividad act = buscarActividad(idAct);
        Deadline d = (Deadline) act;
        d.setFinal(fechaf);
        d.setHoras(numHores);
        d.setPrioridad(prio);
        d.setEsLaboral(eslab);
        d.setHorasMin(horasMin);
        d.setHorasMax(horasMax);
        d.setFechaInicio(fechaInicio);
    }

    public void completarMemorandum(int idAct, String texto) {
        /*completa memorandum una vez creado*/
        Actividad act = buscarActividad(idAct);
        Memorandum m = (Memorandum) act;
        m.setTexto(texto);
    }


    
    public void completarCita(int idAct, boolean rep, boolean lab) {
        /*completa una cita una vez creada*/
        Actividad act = buscarActividad(idAct);
        Cita c = (Cita) act;
        c.setEsLaboral(lab);
        c.setRepetitiva(rep);


    }



    public void completarEnMente(int idAct, int prioridad, int iNHores, boolean eslab,
            int horasMin, int horasMax, Date fechaInicio) {
        /*completa un en mente una vez creado*/
        Actividad act = buscarActividad(idAct);
        EnMente e = (EnMente) act;
        e.setPrioridad(prioridad);
        e.setNHoras(iNHores);
        e.setEs_laboral(eslab);
        e.setSlotMin(horasMin);
        e.setSlotMax(horasMax);
        e.setFechaInicio(fechaInicio);

    }

    @SuppressWarnings("unchecked")
    public void insertarEnControladorActividad(Actividad act){

        insertarActividad(act);
        int h=act.getIdActividad();
        TCtrlAct2 tact2 = new TCtrlAct2();
        tact2.arrayTema = new ArrayList<Tema>();
        actividadTema.put(new Integer(h),tact2);
        TCtrlAct3 tact3 = new TCtrlAct3();
        tact3.arrayAviso = new ArrayList<Integer>();
        actAvisos.put(new Integer(h), tact3);

    }
    
    public boolean eliminarAvisodDeActividad(int idActividad, int idAviso){
    /*dado un idActividad y un idAviso, elimina el idAviso del conjunto de
     *Avisos de una Actividad y devuelve cierto si ha eliminado y falso
     * en el caso de no haber eliminado (porque no estaba presente)
    */
        boolean eliminado=false;
        int index;
        ArrayList<Integer> Avis=obtenerAvisos(idActividad);
        
        if(Avis.contains(new Integer(idAviso)) && Avis != null){
            index=Avis.indexOf(new Integer(idAviso));
            Avis.remove(index);
            eliminado=true;
        }

        return eliminado;
    }//fin operacion

    
    public int obtenerPrioridad(int idAct){
    
        int prio=-1;
        Actividad act= this.buscarActividad(idAct);
        if (act!=null){
            String tipo=act.getClass().getSimpleName();
            if (tipo.equals(Constantes.ENMENTE)){ prio = ((EnMente)act).getPrioridad();}
            if (tipo.equals(Constantes.DEADLINE)){ prio = ((Deadline)act).getPrioridad();}
        }
        return prio;
        }

    public void insertarInformacionGenerica(int idAct, String titulo, String descripcion) {

        Actividad act = buscarActividad(idAct);
        if(act!=null){
            act.modificarActividadTitulo(titulo);
            act.modificarActividadDescripcion(descripcion);
        }
    }
      
    
        
    
   
    /*operacion para listar en una arrayList todos los nombres de actividades
     con sus Ids*/

    /*tenemos un problema, para detectar el tipo de la actividad tenemos que acceder
     a la operacion obtenerTipo que son de las subclases!!! para acceder a ellas
     tendriamos que modificar una clase compartida*/
    @SuppressWarnings("unchecked")
    ArrayList<IdNombre> listarActividadEspecifica(String tipo) {

        ArrayList<IdNombre> lista=new ArrayList<IdNombre>();
        Enumeration<TCtrlAct> enu;
        enu = hashAct.elements();
        
        String tipoActividad;
        if(enu==null)return null;

            while (enu.hasMoreElements()){
                
            IdNombre estructura = new IdNombre();
            TCtrlAct actual = enu.nextElement();
            tipoActividad = actual.tAct.getClass().getSimpleName();
                if(tipoActividad.equals(tipo)){
                    estructura.idActividad = actual.tAct.getIdActividad();
                    estructura.nombre = actual.tAct.getTitulo();
                    estructura.idHorarios = actual.tHorario;
                    lista.add(estructura);
                }//fin if
            }//fin while


        return lista;
    }//fin operacion


    public int getIndiceActividad(){

        return this.indiceActividad;

    }

    public void setIndiceActividad(int iA){

        this.indiceActividad=iA;

    }

    public int obtenerHorasHechas(int idActividad) {

        Actividad a = buscarActividad(idActividad);
        EnMente e = (EnMente) a;
        return e.getHorasHechas();
    }

    @Override
        public boolean eliminarHorariodDeActividad(int idActividad, int idHorario){
    /*dado un idActividad y un idHorario, elimina el idHorario del conjunto de
     *Horarios de una Actividad y devuelve cierto si ha eliminado y falso
     * en el caso de no haber eliminado (porque no estaba presente)
    */
        boolean eliminados=false;
        TreeSet<Integer> TShorarios=obtenerHorarios(idActividad);

        if(TShorarios!=null && !TShorarios.isEmpty()){

            eliminados = TShorarios.remove(new Integer(idHorario));

        }//fin if

        return eliminados;
    }//fin operacion


  /*  public void modificarHorarioActividad(int idActividad, int idHorarioOld, int idHorarioNew){
        /*asigna un nuevo horario a una actividad*/
/*

        TCtrlAct tact = (TCtrlAct) hashAct.get(new Integer(idActividad));

        if (tact != null){

            tact.tHorario.add(idHorario);

         }//fin if

    }//fin operacion
*/

}//fin clase
