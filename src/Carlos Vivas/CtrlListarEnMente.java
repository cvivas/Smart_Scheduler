/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agendainteligente;

import java.util.ArrayList;


/**
 * Descripcion: Clase dedicada a listar las actividades de tipo "En Mente"
 *              que no tienen horas asociadas. Interactua con CtrlDominio3
 *
 * Autor: Carlos Vivas
 *
 * Ultima modificacion: 28/06/2009
 */




public class CtrlListarEnMente {

   private CtrlDominio3 control=new CtrlDominio3();

   private ArrayList<TCtrlListar>t=new ArrayList<TCtrlListar>();

    /*Funcion que coge todas las tareas en mente encapsuladas en IdNombre y se guarda los ids*/
    private ArrayList<Integer> insertaIds(){

        int indiceI=0;
        int tam=0;       

        ArrayList<IdNombre> lista=control.listarActividadEspecifica(Constantes.ENMENTE);
        ArrayList<Integer>ids=new ArrayList<Integer>();
       

        if(lista != null){
            tam=lista.size();
            while(indiceI<tam){

                IdNombre e;
                e=lista.get(indiceI);
                ids.add(e.idActividad);
                indiceI++;
            }return ids;
         }
        else{
            return null;
         }


    }

    /*Comprueba que los enMente  tengan 0 horas y los inserta en un array*/
    public ArrayList<TCtrlListar> getTitulosEnMente2(){

        int tam=0;
        int indiceI=0;
        t = new ArrayList<TCtrlListar>();
        
        ArrayList<Integer>ids=insertaIds(); //ids de enMente
        //ArrayList<TCtrlListar>t=new ArrayList<TCtrlListar>();
        boolean insertado = false;

        if(ids != null){
            tam=ids.size();
            while(indiceI<tam){
                TCtrlListar paq=new TCtrlListar();

                Actividad a;
                EnMente e;
                a=control.buscarActividad(ids.get(indiceI));
                e=(EnMente)a;
                if(e.getNHoras()==0){
                    insertado = true;
                   String titulo=e.getTitulo();
                   paq.setIdAct(ids.get(indiceI));
                   paq.setTitulo(titulo);
                   paq.setFechaAviso(null);
                    getT().add(paq);
                }
                indiceI++;
            }
        }

        if (!insertado) return null;
        return getT();
        
    }

    /*Establece un array para devolver*/
    public ArrayList<TCtrlListar> getTitulosEnMente(){

        setT(this.getTitulosEnMente2());
        return getT();

    }

    /**
     * @return the t
     */
    public ArrayList<TCtrlListar> getT() {
        return t;
    }

    /**
     * @param t the t to set
     */
    public void setT(ArrayList<TCtrlListar> t) {
        this.t = t;
    }



}
