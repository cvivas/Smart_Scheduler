/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/* Descripcion: Muestra una actividad seleccionada por pantalla, interactua con
 * CtrlDominio3
 * VistaVerAniversario.java
 * Autor Carlos Vivas
 * Created on 24-may-2009, 23:21:44
 */

package agendainteligente;

import java.util.Calendar;
import java.util.Date;



public class VistaVerAniversario extends javax.swing.JDialog {
    CtrlDominio3 control =  new CtrlDominio3();
    int id;
    /** Creates new form VistaVerAniversario */
    public VistaVerAniversario(java.awt.Frame parent, boolean modal,int id) {
        super(parent, modal);
        initComponents();
         this.id=id;
        inicializarCampos();
       
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        textoNombre = new javax.swing.JTextField();
        fechaAniversario = new datechooser.beans.DateChooserCombo();
        buttonSalir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel10.setText("Vista Aniversario");

        jLabel7.setText("Fecha de nacimiento");

        jLabel2.setText("Nombre");

        textoNombre.setEnabled(false);
        textoNombre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textoNombreActionPerformed(evt);
            }
        });
        textoNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                textoNombreKeyTyped(evt);
            }
        });

        fechaAniversario.setCurrentView(new datechooser.view.appearance.AppearancesList("Light",
            new datechooser.view.appearance.ViewAppearance("custom",
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    true,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 255),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(128, 128, 128),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(0, 0, 255),
                    false,
                    true,
                    new datechooser.view.appearance.swing.LabelPainter()),
                new datechooser.view.appearance.swing.SwingCellAppearance(new java.awt.Font("Tahoma", java.awt.Font.PLAIN, 11),
                    new java.awt.Color(0, 0, 0),
                    new java.awt.Color(255, 0, 0),
                    false,
                    false,
                    new datechooser.view.appearance.swing.ButtonPainter()),
                (datechooser.view.BackRenderer)null,
                false,
                true)));
    fechaAniversario.setEnabled(false);
    fechaAniversario.addSelectionChangedListener(new datechooser.events.SelectionChangedListener() {
        public void onSelectionChange(datechooser.events.SelectionChangedEvent evt) {
            fechaAniversarioOnSelectionChange(evt);
        }
    });

    buttonSalir.setText("Salir");
    buttonSalir.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent evt) {
            buttonSalirActionPerformed(evt);
        }
    });

    org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(getContentPane());
    getContentPane().setLayout(layout);
    layout.setHorizontalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
            .addContainerGap()
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(layout.createSequentialGroup()
                    .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jSeparator1, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                        .add(layout.createSequentialGroup()
                            .add(163, 163, 163)
                            .add(jLabel10)
                            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 202, Short.MAX_VALUE))
                        .add(layout.createSequentialGroup()
                            .add(31, 31, 31)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(jLabel7)
                                .add(jLabel2))
                            .add(35, 35, 35)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                .add(textoNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 73, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(fechaAniversario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(161, 161, 161)))
                    .addContainerGap())
                .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                    .add(buttonSalir, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 74, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                    .add(37, 37, 37))))
    );
    layout.setVerticalGroup(
        layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
        .add(layout.createSequentialGroup()
            .add(22, 22, 22)
            .add(jLabel10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 19, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .add(18, 18, 18)
            .add(jSeparator1, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 10, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
            .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                .add(jLabel2)
                .add(textoNombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(34, 34, 34)
            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                .add(jLabel7)
                .add(fechaAniversario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
            .add(104, 104, 104)
            .add(buttonSalir)
            .addContainerGap(24, Short.MAX_VALUE))
    );

    pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textoNombreActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textoNombreActionPerformed

}//GEN-LAST:event_textoNombreActionPerformed

    private void textoNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textoNombreKeyTyped
        // TODO add your handling code here:

}//GEN-LAST:event_textoNombreKeyTyped

    private void fechaAniversarioOnSelectionChange(datechooser.events.SelectionChangedEvent evt) {//GEN-FIRST:event_fechaAniversarioOnSelectionChange
        // TODO add your handling code here:

}//GEN-LAST:event_fechaAniversarioOnSelectionChange

    private void buttonSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSalirActionPerformed
        this.dispose();
    }//GEN-LAST:event_buttonSalirActionPerformed

    /*Carga todos los campos con los datos previamente insertados*/
    private void inicializarCampos(){
        Actividad d=control.CA3.buscarActividad(id);
        Aniversario a=(Aniversario)d;
        Date fechaN=a.getFechaNacimiento();

        Calendar c= Calendar.getInstance();
        c.setTime(fechaN);

        textoNombre.setText(d.getTitulo());
        fechaAniversario.setSelectedDate(c);
}
    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            int idAct;
            public void run() {
                VistaVerAniversario dialog = new VistaVerAniversario(new javax.swing.JFrame(), true,idAct);
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
    private javax.swing.JButton buttonSalir;
    private datechooser.beans.DateChooserCombo fechaAniversario;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTextField textoNombre;
    // End of variables declaration//GEN-END:variables

}