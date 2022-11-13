/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3.proyectoeddg3.modelo;
import grupo3.proyectoeddg3.list.DoubleCircularLL;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
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
    private DoubleCircularLL<Feedback> listaFeedback;
    

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
        InputStream input = Juego.class.getClassLoader().getResourceAsStream(ruta);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(input)))
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
    
    public static void cargarFeedback(String ruta){
        InputStream input = Feedback.class.getClassLoader().getResourceAsStream(ruta);
        try(BufferedReader br = new BufferedReader(new InputStreamReader(input)))
         {
            String line;
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(";");
                if(datos[4].equals(this.titulo)){
                   Feedback j = new Feedback(Integer.parseInt(datos[0]), datos[1], datos[2], datos[3], datos[4]);
                   this.listaFeedback.addLast(j);
                }
                
            }

        } catch (IOException e) {
            e.printStackTrace();
        } 
    }
        
}
