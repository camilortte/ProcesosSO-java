/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Queue;
import java.util.TreeSet;
import sun.reflect.generics.tree.Tree;

/**
 *
 * @author camilortte
 */
public class ControlProceso {
    
    private TreeSet<String> tree_procesos;
    private Queue<Proceso> cola_listo;
    private Queue<Proceso> cola_terminado;
    private Queue<Proceso> cola_bloquedao;
    //offer(proceso);// inserta un elemento
    //poll();//Nos da la cabeza y la remueve
    //peek();//Nos da la cabeza sin remover
    
    public ControlProceso(){
        tree_procesos=new TreeSet<String>();        
    }
    
    public boolean addProceso(Proceso proceso){
       return tree_procesos.add(proceso.getId());
    }
    
}
