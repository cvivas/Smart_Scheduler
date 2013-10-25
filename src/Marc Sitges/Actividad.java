/*
* Classe Actividad abstracta para poder trabajar desde la CtrlActividad con ella
* independientemente de la subclase que se cree.
*/
/*
* Descripcion: Clase Actividad
* Autor: Marc Sitges
* Ultima data: 22 d'abril 2009
* Relacionada con las clases: 
        -CtrlActivitat
*/

/*
 *
 * ****************************************************************
 * ************LISTA DE FUNCIONES DE LA CLASE**********************
 * ****************************************************************
 *  abstract public void modificarActividad();
 *  abstract public void modificarActividadHorario(int idHorario);
 *  abstract public void listarActividad();
 *
 *  public String getTitulo()
 *  public void modificarActividadTitulo(String titulo)
 *  public String getDescripcion() 
 *  public void modificarActividadDescripcion(String d)
 *  public int getIdActividad()
 *  public void setId(int id)
 *  
 *      
 */
package agendainteligente;

import java.io.Serializable;

/**
 *
 * @author UserXP
 */
abstract public class Actividad implements Serializable{

    /**
     *
     */
    protected String titulo;
    /**
     *
     */
    protected String descripcion;
    /**
     *
     */
    protected int idActividad;

    /*abstract public void modificarActividad();
    abstract public void modificarActividadHorario(int idHorario);
    abstract public void listarActividad();
    */
    /**
     *
     * @param titulo
     * @param descripcion
     * @return
     */
    abstract public Actividad crearActividad(String titulo, String descripcion);

    /**
     *
     * @return
     */
    public String getTitulo(){
        return titulo;
    }//fin operacion

    /**
     *
     * @param titulo
     */
    public void modificarActividadTitulo(String titulo){
        this.titulo=titulo;
    }//fin operacion

    /**
     *
     * @return
     */
    public String getDescripcion(){
        return descripcion;
    }//fin operacion

    /**
     *
     * @param d
     */
    public void modificarActividadDescripcion(String d){
        this.descripcion=d;
    }//fin operacion

    /**
     *
     * @return
     */
    public int getIdActividad(){
        return idActividad;
    }//fin operacion

    /**
     *
     * @param id
     */
    public void setId(int id){
        this.idActividad=id;
    }//fin operacion

     /*public void mostrarActividad (){
        System.out.print("Titulo de la Actividad: ");
        System.out.println(titulo);
        System.out.print("Descripcion de la Actividad: ");
        System.out.println(descripcion);
    }//fin operacion
*/
}//fin clase
