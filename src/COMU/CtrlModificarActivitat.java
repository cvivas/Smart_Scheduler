/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agenda;

/**
 * Descripcion: Controlador de caso de uso de modificar actividad
 * Autor: Xavier Oró Gay
 * Ultima actualizacion: 20 de abril 2009
 * Relacionada con las clases:
 *      -CtrlDominio
 */
import java.io.Serializable;


public class CtrlModificarActivitat implements Serializable{

    CtrlDominio controladorDeDominio = new CtrlDominio();

    
    public  void modificarActividadTitulo(int id,String titulo){
        controladorDeDominio.modificarActividadTitulo(id, titulo);
    }//fin operacion
    
    public  void modificarActividadDescripcion(int id,String descripcion){
        controladorDeDominio.modificarActividadDescripcion(id, descripcion);
    }//fin operacion
    

}
