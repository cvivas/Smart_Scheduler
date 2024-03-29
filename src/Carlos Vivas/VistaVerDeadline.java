/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/* Descripcion: Muestra una actividad seleccionada por pantalla, interactua con
 * CtrlDominio3
 * VistaVerDeadline.java
 * Descripcion: Muestra todos los datos introducidos en el deadline seleccionado
 * Autor Carlos Vivas.
 * Created on 24-may-2009, 20:37:18
 */

package agendainteligente;

import java.util.ArrayList;
import java.util.Calendar;


public class VistaVerDeadline extends javax.swing.JDialog {
    CtrlDominio3 control =  new CtrlDominio3();
    int id;
    public VistaVerDeadline(java.awt.Frame parent, boolean modal,int id) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        this.id=id;
        cargarTemas();
        inicializarCampos(id);
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtHoras = new javax.swing.JTextField();
        comboPrioridad = new javax.swing.JComboBox();
        txtTitulo = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtDescripcion = new javax.swing.JTextPane();
        comboFecha = new datechooser.beans.DateChooserCombo();
        jLabel7 = new javax.swing.JLabel();
        checkLaboral = new javax.swing.JCheckBox();
        jButton1 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        comboFechaI = new datechooser.beans.DateChooserCombo();
        jLabel8 = new javax.swing.JLabel();
        boxTema = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        horasMax = new javax.swing.JComboBox();
        jLabel10 = new javax.swing.JLabel();
        horasMin = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Vista Deadline");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Vista Deadline");

        jLabel2.setText("Titulo");

        jLabel6.setText("Num. Horas");

        jLabel4.setText("Prioridad");

        txtHoras.setEnabled(false);
        txtHoras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHorasActionPerformed(evt);
            }
        });

        comboPrioridad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Alta", "Media", "Baja" }));
        comboPrioridad.setEnabled(false);
        comboPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPrioridadActionPerformed(evt);
            }
        });

        txtTitulo.setEnabled(false);

        jLabel5.setText("Descripcion");

        txtDescripcion.setEnabled(false);
        jScrollPane2.setViewportView(txtDescripcion);

        comboFecha.setEnabled(false);

        jLabel7.setText("Fecha fin");

        checkLaboral.setText("Es laboral");
        checkLaboral.setEnabled(false);

        jButton1.setText("Salir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel11.setText("Fecha inicio");

        comboFechaI.setEnabled(false);

        jLabel8.setText("Tema");

        boxTema.setModel(new javax.swing.DefaultComboBoxModel(new String[] {}));
        boxTema.setEnabled(false);

        jLabel9.setText("Numero de horas como maximo");

        horasMax.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24" }));
        horasMax.setEnabled(false);

        jLabel10.setText("Numero de horas como minimo");

        horasMin.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "00", "01", "02", "03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24" }));
        horasMin.setEnabled(false);

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(20, 20, 20)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel2)
                                    .add(jLabel6)
                                    .add(jLabel8)
                                    .add(jLabel4))
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(txtTitulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 82, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(txtHoras, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 82, Short.MAX_VALUE)
                                    .add(comboPrioridad, 0, 82, Short.MAX_VALUE)
                                    .add(boxTema, 0, 82, Short.MAX_VALUE))
                                .add(222, 222, 222)
                                .add(jLabel5)
                                .add(10, 10, 10)
                                .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 133, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(166, 166, 166))
                            .add(layout.createSequentialGroup()
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(jLabel11)
                                    .add(jLabel7))
                                .add(33, 33, 33)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(comboFechaI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                    .add(comboFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                                .add(158, 158, 158))
                            .add(layout.createSequentialGroup()
                                .add(checkLaboral)
                                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 481, Short.MAX_VALUE)
                                .add(jButton1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 66, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(109, 109, 109))))
                    .add(layout.createSequentialGroup()
                        .add(262, 262, 262)
                        .add(jLabel1))
                    .add(layout.createSequentialGroup()
                        .addContainerGap()
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 652, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                .addContainerGap(427, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                    .add(layout.createSequentialGroup()
                        .add(jLabel9)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(horasMax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                    .add(layout.createSequentialGroup()
                        .add(jLabel10)
                        .add(18, 18, 18)
                        .add(horasMin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(129, 129, 129))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(16, 16, 16)
                .add(jLabel1)
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                .add(15, 15, 15)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(layout.createSequentialGroup()
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(jLabel8)
                        .add(41, 41, 41)
                        .add(jLabel6))
                    .add(layout.createSequentialGroup()
                        .add(jLabel5)
                        .add(54, 54, 54))
                    .add(jScrollPane2, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 100, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(layout.createSequentialGroup()
                        .add(txtTitulo, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(boxTema, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(comboPrioridad, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 20, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(jLabel4))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(txtHoras, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .add(26, 26, 26)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel7)
                    .add(comboFecha, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(jLabel11)
                    .add(comboFechaI, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 19, Short.MAX_VALUE)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                    .add(jLabel10)
                    .add(horasMin, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(horasMax, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(jLabel9))
                .add(18, 18, 18)
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                    .add(checkLaboral)
                    .add(jButton1))
                .add(29, 29, 29))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHorasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHorasActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtHorasActionPerformed

    private void comboPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPrioridadActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_comboPrioridadActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    //Carga los campos de la actividad
    private void inicializarCampos(int id){
        Actividad d=control.CA3.buscarActividad(id);
        Deadline mostrador=(Deadline)d;
        Calendar c= Calendar.getInstance();

        txtTitulo.setText(mostrador.getTitulo());
        txtDescripcion.setText(mostrador.getDescripcion());
        Integer h=mostrador.getNumHoras();
        txtHoras.setText(h.toString());
        checkLaboral.setSelected(mostrador.isEsLaboral());
        c.setTime(mostrador.getFechaFinal());
        comboFecha.setSelectedDate(c);
        boxTema.setSelectedItem(control.obtenerTema(id));
        horasMin.setSelectedIndex((mostrador.getHorasMin()));
        horasMax.setSelectedIndex(mostrador.getHorasMax());
        c.setTime(mostrador.getFechaInicio());
        comboFechaI.setSelectedDate(c);
        int p=mostrador.getPrioridad();
            if(p==1){
               comboPrioridad.setSelectedItem("Baja");
            }
            else if(p==2){
               comboPrioridad.setSelectedItem("Media");
            }
            else{
                comboPrioridad.setSelectedItem("Alta");
            }
    }

    //Carga los temas en el boxTema
    private  void cargarTemas(){

        ArrayList<String>lista=control.listartemas();
        int indiceI=0;
        int tamanyo=lista.size();
        boxTema.addItem(Constantes.NINGUNO);
        while(indiceI<tamanyo){
               boxTema.addItem(lista.get(indiceI));
             indiceI++;
        }

    }
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            int idAct;
            public void run() {
                VistaVerDeadline dialog = new VistaVerDeadline(new javax.swing.JFrame(), true,idAct);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JComboBox boxTema;
    private javax.swing.JCheckBox checkLaboral;
    private datechooser.beans.DateChooserCombo comboFecha;
    private datechooser.beans.DateChooserCombo comboFechaI;
    private javax.swing.JComboBox comboPrioridad;
    private javax.swing.JComboBox horasMax;
    private javax.swing.JComboBox horasMin;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextPane txtDescripcion;
    private javax.swing.JTextField txtHoras;
    private javax.swing.JTextField txtTitulo;
    // End of variables declaration//GEN-END:variables

}
