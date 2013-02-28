
package modelo;

import com.sun.org.apache.xalan.internal.xsltc.dom.BitArray;

/**
 *
 * @author camilortte
 */
public class Proceso {
    private String nombre;
    private String id;
    private String estado;
    private int tamanio;
    private boolean requerimientos[];
    private boolean requiereDispositivo;
    public Proceso(String nombre,String id, String estado,int tamanio, boolean requerimientos[]){
        this.nombre=nombre;
        this.estado=estado;
        this.id=id;
        this.tamanio=tamanio;
        this.requerimientos=requerimientos;
        this.requiereDispositivo=false;
        for(int i=0;i<requerimientos.length;i++){
            if(requerimientos[i]==true){
                requiereDispositivo=true;
                break;
            }
        }
    }
    
       
    public Proceso(){
        this.nombre="";
        this.estado="";
        this.id="";
    }

    public boolean isRequiereDispositivo() {
        return requiereDispositivo;
    }

    
    
    public int getTamanio() {
        return tamanio;
    }

    public void setTamanio(int tamanio) {
        this.tamanio = tamanio;
    }

    public boolean[] getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(boolean[] requerimientos) {
        this.requerimientos = requerimientos;
    }
    
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}
