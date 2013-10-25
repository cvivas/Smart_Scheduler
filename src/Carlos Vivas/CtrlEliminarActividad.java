/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agendainteligente;

import java.util.Date;

/**
 *
 * author carlos
 */
public class CtrlEliminarActividad {

        CtrlAgenda CA = new CtrlAgenda();

    public void eliminarActividadTodo(int idActividad){

        CA.eliminarActividad(idActividad);

    }
    public void eliminarActividadDia(int idAct, Date fecha){

        CA.eliminarActividadDia(idAct,fecha);
    }
    public void eliminarActividadFranja(int idAct, Date inicio, Date fin){

        CA.eliminarActividadFranja(idAct,inicio,fin);
    }

    public int exsisteHorarioOcupado(int idAct, int hIni, int hFin, Date fecha){


        /*
         *todo lo que hay entre  hini y hora fi
         * si es deadline o en mente, realocarlo
         * si es cita, eliminar esa instancia (si es repetitiva, + su aviso si tiene )
         * si es cita no repetitiva, eliminar del todo la cita. 
         */



    return 2;
    }

}
