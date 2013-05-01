/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.ArrayList;
import java.util.Collections;
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
                memoriaPrincipal.set(indiceVacio, (nombreProceso+" Pag_"+i));
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
                    memoriaVirtual.set(indiceVacio, nombreProceso+" PAG_"+i+" Virtual");
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
        
        if(espaciosVaciosPrincipal.size()>=numeroPaginas ){
            return true;
        }else if(cantidadDePaginas<=espaciosVaciosPrincipal.size()){
            return true;
        }else{
            return false;
        }
    }
}
