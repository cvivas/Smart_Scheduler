
package Agenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.TreeSet;

/**
* Clase CtrlDominio2 necesaria para gestionar toda la informacion del sistema,
* incluye el controlador de temas
*/

/*
 * Descripcion: CtrlDominio2 para grupos 1,2
 * Autor: Sergi Salvador
 * Ultima actualizacion: 23 de abril 2009
 * Relacionada con las clases:
 *      -CtrlActividad2, CtrlTema,
 


 */

public class CtrlDominio2 extends CtrlDominio {


    protected static CtrlTema CT=new CtrlTema();
    protected static CtrlActividad2 CA2;

    public CtrlDominio2(){

    }


    public void cargar() throws IOException, ClassNotFoundException {
     /* Operacion cargar obtiene todos los listados de las controladoras
      de los ficheros de la carpeta /object y los carga en las controladoras*/
        super.cargar();
        Object obj1 = gestor.cargar("objects/tema.obj");
        CT.setCtrlTema((ArrayList) obj1);
        Object obj2 = gestor.cargar("objects/actividadtema.obj");
        CA2.setCtrlActividad2((Hashtable) obj2);

    }//fin operacion

    public void guardar() throws IOException {
       /* Operacion guardar obtiene todos los listados de las controladoras
       y los guarda para no perder los cambios al cerrar el programa*/

        super.guardar();
        gestor.guardar(CT.getCtrlTema(), "objects/tema.obj");
        gestor.guardar(CA2.getCtrlActividad2(),"objects/actividadtema.obj");


    }//fin operacion
  public void asignarCtrlActividadPropio(CtrlActividad2 control) {
      /* Operacion asigna el CtrlActividad al dominio, en el main cada uno crea el suyo */
		CA2=control;
        CA=(CtrlActividad)control;
	}//fin operacion


public boolean crearTema(String nombre){
    /*Operacion crearTema generica creara un tema en el sistema*/
    boolean encontrado=false;
    Tema t;
    t=CT.ObtenerTema(nombre);
    if (t!=null){encontrado=true;}
    return encontrado;

}//fin operacion

public boolean crearTema( String nomT, String nomA, int id){
     /* Operacion se llamara desde el CtrlCrearTema y creara un tema en el sistema.
      La Actividad guardara el tema creado, y la CtrlTema se actualizara con el
      nuevo tema y guardara informacion de la actividad para un futuro listado */
    boolean encontrado=false;
    Tema t;
    t=CT.ObtenerTema(nomT);
    if (t!=null){
    CT.anadirTema(nomT, nomA, id);
    CA2.asignarTemaActividad(t, id);
    }
    return encontrado;

}//fin operacion

public boolean eliminarTema( String nombre){
     /* Operacion eliminarTema generica eliminara el tema del sistema si este
      no tiene actividades que lo usen */

    return CT.eliminarTema(nombre);

}//fin operacion

public boolean eliminarTema( String nomT, int id){
     /* Operacion se llamara desde el CtrlEliminarTema y eliminara el tema del
      sistema si este no tiene actividades que lo usen.
      La Actividad eliminara el tema de su listado, y el CtrlTema se actualizara
      quitando la informacion de la actividad para un futuro listado*/
    boolean encontrado=false;
    Tema t;
    t=CT.quitarTema(nomT, id);
    if (t!=null){
    encontrado=CA2.desasignarTemaActividad(id, t);
    }
    return encontrado;
}//fin operacion


public boolean eliminarActividad(int idA) {
/* Elimina una actividad identificada por idA del CtrlActividad, y su relacion con temas*/
        TreeSet<Integer> horarios;
        horarios= CA2.obtenerHorarios(idA);
        while ( !horarios.isEmpty()){
            Integer actual = horarios.first();
            CH.borrarActividad(idA, actual);
            horarios.remove(actual);
        }//fin while

        ArrayList<Tema> temas;
        temas=CA2.obtenerTemas(idA);
        Iterator<Tema> it1= temas.iterator();
        while (it1.hasNext()){
            Tema actual = it1.next();
            CT.quitarTema(actual.getNom(), idA);
        }//fin while
        return CA2.eliminarActividad(idA);
    }//fin operacion


}//fin clase
