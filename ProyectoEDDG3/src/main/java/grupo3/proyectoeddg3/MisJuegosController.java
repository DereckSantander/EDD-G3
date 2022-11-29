/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo3.proyectoeddg3;

import static grupo3.proyectoeddg3.PrimaryController.juegoLabel;
import static grupo3.proyectoeddg3.PrimaryController.juegoMostrado;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * FXML Controller class
 *
 * @author Dereck Santander
 */
public class MisJuegosController{

    @FXML private Button btnVolver;
    @FXML private FlowPane juegosPane;
    @FXML
    private Button btnmjDer;

    @FXML
    private Button btnmjIzq;
    
    
    public static int miJuegoMostrado = 0;
    
    public void initialize() {
        PrimaryController.desdeMisJuegos = true;
        llenarJuegos();
        
        if(PrimaryController.misJuegos.largo()<=14){
            btnmjDer.setDisable(true);
            btnmjIzq.setDisable(true);
        }
    }  

    
    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    @FXML
    void miJuegoDer(ActionEvent event) {
        miJuegoMostrado+=14;
        try {
            App.setRoot("misjuegos");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void miJuegoIzq(ActionEvent event) {
        miJuegoMostrado-=14;
        try {
            App.setRoot("misjuegos");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
      
    void llenarJuegos(){
        
        for(Juego j:Juego.misJuegosCargados(miJuegoMostrado)){
               VBox vbox=new VBox();
               vbox.setAlignment(Pos.CENTER);
               ImageView ivJuego=new ImageView();
               App.setImage(j.getTitulo(),App.pathImagesJuegos,ivJuego,137,192,".jpg");
               Label lbl=new Label(j.getTitulo());
               lbl.setMaxWidth(137);
               lbl.setAlignment(Pos.CENTER);
               
               
               vbox.setMargin(ivJuego,new Insets(0,10,0,10));
               vbox.setMargin(lbl,new Insets(5,10,0,10));
               
               vbox.getChildren().addAll(ivJuego,lbl);
               juegosPane.getChildren().add(vbox);
               juegosPane.setMargin(vbox,new Insets(0,0,10,0));
               
               ivJuego.setOnMouseClicked(ev ->juegoLabel(lbl));
               lbl.setOnMouseClicked(ev ->juegoLabel(lbl));
           }
    }
    
    
}
