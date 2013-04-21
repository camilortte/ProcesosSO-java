package modelo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import vista.VentanaPrincipal;

public class ControlProceso {

    //private TreeSet<String> tree_procesos;
    private TreeSet<Proceso> tree_procesos;
    private TreeSet<String> tree_nuevo;
    private Queue<Proceso> cola_listo;
    private Queue<Proceso> cola_terminado;
    private Queue<Proceso> cola_bloquedao;
    private Queue<Proceso> cola_bloqueadoImpresora;
    private Queue<Proceso> cola_bloqueadoMonitor;
    private Queue<Proceso> cola_bloqueadoArchivo;
    private Queue<Proceso> cola_bloqueadoParlante;
    private Queue<Proceso> cola_bloqueadoMicrofono;
    private Queue<Proceso> cola_bloqueadoUSB;
    private Queue<Proceso> cola_bloqueadoCamara;
    private boolean stop;
    private Dispositivo dispositivosDisponibles[];
    private Procesador procesador;
    private int tiempoProceso;
    //Es la unica forma que se me ocurrio para modificar la ventana  desde los
    //proceso de la clase control proceso =D
    private VentanaPrincipal ventana;
    private boolean terminado;
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
        cola_bloqueadoImpresora = new LinkedList<Proceso>();
        cola_bloqueadoMonitor = new LinkedList<Proceso>();
        cola_bloqueadoArchivo = new LinkedList<Proceso>();
        cola_bloqueadoParlante = new LinkedList<Proceso>();
        cola_bloqueadoMicrofono = new LinkedList<Proceso>();
        cola_bloqueadoUSB = new LinkedList<Proceso>();
        cola_bloqueadoCamara = new LinkedList<Proceso>();
        stop = false;
        procesador = new Procesador();
        this.ventana = ventana;
        this.terminado = true;
    }

    public void eliminarProceso(Proceso proceso) {
        Iterator it = tree_procesos.iterator();
        Proceso value = proceso;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getId()) == 0) {
                tree_procesos.remove(value);
                value.setTamanio_actual(0);
                value.setNombre(value.getNombre() + " KILL");
                tree_procesos.add(value);
                break;
            }
        }
    }

    public int getTamanio(String id) {
        Iterator it = tree_procesos.iterator();
        Proceso value = null;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            if (value.getId().compareTo(id) == 0) {
                tree_procesos.remove(value);
                tree_procesos.add(value);
                return value.getTamanio();
            }
        }
        return 0;
    }

    /*OJO SE MODIFICO EN LA PRIMERA LOINEA DEL IF y el valor que return era Object*/
    public Proceso obtenerProceso(String id) {
        Iterator it = tree_procesos.iterator();
        Proceso value = null;

        while (it.hasNext()) {
            value = (Proceso) it.next();
            if (id != null) {
                if (value.getId().compareTo(id) == 0) {
                    //value=(Proceso) it.next();
                    break;
                } else {
                    value = null;
                }
            }else{
                    value = null;
            }
        }
        return value;
    }

    /*Eliminar un proceso del arrbol de procesos*/
    public void eliminarProcesoDeArbol(Proceso proceso) {
        Iterator it = tree_procesos.iterator();
        Proceso value = proceso;

        while (it.hasNext()) {
            value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getId()) == 0) {
                tree_procesos.remove(value);
                break;
            } else {
                value = proceso;
            }
        }
    }

    public void eleminarProcesoDeColaListo(Proceso proceso) {
        Iterator it = cola_listo.iterator();
        Proceso value = proceso;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getId()) == 0) { //esta
                cola_listo.remove(value);
            } else {
                value = proceso;
            }
        }
    }

    public void eleminarProcesoDeColaBloqueado(Proceso proceso) {
        Iterator it = cola_bloquedao.iterator();
        Proceso value = proceso;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getId()) == 0) { //esta
                cola_bloquedao.remove(value);
            } else {
                value = proceso;
            }
        }
    }

    public void eleminarProcesoDeColaTerminado(Proceso proceso) {
        Iterator it = cola_terminado.iterator();
        Proceso value = proceso;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getId()) == 0) { //esta
                cola_terminado.remove(value);
            } else {
                value = proceso;
            }
        }
    }

    public int getTiempoProceso() {
        return tiempoProceso;
    }

    public void setTiempoProceso(int tiempoProceso) {
        this.tiempoProceso = tiempoProceso;
    }
    /*
     public void sumarTiempoEjecucion(Proceso proceso){
     proceso.addTiempoEjecucion();
     }*/

    /*A todos los procesos de listo les aumenta el tiempo*/
    public void sumarTiempoListos() {
        Iterator it = cola_listo.iterator();
        Proceso value;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            value.addTiempoListo();
        }
    }

    public void sumaTiempoBloqueadosArchivo() {
        Iterator it = cola_bloqueadoArchivo.iterator();
        Proceso value;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            value.addTiempoBloqueado();
        }
    }

    public void sumaTiempoBloqueadosImpresora() {
        Iterator it = cola_bloqueadoImpresora.iterator();
        Proceso value;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            value.addTiempoBloqueado();
        }
    }

    public void sumaTiempoBloqueadosMonitor() {
        Iterator it = cola_bloqueadoMonitor.iterator();
        Proceso value;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            value.addTiempoBloqueado();
        }
    }

    public boolean isStop() {
        return stop;
    }

    public void setStop(boolean stop) {
        this.stop = stop;
    }

    public Dispositivo[] getDispositivosDisponibles() {
        return dispositivosDisponibles;
    }

    public void setDispositivosDisponibles(Dispositivo[] dispositivosDisponibles) {
        this.dispositivosDisponibles = dispositivosDisponibles;
    }

    public boolean addProceso(Proceso proceso) {
        boolean estado = tree_procesos.add(proceso);
        if (estado == true) {
            cola_listo.offer(proceso);
        }
        return estado;
    }

    public boolean addNuevo(String id) {
        return tree_nuevo.add(id);
    }

    //prueba, esto se va a borrar
    public void cambiarEstado(Proceso proceso, String estado) {
        Iterator it = tree_procesos.iterator();
        Proceso value = proceso;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getId()) == 0) {
                tree_procesos.remove(value);
                value.setEstado(estado);
                tree_procesos.add(value);
                break;
            } else {
                value = proceso;
            }
        }

    }

    public void ejecutar() throws InterruptedException {
        stop = false;
        ventana.desactivarPaneles();

        while (!cola_listo.isEmpty() && stop != true) {
            sumarTiempoListos();
            sumaTiempoBloqueadosArchivo();
            sumaTiempoBloqueadosImpresora();
            sumaTiempoBloqueadosMonitor();
            terminado = false;           
            Proceso proceso = cola_listo.poll();
             ventana.actualizarInformacion(proceso);
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
                ventana.actualizarInformacion(-1);
                sleep();
                //estan disponible los dispostivos solicitados 
                if (comprobarRecursoDisponible(proceso)) {
                    desactivarDispositivos(proceso);
                    procesador.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                    proceso = procesador.procesar(proceso);
                    ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                    sleep();
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();

                    if (proceso.getTamanio_actual() <= 0) {
                        cambiarEstado(proceso, "TERMINADO");
                        activarDispositivos(proceso);
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
                        //proceso.sumarTiempoListo(); //mas 10 unidades  en listo
                    }
                    //Como no estan disponibles los dispositivos solicitados.
                } else {
                    cambiarEstado(proceso, "BLOQUEADO");
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
                    bloquearProceso(proceso);
                    //proceso.sumarTiempoBloqueado();//mas 10 unidades en bloqueado
                    //cola_bloquedao.offer(proceso);
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
                ventana.actualizarInformacion(proceso);
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
                    //proceso.sumarTiempoListo(); //mas 10 unidades en listo
                }
            }
            ventana.actualizarInformacion(proceso);
        }
        terminado = true;
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
    private void bloquearProceso(Proceso proceso) {
        Dispositivo dispositivosRequerdos[] = proceso.getRequerimientos();
        //proceso.sumarTiempoBloqueado(1);
        for (int i = 0; i < dispositivosRequerdos.length; i++) {
            //Comprobamos que el dispositivo no este disponible
            if (!dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())].isDisponible()) {
                 switch (Integer.parseInt(dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())].getId())) {
                    case 0:
                        cola_bloqueadoImpresora.offer(proceso);
                        ventana.ejecucionBloqueado();
                        break;
                    case 1:
                        cola_bloqueadoMonitor.offer(proceso);
                        ventana.ejecucionBloqueado();
                        break;
                    case 2:
                     cola_bloqueadoArchivo.offer(proceso);
                     ventana.ejecucionBloqueado();
                     break;
                     case 3:
                         cola_bloqueadoParlante.offer(proceso);
                         ventana.ejecucionBloqueado();
                         break;
                     case 4:
                         cola_bloqueadoMicrofono.offer(proceso);
                         ventana.ejecucionBloqueado();
                         break;
                     case 5:
                         cola_bloqueadoUSB.offer(proceso);
                         ventana.ejecucionBloqueado();
                         break;
                     case 6:
                         cola_bloqueadoCamara.offer(proceso);
                         ventana.ejecucionBloqueado();
                         break;
                    }
                    sleep();
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
                    break;
            } 
        }       
        
    }

    public void printTreeSet() {
        Iterator iteratoro = tree_procesos.iterator();
        //Displaying the Tree set data
        while (iteratoro.hasNext()) {
            Proceso a = (Proceso) iteratoro.next();
            System.out.print(a.getId() + a.getEstado() + "_" + a.getRequerimientos());
        }
        System.out.println();
    }

    public void sleep() {
        tiempoProceso = ventana.getValueTiempoProceso();
        try {
            Thread.sleep(tiempoProceso);
        } catch (InterruptedException ex) {
            Logger.getLogger(ControlProceso.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //comprueba que los dispositivos esten disponibles o que 
    //los dispositivos tengan asignado el id del proceso
    public boolean comprobarRecursoDisponible(Proceso proceso) {
        Dispositivo dispositivosRequerdos[] = proceso.getRequerimientos();
        boolean todoDisponible = false;

        for (int i = 0; i < dispositivosRequerdos.length; i++) {
            //Comprobamos que el dispositivo este disponible
            if (dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())].isDisponible()) {
                todoDisponible = true;
            } else if (dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())].getIdProcesoContenedor().compareTo(proceso.getId()) == 0) {
                todoDisponible = true;
            } else {
                todoDisponible = false;
                break;
            }
        }

        return todoDisponible;
    }

    public boolean isTerminado() {
        return terminado;
    }

    //Desactiva los dispositivos que requiere el proceso para que no esten y
    //asigna los id's de los procesos a los dispositivos
    public void desactivarDispositivos(Proceso proceso) {
        Dispositivo dispositivosRequerdos[] = proceso.getRequerimientos();

        for (int i = 0; i < dispositivosRequerdos.length; i++) {
            if (dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())].isDisponible()) {
                dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())].setDisponible(false);
                dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())].setIdProcesoContenedor(proceso.getId());
                ventana.actualizarDispositivos(dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())]);
            }
        }


    }

    //Activar los dispositovos que requirio el proceso
    // y elimina las asignaciones de los dispositivos
    //De igual forma sacá los disñositivos en esepra
    public void activarDispositivos(Proceso proceso) {

        Dispositivo dispositivosRequerdos[] = proceso.getRequerimientos();

        for (int i = 0; i < dispositivosRequerdos.length; i++) {
            if (!dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())].isDisponible()) {
                dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())].setDisponible(true);
                dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())].setIdProcesoContenedor(null);
                ventana.actualizarDispositivos(dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())]);
            }

            Proceso procesoAux = null;
            switch (Integer.parseInt(dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())].getId())) {
                case 0:
                    if (!cola_bloqueadoImpresora.isEmpty()) {
                        //Lo mete a listo
                        procesoAux = cola_bloqueadoImpresora.poll();
                        ventana.bloqueadoToListo(procesoAux.getId()+" "+procesoAux.getNombre());
                    }
                    break;
                case 1:
                    if (!cola_bloqueadoMonitor.isEmpty()) {
                        //Lo mete a listo
                        procesoAux = cola_bloqueadoMonitor.poll();
                        ventana.bloqueadoToListo(procesoAux.getId()+" "+procesoAux.getNombre());
                    }
                    break;
                case 2:
                    if (!cola_bloqueadoArchivo.isEmpty()) {
                        //Lo mete a listo
                        procesoAux = cola_bloqueadoArchivo.poll();
                        ventana.bloqueadoToListo(procesoAux.getId()+" "+procesoAux.getNombre());
                    }
                    break;
                case 3:
                    if (!cola_bloqueadoParlante.isEmpty()) {
                        //Lo mete a listo
                        procesoAux = cola_bloqueadoParlante.poll();
                        ventana.bloqueadoToListo(procesoAux.getId()+" "+procesoAux.getNombre());
                    }
                    break;
                case 4:
                    if (!cola_bloqueadoMicrofono.isEmpty()) {
                        //Lo mete a listo
                        procesoAux = cola_bloqueadoMicrofono.poll();
                        ventana.bloqueadoToListo(procesoAux.getId()+" "+procesoAux.getNombre());
                    }
                    break;
                case 5:
                    if (!cola_bloqueadoUSB.isEmpty()) {
                        //Lo mete a listo
                        procesoAux = cola_bloqueadoUSB.poll();
                        ventana.bloqueadoToListo(procesoAux.getId()+" "+procesoAux.getNombre());
                    }
                    break;
                case 6:
                    if (!cola_bloqueadoCamara.isEmpty()) {
                        //Lo mete a listo
                        procesoAux = cola_bloqueadoCamara.poll();
                        ventana.bloqueadoToListo(procesoAux.getId()+" "+procesoAux.getNombre());
                    }
                    break;
            }

            if (procesoAux != null) {
                cola_listo.offer(procesoAux);
                cambiarEstado(procesoAux, "LISTO");
                ventana.actualizarProcesosTabla(procesoAux);
                sleep();
                ventana.actualizarDispositivos(dispositivosDisponibles[Integer.parseInt(dispositivosRequerdos[i].getId())]);
            }
        }



    }
}