/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author camilortte
 */
public class Proceso {
    private String nombre;
    private String id;
    private String estado;

    public Proceso(String nombre,String id, String estado){
        this.nombre=nombre;
        this.estado=estado;
        this.id=id;
    }
    
    public Proceso(){
        this.nombre="";
        this.estado="";
        this.id="";
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
