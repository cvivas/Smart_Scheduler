/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agendainteligente;

import java.util.Date;


/**
 * Descripcion: Empaqueta ids de actividad, titulo y idhorario
 * Autor: Carlos Vivas
 * Fecha: 29/06/2009
 */

public class TCtrlListar {

     private int idAct;
     private Date fechaAviso;
     private String titulo;

    /**
     * @return the idAct
     */
    public int getIdAct() {
        return idAct;
    }

    /**
     * @param idAct the idAct to set
     */
    public void setIdAct(int idAct) {
        this.idAct = idAct;
    }


    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @return the fechaAviso
     */
    public Date getFechaAviso() {
        return fechaAviso;
    }

    /**
     * @param fechaAviso the fechaAviso to set
     */
    public void setFechaAviso(Date fechaAviso) {
        this.fechaAviso = fechaAviso;
    }

}
