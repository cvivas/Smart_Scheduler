/**
* Descripcio: Operaciones propias de Horario
* Autor: Rafael D. Gracia (Grup 3)
* Ultima data: 30 d'abril 2009
* Relacionada amb les classes: CtrlHorario.java
*/
package Agenda;

import java.io.Serializable;
import java.util.Date;

abstract public class Horario implements Serializable{

    protected Date data;
    protected int idHorario;

    abstract public Horario crearHorario(Date fecha);

    public Date getData () {
        return data;
    }

    public void setData (Date val) {
        this.data = val;
    }

    public int getidHorario () {
        return idHorario;
    }

    public void setidHorario (int id) {
        this.idHorario = id;
    }

}
