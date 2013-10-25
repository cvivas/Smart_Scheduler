

package agendainteligente;
import java.io.*;

/**
 *
 * author Marc Sitges
 *  *  Grup 4
 *  Subgrup 1
 */

public class JornadaLaboral implements Serializable {

    private static int horaInicioJornadaLaboral;
    private static int horaFinJornadaLaboral;
    private static int horaInicioJornadaOcio;
    private static int horaFinJornadaOcio;

    /*operacion constructora de Jornada laboral*/
    /**
     *
     * @param hora_inicio_jl
     * @param hora_fin_jl
     * @param horaInicioJornadaO
     * @param horaFinJornadaO
     */
    public JornadaLaboral(int hora_inicio_jl, int hora_fin_jl, int horaInicioJornadaO, int horaFinJornadaO) {
        horaInicioJornadaLaboral = hora_inicio_jl;
        horaFinJornadaLaboral = hora_fin_jl;
        horaInicioJornadaOcio = horaInicioJornadaO;
        horaFinJornadaOcio = horaFinJornadaO;
    }//fin operacion

    /**
     *
     */
    public JornadaLaboral() {

    }//fin operacion

    /**
     * @return the horaInicioJornadaLaboral
     */
    public int getHoraInicioJornadaLaboral() {
        return horaInicioJornadaLaboral;
    }

    /**
     * @param horaInicioJornadaLab
     */
    public void setHoraInicioJornadaLaboral(int horaInicioJornadaLab) {
        horaInicioJornadaLaboral = horaInicioJornadaLab;
    }

    /**
     * @return the horaFinJornadaLaboral
     */
    public int getHoraFinJornadaLaboral() {
        return horaFinJornadaLaboral;
    }

    /**
     * @param horaFinJornadaLab
     */
    public void setHoraFinJornadaLaboral(int horaFinJornadaLab) {
        horaFinJornadaLaboral = horaFinJornadaLab;
    }

    /**
     * @return the horaIniciJornadaLucro
     */
    public int getHoraInicioJornadaOcio() {
        return horaInicioJornadaOcio;
    }

    /**
     * @param horaIniciJornadaO
     */
    public void setHoraInicioJornadaOcio(int horaIniciJornadaO) {
        horaInicioJornadaOcio = horaIniciJornadaO;
    }

    /**
     * @return the horaFinJornadaLucro
     */
    public int getHoraFinJornadaOcio() {
        return horaFinJornadaOcio;
    }

    /**
     * @param horaFinJornadaO
     */
    public void setHoraFinJornadaOcio(int horaFinJornadaO) {
        horaFinJornadaOcio = horaFinJornadaO;
    }


}//fin clase
