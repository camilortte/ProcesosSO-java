/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author Jhon
 */
public class FalloPagina {
    int[] falloPaginas;
    int numeroFallos;
    
    //establece una secuencia de fallos de pagina secuencial, es decir la pag 1 llama a la pag 2 y la 2 a la 3.....
    public final void setSecuenciaFallos(){
        for (int i=0;i<this.falloPaginas.length-1;i++){
            this.falloPaginas[i]=i+1;
        }
    }
    
    //numero de fallos es igual al numero de paginas
    public FalloPagina(int numeroPosibleDeFallos){
        this.falloPaginas = new int[numeroPosibleDeFallos];
        this.numeroFallos = numeroPosibleDeFallos;
        this.setSecuenciaFallos();
    }
    
    //establece una secuncia de fallos de pagina
    public void setFalloPaginas(int[] falloPaginas) {
        this.falloPaginas = falloPaginas;
    }
    
    //obtener la secuencia de fallos de pagina
    public int[] getSecuenciaFallos(){
        return this.falloPaginas;
    }
   
    //obtiene la pagina que sigue a otra
    public int getFalloSiguiente(int paginaQueLlama){
        int paginaSiguiente = -1;
        int numeroDefallos = this.falloPaginas.length;
        
        for (int i=0;i<numeroDefallos;i++){
            if(this.falloPaginas[i]==paginaQueLlama && paginaQueLlama!=this.falloPaginas[numeroDefallos-1]){
                paginaSiguiente = falloPaginas[i]+1;
                break;
            }
        }
        return paginaSiguiente;
    }
}
