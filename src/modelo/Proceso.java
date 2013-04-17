
package modelo;

public class Proceso {
    
    private String nombre;
    private String id;
    private String estado;
    private int tamanio;
    private int tamanio_actual;
    private int tiempoListo;
    private int tiempoBloqueado;
    private int tiempoEjecucion;
    private Dispositivo requerimientos[];
    private boolean requiereDispositivo;
    
    public Proceso(String nombre,String id, String estado,int tamanio, Dispositivo requerimientos[]){
        this.nombre = nombre;
        this.estado = estado;
        this.id = id;
        this.tamanio = tamanio;
        this.tamanio_actual = tamanio;
        this.requerimientos = requerimientos;
        this.requiereDispositivo = false;
        this.tiempoListo = 0;
        this.tiempoEjecucion = 0;
        this.tiempoBloqueado = 0;
        for(int i=0;i<requerimientos.length;i++){
            if(requerimientos[i]!=null){
                requiereDispositivo=true;
                break;
            }
        }
    }

    public int getTiempoEjecucion() {
        return tiempoEjecucion;
    }

    public void setTiempoEjecucion(int tiempoEjecucion) {
        this.tiempoEjecucion = tiempoEjecucion;
    }
    
   
    public int getTiempoListo(){
        return this.tiempoListo;
    }
    
    public int getTiempoBloqueado(){
        return this.tiempoBloqueado;
    }
    
    public void setTiempoListo(int tiempoListo){
        this.tiempoListo=tiempoListo;
    }
    
    public void setTiempoBloqueado(int tiempoBloqueado){
        this.tiempoBloqueado=tiempoBloqueado;
    }
    
    
    public void addTiempoListo(){
        this.tiempoListo ++;
    }
    
    public void addTiempoBloqueado(){
        this.tiempoBloqueado ++;
    }
    
    public void addTiempoEjecucion(){
        this.tiempoEjecucion++;
    }
    
    public int getTamanio_actual() {
        return tamanio_actual;
    }

    public void setTamanio_actual(int tamanio_actual) {
        this.tamanio_actual = tamanio_actual;
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

    public Dispositivo[] getRequerimientos() {
        return requerimientos;
    }

    public void setRequerimientos(Dispositivo[] requerimientos) {
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
