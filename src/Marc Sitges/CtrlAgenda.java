/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agendainteligente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author Marc Sitges
 */
public class CtrlAgenda extends CtrlDominio3 {

    
    /**
     * Operacion que asigna un horario, desde la fecha inicio hasta la fecha fin,
     * a la actividad idActividad. Cada dia que pasa se asignara un numero desde
     * SlotPorDiaMax de horas como maximo hasta SlotPorDiaMin de horas como minimo
     * hasta llegar a completar las numHoras que se le han asignado a la actividad
     *
     * @param idActividad
     * @param prioridad
     * @param numHoras
     * @param laboral
     * @param inicio
     * @param fin
     * @param SlotsPorDiaMin
     * @param SlotsPorDiaMax
     * @return
     */
    public int asignacionAutomatica(int idActividad, int prioridad, int numHoras, boolean laboral,
            Date inicio, Date fin, int SlotsPorDiaMin, int SlotsPorDiaMax){

        //hemos llegado al final, es decir, hemos probado todas las combinaciones de slot
        //con todos los dias y al final resulta que es imposible poner la actividad en mente
        if(numHoras == 0)return 0;
        int retorno = numHoras;
        if((inicio.before(fin) || sonIguales(inicio,fin)) && numHoras>0){
            ArrayList<TCtrlHorSlot> pendientes = new ArrayList<TCtrlHorSlot>();
            int slots = SlotsPorDiaMax;
            int idHorario = CH2.crearHorario(inicio);
            retorno = 0;
            int horasRestantes = numHoras;
            int minimo = SlotsPorDiaMin;
            Date dia = null;
            boolean es_adecuado=false;

            ArrayList<TCtrlHorSlot> SlotsDeActividad = CH2.obtenerSlotsDeActividad(idHorario, idActividad);
            if(SlotsDeActividad!=null){
                int slotsAct = SlotsDeActividad.size();
                if(slotsAct>0){
                    this.eliminarHorarioDeActividadConSlotSinBorrarIdHorario(idHorario, idActividad);
                    horasRestantes = horasRestantes + slotsAct;
                }
            }


            /*si quedan menos horas que slots entonces slots=horasRestantes*/
            if(horasRestantes<slots){
                slots=horasRestantes;
                minimo=1;
            }
            while( slots >= minimo && !es_adecuado ){
               
                es_adecuado = dia_adecuado(idActividad,idHorario,slots,
                        prioridad,laboral,pendientes,SlotsPorDiaMax);
                if(!es_adecuado)slots--;

            }
            dia= (Date) diaSiguiente(inicio).clone();
            /*Avanzamos al dia siguiente sin restar SlotsPorDia a numHoras*/
            if(!es_adecuado){

                retorno = asignacionAutomatica(idActividad,prioridad,
                        horasRestantes,laboral,dia,fin,SlotsPorDiaMin,SlotsPorDiaMax);
            }
            /*Avanzamos al dia siguiente restando slots a horasRestantes*/
            else{

                retorno = asignacionAutomatica(idActividad,prioridad,
                        (horasRestantes-slots),laboral,dia,fin,SlotsPorDiaMin,SlotsPorDiaMax);
//
//                if(horasRestantes>=slots){
//                }
//                else{
//                    retorno = asignacionAutomatica(idActividad,prioridad,
//                        0,laboral,dia,fin,SlotsPorDiaMin,SlotsPorDiaMax);
//                }
            }
            if(retorno == 0){
                recolocarEliminados(pendientes, inicio);
                return retorno;
            }
            else{
                this.eliminarHorarioDeActividadConSlotSinBorrarIdHorario(idHorario, idActividad);
                if(!pendientes.isEmpty()){
                    insertarEliminados(idHorario,pendientes);
                    pendientes = null;
                }
            }
        }
        return retorno;
    }

/**
 * operacion que nos indica si en el horario con id "idHorario", podemos añadir
     un numero de slots "SlotPorDia"
 *
 * @param inicioJornada
 * @param finJornada
 * @param slots
 * @param SlotsPorDia
 * @param prioridad
 * @param idHorario
 * @param pendientes
 * @return
 */
    private int buscarEspacio(int inicioJornada, int finJornada, ArrayList<TCtrlHorSlot> slots,
            int SlotsPorDia,int prioridad, int idHorario, ArrayList<TCtrlHorSlot> pendientes) {

          Iterator<TCtrlHorSlot> index = slots.iterator();
          ArrayList<TCtrlHorSlot> slotsDeActividad = null;
          TCtrlHorSlot elem = new TCtrlHorSlot();
          boolean dia[] = new boolean[24];
          int diaAct[] = new int[24];
          int i;
          int horas = 0;
          /*Inicializamos el array dia a falso*/
          for(i=0;i<dia.length;i++){
              dia[i]=false;
              diaAct[i]=0;
          }
          /*si hay slots ocupados ponemos su posicion en el array en true*/
          while(index.hasNext()){
              TCtrlHorSlot temporal = index.next();
              dia[temporal.slot]=true;
              diaAct[temporal.slot]=temporal.idActividad;
          }//fin while
          i = inicioJornada;
          /*hacemos un recorrido del array desde el inicio de la jornada hasta
           su final buscando un numero de slots vacios y consecutivos superior o
           igual a SlotsPorDia que segun nuestro algoritmo, es el numero de horas
           que tendremos que llenar al dia*/
          while(i<=finJornada){
              /*calculamos el intervalo de slots libres que hay entre dos slots
               ocupados*/
              while(!dia[i] && i<=finJornada){
                  horas++;
                  i++;
              }//fin while
              /*si hemos encontrado un intervalo suficientemente grande, lo retornamos*/
              if(horas>=SlotsPorDia)return (i-horas); /*retornamos el inicio de horas*/
              /*sino, si hay un intervalo demasiado pequeño y no hemos llegado
               al final, miramos si las actividades puestas durante el dia
               tienen menor prioridad. Si la tienen, entonces vamos quitando de
               slot en slot*/
              if(horas<SlotsPorDia && i<=finJornada){

                  int idActividadBarrera = diaAct[i];
                  Actividad a = CA3.buscarActividad(idActividadBarrera);
                  String tipo = a.getClass().getSimpleName();

                  /*Queremos suprimir la actividad pero solo si la actividad
                   no es una cita/cita repetitiva/actividad con mas prioridad*/
                  if(!tipo.equals(Constantes.CITA) && !tipo.equals(Constantes.CITAREPETITIVA)){
                      if(CA3.obtenerPrioridad(idActividadBarrera)<prioridad){
                          
                          elem.idActividad=idActividadBarrera;
                          elem.slot=i;
                          pendientes.add(elem);
                          elem = new TCtrlHorSlot();
                          horas++;
                          CH2.quitarSlot(idHorario, i);
                          slotsDeActividad = CH2.obtenerSlotsDeActividad(idHorario, idActividadBarrera);
                          if(slotsDeActividad.isEmpty()){
                              CH2.borrarActividad(idActividadBarrera, idHorario);
                              CA3.eliminarHorariodDeActividad(idActividadBarrera, idHorario);
                          }
                      }//fin if
                      else horas=0;
                  }//fin if
                  else horas=0;
                  i++;
              }//fin if
          }//fin while
          return -1;
    }//fin operacion

    /**
     * operacion que devuele cierto si el dia es adecuado para insertar parte
     de los slots de la actividad. Ademas, en el caso en que sea adecuada,
     inserta los slots.
     * @param idActividad
     * @param idH
     * @param SlotsPorDia
     * @param prioridad
     * @param laboral
     * @param pendientes
     * @param SlotsMax
     * @return
     */
    private boolean dia_adecuado(int idActividad, int idH, int SlotsPorDia, int prioridad,
            boolean laboral, ArrayList<TCtrlHorSlot> pendientes,int SlotsMax) {

        boolean adecuado=false;
        int inicioJornada;
        int finJornada;
        int hora=0;
        ArrayList<TCtrlHorSlot> slotsDelDia = CH2.obtenerSlotsDeActividad(idH, idActividad);
        if(slotsDelDia!=null){
            if(slotsDelDia.size()+SlotsPorDia>SlotsMax)return false;
        }
        ArrayList<TCtrlHorSlot> slots = CH2.obtenerSlots(idH);
        Date data = CH2.buscarHorario(idH).data;

        /*acotamos el espacio donde se puede mirar si hay slots libres*/
        if(laboral){
            /*en el caso en que estemos en fin de semana, retornamos falso ya que
             la actividad es laboral*/
            if(data.getDay()==0 || data.getDay()==6)return false;
            /*en caso contrario, buscamos su horas de jornada*/
            else {
                inicioJornada=JL.getHoraInicioJornadaLaboral();
                finJornada=JL.getHoraFinJornadaLaboral();
            }
        }
        else{
            inicioJornada=JL.getHoraInicioJornadaOcio();
            finJornada=JL.getHoraFinJornadaOcio();
        }
        /*Si SlotsPorDia es mas grande que el numero de slots que tenemos en la
         jornada, tenemos la certeza de que seguro que el dia no es adecuado*/
        if(SlotsPorDia<=(finJornada-inicioJornada)){

            if(slots==null)hora=inicioJornada;
            else hora=buscarEspacio(inicioJornada,finJornada,slots,SlotsPorDia,
                    prioridad,idH,pendientes);
            /*si hemos encontrado una hora para poner la actividad...*/
            if(hora>=0){
                for(int inicio=0;inicio<SlotsPorDia;inicio++){

                    asignarHorarioActividad(idH, idActividad);
                    CH2.asignarActividad(idActividad, idH);
                    insertarConSlot(idH, hora+inicio, idActividad);
                }
                adecuado=true;
            }
        }
        return adecuado;
    }

    /**
     * operacion para insertar actividades que se habian eliminado a partir de
     la operacion asignacionAutomatica
     * @param idHorario
     * @param pendientes
     */
    private void insertarEliminados(int idHorario, ArrayList<TCtrlHorSlot> pendientes) {

        Iterator<TCtrlHorSlot> iter = pendientes.iterator();
        TCtrlHorSlot elem = null;
        while(iter.hasNext()){
            elem = iter.next();
            int slot = elem.slot;
            int actividad = elem.idActividad;
            CH2.insertarConSlot(idHorario, slot, actividad);
            CA3.asignarHorario(idHorario, actividad);
        }
    }

    /**
     *
     * @param idAct
     * @param fecha1
     * @param fecha2
     * @param hIni
     * @param hFin
     * @param valorPeriodicidad
     * @param aviso
     */
    public void insertarPeriodicamente(int idAct, Date fecha1, Date fecha2, int hIni, int hFin,
            int valorPeriodicidad,boolean aviso) {

        int idHorario;

        if (valorPeriodicidad == Constantes.DIARIA){

            while (fecha1.before(fecha2) || fecha1.equals(fecha2)){

                this.asignarNuevoHorarioCita(idAct, fecha1, hIni, hFin);
                if (aviso){ crearAviso(fecha1, idAct); }
                fecha1=diaSiguiente(fecha1);
            }
        }
        if (valorPeriodicidad == Constantes.SEMANAL){

            while (fecha1.before(fecha2) || fecha1.equals(fecha2)){
                this.asignarNuevoHorarioCita(idAct, fecha1, hIni, hFin);
                if (aviso){ crearAviso(fecha1, idAct); }
                fecha1=semanaSiguiente(fecha1);

            }
        }
        if (valorPeriodicidad == Constantes.MENSUAL){

            while (fecha1.before(fecha2) || fecha1.equals(fecha2)){
                this.asignarNuevoHorarioCita(idAct, fecha1, hIni, hFin);
                if (aviso){ crearAviso(fecha1, idAct); }
                fecha1=mesSiguiente(fecha1);
            }
        }
        if (valorPeriodicidad == Constantes.ANUAL){

            while (fecha1.before(fecha2) || fecha1.equals(fecha2)){
                this.asignarNuevoHorarioCita(idAct, fecha1, hIni, hFin);
                if (aviso){ crearAviso(fecha1, idAct); }
                fecha1=annoSiguiente(fecha1);
            }
        }
    }

    /**
     *
     * @param idAct
     * @param fecha
     * @param hIni
     * @param hFin
     * @return
     */
    public int asignarNuevoHorarioCita(int idAct, Date fecha, int hIni, int hFin){
    /*Crea y asigna el horario con Date fecha a la activida idAct y Asigna sus slots*/
        int idHorario=-1;
        int correcto = Constantes.INCORRECTO;
        ArrayList<TCtrlHorSlot> pendientes = new ArrayList<TCtrlHorSlot>();

        correcto = exsisteHorarioOcupado(idAct,  hIni,  hFin, fecha, pendientes);
        if (correcto>0){

            idHorario= crearHorario(fecha, idAct);
            asignarHorarioActividad(idHorario, idAct);

            while (hIni<hFin){

               insertarConSlot(idHorario, hIni, idAct);
               hIni++;
            }
            if(pendientes != null){
                recolocarEliminados(pendientes,fecha);
                pendientes = null;
            }
            correcto = Constantes.INCORRECTO;
        }

        return correcto;

    }
    /**
     * Operacion que dada una cita con id = idAct, con una hora hIni y una hora hFin
     * en una fecha, nos aseguramos de asignarle un horario en aquel dia.
     *
     * @param idAct
     * @param hIni
     * @param hFin
     * @param fecha
     * @param pendientes
     * @return
     */
    public int exsisteHorarioOcupado(int idAct, int hIni, int hFin, Date fecha,
            ArrayList<TCtrlHorSlot> pendientes){

        int idHorarioPrevio=Constantes.INCORRECTO;
        ArrayList<TCtrlHorSlot> slotsDeActividad = null;
        idHorarioPrevio = CH2.obtenerIdHorario(fecha);

        if(idHorarioPrevio>0){

            ArrayList<TCtrlHorSlot> lista = CH2.obtenerSlots(idHorarioPrevio);
            /*si hay slots en el horario*/
            if(lista!=null){

                Iterator<TCtrlHorSlot> index = lista.iterator();
                TCtrlHorSlot elem = new TCtrlHorSlot();
                Horario2 h2 = (Horario2) CH2.buscarHorario(idHorarioPrevio);
                boolean dia[] = new boolean[24];
                int diaAct[] = new int[24];
                int i;
                /*Inicializamos el array dia a falso*/
                for(i=0;i<dia.length;i++){
                    dia[i]=false;
                    diaAct[i]=0;
                }
                /*si hay slots ocupados ponemos su posicion en el array en true*/
                while(index.hasNext()){
                    TCtrlHorSlot temporal = index.next();
                    dia[temporal.slot]=true;
                    diaAct[temporal.slot]=temporal.idActividad;
                }//fin while
                i=hIni;
                while(i<hFin){

                    /*si el slot esta ocupado, lo vaciamos, en caso en que no sea cita
                     o cita repetitiva lo guardamos*/
                    if(dia[i]){

                        int idActividadBarrera = diaAct[i];

                        Actividad a = CA3.buscarActividad(idActividadBarrera);
                        String tipo = a.getClass().getSimpleName();

                        if(!(tipo.equals(Constantes.CITA)) && !(tipo.equals(Constantes.CITAREPETITIVA))){

                            elem.idActividad=idActividadBarrera;
                            elem.slot=i;
                            pendientes.add(elem);
                            elem = new TCtrlHorSlot();
                        }
                        CH2.quitarSlot(idHorarioPrevio, i);
                        slotsDeActividad = CH2.obtenerSlotsDeActividad(idHorarioPrevio, idActividadBarrera);
                        if(slotsDeActividad.isEmpty()){
                            CH2.borrarActividad2(idActividadBarrera, idHorarioPrevio);
                            CA3.eliminarHorariodDeActividad(idActividadBarrera, idHorarioPrevio);
                        }

                    }
                    i++;
                }
            }
        }
        return 1;
    }

    /**
     * Operacion que se dedica a recolocar todas las actividades borradas por culpa
     * de la asginacion automatica o la insercion de citas
     *
     * @param pendientes
     * @param fecha
     */
    private void recolocarEliminados(ArrayList<TCtrlHorSlot> pendientes, Date fecha) {

        Iterator<TCtrlHorSlot> index = pendientes.iterator();
        int idActividad;
        Actividad a;
        String tipo;
        Date diaFin = (Date) annoSiguiente(fecha).clone();

        int diaAct[][] = new int[24][2];

        for(int j=0;j<24;j++){

            diaAct[j][0]=0;
            diaAct[j][1]=0;
        }
        while(index.hasNext()){

            TCtrlHorSlot temporal = index.next();
            int k = 0;
            boolean trobat =false;
            while(diaAct[k][0]!=0 && !trobat){

                if(diaAct[k][0]==temporal.idActividad)trobat=true;
                else k++;
            }
            
            diaAct[k][0]=temporal.idActividad;
            diaAct[k][1]++;
            
        }

        int k=0;
        while(diaAct[k][0]!=0){
            idActividad = diaAct[k][0];
            int numeroSlots = diaAct[k][1];

            a = CA3.buscarActividad(idActividad);
            tipo = a.getClass().getSimpleName();

            if(tipo.equals(Constantes.DEADLINE)){
                Deadline d = (Deadline) a;
                asignacionAutomatica(idActividad, d.getPrioridad(), numeroSlots, d.isEsLaboral(),
            fecha, d.getFechaFinal(), d.getHorasMin(), d.getHorasMax());
            }
            if(tipo.equals(Constantes.ENMENTE)){
                EnMente e = (EnMente) a;
                int retorno = asignacionAutomatica(idActividad, e.getPrioridad(), numeroSlots, e.isEs_laboral(),
            fecha, diaFin , e.getSlotMin(), e.getSlotMax());
            }
            fecha=(Date) diaSiguiente(fecha).clone();
            k++;
        }
        pendientes = null;
    }

    /**
     *
     * @param dataH
     * @param data0
     * @return
     */
    public boolean sonIguales(Date dataH, Date data0) {

        return (dataH.getDate() == data0.getDate() && dataH.getMonth() == data0.getMonth()
                && dataH.getYear() == data0.getYear());
    }

    /**
     *
     * @param idAct
     * @param fecha
     */
    public void eliminarActividadDia(int idAct, Date fecha){

        Actividad a = CA3.buscarActividad(idAct);
        String tipo = a.getClass().getSimpleName();
        int idHorario = CH2.obtenerIdHorario(fecha);
        Date diaFin = annoSiguiente(fecha);
        ArrayList<TCtrlHorSlot> elemento = CH2.obtenerSlotsDeActividad(idHorario, idAct);

        if(elemento==null)System.out.println("error");
        else{

            eliminarHorarioDeActividadConSlot(idHorario,idAct);
            eliminarAvisoDeActividad(idAct, fecha);

            if(tipo.equals(Constantes.DEADLINE)){

                Deadline d = (Deadline) a;
                asignacionAutomatica(idAct, d.getPrioridad(), elemento.size(), d.isEsLaboral(),
            fecha, d.getFechaFinal(), d.getHorasMin(), d.getHorasMax());
            }
            if(tipo.equals(Constantes.ENMENTE)){

                EnMente e = (EnMente) a;
                asignacionAutomatica(idAct, e.getPrioridad(), elemento.size(), e.isEs_laboral(),
            diaSiguiente(fecha), diaFin , e.getSlotMin(), e.getSlotMax());
            }
        }
    }

    /**
     *
     * @param idAct
     * @param inicio
     * @param fin
     */
    public void eliminarActividadFranja(int idAct, Date inicio, Date fin){

         Actividad a = CA3.buscarActividad(idAct);
        String tipo = a.getClass().getSimpleName();
        int idHorario = CH2.obtenerIdHorario(inicio);
        Date diaFin = annoSiguiente(fin);
        Date dia = (Date) inicio.clone();
        Date diaFinal = (Date) fin.clone();
        diaFinal = diaSiguiente(diaFinal);
        ArrayList<TCtrlHorSlot> elemento = null;
        int slotsBorrados = 0;

        if(tipo.equals(Constantes.DEADLINE)){

            Deadline d = (Deadline) a;

            while(!sonIguales(inicio,diaFinal)){

                elemento = CH2.obtenerSlotsDeActividad(idHorario, idAct);
                slotsBorrados = slotsBorrados + elemento.size();
                dia = diaSiguiente(dia);
            }
            borrarActividadEnFranja(idAct, inicio, diaFinal);

            asignacionAutomatica(idAct, d.getPrioridad(), slotsBorrados, d.isEsLaboral(),
        diaFinal, d.getFechaFinal(), 1, 1);
        }
        if(tipo.equals(Constantes.ENMENTE)){

            EnMente e = (EnMente) a;
            
            while(!sonIguales(dia,diaFinal)){

                elemento = CH2.obtenerSlotsDeActividad(idHorario, idAct);
                slotsBorrados = slotsBorrados + elemento.size();
                dia = diaSiguiente(dia);
            }
            borrarActividadEnFranja(idAct, inicio, diaFinal);
            asignacionAutomatica(idAct, e.getPrioridad(), slotsBorrados, e.isEs_laboral(),
        diaSiguiente(fin), diaFin , 1, 1);
        }
        if(tipo.equals(Constantes.CITAREPETITIVA)){
           // System.out.println("ES UNA CITA REPETITIVA !!!!!");
            borrarActividadEnFranja(idAct, inicio, diaFinal);
        }

    }

    private void borrarActividadEnFranja(int idAct, Date inicio, Date fin){

       int idHorario = -1;
        Date dia = (Date) inicio.clone();
        
        while(!sonIguales(dia,fin)){
            
            idHorario = CH2.obtenerIdHorario(dia);
            eliminarHorarioDeActividadConSlot(idHorario,idAct);
            eliminarAvisoDeActividad(idAct, dia);

            dia = diaSiguiente(dia);
        }
    }

    /**
     * Operacion que se dedica a reagrupar actividades en mente o deadlines despues
     * de que una cita haya sido eliminada
     *
     * @param inicio
     * @param fin
     */
    public void recuperarHoras(Date inicio, Date fin){

        ActividadConSusHoras idAct = new ActividadConSusHoras();
        idAct.idActividad=0;
        idAct.numeroDeSlots=0;
        boolean hayLibres = false;
        Stack<Integer> visitados = new Stack<Integer>();

        /*si no hemos llegado al final*/
        while(inicio.before(fin)){

            int idHorario = CH2.crearHorario(inicio);
            Date diaSig = (Date) diaSiguiente(inicio).clone();
            hayLibres = quedanSitios(idHorario);
            /*mientras nos queden sitios libres en el horairo y aun tengamos
             dias en los cuales mirar si podemos capturar slots...*/
            while(diaSig.before(fin) && hayLibres){

                    /*Si en diaSig aun hay actividades que comprobar*/
                    while(idAct!=null && idAct.idActividad >=0 && hayLibres){

                        /*buscamos un id de actividad que nos convenga y lo ponemos en
                         la cola*/
                        idAct = encontrarActividadConMasSlots(visitados, diaSig);
                        if(idAct!=null){
                            Integer e = Integer.valueOf(idAct.idActividad);
                            visitados.push(e);
                            /*si se puede colocar en el horario actual, lo ponemos,
                             visitados.peek() es el ultimo idActividad encontrado en
                             la operacion encontrarActividadConMasSlots*/
                             colocar(idAct,idHorario,diaSig);
                        }
                        hayLibres = quedanSitios(idHorario);
                    }
                    diaSig= (Date) diaSiguiente(diaSig).clone();
                    visitados = new Stack<Integer>();
                    idAct = new ActividadConSusHoras();
                    idAct.idActividad = 0;
            }
            inicio = (Date) diaSiguiente(inicio).clone();
        }
    }

    /**
     * operacion que dado un idAct busca la actividad con id distinto que ocupa
     mas slots en el horario y que ademas, tiene la prioridad mas alta
     *
     * @param visitados
     * @param actual2
     * @return
     */
    private ActividadConSusHoras encontrarActividadConMasSlots(Stack<Integer> visitados, Date actual2) {

        int idH = CH2.obtenerIdHorario(actual2);
        /*si el horario no existe, devolvemos -1*/
        if(idH<0)return null;
        ArrayList<TCtrlHorSlot> slots = CH2.obtenerSlots(idH);
        Iterator<TCtrlHorSlot> index = slots.iterator();
        ActividadConSusHoras ActividadBuena = new ActividadConSusHoras();

        /*estas variables nos ayudaran definir que idActividad nos quedamos*/
        int idActividadElegida=-1;
        int maximo = -1;
        int PrioMasAlta = -1;

        /*hacemos un "inventario" de los slots del dia*/
        int diaAct[][] = new int[24][3];

        for(int j=0;j<24;j++){

            diaAct[j][0]=0;
            diaAct[j][1]=0;
            diaAct[j][2]=0;
        }
        while(index.hasNext()){

            TCtrlHorSlot temporal = index.next();
            int k = 0;
            boolean trobat =false;
            while(diaAct[k][0]!=0 && !trobat){

                if(diaAct[k][0]==temporal.idActividad)trobat=true;
                else k++;
            }

            diaAct[k][0]=temporal.idActividad;
            diaAct[k][1]++;
            diaAct[k][2]=CA3.obtenerPrioridad(temporal.idActividad);

        }
        /*"inventario de los slots del dia hecho!*/
        int j;
        /*En este FOR buscamos que actividad nos interesa mas, teniendo en cuenta las
         que ya hemos visitado anteriormente y que estan guardadas en "visitados"*/
        for(j = 0; j<24 && diaAct[j][0]>0; j++){

            if(diaAct[j][2]>=PrioMasAlta && !visitados.contains(new Integer(diaAct[j][0]))){
                if(diaAct[j][1]>=maximo){
                    idActividadElegida = diaAct[j][0];
                    PrioMasAlta = diaAct[j][2];
                    maximo = diaAct[j][1];
                }
//                else{
//                    idActividadElegida = diaAct[j][0];
//                    PrioMasAlta = diaAct[j][2];
//                }

            }
        }
        ActividadBuena.idActividad = idActividadElegida;
        ActividadBuena.numeroDeSlots = maximo;
        return ActividadBuena;
    }

    /**
     * operacion mas complicada:
     dada una actividad idAct que viene de la fecha diaSig, se intenta insertar
     en el horario con id idH pero teniendo en cuenta de que no puede borrar
     ninguna actividad.
     * @param idAct
     * @param idH
     * @param diaSig
     */
    private void colocar(ActividadConSusHoras idAct, int idH, Date diaSig) {

        int iniJorLab = JL.getHoraInicioJornadaLaboral();
        int finJorLab = JL.getHoraFinJornadaLaboral();
        int iniJorOc = JL.getHoraInicioJornadaOcio();
        int finJorOc = JL.getHoraFinJornadaOcio();
        int idHorarioSiguiente = CH2.obtenerIdHorario(diaSig);
        if(idHorarioSiguiente<0)System.out.println("error");

        ArrayList<TCtrlHorSlot> slotsAct = CH2.obtenerSlotsDeActividad(idH, idAct.idActividad);
        if(slotsAct==null || slotsAct.isEmpty()){

            Actividad a = this.buscarActividad(idAct.idActividad);
            String tipo = this.obtenerTipoActividad(idAct.idActividad);
            boolean dia[] = devuelveSlots(idH);

            boolean insertado=false;

            int inicioJ;
            int finJ;

            /*la actividad es en mente*/
            if(tipo.equals("EnMente")){

                EnMente e = (EnMente) a;
                int SlotsPorDia = idAct.numeroDeSlots;

                if(e.isEs_laboral()){
                    inicioJ=iniJorLab;
                    finJ=finJorLab;
                }
                else{
                    inicioJ=iniJorOc;
                    finJ=finJorOc;
                }

                /*llamamos a la operacion insertarActividadEnHorario que si hay sitio
                 coloca la actividad idAct en el horario idH*/
                insertado = insertarActividadEnHorario(inicioJ,finJ,idAct.idActividad,idH,dia,SlotsPorDia);

                /*si hemos insertado, borramos la actividad en el horario con id
                 idHorarioSiguiente que se refiere al horario con fecha diaSig
                 (perdon por la redundancia pero estoy muy cansado)*/
                if(insertado){

                   eliminarHorarioDeActividadConSlotSinBorrarIdHorario(idHorarioSiguiente, idAct.idActividad);
                }

              }

            /*funciona igual que en mente*/
            else if(tipo.equals("Deadline")){

                Deadline d = (Deadline) a;
                int SlotsPorDia = idAct.numeroDeSlots;

                if(d.isEsLaboral()){
                    inicioJ=iniJorLab;
                    finJ=finJorLab;
                }
                else{
                    inicioJ=iniJorOc;
                    finJ=finJorOc;
                }

                insertado = insertarActividadEnHorario(inicioJ,finJ,idAct.idActividad,idH,dia,SlotsPorDia);

                if(insertado){

                    eliminarHorarioDeActividadConSlotSinBorrarIdHorario(idHorarioSiguiente, idAct.idActividad);
                }
            }
        }
    }

    /**
     * dado un horario, nos indica si aun quedan slots por asignar
     *
     * @param idHorario
     * @return
     */
    private boolean quedanSitios(int idHorario) {

        ArrayList<TCtrlHorSlot> slots = CH2.obtenerSlots(idHorario);
        if(slots==null)return true;

        int iniJorLab = JL.getHoraInicioJornadaLaboral();
        int finJorLab = JL.getHoraFinJornadaLaboral();
        int iniJorOc = JL.getHoraInicioJornadaOcio();
        int finJorOc = JL.getHoraFinJornadaOcio();

        int slotsParaActividades = (finJorLab-iniJorLab)+(finJorOc-iniJorOc);

        return (slotsParaActividades!=slots.size());
    }

    /**
     * operacion que devuelve un array de booleanos donde las posiciones
     ciertas indican la presencia de una actividad
     *
     * @param idH
     * @return
     */
    public boolean[] devuelveSlots(int idH){

          ArrayList<TCtrlHorSlot> slots = CH2.obtenerSlots(idH);
          Iterator<TCtrlHorSlot> index = slots.iterator();

          boolean dia[] = new boolean[24];

          int i;
          int horas = 0;
          /*Inicializamos el array dia a falso*/
          for(i=0;i<dia.length;i++){
              dia[i]=false;
          }

          if(slots==null)return dia;
          /*si hay slots ocupados ponemos su posicion en el array en true*/
          while(index.hasNext()){
              TCtrlHorSlot temporal = index.next();
              dia[temporal.slot]=true;
          }
        
        return dia;
    }

    /**
     * busca entre la franja inicioJ y finJ una posicion donde insertar la actividad
     idAct
     * @param inicioJ
     * @param finJ
     * @param idAct
     * @param idH
     * @param dia
     * @param SlotsPorDia
     * @return
     */
    private boolean insertarActividadEnHorario(int inicioJ, int finJ, int idAct, int idH,
            boolean[] dia, int SlotsPorDia) {

        int i = inicioJ;
        int horas = 0;
        while(i<=finJ){
            /*calculamos el intervalo de slots libres que hay entre dos slots
            ocupados*/
            while(!dia[i] && i<=finJ){
              horas++;
              i++;
            }//fin while
            /*si hemos encontrado un intervalo suficientemente grande, lo retornamos*/
            if(horas>=SlotsPorDia){
                horas = i-horas;
            for(int inicio=0;inicio<SlotsPorDia;inicio++){

                System.out.println("que actividad estamos insertando? "+idAct);
                asignarHorarioActividad(idH, idAct);
                CH2.asignarActividad(idAct, idH);
                insertarConSlot(idH, horas+inicio, idAct);
            }
            return true;
            }
            if(horas<SlotsPorDia && i<=finJ){

              horas =0;
              i++;
            }//fin if
        }
        return false;
    }
}
