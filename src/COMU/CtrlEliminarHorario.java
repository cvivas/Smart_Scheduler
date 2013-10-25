package Agenda;

/**
* Descripcion: Clase CtrlEliminarHorario gestiona la eliminacion de un horario de una actividad
* Autor: Cesar Nogales
* Ultima fecha: 22 d'abril 2009
* Relacionada con las clases:
        -CtrlDominio
*/

public class CtrlEliminarHorario {

    public void eliminarHorarioDeActividad(int idH, int idA){
   
        CtrlDominio controladorDeDominio = new CtrlDominio();

        /* llamamos a la la operacion del controlador de dominio*/
        controladorDeDominio.eliminarHorarioDeActividad(idH, idA);

    }//fin operacion

}
