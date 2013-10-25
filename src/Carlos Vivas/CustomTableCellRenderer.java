/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agendainteligente;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Carlos Vivas Abilahoud 
 */

public class CustomTableCellRenderer extends DefaultTableCellRenderer {

    /** Creates a new instance of CustomTableCellRenderer */

   Color c=new Color(238,236,179);
   Color fg = null;
        Color bg = null;

    @Override
   public Component getTableCellRendererComponent
       (JTable table, Object value, boolean isSelected,
       boolean hasFocus, int row, int column)
    {

     JTextField campo = new JTextField();
     TCtrlVista tcv;
     if(value instanceof TCtrlVista){
          tcv=(TCtrlVista)value;

        if(tcv.getColor()==Constantes.NOCOLOR) {
            campo.setBackground(c);
        }
        else if(tcv.getColor()==Constantes.COLORCITA) {
            campo.setBackground(Color.ORANGE);
        }
        else if(tcv.getColor()==Constantes.COLORREP) {
            campo.setBackground(Color.CYAN);
        }
        else if(tcv.getColor()==Constantes.COLORENMENTE) {
            campo.setBackground(Color.GREEN);
        }
        else if(tcv.getColor()==Constantes.COLORDEADLINE) {
        campo.setBackground(Color.YELLOW);
        }
          else if(tcv.getColor()==Constantes.COLORMEMORANDUM) {
        campo.setBackground(Color.RED);
        }
          else if(tcv.getColor()==Constantes.COLORANIVERSARIO) {
        campo.setBackground(Color.PINK);
        }

       //if (is.FILA==is.hi) {campo.setText(is.titulo);}
          campo.setText(tcv.getTitulo());

     }EmptyBorder b=new EmptyBorder(1,1,1,1);
      campo.setBorder(b);
          return campo;
    }


}

