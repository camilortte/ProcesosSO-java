/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import com.sun.org.apache.xerces.internal.parsers.IntegratedParserConfiguration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import javax.swing.JOptionPane;

/**
 *
 * @author camilortte
 */
public class Memoria {
    private ArrayList<String> memoriaPrincipal;
    private ArrayList<String> memoriaVirtual;    
    private int numeroPaginas=5;
    private int tamanioMemoria;
    //COntiene todos los espacios vacios que hay en la memoria principal.
    private ArrayList<Integer> espaciosVaciosPrincipal;
    private ArrayList<Integer> espaciosVaciosVirtual;
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
    
    
    
    //recibe un  arreglo de paginas vacio al cual se le asignaran indices de ubicacion tanto en
    //la memoria principal como dinamica .
    /*Asi es que toca llamarlo
     * Memoria memor=new Memoria(10);
        Integer tabla[][]=new Integer[5][2];
        tabla=memor.solicitarEspacio(tabla, "Chrome");
        for(int i=0;i<tabla.length;i++){
            System.out.print("->"+tabla[i][0]);
            if(tabla[i][1]==1)
                System.out.print("Virtual\n");
            else
                System.out.println("");
        }
     */
    
    /*Obtenien una pagina y un proceso de memoria principal especificos*/
    public String[] obtenerProcesoDePrincipal(Proceso proceso, int paginaASubir){
        String datosProceso[] = null;
        for(int i=0;i<memoriaPrincipal.size();i++){
            if(memoriaPrincipal.get(i)!=null){
                String vector[] = memoriaPrincipal.get(i).split(" ");
                if(vector[0].compareTo(proceso.getNombre())==0 && vector[1].compareTo(proceso.getId())==0 && vector[2].compareTo(""+paginaASubir)==0){
                    //System.out.println("la pagina referenciada "+paginaReferenciada+"esta en la pos "+i);
                    datosProceso =  new String[3];
                    
                    //datosProceso=vector;
                    datosProceso[0]=vector[0];
                    datosProceso[1]=vector[1];
                    datosProceso[2]=vector[2]+" "+i;
                    //datosProceso[3]=vector[3];
                    //datosProceso[3]=""+i; //el indice de la pos en MP 
                    memoriaPrincipal.set(i, null);
                    break;
                }
            }
        }
        return datosProceso;
    }
    
    /*Obtenien una pagina y un proceso de memoria virtual especificos*/
    public String[] obtenerProcesoDeVirtual(Proceso proceso, int paginaASubir){
        String datosProceso[]=null;
        for(int i=0;i<memoriaVirtual.size();i++){
            if(memoriaVirtual.get(i)!=null){
                String vector[] = memoriaVirtual.get(i).split(" ");
                if(vector[0].compareTo(proceso.getNombre())==0 && vector[1].compareTo(proceso.getId())==0 && vector[2].compareTo(""+paginaASubir)==0){
                    //System.out.println("la pagina referenciada "+paginaReferenciada+"esta en la pos "+i);
                    datosProceso =  new String[3];
                    datosProceso[0]=vector[0];
                    datosProceso[1]=vector[1];
                    datosProceso[2]=vector[2]+" "+i;
                    //datosProceso=vector;
                    //datosProceso[3]=""+i; //el indice de la pos en MP 
                    memoriaVirtual.set(i, null);
                    break;
                }
            }
        }
        return datosProceso;
    }
    
    /*Este metodo  hace la hiperpaginacion segun la politica de vaciado local.*/
    public void hiperPaginar(Proceso proceso, int paginaASubir){
        int paginaAVirtual = paginaASubir-1;
        String temporal_p[] = null;
        String temporal_v[] = null;
        System.out.println("se ha llamado a hiperPaginar()....");
        //if(paginaEnVirtual(proceso, paginaASubir)){
            System.out.println("se esta hiperpaginando....");
            System.out.println("valor de paginaAVirtual:"+paginaAVirtual);
            temporal_p = obtenerProcesoDePrincipal(proceso, paginaAVirtual);
            System.out.println("valor de painaASubir:"+paginaASubir);
            temporal_v = obtenerProcesoDeVirtual(proceso, paginaASubir);
            
            /*String indice_1[]=temporal_p[2].split(" ");
            String indice_2[]=temporal_v[2].split(" ");*/
            
            insertarEnPrincipal(temporal_v);
            insertarEnVirtual(temporal_p);
            /*
            memoriaPrincipal.set(Integer.parseInt(indice_1[1]),temporal_v[0]+" "+temporal_v[1]+" "+temporal_v[2]);
            memoriaVirtual.set(Integer.parseInt(indice_2[1]),temporal_p[0]+" "+temporal_p[1]+" "+temporal_p[2]);
            */
            //memoriaPrincipal.add(Integer.parseInt(indice_2[1]),temporal_v[0]+" "+temporal_v[1]+" "+temporal_v[2]);
            //memoriaVirtual.add(Integer.parseInt(indice_1[1]),temporal_p[0]+" "+temporal_p[1]+" "+temporal_p[2]);
            //memoriaVirtual.add(Integer.parseInt(indice_2[1]),temporal_p[0]+" "+temporal_p[1]+" "+temporal_p[2]);
            System.out.println("se ha hiperpaginado...");
            proceso.addFalloDePagina();
            System.out.println("HA HABIDO UN NUEVO FALLO DE PAGINA");
        //}
    }
    
    /*Este metodo mira si es necesario cargar una pagina de virtual o si ya esta en principal*/
    public void cargarPagina(Proceso proceso,int paginaASubir){
        Integer tablaPaginas[][]=proceso.getTablaDePaginas();
        System.out.println("tabla de paginas:");
        for(int i=0;i<tablaPaginas.length;i++){
            System.out.println("vector[i][0] :"+tablaPaginas[i][0]);
            System.out.println("vector[i][1] :"+tablaPaginas[i][1]);
        }
        System.out.println("se ha referenciado a la pagina :"+paginaASubir);
        if(paginaEnPrincipal(proceso, paginaASubir)){
            System.out.println("la pagina esta en MP, no es necesario subirla");
            proceso.addPaginaCargada();
        }else{
            System.out.println("la pagina no esta en MP, se necesita subir la pagina de MV, fallo de pagina");
            hiperPaginar(proceso, paginaASubir);
            proceso.addPaginaCargada();
        }
        
    }
    
    /*busca un proceso y una pagina referenciadae en MV, return true si está*/
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
    
    /*public void bajarTodasPaginas(Proceso proceso){
        String nombreP = proceso.getNombre();
        String idP = proceso.getId();
        int numPages = proceso.getPaginasCount();
        for(int i=0;i<memoriaPrincipal.size();i++){
            String vector[] = memoriaPrincipal.get(i).split(" ");
         for(int k=0;k<memoriaVirtual.size();k++){
            for(int j=0;j<numPages;j++){
                if(vector[0].compareTo(nombreP)==0 && vector[1].compareTo(idP)==0 && Integer.parseInt(vector[2])==j){
                    memoriaPrincipal.set(i, null);
                    
                }
            }
        }
        }
    }*/
    
    public void bajarPaginas(Proceso p){
        //Integer tablaPaginas[][] = p.getTablaDePaginas();
        //System.out.println("bajada a virtual de todas las paginas del proceso :"+p.getNombre());
      
        for(int i=0;i<memoriaPrincipal.size();i++){
            if(memoriaPrincipal.get(i)!=null){
                String v[]=memoriaPrincipal.get(i).split(" ");
            
                if(v[1].compareTo(p.getId())==0){
                //System.out.println("datos a bajar a virtual : "+datoABajar[0]+" "+datoABajar[1]+" "+datoABajar[2]);
                    System.out.println("SE ESTA BAJANDO LAS PAGINAS DEL PROCESO "+p.getNombre());
                    memoriaPrincipal.set(i, null);
                    insertarEnVirtual(v);
               }
            }
        }
    }
    
    public void insertarEnVirtual(String v[]){
        for(int i=0;i<memoriaVirtual.size();i++){
            if(memoriaVirtual.get(i)==null){
                memoriaVirtual.set(i,v[0]+" "+v[1]+" "+v[2]);
                System.out.println("se ha insertado en virtaul");
                break;
            }
        }
    }
    
    public void insertarEnPrincipal(String v[]){
        for(int i=0;i<memoriaPrincipal.size();i++){
            if(memoriaPrincipal.get(i)==null){
                memoriaPrincipal.set(i,v[0]+" "+v[1]+" "+v[2]);
                System.out.println("se ha insertado en principal");
                break;
            }
        }
    }
    
    /*Metodo que recibe un proceso que se va a bajar de la memoria principal
     Es llamado cuando ya se termina se ejecutar un proceso*/
    public void bajarUnProceso(Proceso proceso){
        Integer tablaPaginas[][] = proceso.getTablaDePaginas();
        //ArrayList vaciosVirtual = getEspaciosVaciosVirtual();
        for(int i=0;i<tablaPaginas.length;i++){
            //memoriaVirtual.add(memoriaPrincipal.get(tablaPaginas[i][0]));
            /*for(int j=0;j<memoriaVirtual.size();j++){
                if(memoriaVirtual.get(i)==null){
                    memoriaVirtual.add(j,memoriaPrincipal.get(tablaPaginas[i][0]));
                }
            }*/
            //memoriaPrincipal.remove(tablaPaginas[i][0]);
            //insertarEnMemoriaVirtual(tablaPaginas[i][0]);
            memoriaPrincipal.set(tablaPaginas[i][0], null);
            //memoriaPrincipal.add(tablaPaginas[i][0], null);
            //memoriaPrincipal.set(tablaPaginas[i][0],"");
            System.out.println("memoria princiapl");
            System.out.println(memoriaPrincipal.get(i));
            espaciosVaciosPrincipal.add(tablaPaginas[i][0]);
            //System.out.println(proceso.getNombre()+" "+tablaPaginas[i][0]+" ---   "+tablaPaginas[i][1]);
        }
    }
      
    
    public Integer[][]  solicitarEspacio(Integer tabla_paginas[][],String nombreProceso){
              
        
        int indiceVacio=0;
        int numeroPaginasAux;
        boolean excedeElTamanioPagina=false;
        if(tabla_paginas.length<=numeroPaginas){
            numeroPaginasAux=tabla_paginas.length;
            excedeElTamanioPagina=false;
        }else{
            numeroPaginasAux=numeroPaginas;
            excedeElTamanioPagina=true;
        }
        
                //solo lo va a hacer con 5 paginas =D
        for(int i=0;i<numeroPaginasAux;i++){            
            //Collections.sort(espaciosVaciosPrincipal);
            //Si no esta vacio es que hay espacios disponibles en la memoria 
            //principal.
            if(!espaciosVaciosPrincipal.isEmpty()){
                indiceVacio=espaciosVaciosPrincipal.get(0);
                espaciosVaciosPrincipal.remove(0);
                memoriaPrincipal.set(indiceVacio,(nombreProceso+" "+i));
                tabla_paginas[i][0]=indiceVacio;
                tabla_paginas[i][1]=0;
            }else{
                /*ya no hay espacio en la memoria , entonces toac meterla en la
                 * virtual o no dejar que ingrese mas proceso =D
                 */
            }
            
        }
        
        if(excedeElTamanioPagina==true){
            for(int i=numeroPaginasAux;i<tabla_paginas.length;i++){
                if(!espaciosVaciosVirtual.isEmpty()){
                    indiceVacio=espaciosVaciosVirtual.get(0);
                    espaciosVaciosVirtual.remove(0);
                    //memoriaVirtual.set(indiceVacio, nombreProceso+" PAG_"+i+" Virtual");
                    memoriaVirtual.set(indiceVacio, nombreProceso+" "+i);
                    tabla_paginas[i][0]=indiceVacio;
                    tabla_paginas[i][1]=1;
                }
            }
        }
        
        
        //Para mirar la memoria.
       /* for(int i=0;i<memoriaPrincipal.size();i++){
            System.out.println(memoriaPrincipal.get(i));
        }
        System.out.println("Memoria Virutla");
        for(int i=0;i<memoriaVirtual.size();i++){
            System.out.println(memoriaVirtual.get(i));
        }*/
        
        return tabla_paginas;        
    }
    
    
    public boolean hayMemoriaDisponible(int cantidadDePaginas){
        //refrescarEspaciosVacios();
        if(espaciosVaciosPrincipal.size()>=numeroPaginas ){
            return true;
        }else if(cantidadDePaginas<=espaciosVaciosPrincipal.size()){
            return true;
        }else{
            return false;
        }
    }
    
}
