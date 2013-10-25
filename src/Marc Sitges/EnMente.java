

package agendainteligente;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * author Marc Sitges
 */
public class EnMente extends Actividad implements Serializable{

    private int prioridad;
    private int nHoras;
    private boolean es_laboral;
    private Date fechaInicio;
    private int horasHechas;
    private int slotMin;
    private int slotMax;
    /* operacion constructora de EnMente*/
    /**
     *
     * @param prioridad
     * @param nHoras
     */
    public EnMente(int prioridad, int nHoras) {
        this.prioridad = prioridad;
        this.nHoras = nHoras;
    }//fin operacion

    /*retorna el tipo de actividad*/
    /**
     *
     * @return
     */
    public String obtenerTipo(){

        return Constantes.ENMENTE;
    }//fin operacion

    /*operacion constructora de EnMente*/
    /**
     *
     */
    public EnMente(){

        nHoras = 0;
        es_laboral = false;
        horasHechas = 0;
    }//fin operacion

    /* operacion de obtencion de la prioridad*/
    /**
     *
     * @return
     */
    public int getPrioridad(){

        return prioridad;
    }//fin operacion

    /* operacion de asignacion de la prioridad*/
    /**
     *
     * @param prio
     */
    public void setPrioridad(int prio){

        prioridad=prio;
    }//fin operacion

    /* operacion de obtencion del numero de horas de las horas*/
    /**
     *
     * @return
     */
    public int getNHoras(){

        return nHoras;
    }//fin operacion

    /* operacion de asignacion de las horas*/
    /**
     *
     * @param horas
     */
    public void setNHoras(int horas){

        /*conficional para comprobar que hemos asignado un numero de horas positivo*/
        //if(horas<0)System.out.println("Las horas tienen que tener un valor superior o igual a 0");

        //else nHoras=horas;
        nHoras = horas;
    }//fin operacion

    /**
     * @return the es_laboral
     */
    public boolean isEs_laboral() {
        return es_laboral;
    }

    /**
     * @param es_laboral the es_laboral to set
     */
    public void setEs_laboral(boolean es_laboral) {
        this.es_laboral = es_laboral;
    }//fin operacion

    /**
     *
     * @param titulo
     * @param descripcion
     * @return
     */
    @Override
    public Actividad crearActividad(String titulo, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    /**
     * @return the horasHechas
     */
    public int getHorasHechas() {
        return horasHechas;
    }

    /**
     * @param horasHechas the horasHechas to set
     */
    public void setHorasHechas(int horasHechas) {
        this.horasHechas = horasHechas;
    }

    /**
     * @return the slotMin
     */
    public int getSlotMin() {
        return slotMin;
    }

    /**
     * @param slotMin the slotMin to set
     */
    public void setSlotMin(int slotMin) {
        this.slotMin = slotMin;
    }

    /**
     * @return the slotMax
     */
    public int getSlotMax() {
        return slotMax;
    }

    /**
     * @param slotMax the slotMax to set
     */
    public void setSlotMax(int slotMax) {
        this.slotMax = slotMax;
    }

    /**
     * @return the fechaInicio
     */
    public Date getFechaInicio() {
        return fechaInicio;
    }

    /**
     * @param fechaInicio the fechaInicio to set
     */
    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }
 }  //fin clase




