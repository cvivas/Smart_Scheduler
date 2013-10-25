/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agendainteligente;
import java.io.Serializable;
/**
 *descripcion: clase memorandum
 * author carlos Vivas Abilahoud
 */



public class Memorandum extends Actividad implements Serializable{

    private String texto;

    /*operacion constructora de memorandum*/
    public Memorandum() {
    }//fin operacion

    /*retorna el tipo de actividad*/
    public String obtenerTipo(){

        return "Memorandum";
    }//fin operacion

    /*operacion constructora de memorandum*/
    public Memorandum(String texto) {
        this.texto = texto;
    }//fin operacion

    
    /**
     * @return the texto
     */
    public String getTexto() {
        return texto;
    }//fin operacion

    /**
     * @param texto the texto to set
     */
    public void setTexto(String texto) {
        this.texto = texto;
    }//fin operacion

    @Override
    public Actividad crearActividad(String titulo, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    


}//fin clase
