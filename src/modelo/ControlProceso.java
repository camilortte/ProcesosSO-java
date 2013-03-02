/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.text.Element;
import sun.reflect.generics.tree.Tree;
import vista.VentanaPrincipal;

/**
 *
 * @author camilortte
 */
public class ControlProceso {

    //private TreeSet<String> tree_procesos;
    private TreeSet<Proceso> tree_procesos;
    private TreeSet<String> tree_nuevo;
    private Queue<Proceso> cola_listo;
    private Queue<Proceso> cola_terminado;
    private Queue<Proceso> cola_bloquedao;
    private boolean stop;
    private boolean dispositivosDisponibles[];
    private Procesador procesador;
    //Es la unica forma que se me ocurrio para modificar la ventana  desde los
    //proceso de la clase control proceso =D
    private VentanaPrincipal ventana;

    //offer(proceso);// inserta un elemento
    //poll();//Nos da la cabeza y la remueve
    //peek();//Nos da la cabeza sin remover
    public ControlProceso(VentanaPrincipal ventana) {
        tree_nuevo = new TreeSet<String>();
        tree_procesos = new TreeSet<Proceso>(new Comparator<Proceso>() {
            public int compare(Proceso stud1, Proceso stud2) {
                return stud1.getId().compareTo(stud2.getId());
            }
        });
        cola_listo = new LinkedList<Proceso>();
        cola_terminado = new LinkedList<Proceso>();
        cola_bloquedao = new LinkedList<Proceso>();
        stop = false;
        procesador = new Procesador();
        this.ventana = ventana;
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public boolean[] getDispositivosDisponibles() {
        return dispositivosDisponibles;
    }

    public void setDispositivosDisponibles(boolean[] dispositivosDisponibles) {
        this.dispositivosDisponibles = dispositivosDisponibles;
    }

    public boolean addProceso(Proceso proceso) {
        boolean estado = tree_procesos.add(proceso);
        cola_listo.offer(proceso);
        return estado;
    }

    public boolean addNuevo(String id) {
        return tree_nuevo.add(id);
    }

    //prueba, esto se va a borrar
    public void cambiarEstado(Proceso proceso, String estado) {
        Iterator it = tree_procesos.iterator();
        while (it.hasNext()) {
            Proceso value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getEstado()) == 0) {
                tree_procesos.remove(value);
                value.setEstado(estado);
                tree_procesos.add(value);
            }
            //System.out.println("Value :"+value.getId());
        }
    }

    public void ejecutar() {               
        //falta cambiar los estados.       
        stop=false;
        ventana.desactivarPaneles();
        while(!cola_listo.isEmpty() && stop != true) {
            Proceso proceso = cola_listo.poll();
            //Ejecuta un proceso de la clase proceso            
            if (proceso.getTamanio_actual() <= 0) {
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                //ventana.ejecucionToTerminado();                
                cambiarEstado(proceso, "TERMINADO");                
                cola_terminado.offer(proceso);
                //Ojo no lo elimina del arbol de proces                
                //Si el proceso requiere un dispositivo
            } else if (proceso.isRequiereDispositivo()) {        
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                //estan disponible los dispostivos solicitados 
                if (comprobarRecursoDisponible(proceso)) {                    
                    ventana.listoToEjecucion();                    
                    proceso = procesador.procesar(proceso);
                    ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                    if (proceso.getTamanio_actual() <= 0) {                        
                         cambiarEstado(proceso, "TERMINADO");
                        ventana.ejecucionToTerminado();
                        cola_terminado.offer(proceso);
                    } else {
                        ventana.ejecucionToListo();
                        cambiarEstado(proceso, "LISTO");
                        cola_listo.offer(proceso);
                    }
                   //Como no estan disponibles los dispositivos solicitados.
                } else {
                    cambiarEstado(proceso, "BLOQUEADO");
                    cola_bloquedao.offer(proceso);
                } 
                //COmo no requere un dispositivo
            } else {                
                ventana.listoToEjecucion();
                
                try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ControlProceso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                
                proceso = procesador.procesar(proceso);     
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                //Se termino el tamanio de proedimientos ?
                if (proceso.getTamanio_actual() <= 0) {                    
                    cambiarEstado(proceso, "TERMINADO");
                    ventana.ejecucionToTerminado();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ControlProceso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cola_terminado.offer(proceso);
                   //COmo no termino entonces vuelve a la cola de LISTO 
                } else {
                    ventana.ejecucionToListo();
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(ControlProceso.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cambiarEstado(proceso, "LISTO");
                    cola_listo.offer(proceso);
                }
            }
        }
        
        ventana.activarPaneles();
    }

    public boolean comprobarRecursoDisponible(Proceso proceso) {
        boolean dispositivosRequerdos[] = proceso.getRequerimientos();
        boolean todoDisponible = false;
        for (int i = 0; i < dispositivosDisponibles.length; i++) {
            if (dispositivosRequerdos[i] == true) {
                if (dispositivosDisponibles[i] == true) {
                    todoDisponible = true;
                } else {
                    todoDisponible = false;
                    break;
                }
            }
            return todoDisponible;
        }
        return true;
    }
}
