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
    private int tiempoProceso;
    //Es la unica forma que se me ocurrio para modificar la ventana  desde los
    //proceso de la clase control proceso =D
    private VentanaPrincipal ventana;

    //offer(proceso);// inserta un elemento
    //poll();//Nos da la cabeza y la remueve
    //peek();//Nos da la cabeza sin remover
    
    public void eliminarProceso(Proceso proceso){
        Iterator it = tree_procesos.iterator();
        Proceso value=proceso;
        while (it.hasNext()) {
           value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getId()) == 0) {
                tree_procesos.remove(value);
                value.setTamanio_actual(0);
                value.setNombre(value.getNombre()+" KILL");
                tree_procesos.add(value);
                break;
            }
        }
    }
    
    public Object obtenerProceso(String id){
        Iterator it = tree_procesos.iterator();
        Proceso value = null;
        
        while (it.hasNext()) {
           value = (Proceso) it.next();
            if (value.getId().compareTo(id) == 0){
                //tree_procesos.remove(value);
                break;
            }else{
                value = null;
            }
        }
        return value;
    }
    
    /*Eliminar un proceso del arrbol de procesos*/
    public void eliminarProcesoDeArbol(Proceso proceso){
        Iterator it = tree_procesos.iterator();
        Proceso value = proceso;
        
        while (it.hasNext()) {
           value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getId()) == 0) {
                tree_procesos.remove(value);
                break;
            }else{
                value = proceso;
            }
        }
    }
    
    public void eleminarProcesoDeColaListo(Proceso proceso){
        Iterator it = cola_listo.iterator();
        Proceso value = proceso;
        while(it.hasNext()){
            value=(Proceso)it.next();
            if(value.getId().compareTo(proceso.getId())==0){ //esta
                cola_listo.remove(value);
            }else{
                value=proceso;
            }
        }
    }
    
     public void eleminarProcesoDeColaBloqueado(Proceso proceso){
        Iterator it = cola_bloquedao.iterator();
        Proceso value = proceso;
        while(it.hasNext()){
            value=(Proceso)it.next();
            if(value.getId().compareTo(proceso.getId())==0){ //esta
                cola_bloquedao.remove(value);
            }else{
                value=proceso;
            }
        }
    }
    
    public void eleminarProcesoDeColaTerminado(Proceso proceso){
        Iterator it = cola_terminado.iterator();
        Proceso value = proceso;
        while(it.hasNext()){
            value=(Proceso)it.next();
            if(value.getId().compareTo(proceso.getId())==0){ //esta
                cola_terminado.remove(value);
            }else{
                value=proceso;
            }
        }
    }
     
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

    public int getTiempoProceso() {
        return tiempoProceso;
    }

    public void setTiempoProceso(int tiempoProceso) {
        this.tiempoProceso = tiempoProceso;
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
        if(estado==true)/*PUTA MADRE*/
            cola_listo.offer(proceso);
        return estado;
    }

    public boolean addNuevo(String id) {
        return tree_nuevo.add(id);
    }

    //prueba, esto se va a borrar
    public void cambiarEstado(Proceso proceso, String estado) {
        Iterator it = tree_procesos.iterator();
        Proceso value=proceso;
        while (it.hasNext()) {
           value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getId()) == 0) {
                tree_procesos.remove(value);
                value.setEstado(estado);
                tree_procesos.add(value);
                break;
            }else{
                value=proceso;
            }
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
                ventana.listoToEjecucion();
                sleep();
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                ventana.ejecucionToTerminado();                
                sleep();                
                cambiarEstado(proceso, "TERMINADO");   
                ventana.actualizarProcesosTabla(proceso);
                sleep();          
                cola_terminado.offer(proceso);
                //Ojo no lo elimina del arbol de proces                
                //Si el proceso requiere un dispositivo
            } else if (proceso.isRequiereDispositivo()) { 
                ventana.listoToEjecucion();   
                sleep();
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                cambiarEstado(proceso, "EJECUCION");
                ventana.actualizarProcesosTabla(proceso);
                sleep();
                //estan disponible los dispostivos solicitados 
                if (comprobarRecursoDisponible(proceso)) {  
                    procesador.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                    proceso = procesador.procesar(proceso); 
                    
                    ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                    sleep();
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
                    
                    if (proceso.getTamanio_actual() <= 0) {                        
                        cambiarEstado(proceso, "TERMINADO");
                        ventana.activarPorgresBar(0, 0);
                        sleep();
                        ventana.actualizarProcesosTabla(proceso);
                        sleep();
                        ventana.ejecucionToTerminado();
                        sleep();
                        cola_terminado.offer(proceso);
                    } else {
                        ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                        sleep();
                        ventana.ejecucionToListo();
                        sleep();
                        cambiarEstado(proceso, "LISTO");
                        ventana.actualizarProcesosTabla(proceso);
                        sleep();
                                    
                        cola_listo.offer(proceso);
                    }
                   //Como no estan disponibles los dispositivos solicitados.
                } else {
                    cambiarEstado(proceso, "BLOQUEADO");                    
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
                    ventana.ejecucionToBloqueado();
                    sleep();                    
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
            
                    cola_bloquedao.offer(proceso);
                } 
                //COmo no requere un dispositivo
            } else {                
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                ventana.listoToEjecucion();                
                sleep();
                procesador.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                proceso = procesador.procesar(proceso);                 
                cambiarEstado(proceso, "EJECUCION");
                ventana.actualizarProcesosTabla(proceso);
                sleep();
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                //Se termino el tamanio de proedimientos ?
                if (proceso.getTamanio_actual() <= 0) {                    
                    cambiarEstado(proceso, "TERMINADO");
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();                    
                    ventana.ejecucionToTerminado();
                    sleep();
                    ventana.activarPorgresBar(0, 0);
                    sleep();
                    
                    cola_terminado.offer(proceso);
                   //COmo no termino entonces vuelve a la cola de LISTO 
                } else {
                    ventana.ejecucionToListo();
                    sleep();
                    ventana.activarPorgresBar(0, 0);                    
                    sleep();
                    cambiarEstado(proceso, "LISTO");
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();            
                    cola_listo.offer(proceso);
                }
            }
        }
        
        ventana.activarPaneles();
    }

    /*
    private void etapasProcesamientoVisual(Proceso proceso,String estado){
        ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
        sleep();              
        cambiarEstado(proceso, estado);   
        ventana.actualizarProcesosTabla(proceso);
        sleep();          
    }*/
    
    void printTreeSet()
    {
        Iterator iteratoro = tree_procesos.iterator();
        //Displaying the Tree set data
        while (iteratoro.hasNext()) {
            Proceso a=(Proceso) iteratoro.next();
            System.out.print(a.getId()+a.getEstado()+"_");
        }
        System.out.println();
    }    
    public void sleep() {
        tiempoProceso=ventana.getValueTiempoProceso();
        try {
            Thread.sleep(tiempoProceso);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        }
        return todoDisponible;
    }
}
