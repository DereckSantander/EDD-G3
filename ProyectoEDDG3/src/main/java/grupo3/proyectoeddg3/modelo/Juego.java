
package grupo3.proyectoeddg3.modelo;
import grupo3.proyectoeddg3.list.DoubleCircularLL;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import grupo3.proyectoeddg3.PrimaryController;
/**
 *
 * @author mbravop
 */

public class Juego {
    private String titulo;
    private String genero;
    private String desarrolladores;
    private String fechaLanzamiento;
    private String descripcion;
    private float precio;
    

    public String getTitulo() {
        return titulo;
    }

    public String getGenero() {
        return genero;
    }

    public String getDesarrolladores() {
        return desarrolladores;
    }

    public String getFechaLanzamiento() {
        return fechaLanzamiento;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public float getPrecio() {
        return precio;
    }

    public Juego(String titulo, String genero, String desarrolladores, String fechaLanzamiento, String descripcion, float precio) {
        this.titulo = titulo;
        this.genero = genero;
        this.desarrolladores = desarrolladores;
        this.fechaLanzamiento = fechaLanzamiento;
        this.descripcion = descripcion;
        this.precio = precio;
    }
    
    public static DoubleCircularLL<Juego> cargarJuegos(String ruta){
        DoubleCircularLL<Juego> listaJuegos = new DoubleCircularLL<>();
        try(BufferedReader br=new BufferedReader(new FileReader(ruta)))
         {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                Juego j = new Juego(datos[0], datos[1], datos[2], datos[3], datos[4], Float.parseFloat(datos[5]));
                listaJuegos.addLast(j);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
        return listaJuegos;
    }
    
    public static Juego buscarPorTitulo(String titulo){
        
        Juego j=null;
        System.out.println(PrimaryController.listaJuegos.largo());
        for(Juego a: PrimaryController.listaJuegos){
            if(a.getTitulo().equals(titulo)){
                j=a;
            }
        }
        
        return j;
        
    }
    
    public static void juegosEncontrados(String busqueda, String año){
        
        PrimaryController.juegosEncontrados=new DoubleCircularLL();
        
        if(busqueda.length()!=0 && año.length()!=0){
            //System.out.println("busco por ambos");
            for(Juego j: PrimaryController.listaJuegos){
                if(j.getTitulo().contains(busqueda) && j.getFechaLanzamiento().equals(año)){
                    PrimaryController.juegosEncontrados.addLast(j);
                }
            }
            PrimaryController.busqueda="Resultados de: '"+ busqueda +"' del año "+año;
        } else if(busqueda.length()!=0 && año.length()==0){
            //System.out.println("busco por titulo");
            for(Juego j: PrimaryController.listaJuegos){
                if(j.getTitulo().contains(busqueda)){
                    PrimaryController.juegosEncontrados.addLast(j);
                }
            }
            PrimaryController.busqueda="Resultados de: '"+ busqueda +"'";
        } else if(busqueda.length()==0 && año.length()!=0){
            //System.out.println("busco por año");
            for(Juego j: PrimaryController.listaJuegos){
                if(j.getFechaLanzamiento().equals(año)){
                    PrimaryController.juegosEncontrados.addLast(j);
                }
            PrimaryController.busqueda="Resultados de juegos del año: "+año;
        } 
        
    }}
    
    public static void juegosGenero(String genero){
        
        PrimaryController.juegosEncontrados=new DoubleCircularLL();

        
        //System.out.println("busco por genero");
        
        for(Juego j: PrimaryController.listaJuegos){
                if(j.getGenero().equals(genero)){
                    PrimaryController.juegosEncontrados.addLast(j);
                }
            }
   
    }
    
    public static DoubleCircularLL<Juego> juegosCargados(int indice){
        DoubleCircularLL<Juego> listaCargada = new DoubleCircularLL<>();
        int tope = indice+3;
        for(int i = indice;i<=tope;i++){
            Juego juego = PrimaryController.listaJuegos.getIndex(i);
            listaCargada.addLast(juego);
        }
        return listaCargada;
    }
    
    public static DoubleCircularLL<Juego> categoriasCargadas(int indice){
        DoubleCircularLL<Juego> listaCargada = new DoubleCircularLL<>();
        int tope = indice+3;
        for(int i = indice;i<=tope;i++){
            Juego juego = PrimaryController.listaCategorias.getIndex(i);
            listaCargada.addLast(juego);
        }
        return listaCargada;
    }
    
    public static DoubleCircularLL<Juego> carritoCargado(int indice){
        DoubleCircularLL<Juego> listaCargada = new DoubleCircularLL<>();
        int tope = indice+=2;
        for(int i = indice;i<=tope;i++){
            Juego juego = PrimaryController.carrito.getIndex(i);
            listaCargada.addLast(juego);
        }
        return listaCargada;
    }

    @Override
    public String toString() {
        return titulo + ";" + genero + ";" + desarrolladores + ";" + fechaLanzamiento + ";" + descripcion + ";" + precio;
    }
    
    
    
}
