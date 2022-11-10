/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3.proyectoeddg3.modelo;

/**
 *
 * @author mbravop
 */

public class Juego {
    private String titulo;
    private String genero;
    private String desarrolladores;
    private int fechaLanzamiento;
    private String descripcion;
    private float precio;
    private float descuento;
    private int idJuego;
    // private DoublyLinkedList listaFeedback;
    

    public Juego(String titulo, String genero, String desarrolladores, int fechaLanzamiento, String descripcion, float precio, float descuento, int idJuego) {
        this.titulo = titulo;
        this.genero = genero;
        this.desarrolladores = desarrolladores;
        this.fechaLanzamiento = fechaLanzamiento;
        this.descripcion = descripcion;
        this.precio = precio - (precio*descuento/100);
        this.descuento = descuento;
        this.idJuego = idJuego;
    }
    /*
    public DoublyLinkedList<Juego> cargarJuegos(String ruta){
        DoublyLinkedList<Juego> listaJuegos = new DoublyLinkedList<>();
        InputStream input = Cliente.class.getClassLoader().getResourceAsStream(ruta);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(input)))
         {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                Juego j = new Juego(datos[0], datos[1], datos[2], datos[3], datos[4], Float.parseFloat(datos[5), Float.parseFloat(datos[6]), Integer.parseInt(datos[7]));
                listaJuegos.addLast(j);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
        return listaJuegos;
    }
    
    public void cargarFeedback(String ruta){
        InputStream input = Cliente.class.getClassLoader().getResourceAsStream(ruta);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(input)))
         {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                if(Integer.parseInt(datos[4]) == this.idJuego){
                   Feedback j = new Feedback(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], Integer.parseInt(datos[4]));
                   this.listaFeedback.addLast(j);
                }
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
    
    */
    
    
}
