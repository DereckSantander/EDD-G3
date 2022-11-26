/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo3.proyectoeddg3;

import static grupo3.proyectoeddg3.PrimaryController.juegoMostrado;
import grupo3.proyectoeddg3.list.DoubleCircularLL;
import grupo3.proyectoeddg3.modelo.Juego;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

/**
 * FXML Controller class
 *
 * @author Dereck Santander
 */
public class MisJuegosController{

    @FXML private Button btnCarrDer;
    @FXML private Button btnCarrIzq;
    @FXML private Button btnVolver;
    @FXML private HBox hbCarrusel;
    @FXML private ImageView imvC1;
    @FXML private ImageView imvC2;
    @FXML private ImageView imvC3;
    @FXML private ImageView imvC4;
    @FXML private Label lblC1;
    @FXML private Label lblC2;
    @FXML private Label lblC3;
    @FXML private Label lblC4;
    
    public void initialize() {
        llenarCarr(juegoMostrado);
    }  

    @FXML
    void CarrDer() {
        llenarCarr(juegoMostrado);
        PrimaryController.juegoMostrado+=4;
        try {
            App.setRoot("misjuegos");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    @FXML
    void CarrIzq() {
        llenarCarr(juegoMostrado);
        PrimaryController.juegoMostrado-=4;
        try {
            App.setRoot("primary");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    
    void llenarCarr(int indice){
        DoubleCircularLL<Juego> juegosMostrados = Juego.juegosCargados(indice);
        App.setImage(juegosMostrados.getIndex(0).getTitulo(),App.pathImagesJuegos,imvC1);
        App.setImage(juegosMostrados.getIndex(1).getTitulo(),App.pathImagesJuegos,imvC2);
        App.setImage(juegosMostrados.getIndex(2).getTitulo(),App.pathImagesJuegos,imvC3);
        App.setImage(juegosMostrados.getIndex(3).getTitulo(),App.pathImagesJuegos,imvC4);
        
        lblC1.setText(juegosMostrados.getIndex(0).getTitulo());
        lblC2.setText(juegosMostrados.getIndex(1).getTitulo());
        lblC3.setText(juegosMostrados.getIndex(2).getTitulo());
        lblC4.setText(juegosMostrados.getIndex(3).getTitulo());
        
        lblC1.setOnMouseClicked(ev ->PrimaryController.juegoLabel(lblC1));
        lblC2.setOnMouseClicked(ev ->PrimaryController.juegoLabel(lblC2));
        lblC3.setOnMouseClicked(ev ->PrimaryController.juegoLabel(lblC3));
        lblC4.setOnMouseClicked(ev ->PrimaryController.juegoLabel(lblC4));
    }
    

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
      
    
}
