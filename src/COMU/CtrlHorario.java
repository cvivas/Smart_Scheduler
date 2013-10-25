
package Agenda;

import java.util.ArrayList;
import java.util.Hashtable;

/**
 * Descripcion: Controlador de caso de uso del controlador de horario
 * Autor: David Pons Belda
 * Ultima actualizacion: 28 de abril 2009
 * Relacionada con las clases:
 *      -CtrlDominio, Horario
 */

public class CtrlHorario{

    protected Hashtable hashHorario;
    
	public CtrlHorario (){
        hashHorario= new Hashtable();
    }//fi operacio

	  
    public boolean eliminarHorario (int idHorario) {
        boolean result=false;
        if(hashHorario.containsKey(idHorario)){
            hashHorario.remove(idHorario);
            result=true;
        }//fi if
        return result;
    }//fi operacio


    public boolean existeHorario (int idHorario){
        if(hashHorario. containsKey(idHorario)){
            return true;
        }else return false;
    }//fi operacio


    public Horario buscarHorario (int idHorario){
        //Busca el horario con id=idHorario y lo devuelve, sino null.
        TCtrlHorario tHor = (TCtrlHorario) hashHorario.get(idHorario);
        Horario hor=null;
        if(tHor!=null){
            hor=tHor.tHorario;
        }//fi if
        return hor;
    }//fi operacio


	public boolean asignarActividad (int idActividad, int idHorario) {
        //Añade la actividad con id=idActividad al Arralist de el Horario con id=idHorario
        //Pre existe el Horario con id=idHorario
        boolean result=false;
        TCtrlHorario tHor = (TCtrlHorario) hashHorario.get(idHorario);
        if(tHor!=null){
            if (!existeActividadEnHorario(tHor.tActividad, idActividad)){
                 ArrayList<Integer> tAct=tHor.tActividad;
                 tAct.add(idHorario);
                 result=true;
            }//fi if2
        }//fi if1
        return result;
    }//fi operacio


    public boolean existeActividadEnHorario(ArrayList<Integer> tActividad, int idActividad) {
        boolean result=false;
        result=tActividad.contains(idActividad);
        return result;
    }//fi operacio

    
    public boolean borrarActividad (int idActividad, int idHorario){
    /*
     * Pre: idActividad existe dentro de Horario
     * Post: se borra el id idActividad del Horario
     */
        boolean result=false;
        TCtrlHorario tHor = (TCtrlHorario) hashHorario.get(idHorario);
        if(tHor!=null){
            if (existeActividadEnHorario(tHor.tActividad, idActividad)){
                tHor.tActividad.remove(idActividad);
                result=true;
            }//fi if2
        }//fi if1
        return result;
    }//fi operacio


   public ArrayList<Integer> dameIdActividades(int idHorario){
       //Post: retorna una lista de idActividades del Horario con idHorario
        ArrayList<Integer> listaActividades=null;
        TCtrlHorario tHor = (TCtrlHorario) hashHorario.get(idHorario);
        if(tHor!=null){
            listaActividades=tHor.tActividad;
        }//fi if
        return listaActividades;
    }//fi operacio


    public Hashtable getCtrlHorario() {
		return hashHorario;
	}//fi operacio


    public void setCtrlHorario(Hashtable a) {
	 hashHorario=a;
	}//fi operacio
    
}//fi classe
