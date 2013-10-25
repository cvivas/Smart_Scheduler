

package agendainteligente;
import java.io.Serializable;
import java.util.Date;
/**
 * descripcion : Clase aniversario para cumpleanyos
 * author carlos Vivas Abilahoud
 */


public class Aniversario extends Actividad implements Serializable{

    private Date fechaNacimiento;

    /*operacion creadora de aniversario*/
    public Aniversario() {
    }//fin operacion

    /*retorna el tipo de actividad*/
    public String obtenerTipo(){

        return "Aniversario";
    }//fin operacion

    /*operacion creadora de aniversario*/
    public Aniversario(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }//fin operacion

    /*operacion para calcular la edad de la persona del aniversario*/
    public int edad (Date fechaActual){

        int edad;
        edad = fechaActual.getYear() - fechaNacimiento.getYear();
        return edad;

    }//fin operacion
    

    /**
     * @return the fechaNacimiento
     */
    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    @Override
    public Actividad crearActividad(String titulo, String descripcion) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    

}//fin clase
