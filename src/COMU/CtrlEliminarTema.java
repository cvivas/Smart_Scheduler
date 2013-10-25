package Agenda;

/**
* Descripcion: Clase CtrlEliminarTema gestiona la eliminacion de temas, compartido por grupo 1 y 2
* Autor: Cesar Nogales
* Ultima fecha: 22 d'abril 2009
* Relacionada con las clases:
        -CtrlDominio2
*/

public class CtrlEliminarTema {

    CtrlDominio2 controladorDeDominio =  new CtrlDominio2();

    public void eliminarTemaGenerico (String nomT) {
     /*Operacion que llama a la capa de dominio para aplicar el caso de uso de
     *eliminar tema*/

        /* llamamos a la la operacion del controlador de dominio*/
        controladorDeDominio.eliminarTema(nomT);

    }//fin operacion

    public void eliminarTema (String nomT, int idA) {
     /*Operacion que llama a la capa de dominio para aplicar el caso de uso de
     *eliminar tema de la actividad identificada por idA*/

        /* llamamos a la la operacion del controlador de dominio*/
        controladorDeDominio.eliminarTema(nomT, idA);

    }//fin operacion
 
}
