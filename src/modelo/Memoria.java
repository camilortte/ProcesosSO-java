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
    
    /*Metodo que recibe un proceso que se va a bajar de la memoria principal*/
    public void bajarUnProceso(Proceso proceso){
        Integer tablaPaginas[][] = proceso.getTablaDePaginas();
        for(int i=0;i<tablaPaginas.length;i++){
            //memoriaPrincipal.remove(tablaPaginas[i][0]);
            memoriaPrincipal.set(tablaPaginas[i][0], null);
            System.out.println("memoria princiapl");
            System.out.println(memoriaPrincipal.get(i));
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
        
        if(espaciosVaciosPrincipal.size()>=numeroPaginas ){
            return true;
        }else if(cantidadDePaginas<=espaciosVaciosPrincipal.size()){
            return true;
        }else{
            return false;
        }
    }
    
    //busca si una pagina de un proceso esta o no en memoria principal
    public boolean estaEnPrincipal(Proceso proceso, int pagina){
        boolean esta=false;
        if(memoriaPrincipal.isEmpty()){
            esta=false;
        }else{
            String proc[]= new String[2]; //para extraer el nombre del proceso y la pagina
            for(int i=0;i<memoriaPrincipal.size();i++){
                proc=memoriaPrincipal.get(i).split(" ");
                //si nombre es igual al nombre del proceso buscado y la pagina es la pagina buscada
                if(proc[0].compareTo(proceso.getNombre())==0 && proc[1].compareTo(String.valueOf(pagina))==0){
                    esta=true;
                }
            }
        }
        return esta;
    }
    
    //retorna una pagina que este en memoria principal, si no esta retorna null
    public String getPaginaDePrincipal(Proceso proceso, int paginaReferenciada){
        String pagina = null;
        String paginaBuscada = proceso+" "+paginaReferenciada;
        for(int i=0;i<memoriaPrincipal.size();i++){
            if(memoriaPrincipal.get(i).compareTo(paginaBuscada)==0){
                pagina=memoriaPrincipal.get(i);
                break;
            }
        }
        return pagina;
    }
    
    //retorna una pagina que este en memoria virtual, si no esta retorna null
    public String getPaginaDeVirtual(Proceso proceso, int paginaReferenciada){
        String pagina = null;
        String paginaBuscada = proceso+" "+paginaReferenciada;
        for(int i=0;i<memoriaVirtual.size();i++){
            if(memoriaVirtual.get(i).compareTo(paginaBuscada)==0){
                pagina=memoriaVirtual.get(i);
                break;
            }
        }
        return pagina;
    }
    
    public int getIndiceDePaginaEnPrincipal(Proceso p, int pagina){
        int index=-1;
        String pag[] = new String[2];
        if(estaEnPrincipal(p, pagina)){//si la pagina esta en principal entonces busquea y returne el INDICE
            for(int i=0;i<memoriaPrincipal.size();i++){
                pag=memoriaPrincipal.get(i).split(" ");
                if(Integer.parseInt(pag[2]) == pagina){
                    index=i;
                    break;
                }
            }
        }        
        return index;
    }
    
    public int getIndiceDePaginaEnVirtual(Proceso p, int pagina){
        int index=-1;
        String pag[] = new String[2];
        if(estaEnPrincipal(p, pagina)){//si la pagina esta en principal entonces busquea y returne el INDICE
            for(int i=0;i<memoriaVirtual.size();i++){
                pag=memoriaVirtual.get(i).split(" ");
                if(Integer.parseInt(pag[2]) == pagina){
                    index=i;
                    break;
                }
            }
        }        
        return index;
    }
    
    /*
     * Politica: Una pagina se escribira en la memoria secundaria (virtual) solo cuando haya sido elegida para
     * reemplaarce.
     *  La pagina que se va a reeemplazar es la que provoco el fallo.
     *  
     * Explicacion del metodo: recibe el proceso y la pagina que esta llamando a otra pagina
     * se obtiene la pagina llamada, si no esta en principal se provoca un fallo, se baja la pagina
     * que lo provoco y se sube la pagina llamada.
     */
    public void reemplazoPorDemanda(Proceso proceso, int paginaAReemplazarce){
        int paginaAEjecutar = proceso.getFallosDePagina().getFalloSiguiente(paginaAReemplazarce);
        String intercambio="";
        //si la pagina a subir no esta en principal y el proceso tiene mas de una pagina entonces, esta en virtual
        if(paginaAEjecutar != -1 && !estaEnPrincipal(proceso, paginaAEjecutar)){
            intercambio = getPaginaDePrincipal(proceso, paginaAReemplazarce);
            int indice_1 = getIndiceDePaginaEnPrincipal(proceso,paginaAReemplazarce);
            int indice_2 = getIndiceDePaginaEnVirtual(proceso, paginaAEjecutar);
            memoriaPrincipal.set(indice_1,proceso.getNombre()+" "+paginaAEjecutar);
            memoriaVirtual.set(indice_2,proceso.getNombre()+" "+intercambio);
            
        }
    }
}
