



package Agenda;

import java.io.Serializable;
/**
 ** Descripcio: IntStr es una tupla que contiene el identificador de una actividad y su nombre
 *  Autor: Raul Serna
 *  Ultima actualizacion:30 de abril 2009
 *  Relacionada con las clases: CtrlActividad

 */
public class IntStr implements Serializable {
    int idAct;
    String titAct;
    public IntStr(){
     /*Operacion Constructora inicializa la clase*/
        titAct=new String();
    }
}
