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
    
    private int cantidadAQuitar;
    
    void Procesador(){
        this.cantidadAQuitar=20;
    }

    public int getCantidadAQuitar() {
        return cantidadAQuitar;
    }

    public void setCantidadAQuitar(int cantidadAQuitar) {
        this.cantidadAQuitar = cantidadAQuitar;
    }

    public Proceso procesar(Proceso proceso) {
        //for (int i = 0; i < 5; i++) {

        if (proceso.getTamanio_actual() > 0) {
            proceso.setTamanio_actual(proceso.getTamanio_actual() - cantidadAQuitar);
            //tiempo ejecucion
            proceso.sumarTiempoEjecucion(10);
            if(proceso.getTamanio_actual()<0) {
                proceso.setTamanio_actual(0);
            }
        } else {
            proceso.setTamanio_actual(0);
            //break;
        }
        // }
        return proceso;
    }
}