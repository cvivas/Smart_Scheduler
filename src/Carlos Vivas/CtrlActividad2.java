
package agendainteligente;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Hashtable;

/**
 ** Descripcion: CtrlActividad2 en esta clase se guardaran los temas
 *  con sus actividades asociadas y permitira la asignacion y desasignacion
 *  de temas de estas
 *  Autor: Carlos Vivas
 *  Relacionada con las clases: Tema y Actividad
 * Ultima modificacion: 24-4-2009
 */

public class CtrlActividad2 extends CtrlActividad implements Serializable{

    protected Hashtable actividadTema  = new Hashtable();

   
/*Asigna un tema a una actividad concreta*/
public boolean asignarTemaActividad(Tema t, int idActividad){

      boolean exito=false;
      Actividad act = buscarActividad(idActividad);
      if(act!=null){
          TCtrlAct2 temp=new TCtrlAct2();
          temp=(TCtrlAct2)actividadTema.get(idActividad);
          if(temp==null){
              temp.arrayTema=new ArrayList<Tema>();
              temp.arrayTema.add(t);
              actividadTema.put(idActividad,temp);
          }
          else if(!temp.arrayTema.contains(t)){
            temp.arrayTema.add(t);
          }//Fin if
          exito=true;
      }//fin if
      return exito;
}//Fin operacion


/*Desasigna un tema de una actividad*/
public boolean desasignarTemaActividad(int idActividad,Tema tema){

        boolean resultado=false;
        Actividad act = buscarActividad(idActividad);
        if(act!=null){
            TCtrlAct2 TemasActualizados=new TCtrlAct2();
            TemasActualizados=(TCtrlAct2)actividadTema.get(idActividad);
            //if(TemasActualizados.arrayTema != null){
                resultado= TemasActualizados.arrayTema.remove(tema);
                return resultado;
            //} //fin if
        }//Fin if
        return resultado;
}//Fin operacion


   /*elimina por completo una actividad sacandola de la tabla */
 public boolean eliminarActividad(int idActividad){
 
       super.eliminarActividad(idActividad);
        boolean eliminado = actividadTema.containsKey(new Integer(idActividad));
        actividadTema.remove(new Integer(idActividad));
        return eliminado;

    }//fin operacion

/*Devuelve una lista de temas insertados*/
public ArrayList<Tema> obtenerTemas(int idActividad){

        Actividad act = buscarActividad(idActividad);
        if(act != null){
            TCtrlAct2 temasRecuperados;
            temasRecuperados=(TCtrlAct2)actividadTema.get(idActividad);//MODIFICADO
           return temasRecuperados.arrayTema;
        }//Fin if
        else return null;
}//Fin operacion


 public Hashtable getCtrlActividad2() {
		return actividadTema;
	}//fin operacion


    public void setCtrlActividad2(Hashtable a) {
	 actividadTema=a;
	}//fin operacion


}//Fin clase
