/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

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
            proceso.addTamanhoEjecutado(cantidadAQuitar);
            //tiempo ejecucion funciona
            proceso.addTiempoEjecucion();
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