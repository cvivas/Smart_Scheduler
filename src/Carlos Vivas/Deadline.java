package agendainteligente;


import java.util.Date;
import java.io.*;

/**
 * Descripcion: Operaciones de la actividad Deadline
 * author Carlos Vivas 
 *  
 */




public class Deadline extends Actividad implements Serializable{

    private Date fecha_Final;
    private Date fecha_Inicio;
    private int num_Horas;
    private int prioridad;
    private int horasMin;
    private int horasMax;
    private boolean es_laboral;

    
    /*operacion constructora de deadline*/
    public Deadline(Date fecha_Final, int num_Horas, int prioridad) {
        this.fecha_Final = fecha_Final;
        this.num_Horas = num_Horas;
        this.prioridad = prioridad;
    }//fin operacion

    /*operacion constructora de deadline*/
    public Deadline(){
        
    }//fin operacion

    /*inserta la fecha a partir de la cual se quiere hacer el deadline*/
    public void setFechaInicio(Date d){
        this.fecha_Inicio=d;
    }//fin operacion

    /*Devuelve la fecha de inicio*/
    public Date getFechaInicio(){
        return fecha_Inicio;
    }//fin operacion

    /*set del minimo de horas por dia*/
    public void setHorasMin(int h){
        this.horasMin=h;
    }//fin operacion

    /*get del minimo de horas por dia*/
    public int getHorasMin(){
        return horasMin;

    }//fin operacion

    /*set del maximo de horas por dia*/
    public void setHorasMax(int h){
        this.horasMax=h;
    }//fin operacion

    /*get del maximo de horas por dia*/
    public int getHorasMax(){
        return horasMax;
    }//fin operacion

    //Pre: h es menos que el maximo de integer y mayor que 0
    void setHoras(int h)
    {   //funcion que comprueba si hay horas suficientes
        //hasta la fecha del deadline
        this.num_Horas=h;
    }//fin operacion

    //Pre: p es un valor entre 1 y 4
    void setPrioridad(int p)
    {
        this.prioridad=p;
    }//fin operacion

    //Pre: f es posterior o igual al dia actual
    void setFinal(Date f)
    {
        this.fecha_Final=f;
    }//fin operacion


    Date getFechaFinal()
    {
        return(this.fecha_Final);
    }//fin operacion

    int getPrioridad()
    {
        return(this.prioridad);
    }//fin operacion

    int getNumHoras()
    {
        return(this.num_Horas);
    }//fin operacion

    /**
     * @return the es_laboral
     */
    public boolean isEsLaboral() {

        return es_laboral;
    }//fin operacion

    /**
     * @param es_laboral the es_laboral to set
     */
    public void setEsLaboral(boolean es_laboral) {

        this.es_laboral = es_laboral;
    }//fin operacion

    @Override
    public Actividad crearActividad(String titulo, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    public String obtenerTipo(){

        return Constantes.DEADLINE;
    }//fin operacion



    //Funcion que guarda el deadline en disco

    //Funcion que elimina el deadline del disco



}
