
/* Descripcion: Muestra un resumen de todas las actividades.
 * VistaEstadisticas.java
 * Autor Carlos Vivas
 * Ultima modificacion 16/06/2009
 */

package agendainteligente;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;



public class VistaEstadisticas extends javax.swing.JDialog {

    CtrlDominio3 control =  new CtrlDominio3();
    Actividad act;
    Calendar hoy=Calendar.getInstance();
    ArrayList<IdNombre> lista;
    Date fecha_hoy=hoy.getTime();

    public VistaEstadisticas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.setLocationRelativeTo(parent);
        isCita();
        
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        labelPendientes = new javax.swing.JLabel();
        labelRealizadas = new javax.swing.JLabel();
        txtActPend = new javax.swing.JTextField();
        txtActReal = new javax.swing.JTextField();
        comboActividad = new javax.swing.JComboBox();
        txtTotal = new javax.swing.JTextField();
        labelTotales = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Estadisticas");

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 14));
        jLabel1.setText("Estadisticas");

        jLabel2.setText("Tipo de Actividad");

        labelPendientes.setText("Actividades pendientes");

        labelRealizadas.setText("Actividades realizadas");

        txtActReal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtActRealActionPerformed(evt);
            }
        });

        comboActividad.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Cita","Cita Repetitiva", "Deadline", "EnMente","Aniversario","Memorandum" }));
        comboActividad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboActividadActionPerformed(evt);
            }
        });

        labelTotales.setText("Totales");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, 479, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(179, 179, 179)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelRealizadas)
                            .addComponent(labelPendientes)
                            .addComponent(jLabel2)
                            .addComponent(labelTotales))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboActividad, javax.swing.GroupLayout.PREFERRED_SIZE, 129, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtActReal, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtActPend, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)
                                .addComponent(txtTotal, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 57, Short.MAX_VALUE)))
                        .addGap(56, 56, 56)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboActividad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtActPend, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelPendientes))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtActReal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelRealizadas))
                .addGap(80, 80, 80)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTotales))
                .addContainerGap(46, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtActRealActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtActRealActionPerformed
        // TODO add your handling code here:
}//GEN-LAST:event_txtActRealActionPerformed

    private void comboActividadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboActividadActionPerformed
        
        if(comboActividad.getSelectedItem().equals("Cita"))  {
            isCita();
        }
        else if(comboActividad.getSelectedItem().equals("Cita Repetitiva")){
            isCitaRepetitiva();
        }
        else if(comboActividad.getSelectedItem().equals("Deadline")) {
            isDeadline();
        }
        else if(comboActividad.getSelectedItem().equals("EnMente")) {
            isEnMente();
        }
        else if(comboActividad.getSelectedItem().equals("Aniversario")) {
            isAniversario();
        }
        else  isMemorandum();


        

    }//GEN-LAST:event_comboActividadActionPerformed

    //Carga los datos de enMente
    private void isEnMente(){
        int indiceI=0;
        Integer realizados=0;
        Integer tamanyo=0;


        lista=control.listarActividadEspecifica((String)comboActividad.getSelectedItem());
        tamanyo=lista.size();
        EnMente e;

        while(indiceI<tamanyo){

            act=control.CA.buscarActividad(lista.get(indiceI).idActividad);
            e=(EnMente)act;

            if(e.getNHoras()!=0){
                realizados+=e.getNHoras();
            }
            indiceI++;
        }
        labelPendientes.setVisible(true);
        labelPendientes.setText("Horas invertidas");
        txtActPend.setVisible(true);
        txtActPend.setText(realizados.toString());
        labelRealizadas.setVisible(true);
        labelRealizadas.setText("Tareas insertadas");
        txtActReal.setVisible(true);
        txtActReal.setText(tamanyo.toString());
        labelTotales.setVisible(false);
        txtTotal.setVisible(false);

    }

    //Carga los datos de cita
    private void isCita(){
        Integer tamanyo=0;

        lista=control.listarActividadEspecifica((String)comboActividad.getSelectedItem());
        tamanyo=lista.size();

        labelPendientes.setVisible(false);
        txtActPend.setVisible(false);
        labelRealizadas.setVisible(false);
        txtActReal.setVisible(false);
        labelTotales.setText("Total");
        labelTotales.setVisible(true);
        txtTotal.setVisible(true);
        txtTotal.setText(tamanyo.toString());
   
    }

    //Carga los datos ed cita repetitiva
    private void isCitaRepetitiva(){
        Integer tamanyo=0;
        lista=control.listarActividadEspecifica("CitaRepetitiva");
        tamanyo=lista.size();

        labelPendientes.setVisible(false);
        txtActPend.setVisible(false);
        labelRealizadas.setVisible(false);
        txtActReal.setVisible(false);
        labelTotales.setText("Total");
        labelTotales.setVisible(true);
        txtTotal.setVisible(true);
        txtTotal.setText(tamanyo.toString());
    }

    //Carga los datos de deadline
    private void isDeadline(){
  
        int indiceI=0;
        Integer pendiente=0;
        Integer realizados=0;
        Integer tamanyo=0;

        lista=control.listarActividadEspecifica((String)comboActividad.getSelectedItem());
        tamanyo=lista.size();
        Deadline d;
       
        while(indiceI<tamanyo){
           
            act=control.CA.buscarActividad(lista.get(indiceI).idActividad);
            d=(Deadline)act;
            Date fechaFinAct=d.getFechaFinal();
                       
            if(fecha_hoy.after(fechaFinAct)){
                realizados++;
            }
            else pendiente++;
            indiceI++;
        }
        labelPendientes.setVisible(true);
        labelPendientes.setText("Actividades pendientes");
        txtActPend.setVisible(true);
        txtActPend.setText(pendiente.toString());
        labelRealizadas.setVisible(true);
        txtActReal.setVisible(true);
        txtActReal.setText(realizados.toString());
        labelTotales.setVisible(true);
        txtTotal.setVisible(true);
        txtTotal.setText(tamanyo.toString());

    }

    //Carga los datos de aniversario
     private void isAniversario(){
          Integer tamanyo=0;

        lista=control.listarActividadEspecifica((String)comboActividad.getSelectedItem());
        tamanyo=lista.size();

        labelPendientes.setVisible(false);
        txtActPend.setVisible(false);
        labelRealizadas.setVisible(false);
        txtActReal.setVisible(false);
        labelTotales.setText("Total");
        labelTotales.setVisible(true);
        txtTotal.setVisible(true);
        txtTotal.setText(tamanyo.toString());
     }
//Carga los datos de memorandum
      private void isMemorandum(){
          Integer tamanyo=0;

        lista=control.listarActividadEspecifica((String)comboActividad.getSelectedItem());
        tamanyo=lista.size();

        labelPendientes.setVisible(false);
        txtActPend.setVisible(false);
        labelRealizadas.setVisible(false);
        txtActReal.setVisible(false);
        labelTotales.setText("Total");
        labelTotales.setVisible(true);
        txtTotal.setVisible(true);
        txtTotal.setText(tamanyo.toString());
     }

   

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                VistaEstadisticas dialog = new VistaEstadisticas(new javax.swing.JFrame(), true);
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
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.JComboBox comboActividad;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel labelPendientes;
    private javax.swing.JLabel labelRealizadas;
    private javax.swing.JLabel labelTotales;
    private javax.swing.JTextField txtActPend;
    private javax.swing.JTextField txtActReal;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables

}
