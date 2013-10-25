/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * vistaPrincipal.java
 *
 * Created on 29-abr-2009, 10:25:49
 */

package agendainteligente;

import java.awt.CardLayout;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author carlos Vivas Abilahoud
 */
public class vistaPrincipal extends javax.swing.JFrame {
                         CtrlDominio3 CD3 =  new CtrlDominio3();
                         CtrlListarAvisos CLA = new CtrlListarAvisos();
                         CtrlListarEnMente CLEM = new CtrlListarEnMente();
                         ArrayList<TCtrlListar> listAvisos;
                         ArrayList<TCtrlListar> listOtros;




    /** Creates new form vistaPrincipal */
    public vistaPrincipal() {
        initComponents();
        h1 = new VistaSemanaHorario();
        h2 = new VistaSemanaEvento ();
        d1 = new VistaDiaHorario();
        la = new vistaListaAvisos();
        lo = new vistaListaOtros();

      //  VistaDiaEvento d2 = new VistaDiaEvento();

        jPanel1.add(h1,Constantes.SEMHOR);
        jPanel1.add(h2,Constantes.SEMEV);
        jPanel1.add(d1,Constantes.DIAHOR);
        jPanel2.add(la,Constantes.LISTAAVISOS);
        jPanel2.add(lo,Constantes.LISTAOTROS);
        //jPanel1.add(d2,"diaev");
        CardLayout cl = (CardLayout)(jPanel1.getLayout());
        cl.show(jPanel1,Constantes.SEMHOR);
        ventanaActiva = Constantes.SEMHOR;
        CardLayout c2 = (CardLayout)(jPanel2.getLayout());
        c2.show(jPanel2,Constantes.LISTAAVISOS);
        this.listaActiva = Constantes.LISTAAVISOS;

        TableCellRenderer rendererdia1= new CustomTableCellRenderer();
        TableCellRenderer rendererdia2= new DefaultTableCellRenderer();
        this.d1.tablaHorarios.setDefaultRenderer(String.class, rendererdia2);
        this.d1.tablaHorarios.setDefaultRenderer(Object.class, rendererdia1);
        

        TableCellRenderer rendererSemana1= new CustomTableCellRenderer();
        TableCellRenderer rendererSemana2= new DefaultTableCellRenderer();
        this.h1.tablaHorarios.setDefaultRenderer(String.class, rendererSemana2);
        this.h1.tablaHorarios.setDefaultRenderer(Object.class, rendererSemana1);

        TableCellRenderer rendererSemanaE1= new CustomTableCellRenderer();
        TableCellRenderer rendererSemanaE2= new DefaultTableCellRenderer();
        this.h2.tablaHorarios.setDefaultRenderer(String.class, rendererSemanaE2);
        this.h2.tablaHorarios.setDefaultRenderer(Object.class, rendererSemanaE1);

        this.d1.tablaHorarios.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);


        



        actualizarTablas(fechaActualJdate());
        
    }

    public void actualizarTablas(Calendar c) {
       Calendar c2 = (Calendar) c.clone();
        CD3.rellenarTablas(c);
       TCtrlListar actual=null;
//       listAvisos=new ArrayList<TCtrlListar>();
//       listOtros = new ArrayList<TCtrlListar>();
       this.la.list1.removeAll();
       this.lo.list1.removeAll();
       CD3.rellenarListas(c);

       if (ventanaActiva.equals(Constantes.SEMHOR)){mostrarSemanaHorario();}
       if (ventanaActiva.equals(Constantes.SEMEV)){mostrarSemanaEvento();}
       if (ventanaActiva.equals(Constantes.DIAHOR)){mostrarDiaHorario();}

       listAvisos = CD3.obtenerListadoDeAvisos();
       listOtros = CD3.obtenerListadoDeOtros();

       if (listAvisos !=null && !listAvisos.isEmpty()){
       Iterator<TCtrlListar> it = listAvisos.iterator();
       while (it.hasNext()){
            actual = it.next();
            String tipo = CD3.obtenerTipoActividad(actual.getIdAct());
            la.list1.add(actual.getTitulo());
            if (tipo.equals(Constantes.CITA)){
            this.la.list1.setForeground(Color.orange);

            }
            if (tipo.equals(Constantes.CITAREPETITIVA)){
                this.la.list1.setForeground(Color.cyan);

            }
            if (tipo.equals(Constantes.DEADLINE)){
            this.la.list1.setForeground(Color.blue);}
            if (tipo.equals(Constantes.ANIVERSARIO)){
            this.la.list1.setForeground(Color.darkGray);
            }
            

       }
       }

       if (listOtros!=null && ! listOtros.isEmpty()){
       Iterator<TCtrlListar> it2 = listOtros.iterator();
       while (it2.hasNext()){

           actual = it2.next();
           lo.list1.add(actual.getTitulo());
           this.lo.list1.setForeground(Color.BLUE);

       }



       }


       actualizarTituloDia(c2);

    }

    private void mostrarSemanaHorario(){

        int i;
        for (i=0;i<Constantes.CASILLASSEMANAHORA;i++){
            h1.tablaHorarios.setValueAt(CD3.obtenerElementoSemana(i/7, i%7), i/7, (i%7)+1);
        }
        h1.fechaInicioSemana = (Date) CD3.getDiaInicioSemanaActual().clone();
       
    }
    
    private void mostrarSemanaEvento(){

        for (int i=0;i<Constantes.CASILLASSEMANAEVENTO;i++){
            h2.tablaHorarios.setValueAt(CD3.obtenerElementoSemanaEvento(i/7, i%7), i/7, (i%7));
        }
        h2.fechaInicioSemana = (Date) CD3.getDiaInicioSemanaActual().clone();

    }
    private void mostrarDiaHorario(){


        for (int i=0;i<Constantes.CASILLASDIAHORA;i++){

            d1.tablaHorarios.setValueAt(CD3.obtenerElementoDia(i), i, 1);
        }

    


    }

    private Calendar fechaActualJdate(){

             Iterable<Calendar>dates = dateChooserPanel1.getSelectedPeriodSet().getDates();
        @SuppressWarnings("unchecked")
           ArrayList<Calendar> list = new ArrayList();

           for (Calendar oneDate : dates) {
            list.add(oneDate);

            }
           return list.get(0);

    }

    private void actualizarTituloDia(Calendar c){

        int diaSemana = c.get(Calendar.DAY_OF_WEEK);
        switch (diaSemana){

            case 1 : this.d1.tablaHorarios.getColumnModel().getColumn(1).setHeaderValue("Domingo");break;
            case 2 : this.d1.tablaHorarios.getColumnModel().getColumn(1).setHeaderValue("Lunes");break;
            case 3 : this.d1.tablaHorarios.getColumnModel().getColumn(1).setHeaderValue("Martes");break;
            case 4 : this.d1.tablaHorarios.getColumnModel().getColumn(1).setHeaderValue("Miercoles");break;
            case 5 : this.d1.tablaHorarios.getColumnModel().getColumn(1).setHeaderValue("Jueves");break;
            case 6 : this.d1.tablaHorarios.getColumnModel().getColumn(1).setHeaderValue("Viernes");break;
            case 7 : this.d1.tablaHorarios.getColumnModel().getColumn(1).setHeaderValue("Sabado");break;
            default : break;


        }
this.d1.tablaHorarios.getColumnModel().getColumn(0).setMinWidth(40);
this.d1.tablaHorarios.getColumnModel().getColumn(0).setMaxWidth(60);
this.d1.tablaHorarios.getColumnModel().getColumn(1).setMinWidth(772);
this.d1.tablaHorarios.getColumnModel().getColumn(1).setMaxWidth(772);
        this.jPanel1.repaint();

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        textField1 = new java.awt.TextField();
        dateChooserPanel1 = new datechooser.beans.DateChooserPanel();
        jSeparator2 = new javax.swing.JSeparator();
        dia = new java.awt.Button();
        semana = new java.awt.Button();
        jButton1 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        General = new javax.swing.JButton();
        gestionJornada = new javax.swing.JButton();
        gestionActividad = new javax.swing.JButton();
        estadisticas = new javax.swing.JButton();
        manual = new javax.swing.JButton();
        acercaDe = new javax.swing.JButton();
        gestionTemas = new javax.swing.JButton();
        cargar = new javax.swing.JButton();
        guardar = new javax.swing.JButton();
        verEventos = new java.awt.Button();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        cambioListas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Agenda Inteligente");
        setBackground(new java.awt.Color(51, 204, 255));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        textField1.setEditable(false);
        textField1.setText("Avisos");
        textField1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textField1ActionPerformed(evt);
            }
        });

        dateChooserPanel1.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
            public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
                dateChooserPanel1OnSelectionChange(evt);
            }
        });

        jSeparator2.setOrientation(javax.swing.SwingConstants.VERTICAL);

        dia.setActionCommand("button1");
        dia.setLabel("dia");
        dia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diaActionPerformed(evt);
            }
        });

        semana.setBackground(new java.awt.Color(204, 204, 204));
        semana.setLabel("semana");
        semana.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                semanaActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(204, 204, 204));
        jButton1.setText("Salir");
        jButton1.setToolTipText("Sale del sistema guardando datos");
        jButton1.setBorder(null);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        General.setText("General");
        General.setToolTipText("pantalla principal");
        General.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                GeneralMouseClicked(evt);
            }
        });
        General.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                GeneralActionPerformed(evt);
            }
        });

        gestionJornada.setText("Gestion Jornada");
        gestionJornada.setToolTipText("Gestiona la jornada del usuario");
        gestionJornada.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionJornadaActionPerformed(evt);
            }
        });

        gestionActividad.setText("Gestion Actividad");
        gestionActividad.setToolTipText("Permite gestionar las actividades de la agenda");
        gestionActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionActividadActionPerformed(evt);
            }
        });

        estadisticas.setText("Estadisticas");
        estadisticas.setToolTipText("Muestra las estadisticas de la agenda");
        estadisticas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                estadisticasActionPerformed(evt);
            }
        });

        manual.setText("Manual");
        manual.setToolTipText("Abre el manual de la agenda");
        manual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                manualActionPerformed(evt);
            }
        });

        acercaDe.setText("Acerca De...");
        acercaDe.setToolTipText("Abre los creditos del sistema");
        acercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acercaDeActionPerformed(evt);
            }
        });

        gestionTemas.setText("Gestion Temas");
        gestionTemas.setToolTipText("Gestiona los temas de la agenda");
        gestionTemas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                gestionTemasActionPerformed(evt);
            }
        });

        cargar.setText("Cargar");
        cargar.setToolTipText("Carga la version guardada de la agenda");
        cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cargarActionPerformed(evt);
            }
        });

        guardar.setText("Guardar");
        guardar.setToolTipText("guarda la agenda");
        guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                guardarActionPerformed(evt);
            }
        });

        verEventos.setActionCommand("Ver Eventos");
        verEventos.setLabel("Ver Eventos");
        verEventos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                verEventosActionPerformed(evt);
            }
        });

        jPanel1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                jPanel1MouseReleased(evt);
            }
        });
        jPanel1.setLayout(new java.awt.CardLayout());

        jPanel2.setLayout(new java.awt.CardLayout());

        cambioListas.setText("Cambiar Listado");
        cambioListas.setToolTipText("cambia el listado de avisos al de tareas pendientes");
        cambioListas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cambioListasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dateChooserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 188, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(12, 12, 12)
                                .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(4, 4, 4)
                                .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cambioListas)))
                        .addGap(39, 39, 39)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addComponent(dia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(semana, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(verEventos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(254, 254, 254))
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 745, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(General)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gestionJornada)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(gestionActividad)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(estadisticas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(gestionTemas)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(manual)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(acercaDe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 70, Short.MAX_VALUE)
                        .addComponent(guardar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cargar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 997, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(General)
                    .addComponent(gestionJornada)
                    .addComponent(gestionActividad)
                    .addComponent(estadisticas)
                    .addComponent(manual)
                    .addComponent(acercaDe)
                    .addComponent(gestionTemas)
                    .addComponent(cargar)
                    .addComponent(guardar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(semana, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addComponent(dia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(verEventos, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cambioListas)
                                    .addComponent(textField1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(1, 1, 1)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jSeparator2, javax.swing.GroupLayout.DEFAULT_SIZE, 437, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 289, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(dateChooserPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(29, 29, 29))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 455, Short.MAX_VALUE)
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void diaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diaActionPerformed
        CardLayout c1 = (CardLayout)(jPanel1.getLayout());
        c1.show(jPanel1,Constantes.DIAHOR);
        ventanaActiva = Constantes.DIAHOR;

        this.mostrarDiaHorario();;
}//GEN-LAST:event_diaActionPerformed

    private void semanaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_semanaActionPerformed

        CardLayout c1 = (CardLayout)(jPanel1.getLayout());
        c1.show(jPanel1,Constantes.SEMHOR);
        ventanaActiva = Constantes.SEMHOR;
        this.mostrarSemanaHorario();
}//GEN-LAST:event_semanaActionPerformed

    private void textField1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textField1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textField1ActionPerformed

    private void GeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_GeneralActionPerformed
        actualizarTablas(this.fechaActualJdate());
//        CD3.listarAnadidos();
}//GEN-LAST:event_GeneralActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void gestionTemasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionTemasActionPerformed
        VistaGestionTemas dialog = new VistaGestionTemas(this, true);
        dialog.setVisible(true);
}//GEN-LAST:event_gestionTemasActionPerformed

    private void GeneralMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_GeneralMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_GeneralMouseClicked

    private void gestionJornadaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionJornadaActionPerformed
        VistaGestionJornada dialog = new VistaGestionJornada(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_gestionJornadaActionPerformed

    private void gestionActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_gestionActividadActionPerformed
        int id=0;
        Date fecha=null;
        VistaGestionActividad dialog = new VistaGestionActividad(this, true,id,fecha);
        dialog.setVisible(true);
        actualizarTablas(this.fechaActualJdate());

        

    }//GEN-LAST:event_gestionActividadActionPerformed

    private void acercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acercaDeActionPerformed
        VistaCreditos dialog = new VistaCreditos(this, true);
        dialog.setVisible(true);
    }//GEN-LAST:event_acercaDeActionPerformed

    private void guardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_guardarActionPerformed
      //  CtrlDominio3 CD3=new CtrlDominio3();
        try {
            CD3.guardar();
        } catch (IOException ex) {
            Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_guardarActionPerformed

    private void cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cargarActionPerformed
       // CtrlDominio3 CD3=new CtrlDominio3();
        try {
            CD3.cargar();
        } catch (IOException ex) {
            Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(vistaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }
        actualizarTablas(Calendar.getInstance());
    }//GEN-LAST:event_cargarActionPerformed

    private void manualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_manualActionPerformed

        String path=null;
        File dir = new File(".");
            try {
            path=dir.getCanonicalPath();
            }
            catch (Exception e){
                e.printStackTrace();
            }

        path=path.concat("\\ayuda.pdf");
        System.out.println(path);
           try {

            Runtime.getRuntime().exec("rundll32.exe url.dll,FileProtocolHandler "+path);

            } catch (IOException e) {
    // TODO Auto-generated catch block
            e.printStackTrace();
          }


    }//GEN-LAST:event_manualActionPerformed

    private void estadisticasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_estadisticasActionPerformed
        // TODO add your handling code here:
        VistaEstadisticas dialog = new VistaEstadisticas(this,true);
        dialog.setVisible(true);

    }//GEN-LAST:event_estadisticasActionPerformed

    private void verEventosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_verEventosActionPerformed
        CardLayout c2 = (CardLayout)(jPanel1.getLayout());
        c2.show(jPanel1,Constantes.SEMEV);
        ventanaActiva = Constantes.SEMEV;
        this.mostrarSemanaEvento();
        
}//GEN-LAST:event_verEventosActionPerformed

    private void dateChooserPanel1OnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_dateChooserPanel1OnSelectionChange
          
           Iterable<Calendar>dates = dateChooserPanel1.getSelectedPeriodSet().getDates();
        @SuppressWarnings("unchecked")
           ArrayList<Date> list = new ArrayList();
           for (Calendar oneDate : dates) {
            list.add(oneDate.getTime());
            actualizarTablas(oneDate);
            }
         
    }//GEN-LAST:event_dateChooserPanel1OnSelectionChange

    private void jPanel1MouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel1MouseReleased
        actualizarTablas(this.fechaActualJdate());
    }//GEN-LAST:event_jPanel1MouseReleased

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        actualizarTablas(this.fechaActualJdate());        // TODO add your handling code here:
    }//GEN-LAST:event_formWindowActivated

    private void cambioListasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cambioListasActionPerformed

        CardLayout c3 = (CardLayout) (jPanel2.getLayout());
        if (this.listaActiva.equals(Constantes.LISTAAVISOS)){

            this.listaActiva = Constantes.LISTAOTROS;
            this.textField1.setText("EnMente");

        }
        else {
            this.listaActiva = Constantes.LISTAAVISOS;
            this.textField1.setText("Avisos");

        }

        c3.show(jPanel2,listaActiva);





    }//GEN-LAST:event_cambioListasActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            
            public void run() {
  
                new vistaPrincipal().setVisible(true);
            }
        });


    }

    String listaActiva ;
    vistaListaOtros lo;
    vistaListaAvisos la;
    VistaSemanaHorario h1 ;
    VistaSemanaEvento h2 ;
    VistaDiaHorario d1;
    String ventanaActiva;
    CtrlVistaPrincipal CVP = new CtrlVistaPrincipal();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton General;
    private javax.swing.JButton acercaDe;
    private javax.swing.JButton cambioListas;
    private javax.swing.JButton cargar;
    private datechooser.beans.DateChooserPanel dateChooserPanel1;
    private java.awt.Button dia;
    private javax.swing.JButton estadisticas;
    private javax.swing.JButton gestionActividad;
    private javax.swing.JButton gestionJornada;
    private javax.swing.JButton gestionTemas;
    private javax.swing.JButton guardar;
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JButton manual;
    private java.awt.Button semana;
    private java.awt.TextField textField1;
    private java.awt.Button verEventos;
    // End of variables declaration//GEN-END:variables

}
