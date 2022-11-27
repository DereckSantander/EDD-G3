/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo3.proyectoeddg3;

import static grupo3.proyectoeddg3.PrimaryController.juegoLabel;
import grupo3.proyectoeddg3.list.DoubleCircularLL;
import grupo3.proyectoeddg3.modelo.Juego;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
/**
 * FXML Controller class
 *
 * @author user
 */
public class SearchController{


    @FXML private Button btn_buscar;
    @FXML private Button btnVolver;
    @FXML private Label lblResultado;
    @FXML private FlowPane resultadosPane;    
    public void initialize() {
        
        if(PrimaryController.busquedaC){
            lblResultado.setText(PrimaryController.categoríaSeleccionada);
        }else{
            lblResultado.setText(PrimaryController.busqueda);
            }
        
        llenarResultados();
    }    

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    void llenarResultados(){
        
        for(Juego j:PrimaryController.juegosEncontrados){
               VBox vbox=new VBox();
               ImageView ivJuego=new ImageView();
               App.setImage(j.getTitulo(),App.pathImagesJuegos,ivJuego,137,192,".jpg");
               Label lbl=new Label(j.getTitulo());
               vbox.setAlignment(Pos.CENTER);
               
               vbox.setMargin(ivJuego,new Insets(0,10,0,10));
               vbox.setMargin(lbl,new Insets(5,10,0,10));
               
               vbox.getChildren().addAll(ivJuego,lbl);
               resultadosPane.getChildren().add(vbox);
               resultadosPane.setMargin(vbox,new Insets(0,0,10,0));
               
               lbl.setOnMouseClicked(ev ->juegoLabel(lbl));
           }
    }
    
}
