/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agenda;

/**
 * Descripcion: Controlador de caso de uso de crear horario
 * Autor: David Pons Belda
 * Ultima actualizacion: 20 de abril 2009
 * Relacionada con las clases:
 *      -CtrlDominio
 */

import java.util.Date;

/* s ha de modificar*/
//Solo puedes crear un horario si le pasas una actividad entonces al crearla le pasaras el id tb
abstract public class CtrlCrearHorario{

    abstract public void crearHorario(Date fecha, int idActividad);


}//fi classe
