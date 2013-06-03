package modelo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import vista.VentanaMemoria;
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
    
    private Queue<Proceso> cola_listoPrioridadAlta;
    private Queue<Proceso> cola_listoPrioridaMedia;
    private Queue<Proceso> cola_listoPrioridadBaja;
    private Queue<Proceso> cola_terminadoPrioridadAlta;
    private Queue<Proceso> cola_terminadoPrioridaMedia;
    private Queue<Proceso> cola_terminadoPrioridadBaja;
    
    private boolean stop;
    private Dispositivo dispositivosDisponibles[];
    private Procesador procesador;
    private Procesador procesador_1;
    private Procesador procesador_2;
    private int tiempoProceso;
    //Es la unica forma que se me ocurrio para modificar la ventana  desde los
    //proceso de la clase control proceso =D
    private VentanaPrincipal ventana;
    private boolean terminado;
    private Memoria memoria;
    private VentanaMemoria ventanaMemoria;
    
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
        
        cola_listoPrioridadAlta = new LinkedList<Proceso>();        
        cola_listoPrioridaMedia = new LinkedList<Proceso>();
        cola_listoPrioridadBaja = new LinkedList<Proceso>();
        cola_terminadoPrioridadAlta = new LinkedList<Proceso>();        
        cola_terminadoPrioridaMedia = new LinkedList<Proceso>();
        cola_terminadoPrioridadBaja = new LinkedList<Proceso>();
        
        stop = false;
        procesador = new Procesador();
        procesador_1 = new Procesador();
        procesador_2 = new Procesador();
        this.ventana = ventana;
        this.terminado = true;
        memoria=new Memoria(10);
    }

    public void setVentanaMemoria(VentanaMemoria ventanaMemoria) {
        this.ventanaMemoria = ventanaMemoria;
    }
    
    public void setMemoria(Memoria memoria) {
        this.memoria = memoria;
    }       
    
    /*obtener la memoria*/
    public Memoria getMemoria(){
        return this.memoria;
    }
    
    /*metodo para saber si se puede bajar una pagina..FUNCIONA CORRECTAMENTE*/
    public boolean sePuedeBajarPagina(Proceso proceso){
        boolean sePuedeBajarUnaPagina=false;
        int ejecutado = proceso.getTamanhoEjecutado();
        int tamanhoActual = proceso.getTamanio_actual();
        int tamanhoProceso = proceso.getTamanio();
        int tamanioMarco = memoria.getTamanioMarco();
        
        if(tamanhoProceso<=tamanioMarco){
            if(tamanhoActual>0){
                sePuedeBajarUnaPagina=false;
            }else{
                sePuedeBajarUnaPagina=true;
                proceso.setTamanhoEjecutado(0);
            }
            
        }else if(ejecutado>=tamanioMarco){
            sePuedeBajarUnaPagina=true;
            proceso.setTamanhoEjecutado(0);
        }else{
            if(proceso.getUltimaPaginaCargada()==(proceso.getPaginasCount()-1)){
                sePuedeBajarUnaPagina=true;
            }else{
                sePuedeBajarUnaPagina=false;
            }
        }
        
        return sePuedeBajarUnaPagina;
    }
    
    /*Recibe un proceso al que se le va a bajar una pagina*/
    public void bajarPagina(Proceso proceso){
        
        int paginaASubir = proceso.getUltimaPaginaCargada() +1;
        memoria.cargarPagina(proceso,paginaASubir);
    }
    
    /*Elimina un proceso del arbol de procesos*/
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

    /*Obtiene el tamaño de un proceso especifico*/
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

    /*Metodo para obtener un proceso del arbol de procesos*/
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

    public void quitarRecurso(String id, Dispositivo dispotivoAQuitar){
        Iterator it = tree_procesos.iterator();
        Proceso value = null;

        while (it.hasNext()) {
            value = (Proceso) it.next();
            if (id != null) {
                if (value.getId().compareTo(id) == 0) {
                    //value=(Proceso) it.next();
                    Dispositivo mios[] = value.getRequerimientos();
                    for(int i=0;i<mios.length;i++){
                        if(mios[i].getId().compareTo(dispotivoAQuitar.getId())==0){
                            mios[i].setDisponible(false);
                        }
                        break;
                    }
                    break;
                } else {
                    value = null;
                }
            }else{
                    value = null;
            }
        }
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

    /*Metodo para eliminar un proceso de la cola listo*/
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

    /*Metodo para eliminar un proceso de la cola bloqueado*/
    public void eliminarProcesoDeColaBloqueado(Proceso proceso) {
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

    /*Metodo para eliminar un proceso de la cola terminado*/
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
    

    /*A todos los procesos de listo les aumenta el tiempo en una unidad*/
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
    
    public void sumaTiempoBloqueadosParlante() {
        Iterator it = cola_bloqueadoParlante.iterator();
        Proceso value;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            value.addTiempoBloqueado();
        }
    }
    
    public void sumaTiempoBloqueadosMicrofono() {
        Iterator it = cola_bloqueadoMicrofono.iterator();
        Proceso value;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            value.addTiempoBloqueado();
        }
    }
    
    public void sumaTiempoBloqueadosUsb() {
        Iterator it = cola_bloqueadoUSB.iterator();
        Proceso value;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            value.addTiempoBloqueado();
        }
    }
    
    public void sumaTiempoBloqueadosCamara() {
        Iterator it = cola_bloqueadoCamara.iterator();
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

    /*agrega un proceso en la cola de listo con alta prioridad*/
    public void addProcesoColaListoAlta(Proceso proceso){
        cola_listoPrioridadAlta.offer(proceso);
        //JOptionPane.showMessageDialog(null,"se agrego un proceso a cola VIP");
    }
    
    /*agrega un proceso en la cola de listo con emdia prioridad*/
    public void addProcesoColaListoMedia(Proceso proceso){
        cola_listoPrioridaMedia.offer(proceso);
        //JOptionPane.showMessageDialog(null,"se agrego un proceso a cola MEDia");
    }
    
    /*agrega un proceso en la cola de listo con baja prioridad*/
    public void addProcesoColaListoBaja(Proceso proceso){
        cola_listoPrioridadBaja.offer(proceso);
        //JOptionPane.showMessageDialog(null,"se agrego un proceso a cola BAJA");
    }
    
    /*Este metodo agrega procesos al arbol de procesos, a la cola listo y clasifica
     segun la priioridad del proceso en listo con prioridad alta, media y baja*/
    public boolean addProcesoAListo(Proceso proceso) {
        boolean estado = tree_procesos.add(proceso);
        if (estado == true) {
            short priority = proceso.getPrioridad();
            if(priority==0){
                addProcesoColaListoBaja(proceso);
            }else if(priority==1){
                addProcesoColaListoMedia(proceso);
            }else if(priority==2){
                addProcesoColaListoAlta(proceso);
            }
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

    public void sumarTiempos() {
        sumarTiempoListos();
        sumaTiempoBloqueadosArchivo();
        sumaTiempoBloqueadosImpresora();
        sumaTiempoBloqueadosMonitor();
        sumaTiempoBloqueadosParlante();
        sumaTiempoBloqueadosMicrofono();
        sumaTiempoBloqueadosUsb();
        sumaTiempoBloqueadosCamara();
    }
    
    public void ejecutarPrioridadAlta(){
        while (!cola_listoPrioridadAlta.isEmpty() && stop != true) {
            System.out.println("entre al while()");
            terminado = false;
            Proceso proceso = cola_listoPrioridadAlta.poll();
            ventana.actualizarInformacion(proceso);
            if (proceso.getTamanio_actual() <= 0) {
                ventana.listoToEjecucion();
                sleep();
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                ventana.ejecucionToTerminado();
                sleep();
                cambiarEstado(proceso, "TERMINADO");
                memoria.bajarPaginas(proceso);
                ventanaMemoria.clear();
                ventana.actualizarProcesosTabla(proceso);
                sleep();
                cola_terminado.offer(proceso);
                cola_terminadoPrioridadAlta.offer(proceso);
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
                    procesador_1.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                    proceso = procesador_1.procesar(proceso);
                    procesador_2.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                    proceso = procesador_2.procesar(proceso);
                    
                    if (sePuedeBajarPagina(proceso)) {
                        //System.out.println("Estoy dentro de ejcutar().se proceso.. se puede bajar una pagina..");
                        bajarPagina(proceso);
                        ventanaMemoria.clear();
                    }
                    ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                    sleep();
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();

                    if (proceso.getTamanio_actual() <= 0) {
                        cambiarEstado(proceso, "TERMINADO");
                        memoria.bajarPaginas(proceso);
                        ventanaMemoria.clear();
                        activarDispositivos(proceso);
                        ventana.activarPorgresBar(0, 0);
                        sleep();
                        ventana.actualizarProcesosTabla(proceso);
                        sleep();
                        ventana.ejecucionToTerminado();
                        sleep();
                        cola_terminado.offer(proceso);
                        cola_terminadoPrioridadAlta.offer(proceso);
                    } else {
                        ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                        sleep();
                        ventana.ejecucionToListo();
                        sleep();
                        cambiarEstado(proceso, "LISTO");
                        ventana.actualizarProcesosTabla(proceso);
                        sleep();
                        //cola_listo.offer(proceso);
                        cola_listoPrioridadAlta.offer(proceso);
                    }
                    //Como no estan disponibles los dispositivos solicitados.
                    //se le tiene que dar los recursos que necesita
                } else {
                    Dispositivo recursosQueNecesita[] = proceso.getRequerimientos();
                    for (int i = 0; i < recursosQueNecesita.length; i++) {
                        String idContenedor = recursosQueNecesita[i].getIdProcesoContenedor();
                        Dispositivo dispQuitar = recursosQueNecesita[i];
                        recursosQueNecesita[i].setIdProcesoContenedor(proceso.getId());
                        quitarRecurso(idContenedor, dispQuitar);
                    }
                }

            } else { //NO REQUIERE DE DISPOSITIVOS
                System.out.println("Entro: al else de no requiere dispositivos");
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                ventana.listoToEjecucion();
                sleep();
                procesador.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                procesador_1.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                procesador_2.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());

                proceso = procesador.procesar(proceso);
                proceso = procesador_1.procesar(proceso);
                proceso = procesador_2.procesar(proceso);
                
                //bajarPagina(proceso);
                if (sePuedeBajarPagina(proceso)) {
                    System.out.println("Estoy dentro de ejcutar().se proceso.. se puede bajar una pagina..");
                    bajarPagina(proceso);
                    ventanaMemoria.clear();
                }
                cambiarEstado(proceso, "EJECUCION");
                ventana.actualizarProcesosTabla(proceso);
                ventana.actualizarInformacion(proceso);
                sleep();
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                //Se termino el tamanio de proedimientos ?
                if (proceso.getTamanio_actual() <= 0) {
                    cambiarEstado(proceso, "TERMINADO");
                    memoria.bajarPaginas(proceso);
                    ventanaMemoria.clear();
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
                    ventana.ejecucionToTerminado();
                    sleep();
                    ventana.activarPorgresBar(0, 0);
                    sleep();

                    cola_terminado.offer(proceso);
                    cola_terminadoPrioridadAlta.offer(proceso);
                    //COmo no termino entonces vuelve a la cola de LISTO 
                } else {
                    ventana.ejecucionToListo();
                    sleep();
                    ventana.activarPorgresBar(0, 0);
                    sleep();
                    cambiarEstado(proceso, "LISTO");
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
                    //cola_listo.offer(proceso);
                    cola_listoPrioridadAlta.offer(proceso);
                    //proceso.sumarTiempoListo(); //mas 10 unidades en listo
                }
                ventana.actualizarInformacion(proceso);
            }
        }
    }
    
    public void ejecutarPrioridadMedia(){
        System.out.println("se empieza a ejecutar los de la cola list media");
        while (!cola_listoPrioridaMedia.isEmpty() && stop != true) {
            System.out.println("entre al while()");
            terminado = false;
            Proceso proceso = cola_listoPrioridaMedia.poll();
            ventana.actualizarInformacion(proceso);
            if (proceso.getTamanio_actual() <= 0) {
                ventana.listoToEjecucion();
                sleep();
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                ventana.ejecucionToTerminado();
                sleep();
                cambiarEstado(proceso, "TERMINADO");
                memoria.bajarPaginas(proceso);
                ventanaMemoria.clear();
                ventana.actualizarProcesosTabla(proceso);
                sleep();
                cola_terminado.offer(proceso);
                cola_terminadoPrioridaMedia.offer(proceso);
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
                    procesador_1.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                    proceso = procesador_1.procesar(proceso);
                    procesador_2.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                    proceso = procesador_2.procesar(proceso);
                    
                    if (sePuedeBajarPagina(proceso)) {
                        //System.out.println("Estoy dentro de ejcutar().se proceso.. se puede bajar una pagina..");
                        bajarPagina(proceso);
                        ventanaMemoria.clear();
                    }
                    ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                    sleep();
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();

                    if (proceso.getTamanio_actual() <= 0) {
                        cambiarEstado(proceso, "TERMINADO");
                        memoria.bajarPaginas(proceso);
                        ventanaMemoria.clear();
                        activarDispositivos(proceso);
                        ventana.activarPorgresBar(0, 0);
                        sleep();
                        ventana.actualizarProcesosTabla(proceso);
                        sleep();
                        ventana.ejecucionToTerminado();
                        sleep();
                        cola_terminado.offer(proceso);
                        cola_terminadoPrioridaMedia.offer(proceso);
                    } else {
                        ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                        sleep();
                        ventana.ejecucionToListo();
                        sleep();
                        cambiarEstado(proceso, "LISTO");
                        ventana.actualizarProcesosTabla(proceso);
                        sleep();
                        //cola_listo.offer(proceso);
                        cola_listoPrioridaMedia.offer(proceso);
                    }
                    //Como no estan disponibles los dispositivos solicitados.
                    //se le tiene que dar los recursos que necesita
                } else {
                    Dispositivo recursosQueNecesita[] = proceso.getRequerimientos();
                    for (int i = 0; i < recursosQueNecesita.length; i++) {
                        String idContenedor = recursosQueNecesita[i].getIdProcesoContenedor();
                        Dispositivo dispQuitar = recursosQueNecesita[i];
                        recursosQueNecesita[i].setIdProcesoContenedor(proceso.getId());
                        quitarRecurso(idContenedor, dispQuitar);
                    }
                    
                }

            } else { //NO REQUIERE DE DISPOSITIVOS
                System.out.println("Entro: al else de no requiere dispositivos");
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                ventana.listoToEjecucion();
                sleep();
                procesador.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                procesador_1.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                procesador_2.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());

                proceso = procesador.procesar(proceso);
                proceso = procesador_1.procesar(proceso);
                proceso = procesador_2.procesar(proceso);
                
                //bajarPagina(proceso);
                if (sePuedeBajarPagina(proceso)) {
                    System.out.println("Estoy dentro de ejcutar().se proceso.. se puede bajar una pagina..");
                    bajarPagina(proceso);
                    ventanaMemoria.clear();
                }
                cambiarEstado(proceso, "EJECUCION");
                ventana.actualizarProcesosTabla(proceso);
                ventana.actualizarInformacion(proceso);
                sleep();
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                //Se termino el tamanio de proceso ?
                if (proceso.getTamanio_actual() <= 0) {
                    cambiarEstado(proceso, "TERMINADO");
                    memoria.bajarPaginas(proceso);
                    ventanaMemoria.clear();
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
                    ventana.ejecucionToTerminado();
                    sleep();
                    ventana.activarPorgresBar(0, 0);
                    sleep();

                    cola_terminado.offer(proceso);
                    cola_terminadoPrioridaMedia.offer(proceso);
                    //COmo no termino entonces vuelve a la cola de LISTO 
                } else {
                    ventana.ejecucionToListo();
                    sleep();
                    ventana.activarPorgresBar(0, 0);
                    sleep();
                    cambiarEstado(proceso, "LISTO");
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
                    //cola_listo.offer(proceso);
                    cola_listoPrioridaMedia.offer(proceso);
                    //proceso.sumarTiempoListo(); //mas 10 unidades en listo
                }
                ventana.actualizarInformacion(proceso);
            }
        }
    }
    
    public void ejecutarPrioridadBaja(){
        System.out.println("se empieza a ejecutar los de la cola list baja");
        while (!cola_listoPrioridadBaja.isEmpty() && stop != true) {
            System.out.println("entre al while()");
            terminado = false;
            Proceso proceso = cola_listoPrioridadBaja.poll();
            ventana.actualizarInformacion(proceso);
            if (proceso.getTamanio_actual() <= 0) {
                ventana.listoToEjecucion();
                sleep();
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                ventana.ejecucionToTerminado();
                sleep();
                cambiarEstado(proceso, "TERMINADO");
                memoria.bajarPaginas(proceso);
                ventanaMemoria.clear();
                ventana.actualizarProcesosTabla(proceso);
                sleep();
                cola_terminado.offer(proceso);
                cola_terminadoPrioridadBaja.offer(proceso);
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
                    procesador_1.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                    proceso = procesador_1.procesar(proceso);
                    procesador_2.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                    proceso = procesador_2.procesar(proceso);
                    
                    if (sePuedeBajarPagina(proceso)) {
                        //System.out.println("Estoy dentro de ejcutar().se proceso.. se puede bajar una pagina..");
                        bajarPagina(proceso);
                        ventanaMemoria.clear();
                    }
                    ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                    sleep();
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();

                    if (proceso.getTamanio_actual() <= 0) {
                        cambiarEstado(proceso, "TERMINADO");
                        memoria.bajarPaginas(proceso);
                        ventanaMemoria.clear();
                        activarDispositivos(proceso);
                        ventana.activarPorgresBar(0, 0);
                        sleep();
                        ventana.actualizarProcesosTabla(proceso);
                        sleep();
                        ventana.ejecucionToTerminado();
                        sleep();
                        cola_terminado.offer(proceso);
                        cola_terminadoPrioridadBaja.offer(proceso);
                    } else {
                        ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                        sleep();
                        ventana.ejecucionToListo();
                        sleep();
                        cambiarEstado(proceso, "LISTO");
                        ventana.actualizarProcesosTabla(proceso);
                        sleep();
                        //cola_listo.offer(proceso);
                        cola_listoPrioridadBaja.offer(proceso);
                    }
                    //Como no estan disponibles los dispositivos solicitados.
                    //se le tiene que dar los recursos que necesita
                } else {
                    Dispositivo recursosQueNecesita[] = proceso.getRequerimientos();
                    for (int i = 0; i < recursosQueNecesita.length; i++) {
                        String idContenedor = recursosQueNecesita[i].getIdProcesoContenedor();
                        Dispositivo dispQuitar = recursosQueNecesita[i];
                        recursosQueNecesita[i].setIdProcesoContenedor(proceso.getId());
                        quitarRecurso(idContenedor, dispQuitar);
                    }
                    
                }

            } else { //NO REQUIERE DE DISPOSITIVOS
                System.out.println("Entro: al else de no requiere dispositivos");
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                ventana.listoToEjecucion();
                sleep();
                procesador.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                procesador_1.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                procesador_2.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());

                proceso = procesador.procesar(proceso);
                proceso = procesador_1.procesar(proceso);
                proceso = procesador_2.procesar(proceso);
                
                //bajarPagina(proceso);
                if (sePuedeBajarPagina(proceso)) {
                    System.out.println("Estoy dentro de ejcutar().se proceso.. se puede bajar una pagina..");
                    bajarPagina(proceso);
                    ventanaMemoria.clear();
                }
                cambiarEstado(proceso, "EJECUCION");
                ventana.actualizarProcesosTabla(proceso);
                ventana.actualizarInformacion(proceso);
                sleep();
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                //Se termino el tamanio de proedimientos ?
                if (proceso.getTamanio_actual() <= 0) {
                    cambiarEstado(proceso, "TERMINADO");
                    memoria.bajarPaginas(proceso);
                    ventanaMemoria.clear();
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
                    ventana.ejecucionToTerminado();
                    sleep();
                    ventana.activarPorgresBar(0, 0);
                    sleep();

                    cola_terminado.offer(proceso);
                    cola_terminadoPrioridadBaja.offer(proceso);
                    //COmo no termino entonces vuelve a la cola de LISTO 
                } else {
                    ventana.ejecucionToListo();
                    sleep();
                    ventana.activarPorgresBar(0, 0);
                    sleep();
                    cambiarEstado(proceso, "LISTO");
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
                    //cola_listo.offer(proceso);
                    cola_listoPrioridadBaja.offer(proceso);
                    //proceso.sumarTiempoListo(); //mas 10 unidades en listo
                }
                ventana.actualizarInformacion(proceso);
            }
        }
    }
    
    public void ejecutar() throws InterruptedException {
        stop = false;
        ventana.desactivarPaneles();
        sumarTiempos();
        ejecutarPrioridadAlta();        
        ejecutarPrioridadMedia();
        ejecutarPrioridadBaja();
        terminado = true;
        ventana.activarPaneles();
        
        /*   
        while (!cola_listo.isEmpty() && stop != true) {
            
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
                memoria.bajarPaginas(proceso);
                ventanaMemoria.clear();
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
                    if(sePuedeBajarPagina(proceso)){
                        System.out.println("Estoy dentro de ejcutar().se proceso.. se puede bajar una pagina..");
                        
                        bajarPagina(proceso);
                        
                        ventanaMemoria.clear();
                    }
                    ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                    sleep();
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();

                    if (proceso.getTamanio_actual() <= 0) {
                        cambiarEstado(proceso, "TERMINADO");
                        memoria.bajarPaginas(proceso);
                        ventanaMemoria.clear();
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
                    }
                    //Como no estan disponibles los dispositivos solicitados.
                } else {
                    cambiarEstado(proceso, "BLOQUEADO");
                    ventana.actualizarProcesosTabla(proceso);
                    sleep();
                    bloquearProceso(proceso);
                }
                //COmo no requere un dispositivo
            } else {
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                ventana.listoToEjecucion();
                sleep();
                procesador.setCantidadAQuitar(ventana.getCantidadAQUitarJSpinner());
                proceso = procesador.procesar(proceso);
                //bajarPagina(proceso);
                if(sePuedeBajarPagina(proceso)){
                        System.out.println("Estoy dentro de ejcutar().se proceso.. se puede bajar una pagina..");
                        bajarPagina(proceso);
                       ventanaMemoria.clear();
                }
                cambiarEstado(proceso, "EJECUCION");
                ventana.actualizarProcesosTabla(proceso);
                ventana.actualizarInformacion(proceso);
                sleep();
                ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
                sleep();
                //Se termino el tamanio de proedimientos ?
                if (proceso.getTamanio_actual() <= 0) {
                    cambiarEstado(proceso, "TERMINADO");
                    memoria.bajarPaginas(proceso);
                    ventanaMemoria.clear();
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
        ventana.activarPaneles();*/
    }

    /*
     private void etapasProcesamientoVisual(Proceso proceso,String estado){
     ventana.activarPorgresBar(proceso.getTamanio(), proceso.getTamanio_actual());
     sleep();              
     cambiarEstado(proceso, estado);   
     ventana.actualizarProcesosTabla(proceso);
     sleep();          
     }*/
    
    /*Adiciona un proceso a listo cuando sale de un fallo de pagina*/
    public void addListo(Proceso proceso){
        cola_listo.add(proceso);
    }
    /*Adiciona un proceso a bloqueado cuando ha fallo de pagina*/
    public void addBloqueado(Proceso proceso){
        cola_bloquedao.add(proceso);
    }
    
    /*Elimina un proceso especifico de la cola bloqueado*/
    public void eliminarDeBloqueado(Proceso proceso){
        Iterator it = cola_bloquedao.iterator();
        Proceso value = proceso;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getId()) == 0) {
               // tree_procesos.remove(value);
                //value.setEstado(estado);
                cola_bloquedao.remove(value);
                break;
            } else {
                value = proceso;
            }
        }
    }
    
    /*Elimina un proceso especifico de la cola listo*/
    public void eliminarDeListo(Proceso proceso){
        Iterator it = cola_listo.iterator();
        Proceso value = proceso;
        while (it.hasNext()) {
            value = (Proceso) it.next();
            if (value.getId().compareTo(proceso.getId()) == 0) {
                cola_listo.remove(value);
                break;
            } else {
                value = proceso;
            }
        }
    }
    
   
    /*Bloque un proceso por dispositivo*/
    public void bloquearProceso(Proceso proceso) {
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