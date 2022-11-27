
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
    
    public static DoubleCircularLL<Juego> juegosEncontrados;

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
    
    public static DoubleCircularLL<Juego> juegosEncontrados(String busqueda, String año){
        
        juegosEncontrados=null;
        
        if(busqueda.length()!=0 && año.length()!=0){
            System.out.println("busco por ambos");
            PrimaryController.busqueda="Resultados de: '"+ busqueda +"' del año "+año;
        } else if(busqueda.length()!=0 && año.length()==0){
            System.out.println("busco por titulo");
            PrimaryController.busqueda="Resultados de: '"+ busqueda +"'";
        } else if(busqueda.length()==0 && año.length()!=0){
            System.out.println("busco por año");
            PrimaryController.busqueda="Resultados de juegos del año: "+año;
        } 
        
        return juegosEncontrados;
        
    }
    
    public static DoubleCircularLL<Juego> juegosGenero(String genero){
        
        juegosEncontrados=null;
        
        System.out.println("busco por genero");
        
        return juegosEncontrados;
        
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
        
}
