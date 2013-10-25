package agendainteligente;

/**
* Descripcion: Clase CtrlEliminarAvisos gestiona la eliminacion de un aviso de una actividad
* Autor: Marc Sitges
* Ultima fecha: 11 de mayo 2009
* Relacionada con las clases:
        -CtrlDominio
*/

public class CtrlEliminarAvisos {

    /**
     *
     * @param idAviso
     * @param idA
     */
    public void eliminarAvisoDeActividad(int idAviso, int idA){

        CtrlDominio3 controladorDeDominio = new CtrlDominio3();

        /* llamamos a la la operacion del controlador de dominio*/
        controladorDeDominio.eliminarAvisoDeActividad(idAviso, idA);

    }//fin operacion

}
