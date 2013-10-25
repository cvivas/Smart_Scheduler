/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package Agenda;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Descripcion: Tupla de CtrlHorario de un Horario y un ArrayList de id's de Actividades
 * Autor: David Pons Belda
 * Ultima actualizacion: 28 de abril 2009
 * Relacionada con las clases:
 *      -CtrlHorario
 */

 public class TCtrlHorario implements Serializable{
    Horario tHorario;
    ArrayList<Integer> tActividad;
}//fi classe
