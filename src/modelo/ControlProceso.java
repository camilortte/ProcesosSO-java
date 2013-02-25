/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Queue;
import java.util.TreeSet;
import javax.swing.text.Element;
import sun.reflect.generics.tree.Tree;

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
    //offer(proceso);// inserta un elemento
    //poll();//Nos da la cabeza y la remueve
    //peek();//Nos da la cabeza sin remover
    
    public ControlProceso(){     
        tree_nuevo=new TreeSet<String>();   
        tree_procesos=new TreeSet<Proceso>(new Comparator<Proceso>() {
                    public int compare(Proceso stud1, Proceso stud2) {
                        return stud1.getId().compareTo(stud2.getId());                        
                    }
                });  
    }
   
    public boolean addProceso(Proceso proceso) {
       /* Iterator it1 =tree_procesos.iterator();

        while(it1.hasNext()){
          Proceso o1 = (Proceso) it1.next();
          System.out.println(o1.getId());
        }
        System.out.println("---------");*/        
       return tree_procesos.add(proceso);       
    }
    
    public boolean addNuevo(String id){        
        return tree_nuevo.add(id);
    }
    
    
    
}
