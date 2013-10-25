

package agendainteligente;
import java.io.Serializable;
import java.util.Date;

/**
 *Descripcion: clase de aviso contiene avisos.
 * author carlos Vivas Abilahoud
 */



public class Aviso implements Serializable {

    private Date fechaAviso;
    private int idAviso;
    private String textoAviso;

    public Aviso() {
    }

    public Aviso(Date fechaAviso) {
        this.fechaAviso = fechaAviso;
        this.idAviso = 0;
        this.textoAviso="";
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

    /**
     * @return the idAviso
     */
    public int getIdAviso() {
        return idAviso;
    }

    /**
     * @param idAviso the idAviso to set
     */
    public void setIdAviso(int idAviso) {
        this.idAviso = idAviso;
    }

    /**
     * @return the textoAviso
     */
    public String getTextoAviso() {
        return textoAviso;
    }

    /**
     * @param textoAviso the textoAviso to set
     */
    public void setTextoAviso(String textoAviso) {
        this.textoAviso = textoAviso;
    }


    




}
