/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agendainteligente;

/**
 *
 * @author Carlos Vivas Abilahoud 
 */
public class TCtrlVista {
    private String titulo;
    private int idAct;
    private int color;

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

    public TCtrlVista() {
        this.idAct = Constantes.INCORRECTO;
        this.titulo = "";
        this.color=Constantes.NOCOLOR;
    }

    /**
     * @return the color
     */
    public int getColor() {
        return color;
    }

    /**
     * @param color the color to set
     */
    public void setColor(int color) {
        this.color = color;
    }


}
