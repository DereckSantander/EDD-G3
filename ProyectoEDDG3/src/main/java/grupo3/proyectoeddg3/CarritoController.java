/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo3.proyectoeddg3;

import static grupo3.proyectoeddg3.PrimaryController.juegoMostrado;
import static grupo3.proyectoeddg3.PrimaryController.listaCategorias;
import grupo3.proyectoeddg3.list.DoubleCircularLL;
import grupo3.proyectoeddg3.modelo.Juego;
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
 * @author Dereck Santander
 */
public class CarritoController {

    @FXML
    private Button btnVolver;
    @FXML
    private Button btnCarrArriba;
    @FXML
    private Button btnCarrAbajo;
    @FXML
    private ImageView imvJuego1;
    @FXML
    private Label lblnombreJuego1;
    @FXML
    private Label lblprecioJuego1;
    @FXML
    private ImageView imvJuego2;
    @FXML
    private Label lblnombreJuego2;
    @FXML
    private Label lblprecioJuego2;
    @FXML
    private ImageView imvJuego3;
    @FXML
    private Label lblprecioJuego3;
    @FXML
    private Label lblSubtotal;
    @FXML
    private Label lblIVA;
    @FXML
    private Label lblTotal;
    @FXML
    private Button btnComprar;

    public void initialize() {
    
    }    

    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void comprar(ActionEvent event) {
        PrimaryController.misJuegos.addAll(PrimaryController.carrito);
        PrimaryController.misJuegos=new DoubleCircularLL();
    }
    
}
