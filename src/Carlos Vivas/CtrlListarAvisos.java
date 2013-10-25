/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Descripcion: Clase que contiene las operaciones de busqueda de avisos mediante
 * sus ids y una fechas. Interactua con las clases CtrlDominio3 y Aviso
 *
 * Autor: Carlos Vivas
 * Modificacion 28/06/2009
 */

package agendainteligente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;





public class CtrlListarAvisos {

        CtrlDominio3 control=new CtrlDominio3();
        private ArrayList<TCtrlListar>titulos=new ArrayList<TCtrlListar>();


    CtrlListarAvisos() {
    }

    /*Devuelve los ids de aviso que hay para una fecha determinada*/
    private ArrayList<Integer> obtenerIds(Date fecha){
        return control.obtenerIdAviso(fecha);
    }//fin funcion

    

     /*Dada una lista de ids de aviso, devuelve un array de avisos*/
    private ArrayList<Aviso> buscarAviso(ArrayList<Integer> ids){

        ArrayList<Aviso>aAvisos=new ArrayList<Aviso>();
        boolean insertamosAlgo=false;
        if (ids !=null){
        int tam=ids.size();
        int indiceI=0;
        Aviso a ;
            while(indiceI<tam){
              a= control.buscarAvisos(ids.get(indiceI));
              aAvisos.add(a);
              insertamosAlgo=true;
              indiceI++;
            }
        }
        if (!insertamosAlgo)return null;
        return aAvisos;
    }//fin funcion




/*Funcion que compara dos fechas*/
private boolean sonIguales(Date dataH, Date data0) {
//System.out.println("me pasan el date 1 : "+dataH+" me pasan el date 2 : "+data0);
        return (dataH.getDate() == data0.getDate() && dataH.getMonth() == data0.getMonth());
    }

private int fechaAniversario (Date d){

    Calendar c=Calendar.getInstance();
    c.setTime(d);
    int diferenciaEdad = ( ( Calendar.getInstance().get(Calendar.YEAR)) -(c.get(Calendar.YEAR)) );
    //System.out.println("iferencia de edad  "+diferenciaEdad);
    //c.set(Calendar.YEAR, c.get(Calendar.YEAR)+diferenciaEdad );
    if (c.before(Calendar.getInstance())) diferenciaEdad++;
    return diferenciaEdad;
    

}

private boolean insertarAnnoActual(Calendar c) {

    boolean cierto = false ;
    if     (c.get(Calendar.MONTH)<Calendar.getInstance().get(Calendar.MONTH)) return true;
    if ( (c.get(Calendar.MONTH)==Calendar.getInstance().get(Calendar.MONTH)) &&
            (c.get(Calendar.DAY_OF_MONTH)<Calendar.getInstance().get(Calendar.DAY_OF_MONTH))) return true;
    return cierto;

}


    /*Funcion que dada una fecha, devuelve todos los avisos que hay en esa fecha*/
    public ArrayList<TCtrlListar>getTitulos2(Date fecha){

        ArrayList<Integer>ids=obtenerIds(fecha);   //ids de aviso
        ArrayList<Aviso> aAvisos =buscarAviso(ids);//avisos
        ArrayList<TCtrlListar>titulos=new ArrayList<TCtrlListar>();
        ArrayList<Integer>id;
        boolean insertamosAlgo=false;

        if (aAvisos !=null){
            int tam=aAvisos.size();
            int indiceI=0;

                while(indiceI<tam){

                    TCtrlListar paq=new TCtrlListar();
                    int idAviso=aAvisos.get(indiceI).getIdAviso(); //idAviso
                    id=control.CAV.dameIdActividades(idAviso);  //idAct

                    //Tratamos el caso de que sea aniversario y pueda tener
                    //Una fecha de aviso diferente a la de aniversario
                    Actividad a=control.buscarActividad(id.get(0));
//                    System.out.println("el tipo de actividad es : "+a.getClass().getSimpleName());
                    if(a.getClass().getSimpleName().equals(Constantes.ANIVERSARIO)){
//                        System.out.print("es un aniversario");
                        Aniversario ani=(Aniversario)a;
//                        if(sonIguales(ani.getFechaNacimiento(),aAvisos.get(indiceI).getFechaAviso())){
//                            System.out.println("y las fechas son iguales !!!");
                             paq.setIdAct(id.get(0));
                             paq.setFechaAviso(ani.getFechaNacimiento());
                             String edad = "";
                             edad = String.valueOf(this.fechaAniversario(ani.getFechaNacimiento()));

                             paq.setTitulo(aAvisos.get(indiceI).getTextoAviso().concat(" cumple : ").concat(edad));
                             titulos.add(paq);
                             insertamosAlgo=true;
//                        }

                     }
                     else if (!a.getClass().getSimpleName().equals(Constantes.ENMENTE)){

                        paq.setIdAct(id.get(0));
                        paq.setTitulo(aAvisos.get(indiceI).getTextoAviso());
                        paq.setFechaAviso(aAvisos.get(indiceI).getFechaAviso());

                        titulos.add(paq);
                        insertamosAlgo=true;
                  }
                  indiceI++;
                }
        }
         if (!insertamosAlgo)return null;
        return titulos;
    }//fin funcion

    public ArrayList<TCtrlListar>getTitulos(Date fecha){

        setTitulos(this.getTitulos2(fecha));
        return getTitulos();

    }

    /**
     * @return the titulos
     */
    public ArrayList<TCtrlListar> getTitulos() {
        return titulos;
    }

    /**
     * @param titulos the titulos to set
     */
    public void setTitulos(ArrayList<TCtrlListar> titulos) {
        this.titulos = titulos;
    }


}
