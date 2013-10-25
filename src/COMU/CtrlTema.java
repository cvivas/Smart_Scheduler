


package Agenda;

import java.util.ArrayList;
import java.util.Iterator;
/**
* Descripcio:Classe CtrlTema contiene un listado de temas y informacion sobre las actividades
* que tienen asignados estos temas
* Autor: Raul Serna
* Ultima actualizacion:30 de abril 2009
* Relacionada con las clases: Tema, CtrlDominio,TemaActividad

 */

public class CtrlTema {

     private ArrayList<TemaActividad> listT;

    public CtrlTema () { listT = new ArrayList<TemaActividad>();}


    public Tema ObtenerTema (String nomT){
     /* Operacion ObtenerTema devuelve un tema, si no existe lo crea */

        TemaActividad auxiliar;

        auxiliar=this.buscarTema(nomT);
        if (auxiliar==null){
            auxiliar=new TemaActividad();
            auxiliar.tema.crearTema(nomT);
            auxiliar.nombresActi= new ArrayList<IntStr>();
            listT.add(auxiliar);
        }//fin if

        return auxiliar.tema;

    }//fin operacion


    public Tema anadirTema(String nomT, String nomA,int idActividad){
     /* Operacion anadirTema guarda la relacion entre una actividad y un tema
      y devuelve el tema*/
         TemaActividad tema;
         tema=this.buscarTema(nomT);
         IntStr auxiliar=new IntStr();
         auxiliar.idAct=idActividad;
         auxiliar.titAct=nomA;
         tema.nombresActi.add(auxiliar);
         return tema.tema;
    }//fin operacion


    public Tema quitarTema(String nomT,int idActividad){
      /* Operacion quitarTema elimina la relacion entre una actividad y un tema,y devuelve un tema.
        Existe porque el tema se elige de un desplegable */
        TemaActividad tema;
        tema=this.buscarTema(nomT);
        Iterator<IntStr> it=tema.nombresActi.iterator();
        boolean encontrado=false;
        while (!encontrado && it.hasNext()) {
            IntStr actual= it.next();
            if (actual.idAct == idActividad){
                tema.nombresActi.remove(actual);
                encontrado=true;
            }//fin if
        }//fin while

        return tema.tema;
    }//fin operacion


    public boolean eliminarTema(String nomT){
     /* Operacion eliminarTema quita el tema del sistema si no tiene actividades
        asociadas.Devuelve un boleano indicando si se ha podido eliminar.*/
                boolean encontrado=false;
                boolean sepuedeeliminar=false;
       			Iterator<TemaActividad> itl= listT.iterator();

                while (!encontrado && itl.hasNext()) {
                    
                    TemaActividad actual = itl.next();
                    if (actual.tema.getNom().equalsIgnoreCase(nomT)){
                       
                        encontrado=true;
                        if (actual.nombresActi.isEmpty()){
                            listT.remove(actual);
                            sepuedeeliminar=true;
                        }//fin if

                    }//fin if

                }//fin while
                return sepuedeeliminar;
       }//fin operacion



    public void quitarTodasActividadesTema(String nomT){
     /* Operacion quitarTodasActividadesTema elimina todas las relaciones entre un tema y las
        actividades asignadas*/
            TemaActividad tema;
            tema=this.buscarTema(nomT);
            tema.nombresActi.clear();


    }//fin operacion

    public ArrayList mostrarActividadesDeUnTema(String nomT){
        /* Operacion mostraActividadesDeUnTema devuelve la lista de nombres de las actividades de un tema */
        TemaActividad tema;
        tema=buscarTema(nomT);
        if (tema!=null){
            ArrayList<String> nombresactividades= new ArrayList();
            Iterator<IntStr> it = tema.nombresActi.iterator();
            while(it.hasNext()){
                nombresactividades.add(it.next().titAct);
            }//fin while
            return nombresactividades;
        }
        else{
            return null;
        }//fin if
    }//fin operacion




   private TemaActividad buscarTema(String nomT){
    /* Operacion buscarTema devuelve una tupla TemaActividad si existe, sino devuelve null */
        TemaActividad auxiliar=null;
        boolean encontrado=false;

                Iterator<TemaActividad> itl= listT.iterator();
                while (!encontrado && itl.hasNext()) {
                TemaActividad actual = itl.next();
                    if ( actual.tema.getNom().equalsIgnoreCase(nomT)){
                        encontrado=true;
                        auxiliar=actual;
                    }//fin if
                }//fin while
        return auxiliar;
    }//fin operacion



    public ArrayList getCtrlTema() {
      /* Operacion getCtrlTema devuelve el listado para poder guardar */
		return listT;
	}//fin operacion

    public void setCtrlTema( ArrayList a) {
      /* Operacion setCtrlTema modifica el listado para poder cargar */
        listT=a;
	}//fin operacion


    public ArrayList listartemas(){
         /*Operacion Listartemas devuelve un listado con los nombres de los temas en el sistema*/
         ArrayList<String> lista = new ArrayList<String>();
         Iterator<TemaActividad> itl= listT.iterator();
         while (itl.hasNext()) {
            TemaActividad actual = itl.next();
                lista.add(actual.tema.getNom());
         }//fin while


         return lista;
     }//fin operacion


}//fin clase

