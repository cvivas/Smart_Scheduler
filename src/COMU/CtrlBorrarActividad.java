
package Agenda;

/**
 * Descripcion: Controlador del caso de uso de borrarActivitad
 * Autor: Marc Sitges
 * Ultima actualizacion: 19 de abril 2009
 * Relacionada con las clases:
 *      -CtrlDominio
 *
 */
/*Es xaxi*/
import java.io.Serializable;

public class CtrlBorrarActividad implements Serializable{

public void borrarActividad (int idA) {
    /*Operacion que llama a la capa de dominio para aplicar el caso de uso de
     *borrar una actividad*/

    CtrlDominio controladorDeDominio =  new CtrlDominio();

    /* llamamos a la la operacion del controlador de dominio*/
    controladorDeDominio.eliminarActividad(idA);


    }
}
