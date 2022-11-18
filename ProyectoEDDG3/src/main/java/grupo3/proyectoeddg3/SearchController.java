/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo3.proyectoeddg3;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
/**
 * FXML Controller class
 *
 * @author user
 */
public class SearchController{


    @FXML private Button btn_buscar;
    @FXML private ImageView img1;
    @FXML private Label title1;
    @FXML private ImageView img2;
    @FXML private Label title2;
    @FXML private ImageView img3;
    @FXML private Label title3;
    @FXML private ImageView img4;
    @FXML private Label title4;
    @FXML private ImageView img5;
    @FXML private Label title5;
    @FXML private Label title6;
    @FXML private ImageView img7;
    @FXML private Label title7;
    @FXML private ImageView img8;
    @FXML private Label title8;
    @FXML private ImageView img9;
    @FXML private Label title9;
    @FXML private ImageView img10;
    @FXML private Label title10;
    @FXML private Button btnVolver;
    @FXML private ImageView img6;
    @FXML private Label lblResultado;
    
    
    public void initialize() {
        
        if(PrimaryController.busquedaC){
            lblResultado.setText(PrimaryController.categoríaSeleccionada);
        }else{
            lblResultado.setText(PrimaryController.busqueda);
                    }
    }    

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
}
