
package agendainteligente;
import java.io.Serializable;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Enumeration;
import java.util.Hashtable;
import java.util.TreeSet;
import java.util.Iterator;
/**
 * controladora de domino encargada de gestionar e interrelacionar las diferentes
 * clases de del programa.
 * author carlos Vivas Abilahoud
 */


public class CtrlDominio3 extends CtrlDominio2 implements Serializable{

    protected static CtrlAvisos CAV = new CtrlAvisos();
    protected static CtrlActividad3 CA3;
    protected static CtrlHorario2 CH2;
    protected static JornadaLaboral JL = new JornadaLaboral();
    protected static CtrlVistaPrincipal CVP = new CtrlVistaPrincipal();
    protected static CtrlListarAvisos CLA = new CtrlListarAvisos();
    protected static CtrlListarEnMente CLEM = new CtrlListarEnMente();

    public CtrlDominio3(){
    }//fin operacion


    public void listarAnadidos(){

        System.out.println( "Imprimiendo lista");
        TCtrlAct CAct = null;
        Enumeration e = CA3.hashAct.keys();
        TreeSet<Integer> hors;
        while( e. hasMoreElements() ){
            System.out.println();
            CAct = (TCtrlAct) CA3.hashAct.get(e.nextElement());
            System.out.println( CAct.tAct.titulo);
            System.out.println( "Id: "+ CAct.tAct.idActividad);
            hors = CA3.obtenerHorarios( CAct.tAct.idActividad);
            if (hors!=null && !hors.isEmpty()){
                System.out.println("listado de horarios de"+CAct.tAct.titulo);
                 int h1= (hors.first()).intValue();
                  CH2.listarHorario(h1);
                  } //fin IF
        }

    }//fin operacion

    public Object[] getTemas(){

        ArrayList<String> temas= CT.listartemas();
        Object[] temasExistentes= temas.toArray();
        return temasExistentes;
    }//fin operacion


    public void cargar() throws IOException, ClassNotFoundException {

     // Operacion cargar obtiene todos los listados de las controladoras
     // de los ficheros de la carpeta /object y los carga en las controladoras
        super.cargar();
        Object obj1 = gestor.cargar("objects/avisos.obj");
        CAV.setCtrlHorarioAviso((Hashtable) obj1);
        Object obj2 = gestor.cargar("objects/actividavisos.obj");
        CA3.setCtrlActividad3((Hashtable) obj2);
        Object obj3 = gestor.cargar("objects/jornadahf.obj");
        JL.setHoraFinJornadaLaboral(Integer.parseInt(obj3.toString()));
        Object obj4 = gestor.cargar("objects/jornadafo.obj");
        JL.setHoraFinJornadaOcio(Integer.parseInt(obj4.toString()));
        Object obj5 = gestor.cargar("objects/jornadahi.obj");
        JL.setHoraInicioJornadaLaboral(Integer.parseInt(obj5.toString()));
        Object obj6 = gestor.cargar("objects/jornadaio.obj");
        JL.setHoraInicioJornadaOcio(Integer.parseInt(obj6.toString()));
        Object obj7 = gestor.cargar("objects/indiceactividad.obj");
        CA3.setIndiceActividad(Integer.parseInt(obj7.toString()));
        Object obj8 = gestor.cargar("objects/indiceaviso.obj");
        CAV.setIndiceAviso(Integer.parseInt(obj8.toString()));
        Object obj9 = gestor.cargar("objects/indicehorario.obj");
        CH2.setIndiceHorario(Integer.parseInt(obj9.toString()));

        //PERMITIR CARGAR DE JORNADA LABORAL


    }//fin operacion

    public void guardar() throws IOException {
      // Operacion guardar obtiene todos los listados de las controladoras
      // y los guarda para no perder los cambios al cerrar el programa*/

        super.guardar();
        gestor.guardar(CAV.getCtrlHorarioAviso(), "objects/avisos.obj");
        gestor.guardar(CA3.getCtrlActividad3(), "objects/actividavisos.obj");
        gestor.guardar(JL.getHoraFinJornadaLaboral(), "objects/jornadahf.obj");
        gestor.guardar(JL.getHoraFinJornadaOcio(), "objects/jornadafo.obj");
        gestor.guardar(JL.getHoraInicioJornadaLaboral(), "objects/jornadahi.obj");
        gestor.guardar(JL.getHoraInicioJornadaOcio(), "objects/jornadaio.obj");
        gestor.guardar(CA3.getIndiceActividad(), "objects/indiceactividad.obj");
        gestor.guardar(CH2.getIndiceHorario(), "objects/indicehorario.obj");
        gestor.guardar(CAV.getIndiceAviso(),"objects/indiceaviso.obj");

    }//fin operacion

    public void asignarCtrlActividadPropio(CtrlActividad3 control) {
      /* Operacion asigna el CtrlActividad al dominio, en el main cada uno crea el suyo */
		CA3=control;
        CA2=(CtrlActividad2) control;
        CA=(CtrlActividad)control;

	}//fin operacion

    public void asignarCtrlHorarioPropio(CtrlHorario2 control) {
      /* Operacion asigna el CtrlActividad al dominio, en el main cada uno crea el suyo */
		CH2=control;
        CH=(CtrlHorario) control;
    }//fin operacion



    @Override

public boolean eliminarActividad(int idA) {
/*elimina por completo todas las instancias de una actividad*/
        TreeSet<Integer> horarios;
        horarios= CA3.obtenerHorarios(idA);

        if (horarios==null){return false;}
        while ( !horarios.isEmpty()){
            Integer actual = horarios.first();
            eliminarHorarioDeActividadConSlot(actual.intValue(), idA);
            horarios.remove(actual);
        }//fin while

        ArrayList<Tema> temas;
        temas=CA3.obtenerTemas(idA);
        ArrayList<Tema> temas2 = new ArrayList<Tema>(temas);
        Iterator<Tema> it1= temas2.iterator();
        while (it1.hasNext()){
            Tema actual = it1.next();
            CT.quitarTema(actual.getNom(), idA);
        }//fin while
        ArrayList<Integer> avisos;
        avisos=CA3.obtenerAvisos(idA);
        ArrayList<Integer> avisos2 = new ArrayList<Integer>(avisos);
        Iterator<Integer> it2 = avisos2.iterator();
        while(it2.hasNext()){
            Integer actualAviso = it2.next();
            eliminarAvisoDeActividad(actualAviso.intValue(),idA);
            //CAV.borrarActividad(idA, actualAviso.intValue());

        }//fin while
        

        return CA3.eliminarActividad(idA);
        
    }//fin operacion

   

    /**
     * Operacion que dependiendo del tipo, crea un tipo de actividad
     * @param titulo
     * @param descripcion
     * @param tipo
     * @return
     */
    public int crearActividad(String titulo, String descripcion, String tipo) {
        /*Crea una actividad*/
    int idA = 0;
        if (tipo.equals(Constantes.CITA)){

            idA=CA3.crearCita(titulo,descripcion);

        }//end if
        else if (tipo.equals(Constantes.ENMENTE)){

            idA=CA3.crearEnMente(titulo,descripcion);

        }//end if
        else if (tipo.equals(Constantes.DEADLINE)){

            idA=CA3.crearDeadline(titulo,descripcion);


        }//end if
        else if (tipo.equals(Constantes.ANIVERSARIO)){

            idA=CA3.crearAniversario(titulo,descripcion);


        }//end if
        else if (tipo.equals(Constantes.MEMORANDUM)){

            idA=CA3.crearMemorandum(titulo,descripcion);


        }//end if
        else if (tipo.equals(Constantes.CITAREPETITIVA)){

            idA=CA3.crearCitaRepetitiva(titulo,descripcion);

        }//end if

    return idA;
    }//fin operacion

    public void completarCita(int idAct, boolean rep, boolean lab) {
        /*completa una cita despues de crear la actividad*/
        CA3.completarCita(idAct,rep,lab);

    }//fin operacion

    public void completarEnMente(int idAct, int prioridad, int iNHores, boolean eslab,
            int horasMin, int horasMax, Date fechaInicio) {

        CA3.completarEnMente(idAct,prioridad, iNHores, eslab,horasMin,horasMax,fechaInicio);

    }//fin operacion

     public void completarAniversario(int idAct,Date fechaN) {
        CA3.completarAniversario(idAct,fechaN);
         for(int i=0; i<110;i++){
            this.crearHorario(fechaN, idAct);
            fechaN=annoSiguiente(fechaN);
         }
    }//fin operacion

    public void completarCitaRepetitiva(int idAct,boolean eslab, int per, Date fechaIniP,Date fechaP) {
        CA3.completarCitaRepetitiva(idAct,eslab, per,fechaIniP,fechaP);
    }//fin operacion

    public void completarDeadline(int idAct,Date fechaf, int numHores, int prio, boolean eslab,int horasMin, int horasMax, Date fechaInicio) {
        CA3.completarDeadline(idAct,fechaf,numHores,prio,eslab,horasMin,horasMax,fechaInicio);
    }//fin operacion

    public void completarMemorandum(int idAct,String texto, Date fecha) {
        CA3.completarMemorandum(idAct,texto);
        this.crearHorario(fecha, idAct);
    }//fin operacion

    public int crearHorario(Date fecha, int idActividad) {
        /*Crea un horario*/
        int idh= CH2.crearHorario(fecha);
        CH2.asignarActividad(idActividad, idh);
        return idh;

    }//fin operacion

    public int crearAviso(Date fecha, int idActividad) {
    /*crea un aviso*/
        String titul = this.obtenerTitulo(idActividad);
        int idAviso=CAV.crearAviso(fecha,idActividad,titul);
        CA3.asignarAvisoActividad(idAviso, idActividad);
        return idAviso;

    }//fin operacion

    @SuppressWarnings("deprecation")
    public int crearAvisoDeadline(Date fecha, int idActividad) {
    /*crea un aviso*/
        String titul = this.obtenerTitulo(idActividad);
        titul=titul.concat("en la fecha "+fecha.getDate()+"//"+(fecha.getMonth()+1)+"//"+(fecha.getYear()+1900));
        int idAviso=CAV.crearAviso(fecha,idActividad,titul);
        CA3.asignarAvisoActividad(idAviso, idActividad);
        return idAviso;

    }//fin operacion



    void insertarConSlot(int idH, int slot,int idAct) {

        /*inserta en el horario con id=idH el slot slot.*/
        CH2.insertarConSlot(idH,slot,idAct);
    }//fin operacion

    public void asignarHorarioActividad(int idH, int idA){
    /*se le asigna un horario a una actividad*/
        CA3.asignarHorario(idH, idA);

    }//fin operacion

    /*operacion creada para eliminar los avisos*/
    public boolean eliminarAvisoDeActividad(int idAv, int idA) {

        /*Elimina la actividad idA de la estructura de avisos con aviso == idAv
         * luego si ese aviso no tiene mas actividades asociadas, se elimina.
         * tras esto , se elimina la asociacion entre la actividad idA con el aviso
         * idAv.
         */
        
        CAV.borrarActividad(idA, idAv);
        ArrayList<Integer> lista = CAV.dameIdActividades(idAv);
        if (lista == null || lista.isEmpty())CAV.eliminarAviso(idAv);
        CA3.eliminarAvisodDeActividad(idA, idAv);


        return true;
    }//fin operacion
/**
 * Elimina la actividad idA de la estructura de avisos con el aviso que contiene
 * como fecha fechaAviso y que esta asociado a la actividad con id = idActividad
 * luego si ese aviso no tiene mas actividades asociadas, se elimina.
 * tras esto , se elimina la asociacion entre la actividad idActividad con el aviso
 * idAv.
 * @param idActividad
 * @param fechaAviso
 */
    public void eliminarAvisoDeActividad (int idActividad, Date fechaAviso){

        ArrayList<Integer> listaAvisos=CA3.obtenerAvisos(idActividad);
        boolean encontrado = false;
        Integer actual=null;
        Aviso aviso;
        if (listaAvisos != null){
            Iterator<Integer> it = listaAvisos.iterator();
            while (!encontrado && it.hasNext()){

                actual = it.next();
                aviso = CAV.buscarAvisos(idActividad);
                if (aviso !=null){

                    if (fechasIguales(aviso.getFechaAviso(),fechaAviso)){

                        encontrado = true;
                        int idAviso = aviso.getIdAviso();
                        CAV.borrarActividad(idActividad, idAviso);
                        ArrayList<Integer> lista = CAV.dameIdActividades(idAviso);
                        if (lista == null || lista.isEmpty())CAV.eliminarAviso(idAviso);
                        CA3.eliminarAvisodDeActividad(idActividad, idAviso);

                    }//end if
                }//end if
           }//end while
        }//end if
    }//fin operacion

    /**
     * como fecha fechaAviso y que esta asociado a la actividad con id = idActividad
     * luego si ese aviso no tiene mas actividades asociadas, se elimina.
     * tras esto , se elimina la asociacion entre la actividad idActividad con el aviso
     * idAv.

     * @parm idActividad
     * @param fechaAviso
     * @return
     */
    public boolean tieneAviso(int idActividad, Date fechaAviso){
 
        ArrayList<Integer> listaAvisos=CA3.obtenerAvisos(idActividad);
        boolean encontrado = false;
        Integer actual=null;
        Aviso aviso;
        if (listaAvisos != null){
            Iterator<Integer> it = listaAvisos.iterator();
            while (!encontrado && it.hasNext()){

                actual = it.next();
                aviso = CAV.buscarAvisos(idActividad);
                if (aviso !=null){

                    if (fechasIguales(aviso.getFechaAviso(),fechaAviso)){

                        encontrado = true;
                    }//end if
                }//end if
           }//end while
        }//end if
        return encontrado;
    }//fin operacion

    public String obtenerTema (int idActividad){

        String a = Constantes.NINGUNO;
        ArrayList<Tema> lista= CA3.obtenerTemas(idActividad);
        if (lista!=null && !lista.isEmpty()){
              a = lista.get(0).getNom();
        }
        return a;

    }


    @SuppressWarnings("deprecation")
    private boolean fechasIguales(Date dataH, Date data0) {

        return (dataH.getDate() == data0.getDate() && dataH.getMonth() == data0.getMonth()
                && dataH.getYear() == data0.getYear());
    }

    /*operacion para listar en una arrayList todos los nombres de actividades
     con sus Ids*/
    public ArrayList<IdNombre> listarActividadEspecifica(String tipo) {

        ArrayList<IdNombre> lista = null;
        lista = CA3.listarActividadEspecifica(tipo);

        return lista;
    }//fin operacion

    public void modificarGestionJornada(int hInicioLabo, int hFinLabo, int hInicioO, int hFinO){

        JL.setHoraInicioJornadaLaboral( hInicioLabo );
        JL.setHoraInicioJornadaOcio( hInicioO );
        JL.setHoraFinJornadaLaboral( hFinLabo );
        JL.setHoraFinJornadaOcio( hFinO );
    }//fin operacion

    public static Date diaSiguiente(Date date){

       Calendar cal = Calendar.getInstance();
       cal.setTime (date);
       cal.add (Calendar.DATE, 1);
       return cal.getTime();
    }//fin operacion

        public static Date diaAnterior(Date date){

       Calendar cal = Calendar.getInstance();
       cal.setTime (date);
       cal.add (Calendar.DATE, -1);
       return cal.getTime();
    }//fin operacion

    public static Date semanaSiguiente(Date date){

       Calendar cal = Calendar.getInstance();
       cal.setTime (date);
       cal.add (Calendar.WEEK_OF_YEAR, 1);
       return cal.getTime();
    }//fin operacion

    public static Date mesSiguiente(Date date){
   //vigilar dias mes

       Calendar cal = Calendar.getInstance();
       cal.setTime (date);
       cal.add (Calendar.MONTH, 1);
       return cal.getTime();
    }//fin operacion

    public static Date annoSiguiente(Date date){

        //vigilar si bisexto
       Calendar cal = Calendar.getInstance();
       cal.setTime (date);
       cal.add (Calendar.YEAR, 1);
       return cal.getTime();
    }//fin operacion

    public ArrayList<Integer> obtenerIdActividades(Date data){
        /*dada una fecha, retorna en un arraylist el id de las actividades de esa fecha*/

        int idHorario = CH2.obtenerIdHorario(data);
        ArrayList<Integer> idActividades=null;
        if (idHorario >0 ){
             idActividades=CH2.dameIdActividades(idHorario);
        }//end if

        return idActividades;
    }//fin operacion

    public ArrayList<TCtrlHorSlot> obtenerSlots(Date data){
    /*dado una fecha, retorna los slots de esa fecha.*/
        int idHorario = CH2.obtenerIdHorario(data);

        ArrayList<TCtrlHorSlot> slots=null;
        if (idHorario >0 ){
             slots=CH2.obtenerSlots(idHorario);
        }//end if

        return slots;
    }//fin operacion


    public String obtenerTitulo(int idActividad) {
        /*Dado un id de actividad, retorna su titulo*/
        Actividad temp = CA3.buscarActividad(idActividad);
        if (temp!=null) return temp.getTitulo();
        return "";
    }//fin operacion

    public boolean esEvento (int idAct){
    /*dado un idActividad, nos dice si es un aniversario o un memorandum*/

        Actividad temp = CA3.buscarActividad(idAct);
        boolean esEvent = false;

        if (temp!=null){

            String tipo = temp.getClass().getSimpleName();
           // System.out.println("el tipo de actividad en EsEvento es : " +tipo);
            if ((tipo.equals(Constantes.MEMORANDUM)) || (tipo.equals(Constantes.ANIVERSARIO))) {

                esEvent = true;
               // System.out.println("Es un evento efectivamente  "+esEvent);

            }//end if

        }//end if

        return esEvent;

    }//fin operacion

    public int obtenerHorasHechas(int idActividadSeleccionada) {

        return CA3.obtenerHorasHechas(idActividadSeleccionada);

    }//fin operacion

    public Date getDiaInicioSemanaActual(){


       return (Date) CVP.getDiaInicioSemanaActual().clone();

    }

    public Date getDiaIndicadoActualmente(){

        return (Date) CVP.getDiaIndicadoActualmente().clone();

    }

    public TCtrlVista[][] getSemanaHorario(){

        return CVP.getSemanaHorario();

    }

    int obtenerIdActividad(int fila, int i, TCtrlVista[][] semanaHorario) {
        return CVP.obtenerIdActividad(fila, i, semanaHorario);
    }

    String obtenerTituloAct(int i, TCtrlVista[] diaHorario) {
        return CVP.obtenerTituloAct(i, diaHorario);
    }

    String obtenerTituloAct(int fila, int columna, TCtrlVista[][] semanaHorario) {
        return CVP.obtenerTituloAct(fila, columna, semanaHorario);
    }

    void rellenarTablas(Calendar c) {

        CVP.rellenarTablas(c);

    }
    
    TCtrlVista obtenerElementoDia (int fila){
        return CVP.obtenerElementoDia(fila, this.getDiaHorario());
    
    }
    TCtrlVista obtenerElementoSemana (int fila, int columna){
        return CVP.obtenerElementoSemana(fila, columna, this.getSemanaHorario());
    }
    TCtrlVista obtenerElementoSemanaEvento (int fila, int columna){
        return CVP.obtenerElementoSemana(fila, columna, this.getSemanaEvento());
    }




    TCtrlVista[][] getSemanaEvento() {
        return CVP.getSemanaEvento();
    }

    TCtrlVista[] getDiaHorario(){
        return CVP.getDiaHorario();
    }

    public Date obtenerFechaDiaSeleccionado(Date d, int columna) {

        Date temp = new Date();
        temp = (Date) d.clone();
        for (int i =0;i<(columna-1);i++) temp =CtrlDominio3.diaSiguiente(temp);
        return temp;

    }

    public String obtenerDescripcionActividad(int idAct){

        String desc = "";
        Actividad act = CA.buscarActividad(idAct);
        if (act!= null) desc = act.getDescripcion();
        return desc;
    }

    public ArrayList<TCtrlHorSlot> obtenerSlotsDeActividadConFecha(int idAct, Date fecha){

        int idHorario = CH2.obtenerIdHorario(fecha);
        ArrayList<TCtrlHorSlot> lista = CH2.obtenerSlotsDeActividad(idHorario, idAct);

        return lista;


    }

    @Override
    public boolean eliminarHorarioDeActividad(int idH, int idA) {

        CH2.borrarActividad2(idA, idH);
       return CA3.eliminarHorariodDeActividad(idA, idH);
    }//fin operacion

    public boolean eliminarHorarioDeActividadConSlot(int idH, int idA) {

        /*dado un idActividad y un idHorario, elimina de la estructura de
         * horarios los slots de la actividad idA, la actividad idA
         * Y en el caso de que el horario no tuviese ninguna actividad asociada
         * se eliminaria el horario.
         * tras eliminar la actividad de la estructura de horarios, elimina el horario 
         * de la estructura de actividades. 
         */
        
        CH2.borrarActividadConSlot(idA, idH);
        CH2.borrarActividad2(idA, idH);
        ArrayList<Integer> lista = CH2.dameIdActividades(idH);
        if (lista==null || lista.isEmpty() ){
            CH2.eliminarHorario(idH);
        }
       return CA3.eliminarHorariodDeActividad(idA, idH);
    }//fin operacion


    public Actividad buscarActividad (int idActividad){

        return CA.buscarActividad(idActividad);
    }

public Hashtable getHashAvisos(){
      return CAV.getCtrlHorarioAviso();
  }

 public Aviso buscarAvisos(int idAviso){
     return CAV.buscarAvisos(idAviso);
 }

 public ArrayList<Integer> obtenerIdAviso(Date fecha){

     return CAV.obtenerIdAviso(fecha);
 }

 public Date obtenerFechainicioSemana(Calendar c){

        Date diaIntroducido = c.getTime();
        int diaSemana = c.get(Calendar.DAY_OF_WEEK);
        if (diaSemana>2 && diaSemana<8){

            c.add(Calendar.DATE, -(diaSemana-2));

        }//end if

        else if (diaSemana==1) {

            c.add(Calendar.DATE, -6);

        }//end if

        Date inicioSemana = c.getTime();

        return inicioSemana;


 }
 public String obtenerTipoActividad(int idActividad){

     String tipo ="";
     Actividad act = buscarActividad(idActividad);
     if (act != null) tipo = act.getClass().getSimpleName();
     return tipo;

 }
 public void insertarInformacionGenerica(int idAct, String titulo, String descripcion){

     CA3.insertarInformacionGenerica(idAct,titulo,descripcion);
 }
 public void setJornadaLaboralDefecto (int inil,int finl, int inio, int fino){

     JL.setHoraInicioJornadaLaboral(inil);
     JL.setHoraFinJornadaLaboral(finl);
     JL.setHoraInicioJornadaOcio(inio);
     JL.setHoraFinJornadaOcio(fino);


 }



    @Override
public boolean eliminarTema( String nombre){

    boolean b=false;
    ArrayList<TemaActividad> ta=CT.getCtrlTema();
    Iterator<TemaActividad> itl=ta.iterator();
    while (!b && itl.hasNext()){

        TemaActividad actual=itl.next();
        if (actual.tema.getNom().equalsIgnoreCase(nombre)){
            b=true;
            ArrayList<IntStr> aux =actual.nombresActi;
            Iterator<IntStr> it2=aux.iterator();
            while (it2.hasNext()) {
                IntStr act = it2.next();
                CA3.desasignarTemaActividad(act.idAct, actual.tema);
            }

            CT.quitarTodasActividadesTema(nombre);
            CT.eliminarTema(nombre);
        }
  }
    return b;

}//fin operacion

    public void eliminarHorarioDeActividadConSlotSinBorrarIdHorario(int idH,int idA){

                    CH2.borrarActividadConSlot(idA, idH);
                    CH2.borrarActividad2(idA, idH);
                    CA3.eliminarHorariodDeActividad(idA, idH);

    }

    public ArrayList<TCtrlListar> obtenerListadoDeAvisos (){

        return CLA.getTitulos();

    }

        public ArrayList<TCtrlListar> obtenerListadoDeOtros (){

        return CLEM.getT();

    }

    public void rellenarListas(Calendar c){

       ArrayList<TCtrlListar> temporal= null;
       ArrayList<TCtrlListar> defin1 =null;
       ArrayList<TCtrlListar> defin2 = new ArrayList<TCtrlListar>();
       Date iniSem = this.obtenerFechainicioSemana(c);
       boolean insertado = false ;
       for (int i =0;i<7;i++){

           temporal = CLA.getTitulos(iniSem);

           if (temporal!=null){
               defin2.addAll(CLA.getTitulos(iniSem));
               insertado = true;

           }
           iniSem = CtrlDominio3.diaSiguiente(iniSem);


       }

           defin1= CLEM.getTitulosEnMente();
           if (!insertado) CLA.setTitulos(null);
           else{CLA.setTitulos(defin2);}
           CLEM.setT(defin1);


    }

}//fin clase
