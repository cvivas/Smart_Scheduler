package Agenda;

import java.io.Serializable;
import java.util.ArrayList;

/**
* Descripcion: Clase TemaActividad contiene un tema y la lista de actividades que lo tienen, compartido por grupo 1 y 2
* Autor: Cesar Nogales
* Ultima fecha: 22 d'abril 2009
* Relacionada con las clases: 
        -Tema, IntStr
*/

public class TemaActividad implements Serializable {

    Tema tema;
    ArrayList<IntStr> nombresActi;

    public TemaActividad(){

        tema=new Tema();
        nombresActi= new ArrayList<IntStr>();

    }//fin operacion
}
