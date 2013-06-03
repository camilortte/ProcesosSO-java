/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;

public class Memoria {
    private ArrayList<String> memoriaPrincipal;
    private ArrayList<String> memoriaVirtual;    
    private int numeroPaginas=5;
    private int tamanioMemoria;
    private int tamanioMarco;
    //COntiene todos los espacios vacios que hay en la memoria principal.
    private ArrayList<Integer> espaciosVaciosPrincipal;
    private ArrayList<Integer> espaciosVaciosVirtual;
    private ControlProceso controlProceso;
    //se manejas indicies negativos para hacer referencia que es de memoria virual
    
    public Memoria(int tamanioMemoria){
        this.tamanioMemoria=tamanioMemoria;
        this.memoriaPrincipal=new ArrayList<String>();        
        this.memoriaVirtual=new ArrayList<String>();
        this.espaciosVaciosPrincipal=new ArrayList<Integer>();
        this.espaciosVaciosVirtual=new ArrayList<Integer>();
        
        
        System.out.println(memoriaPrincipal.size());
        //iniciamos todos los elementos como nulos para decir que ese espacio de
        //Memoria esta libre
        for(int i=0;i<tamanioMemoria*2;i++){
            if(i<tamanioMemoria){                
                memoriaPrincipal.add(null);
                espaciosVaciosPrincipal.add(i);
            }            
            memoriaVirtual.add(null);
            espaciosVaciosVirtual.add(i);
        }
    }

    public int getTamanioMarco() {
        return tamanioMarco;
    }

    public void setTamanioMarco(int tamanioMarco) {
        this.tamanioMarco = tamanioMarco;
    }
    
    
    
    public ArrayList<Integer> getEspaciosVaciosPrincipal() {
        return espaciosVaciosPrincipal;
    }

    public void setEspaciosVaciosPrincipal(ArrayList<Integer> espaciosVaciosPrincipal) {
        this.espaciosVaciosPrincipal = espaciosVaciosPrincipal;
    }

    public ArrayList<Integer> getEspaciosVaciosVirtual() {
        return espaciosVaciosVirtual;
    }

    public void setEspaciosVaciosVirtual(ArrayList<Integer> espaciosVaciosVirtual) {
        this.espaciosVaciosVirtual = espaciosVaciosVirtual;
    }

    public ArrayList<String> getMemoriaPrincipal() {
        return memoriaPrincipal;
    }

    public void setMemoriaPrincipal(ArrayList<String> memoriaPrincipal) {
        this.memoriaPrincipal = memoriaPrincipal;
    }

    public ArrayList<String> getMemoriaVirtual() {
        return memoriaVirtual;
    }

    public void setMemoriaVirtual(ArrayList<String> memoriaVirtual) {
        this.memoriaVirtual = memoriaVirtual;
    }
    
    public void cambioProceso(Proceso proceso, int paginaToVirtual, int paginaToPrincipal){
        int indiceMemoriaPrincipal=proceso.getTablaDePaginas()[paginaToVirtual][0];
        int indiceMemoriaVirtual=proceso.getTablaDePaginas()[paginaToPrincipal][0];
       
        memoriaPrincipal.set(indiceMemoriaPrincipal, null);
        memoriaVirtual.set(indiceMemoriaVirtual, null);
        
        int indiceAuxiliar=proceso.getTablaDePaginas()[paginaToPrincipal][0];
        proceso.getTablaDePaginas()[paginaToPrincipal][0]=proceso.getTablaDePaginas()[paginaToVirtual][0];
        proceso.getTablaDePaginas()[paginaToPrincipal][1]=0;
        proceso.getTablaDePaginas()[paginaToVirtual][0]=indiceAuxiliar;
        proceso.getTablaDePaginas()[paginaToVirtual][1]=1; 
        String p1= proceso.getNombre()+" "+proceso.getId()+" "+paginaToPrincipal;
        String p2= proceso.getNombre()+" "+proceso.getId()+" "+paginaToVirtual;
        memoriaPrincipal.set(indiceMemoriaPrincipal, p1);
        memoriaVirtual.set(indiceMemoriaVirtual,p2);
        
    }
    
    /*Obtenie una pagina y un proceso  especifico de la memoria principal*/
    public String[] obtenerProcesoDePrincipal(Proceso proceso, int paginaToVirtual){
        
        String datosProceso[] = null;
        for(int i=0;i<memoriaPrincipal.size();i++){
            if(memoriaPrincipal.get(i)!=null){
                String vector[] = memoriaPrincipal.get(i).split(" ");
                if(vector[0].compareTo(proceso.getNombre())==0 && vector[1].compareTo(proceso.getId())==0 && vector[2].compareTo(""+paginaToVirtual)==0){
                    datosProceso =  new String[3];
                    datosProceso[0]=vector[0];
                    datosProceso[1]=vector[1];
                    datosProceso[2]=vector[2]+" "+i; 
                    memoriaPrincipal.set(i, null);
                    break;
                }
            }
        }
        return datosProceso;
    }
    
    /*Obtenie una pagina y un proceso especifico de memoria virtual*/
    public String[] obtenerProcesoDeVirtual(Proceso proceso, int paginaASubir){
        String datosProceso[]=null;
        for(int i=0;i<memoriaVirtual.size();i++){
            if(memoriaVirtual.get(i)!=null){
                String vector[] = memoriaVirtual.get(i).split(" ");
                if(vector[0].compareTo(proceso.getNombre())==0 && vector[1].compareTo(proceso.getId())==0 && vector[2].compareTo(""+paginaASubir)==0){
                    datosProceso =  new String[3];
                    datosProceso[0]=vector[0];
                    datosProceso[1]=vector[1];
                    datosProceso[2]=vector[2]+" "+i;
                    memoriaVirtual.set(i, null);
                    break;
                }
            }
        }
        return datosProceso;
    }
    
    /*Este metodo  hace la hiperpaginacion segun la politica de vaciado local.*/
    public void hiperPaginar(Proceso proceso, int paginaASubir){
        int paginaABajar = paginaASubir - 1;
        System.out.println("se llamo a hiperpaginar()");
        if(proceso.getUltimaPaginaCargada()<proceso.getPaginasCount()-1) {
            cambioProceso(proceso, paginaABajar, paginaASubir);
            proceso.addFalloDePagina();
        }
    }
    
    /*Este metodo mira si es necesario cargar una pagina de virtual o si ya esta en principal*/
    public void cargarPagina(Proceso proceso,int paginaASubir){
        
        if(paginaEnPrincipal(proceso, paginaASubir)){
            System.out.println("la pagina esta en MP, no es necesario subirla");
            proceso.addPaginaCargada();
        }else{
            System.out.println("la pagina no esta en MP, se necesita subir la pagina de MV, fallo de pagina");
            /*controlProceso = new ControlProceso(null);
            
            controlProceso.eliminarDeListo(proceso);
            controlProceso.addBloqueado(proceso);
            controlProceso.cambiarEstado(proceso,"BLOQUEADO");*/
            System.out.println("se va llamar a hiperpaginar()");
            hiperPaginar(proceso, paginaASubir);
            //proceso.addTiempoBloqueado();
            /*
            controlProceso.addListo(proceso);
            controlProceso.eliminarDeBloqueado(proceso);
            controlProceso.cambiarEstado(proceso,"LISTO");*/
            proceso.addPaginaCargada();
        }
        
    }
    
    /*busca un proceso y una pagina referenciada en MV, return true si está*/
    public boolean paginaEnVirtual(Proceso proceso, int paginaReferenciada){
        boolean esta=false;
        String vector[] = new String[2];
        System.out.println("SE ESTA BUSCANDO LA PAGINA EN MV");
        for(int i=0;i<memoriaVirtual.size();i++){
            if(memoriaVirtual.get(i)!=null){
                vector = memoriaVirtual.get(i).split(" ");
                if(vector[0].compareTo(proceso.getNombre())==0 && vector[1].compareTo(proceso.getId())==0 && vector[2].compareTo(""+paginaReferenciada)==0){
                    esta=true;
                    System.out.println("la pagina referenciada "+paginaReferenciada+" esta en la pos "+i+"de virtual");
                    break;
                }
            }
        }
        return esta;
    }
    
    /*busca un proceso y una pagina referenciadae en MP, return true si está*/
    public boolean paginaEnPrincipal(Proceso proceso, int paginaReferenciada){
        boolean esta=false;
        String vector[] = new String[2];
        System.out.println("SE ESTA BUSCANDO LA PAGINA EN MP");
        for(int i=0;i<memoriaPrincipal.size();i++){
            if(memoriaPrincipal.get(i)!=null){
                vector = memoriaPrincipal.get(i).split(" ");
                if(vector[0].compareTo(proceso.getNombre())==0 && vector[1].compareTo(proceso.getId())==0 && vector[2].compareTo(""+paginaReferenciada)==0){
                    esta=true;
                    System.out.println("la pagina referenciada "+paginaReferenciada+"esta en la pos "+i);
                    break;
                }
            }
        }
        return esta;
    }
    
    public void bajarPaginas(Proceso proceso){
        
        for(int i=0;i<proceso.getTablaDePaginas().length;i++){
            //Si la posicion i,1 == 1 es que esta en memoria principal
            int tipoMemoria=proceso.getTablaDePaginas()[i][1];
            int indiceALiberar=proceso.getTablaDePaginas()[i][0];
            if(tipoMemoria==0){
                espaciosVaciosPrincipal.add(indiceALiberar);
                memoriaPrincipal.set(indiceALiberar, null);
            }else{
                espaciosVaciosVirtual.add(indiceALiberar);
                memoriaVirtual.set(indiceALiberar, null);
            }
        }
        
        Collections.sort(espaciosVaciosPrincipal);
        Collections.sort(espaciosVaciosVirtual);
        
    }
    
    
    /*Inserta una pagina en memoria virtual*/
    //ESTA ES LA CAGADA
    public void insertarEnVirtual(String v[]){
        for(int i=0;i<memoriaVirtual.size();i++){
            if(memoriaVirtual.get(i)==null){
                memoriaVirtual.set(i,v[0]+" "+v[1]+" "+v[2]);
                System.out.println("se ha insertado en virtaul");
                break;
            }
        }
    }
    
    /*Inseta una pagina en memoria principal*/
    public void insertarEnPrincipal(String v[]){
        for(int i=0;i<memoriaPrincipal.size();i++){
            if(memoriaPrincipal.get(i)==null){
                memoriaPrincipal.set(i,v[0]+" "+v[1]+" "+v[2]);
                System.out.println("se ha insertado en principal");
                break;
            }
        }
    }
    
    /*Solicita espacio en memoria*/
    public Integer[][]  solicitarEspacio(Integer tabla_paginas[][],String nombreProceso){
        int indiceVacio = 0;
        int numeroPaginasAux;
        boolean excedeElTamanioPagina = false;

        //Se pregunta si se excede el tamanio de paginas minimo y es necesario meter
        //paginas en memoria virtual
        if (tabla_paginas.length <= numeroPaginas) {
            numeroPaginasAux = tabla_paginas.length;
            excedeElTamanioPagina = false;
        } else {
            //Es necesario meter paginas en memoria virtual
            numeroPaginasAux = numeroPaginas;
            excedeElTamanioPagina = true;
        }

        //solo lo va a hacer con 5 paginas =D
        for (int i = 0; i < numeroPaginasAux; i++) {
            //Collections.sort(espaciosVaciosPrincipal);
            //Si no esta vacio es que hay espacios disponibles en la memoria 
            //principal.
            if (!espaciosVaciosPrincipal.isEmpty()) {
                indiceVacio = espaciosVaciosPrincipal.get(0);
                espaciosVaciosPrincipal.remove(0);
                memoriaPrincipal.set(indiceVacio, (nombreProceso + " " + i));
                tabla_paginas[i][0] = indiceVacio;
                tabla_paginas[i][1] = 0;
            } else {
                /*ya no hay espacio en la memoria , entonces toac meterla en la
                 * virtual o no dejar que ingrese mas proceso =D
                 */
            }

        }

        if (excedeElTamanioPagina == true) {
            for (int i = numeroPaginasAux; i < tabla_paginas.length; i++) {
                if (!espaciosVaciosVirtual.isEmpty()) {
                    indiceVacio = espaciosVaciosVirtual.get(0);
                    espaciosVaciosVirtual.remove(0);
                    //memoriaVirtual.set(indiceVacio, nombreProceso+" PAG_"+i+" Virtual");
                    memoriaVirtual.set(indiceVacio, nombreProceso + " " + i);
                    tabla_paginas[i][0] = indiceVacio;
                    tabla_paginas[i][1] = 1;
                }
            }
        }
        return tabla_paginas;
    }
    
    /*Verifica si hay espacio en memoria principal, return true si hay espacion*/
    public boolean hayMemoriaDisponible(int cantidadDePaginas){
        
        if(espaciosVaciosPrincipal.size()>=numeroPaginas ){
            return true;
        }else if(cantidadDePaginas<=espaciosVaciosPrincipal.size()){
            return true;
        }else{
            return false;
        }
    }
    
}
