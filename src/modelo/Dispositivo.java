/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author camilortte
 */
public class Dispositivo {
    
    private String nombre;
    private boolean disponible;
    private String id;
    private String idProcesoContenedor;
            
    public Dispositivo(String nombre,String id){
        this.nombre=nombre;
        this.disponible=false;
        this.id=id;
        this.idProcesoContenedor=null;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public String getIdProcesoContenedor() {
        return idProcesoContenedor;
    }

    public void setIdProcesoContenedor(String idProcesoContenedor) {
        this.idProcesoContenedor = idProcesoContenedor;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    
    
    

    
      
}
