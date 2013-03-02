/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

public class Procesador{
    
    public Proceso procesar(Proceso proceso){        
        for (int i = 0; i < 5; i++) {
            //JOptionPane.showMessageDialog(null, "HOLA");
            try {
                Thread.sleep(0);
                if (proceso.getTamanio_actual() > 0) {
                proceso.setTamanio_actual(proceso.getTamanio_actual() - 20);
                } else {
                    proceso.setTamanio_actual(0);
                    break;
                }
            } catch (InterruptedException ex) {
                Logger.getLogger(Procesador.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        return proceso;
    }
    
}