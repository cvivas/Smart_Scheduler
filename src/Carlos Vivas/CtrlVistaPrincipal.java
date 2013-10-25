/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agendainteligente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Carlos Vivas Abilahoud 
 */
public class CtrlVistaPrincipal {
    private TCtrlVista diaHorario[];
    private TCtrlVista[][] semanaHorario;
    private TCtrlVista[][] semanaEvento;
    private Date diaInicioSemanaActual;
    private Date diaIndicadoActualmente;
    
    
    CtrlAgenda CA = new CtrlAgenda();
    CtrlDominio3 CD3= new CtrlDominio3();

    public CtrlVistaPrincipal() {

        diaHorario = new TCtrlVista[24];
        semanaHorario = new TCtrlVista[24][7];
        semanaEvento=new TCtrlVista[12][7];
        this.diaIndicadoActualmente = new Date();
        this.diaInicioSemanaActual = new Date();
        this.vaciarTablas();







    }//fin operacion

    public void vaciarTablas(){
    /*Elimina los datos almacenados en el controlador
     */
        int i;
        for (i =0;i<Constantes.CASILLASDIAHORA;i++){

            diaHorario[i]=new TCtrlVista();

        }//end for

        for (i=0;i<Constantes.CASILLASSEMANAEVENTO;i++){
             semanaEvento[i/7][i%7] = new TCtrlVista();

        }//end for

        for (i=0;i<Constantes.CASILLASSEMANAHORA;i++){

            semanaHorario[i/7][i%7]=new TCtrlVista();

        }//end for

    }//fin operacion

    /**
     * @return the diaHorario
     */
    public TCtrlVista[] getDiaHorario() {
        return diaHorario;
    }//fin operacion

    /**
     * @param diaHorario the diaHorario to set
     */
    public void setDiaHorario(TCtrlVista[] diaHorario) {
        this.diaHorario = diaHorario;
    }//fin operacion

    /**
     * @return the semanaHorario
     */
    public TCtrlVista[][] getSemanaHorario() {
        return semanaHorario;
    }//fin operacion

    /**
     * @param semanaHorario the semanaHorario to set
     */
    public void setSemanaHorario(TCtrlVista[][] semanaHorario) {
        this.semanaHorario = semanaHorario;
    }//fin operacion

    /**
     * @return the semanaEvento
     */
    public TCtrlVista[][] getSemanaEvento() {
        return semanaEvento;
    }//fin operacion

    /**
     * @param semanaEvento the semanaEvento to set
     */
    public void setSemanaEvento(TCtrlVista[][] semanaEvento) {
        this.semanaEvento = semanaEvento;
    }//fin operacion

    public void rellenarTablas(Calendar c){
    /*
     * Dada una fecha de tipo calendar rellena 3 tablas que seran
     *correspondientes a las de diaHorario, SemanaHorario y SemanaEvento.
     *contendran un idActividad y su titulo.
     */

        Date diaIntroducido = c.getTime();
        int diaSemana = c.get(Calendar.DAY_OF_WEEK);
        this.vaciarTablas();
        rellenarDia(diaHorario,diaIntroducido);
        this.diaIndicadoActualmente= (Date) diaIntroducido.clone();
        if (diaSemana>2 && diaSemana<8){

            c.add(Calendar.DATE, -(diaSemana-2));
        
        }//end if
            
        else if (diaSemana==1) {

            c.add(Calendar.DATE, -6);

        }//end if

        Date inicioSemana = c.getTime();
        this.diaInicioSemanaActual=(Date) inicioSemana.clone();
        rellenarSemanaH(semanaHorario,inicioSemana);
        rellenarSemanaE(semanaEvento,inicioSemana);


    }//fin operacion

    public void rellenarDia(TCtrlVista[] diaH, Date diaI) {

        /*completa un dia de horarios*/
        
         ArrayList<TCtrlHorSlot> ths;
         int indice;
         ths = CD3.obtenerSlots(diaI);
         boolean cambioAct;
         String tipo ="";
         int idActAnterior=Constantes.INCORRECTO;
         if (ths!=null && !ths.isEmpty()){

             Iterator<TCtrlHorSlot> it = ths.iterator();
             while(it.hasNext()){

                 TCtrlHorSlot actual = it.next();
                 indice = actual.slot;
                 diaH[indice].setIdAct(actual.idActividad);
                 if (idActAnterior != actual.idActividad){
                  
                     idActAnterior=actual.idActividad;
                     diaH[indice].setTitulo(CD3.obtenerTitulo(actual.idActividad));
                     
                    }

                 tipo = CD3.obtenerTipoActividad(actual.idActividad);
                 if (tipo.equals(Constantes.CITA))diaH[indice].setColor(Constantes.COLORCITA);
                 if (tipo.equals(Constantes.CITAREPETITIVA))diaH[indice].setColor(Constantes.COLORREP);
                 if (tipo.equals(Constantes.ENMENTE))diaH[indice].setColor(Constantes.COLORENMENTE);
                 if (tipo.equals(Constantes.DEADLINE))diaH[indice].setColor(Constantes.COLORDEADLINE);

                 }//fin while

         }//fin if

    }//fin operacion

    private void rellenarDiaH(TCtrlVista[][] semana, Date dia, int col){
        /*Completa la columna col de la matriz semana con las actividades con horarios del dia <dia>*/

         ArrayList<TCtrlHorSlot> ths;
         int indice;
         ths = CD3.obtenerSlots(dia);
         String tipo = "";
         int idActAnterior = Constantes.INCORRECTO;
         if (ths!=null && !ths.isEmpty()){

             Iterator<TCtrlHorSlot> it = ths.iterator();
             while(it.hasNext()){

                 TCtrlHorSlot actual = it.next();
                 indice = actual.slot;
                 semana[indice][col].setIdAct(actual.idActividad);
                 if (idActAnterior != actual.idActividad){

                     idActAnterior=actual.idActividad;
                     semana[indice][col].setTitulo(CD3.obtenerTitulo(actual.idActividad));

                    }


                  tipo = CD3.obtenerTipoActividad(actual.idActividad);
                 if (tipo.equals(Constantes.CITA))semana[indice][col].setColor(Constantes.COLORCITA);
                 if (tipo.equals(Constantes.CITAREPETITIVA))semana[indice][col].setColor(Constantes.COLORREP);
                 if (tipo.equals(Constantes.ENMENTE))semana[indice][col].setColor(Constantes.COLORENMENTE);
                 if (tipo.equals(Constantes.DEADLINE))semana[indice][col].setColor(Constantes.COLORDEADLINE);

             }//fin while

         }//end if

    }//fin operacion

    private void rellenarDiaE(TCtrlVista[] diaH, Date diaI) {

        /*rellena un dia de eventos*/

         ArrayList<Integer> actividades;
         int indice = 0;
         int idAct;
         actividades = CD3.obtenerIdActividades(diaI);

         if (actividades!=null && !actividades.isEmpty()){

             Iterator<Integer> it = actividades.iterator();

             while(it.hasNext() && indice < 12){

                 Integer actual = it.next();
                 idAct = actual.intValue();
                 if (CD3.esEvento(idAct)){
                     diaH[indice].setIdAct(idAct);
                     diaH[indice].setTitulo(CD3.obtenerTitulo(idAct));
                     indice ++;

                 }//end if

             }//fin while

          }//end if

    }//fin operacion


     private void rellenarDiaEvento(TCtrlVista[][] diaH, Date diaI, int columna) {

      /*Completa la columna col de la matriz diaH con las actividades sin horarios del dia <diaI>*/

         ArrayList<Integer> actividades;
         int indice = 0;
         int idAct;
         actividades = CD3.obtenerIdActividades(diaI);
//         System.out.println("imprimimos el array de actividades:  "+actividades);
         if (actividades!=null && !actividades.isEmpty()){

             Iterator<Integer> it = actividades.iterator();

             while(it.hasNext() && indice < 12){

                 Integer actual = it.next();
                 idAct = actual.intValue();

                 if (CD3.esEvento(idAct)){
                     String tipo = CD3.obtenerTipoActividad(idAct);
                     if (tipo.equals(Constantes.MEMORANDUM))diaH[indice][columna].setColor(Constantes.COLORMEMORANDUM);
                     if (tipo.equals(Constantes.ANIVERSARIO))diaH[indice][columna].setColor(Constantes.COLORANIVERSARIO);


                     diaH[indice][columna].setIdAct(idAct);
                     diaH[indice][columna].setTitulo(CD3.obtenerTitulo(idAct));
                     indice ++;
//                     System.out.println("el titulo de la actividad en rellenarevent es: "+ CD3.obtenerTitulo(idAct));
                 }//end if
             
             }//end while

          }//end if

    }//fin operacion

    public void rellenarSemanaH(TCtrlVista[][] semana, Date dia) {
    /*rellena una semana de horarios del dia "dia" al dia "dia+7"*/

        int i=0;
        Date temp = (Date) dia.clone();
        for (i=0;i<7;i++){

            rellenarDiaH(semana,temp,i);

            temp= CtrlDominio3.diaSiguiente(temp);
        }//end for
    
    }//fin operacion



    public void rellenarSemanaE(TCtrlVista[][] semana, Date dia) {
    /*rellena una semana de eventos del dia "dia" al dia "dia+7"*/

        int i=0;
        Date temp = (Date) dia.clone();
        for (i=0;i<7;i++){

            rellenarDiaEvento(semana ,temp, i);
            temp= CtrlDominio3.diaSiguiente(temp);

        }//end for

    }//fin operacion

    public int obtenerIdActividad(int fila, TCtrlVista[] tablaDia){
        /*retorna el id de la actividad guardada en en la posicion fila del vector tabladia*/

        int idAct = Constantes.INCORRECTO;

        if (fila <tablaDia.length && fila >=0) {

            idAct = tablaDia[fila].getIdAct();

        }//end if

        return idAct;

    }//fin operacion

    public int obtenerIdActividad (int fila, int columna, TCtrlVista[][] tablaSemana){
    /*Devuelve el id contenido en la matriz en la fila fila y la columna columna*/

        int idAct = Constantes.INCORRECTO;

        if ((fila <24 && fila >=0)&&(columna<7 && columna>=0)) {

            idAct = tablaSemana[fila][columna].getIdAct();

        }//end if

        return idAct;
    }//fin operacion

    
    public String obtenerTituloAct(int fila, TCtrlVista[] tablaDia){
    /*retorna el titulo de la actividad en la posicion "fila" de tabladia*/
        String tituloAct = "";

        if (fila <tablaDia.length && fila >=0) {

            tituloAct = tablaDia[fila].getTitulo();

        }//end if

        return tituloAct;

    }//fin operacion

    public String obtenerTituloAct (int fila, int columna, TCtrlVista[][] tablaSemana){
          /*Devuelve el titulo contenido en la matriz en la fila fila y la columna columna*/

        String tituloAct = "";

        if ((fila <24 && fila >=0)&&(columna<7 && columna>=0)) {
            
            tituloAct = tablaSemana[fila][columna].getTitulo();

        }//end if

        return tituloAct;
    }//fin operacion

        public TCtrlVista obtenerElementoDia(int fila, TCtrlVista[] tablaDia){
    /*retorna el titulo de la actividad en la posicion "fila" de tabladia*/
        TCtrlVista tcv = null;

        if (fila <tablaDia.length && fila >=0) {

            tcv = tablaDia[fila];

        }//end if

        return tcv;

    }//fin operacion

    public TCtrlVista obtenerElementoSemana (int fila, int columna, TCtrlVista[][] tablaSemana){
          /*Devuelve el titulo contenido en la matriz en la fila fila y la columna columna*/

        TCtrlVista tcv = null;

        if ((fila <24 && fila >=0)&&(columna<7 && columna>=0)) {

            tcv = tablaSemana[fila][columna];

        }//end if

        return tcv;
    }//fin operacion

    /**
     * @return the diaInicioSemanaActual
     */
    public Date getDiaInicioSemanaActual() {
        return diaInicioSemanaActual;
    }//fin operacion

    /**
     * @return the diaIndicadoActualmente
     */
    public Date getDiaIndicadoActualmente() {
        return diaIndicadoActualmente;
    }//fin operacion


}//fin clase
