/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo3.proyectoeddg3;

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
public class CarritoController{

    @FXML
    private Button btnCarrDer;

    @FXML
    private Button btnCarrIzq;

    @FXML
    private Button btnVolver;

    @FXML
    private HBox hbCarrusel;

    @FXML
    private ImageView imvC1;

    @FXML
    private ImageView imvC2;

    @FXML
    private ImageView imvC3;

    @FXML
    private ImageView imvC4;

    @FXML
    private Label lblC1;

    @FXML
    private Label lblC2;

    @FXML
    private Label lblC3;

    @FXML
    private Label lblC4;

    @FXML
    void CarrDer() {

    }

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
      
    
}
