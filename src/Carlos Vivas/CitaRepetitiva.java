

package agendainteligente;
import java.io.*;
import java.util.Date;

/**
 *  descripcion: clase citarepetitiva que tendra varios horarios asociados
 * author Carlos Vivas Abilahoud
 *  *  Grup 4
 *  Subgrup 1
 */
public class CitaRepetitiva extends Cita implements Serializable  {

    private int periodicidad; // 1:diaria, 2:semanal 3:mensual 4:anual
    private Date finPeriodicidad;
    private Date inicioPeriodicidad;

    /*retorna el tipo de actividad*/
    public String obtenerTipo(){

        return "CitaRepetitiva";
    }//fin operacion

    /*operacion constructora de cita repetitiva*/
    public CitaRepetitiva(int periodicidad) {
        this.periodicidad = periodicidad;
        super.setRepetitiva(true);
    }//fin operacion

    /*operacion constructora de cita repetitiva*/
    public CitaRepetitiva() {
        this.periodicidad =0;
        super.setRepetitiva(false);
    }//fin operacion

    

    /**
     * @return the periodicidad
     */
    public int getPeriodicidad() {
        return periodicidad;
    }//fin operacion

    /**
     * @param periodicidad the periodicidad to set
     */
    public void setPeriodicidad(int periodicidad) {
        this.periodicidad = periodicidad;
    }//fin operacion

    /**
     * @return the fin_periodicidad
     */
    public Date getFinPeriodicidad() {
        return finPeriodicidad;
    }//fin operacion

    /**
     * @param finPeriodicidad the finPeriodicidad to set
     */
    public void setFinPeriodicidad(Date finPeriodicidad) {
        this.finPeriodicidad = finPeriodicidad;
    }//fin operacion

    /**
     * @return the inicioPeriodicidad
     */
    public Date getInicioPeriodicidad() {
        return inicioPeriodicidad;
    }

    /**
     * @param inicioPeriodicidad the inicioPeriodicidad to set
     */
    public void setInicioPeriodicidad(Date inicioPeriodicidad) {
        this.inicioPeriodicidad = inicioPeriodicidad;
    }

}//fin clase
