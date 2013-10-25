

package Agenda;

import java.io.IOException;
import java.util.Hashtable;
import java.util.TreeSet;
/**
* Clase CtrlDominio necesaria para gestionar toda la informacion del sistema

 * Descripcion: Controlador
 * Autor: Sergi Salvador
 * Ultima actualizacion: 21 de abril 2009
 * Relacionada con las clases:
 *      -CtrlActividad, CtrlTema, CtrlHorari

 */

public class CtrlDominio {

    protected static GestionDatos gestor=new GestionDatos();
    protected static CtrlActividad CA;
    protected static CtrlHorario CH;

    public CtrlDominio(){
       
    }


    public void cargar() throws IOException, ClassNotFoundException {
     /* Operacion cargar obtiene todos los listados de las controladoras
      de los ficheros de la carpeta /object y los carga en las controladoras*/
        Object obj2 = gestor.cargar("objects/horario.obj");
        CH.setCtrlHorario((Hashtable) obj2);
        Object obj3 = gestor.cargar("objects/actividad.obj");
        CA.setCtrlActividad((Hashtable) obj3);
        
    }//fin operacion

    public void guardar() throws IOException {
      /* Operacion guardar obtiene todos los listados de las controladoras
       y los guarda para no perder los cambios al cerrar el programa*/

        gestor.guardar(CH.getCtrlHorario(), "objects/horario.obj");
        gestor.guardar(CA.getCtrlActividad(), "objects/actividad.obj");
    }//fin operacion

    public void asignarCtrlActividadPropio(CtrlActividad control) {
      /* Operacion asigna el CtrlActividad al dominio, en el main cada uno crea el suyo */
		CA=control;
	}//fin operacion

    public void asignarCtrlHorarioPropio(CtrlHorario control) {
      /* Operacion asigna el CtrlHorario al dominio, en el main cada uno crea el suyo */
		CH=control;
	}//fin operacion

     
    public boolean eliminarActividad(int idA) {
     /* Elimina una actividad identificada por idA del CtrlActividad*/
        TreeSet<Integer> horarios;
        horarios= CA.obtenerHorarios(idA);
        while ( !horarios.isEmpty()){
            Integer actual = horarios.first();
            CH.borrarActividad(idA, actual);
            horarios.remove(actual);
        }//fin while
        return CA.eliminarActividad(idA);
    }//fin operacion


    public boolean eliminarHorarioDeActividad(int idH, int idA) {

        CH.borrarActividad(idA, idH);
       return CA.eliminarHorariodDeActividad(idA, idH);
    }//fin operacion

    
    public  boolean modificarActividadTitulo(int id,String titulo){
         return CA.modificarActividadTitulo(id, titulo);
    }//fin operacion
    
    public  boolean modificarActividadDescripcion(int id,String descripcion){
       return CA.modificarActividadDescripcion(id, descripcion);
    }//fin operacion
    

}//fin clase
