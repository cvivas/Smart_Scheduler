/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package agendainteligente;

/**
 *
 * @author Marc Sitges
 */

import java.io.Serializable;

/**
 *
 * @author UserXP
 */
public class TCtrlHorSlot extends TCtrlHorario implements Serializable, Comparable {

     int slot;
     int idActividad;

  public int compareTo(Object EstructuraSlot) throws ClassCastException {
    if (!(EstructuraSlot instanceof TCtrlHorSlot))
      throw new ClassCastException("A TCtrlHorSlot object expected.");
    int unSlot = ((TCtrlHorSlot) EstructuraSlot).slot;
    return this.slot - unSlot;
  }


}
