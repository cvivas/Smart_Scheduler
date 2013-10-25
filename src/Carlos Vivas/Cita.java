

package agendainteligente;

import java.io.Serializable;
import java.util.Date;


/**
 *descripcion: clase cita
 * author Carlos Vivas Abilahoud
 *    Grup 4
 *  Subgrup 1
 */
public class Cita extends Actividad implements Serializable  {
    
  

    protected boolean repetitiva;
    protected boolean esLaboral;
  //  protected Date fechaFinAct;

    /*retorna el tipo de actividad*/
    public String obtenerTipo(){

        return Constantes.CITA;
    }//fin operacion

    /*operacion creadora de cita*/
    public Cita(boolean repetitiva, boolean esLaboral) {
        this.repetitiva = repetitiva;
        this.esLaboral = esLaboral;
    }//fin operacion


    public Cita(boolean esLaboral){
        this.esLaboral=esLaboral;

    }

    public Cita() {

        this.repetitiva = false;
    }



    /**
     * @return the repetitiva
     */
    public boolean isRepetitiva() {

        return repetitiva;
    }//fin operacion

    /**
     * @param repetitiva the repetitiva to set
     */
    public void setRepetitiva(boolean repetitiva) {

        this.repetitiva = repetitiva;
    }//fin operacion

    /**
     * @param fechaFinAct the fechaFinAct to set
     */
//    public void setFechaFin(Date d) {
//        this.fechaFinAct=d;
//    }//Fin operacion
//
//     /**
//     * @return the fechaFinAct
//     */
//    public Date getFechaFin() {
//        return(this.fechaFinAct);
//    }//Fin operacion

    /**
     * @return the es_laboral
     */
    public boolean isEsLaboral() {

        return esLaboral;
    }//fin operacion

    /**
     * @param es_laboral the es_laboral to set
     */
    public void setEsLaboral(boolean es_laboral) {

        this.esLaboral = es_laboral;
    }//fin operacion

    @Override
    public Actividad crearActividad(String titulo, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }


}
