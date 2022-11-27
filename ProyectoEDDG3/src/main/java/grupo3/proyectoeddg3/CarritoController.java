/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package grupo3.proyectoeddg3;

import static grupo3.proyectoeddg3.PrimaryController.juegoLabel;
import static grupo3.proyectoeddg3.PrimaryController.juegoMostrado;
import static grupo3.proyectoeddg3.PrimaryController.listaCategorias;
import grupo3.proyectoeddg3.list.DoubleCircularLL;
import grupo3.proyectoeddg3.modelo.Juego;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.TextFlow;

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
    private Label lblSubtotal;
    @FXML
    private Label lblIVA;
    @FXML
    private Label lblTotal;
    @FXML
    private Button btnComprar;
    
    public static int carritoMostrado=0;
    @FXML private TextFlow carritoPane;
    
    public void initialize() {
        PrimaryController.carrito.visualizar();
        llenarCarrito();
        //Juego.carritoCargado(carritoMostrado).visualizar();
    }    

    @FXML
    private void switchToPrimary(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

    @FXML
    private void comprar(ActionEvent event) {
        PrimaryController.misJuegos.addAll(PrimaryController.carrito);
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("archivos/misjuegos.txt",true))) {
            writer.write(PrimaryController.j.toString());
            writer.newLine();
            writer.close();
            System.out.println("GUARDADO EXITOSO");
            } catch (Exception e) {
                System.out.println("no se pudo agregar");
                e.printStackTrace();
            }
        
        try ( BufferedWriter writer = new BufferedWriter(new FileWriter("archivos/carrito.txt",false))) {
            writer.write("");
            } catch (Exception e) {
                e.printStackTrace();
            }
        
        PrimaryController.carrito=new DoubleCircularLL();
    }
    
    void llenarCarrito(){
        
        for(Juego j:Juego.carritoCargado(carritoMostrado)){
                HBox hbox=new HBox();
                hbox.setPrefHeight(233);
                hbox.setPrefWidth(850);
                hbox.setAlignment(Pos.CENTER);
                
                HBox hboxInfo=new HBox();
                hboxInfo.setPrefHeight(233);
                hboxInfo.setPrefWidth(750);
                hboxInfo.setSpacing(20);
                hboxInfo.setAlignment(Pos.CENTER_LEFT);
                
                ImageView ivJuego=new ImageView();
                App.setImage(j.getTitulo(),App.pathImagesJuegos,ivJuego,150,210,".jpg");
                Label lblTitulo=new Label(j.getTitulo());
                Label lblPrecio=new Label(String.valueOf(j.getPrecio()));
               
                
                hboxInfo.getChildren().addAll(ivJuego,lblTitulo);
                hbox.getChildren().addAll(hboxInfo,lblPrecio);
                
                carritoPane.getChildren().addAll(hbox);
                
                /*lblTitulo.setOnMouseClicked(ev ->{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmar eliminar juego");
                alert.setHeaderText(null);
                alert.setContentText("¿Estas seguro que deseas eliminar el juego del carrito?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    PrimaryController.carrito.remove(j);
                    
                    try ( BufferedWriter writer = new BufferedWriter(new FileWriter("archivos/carrito.txt",false))) {
                        for(Juego j1: PrimaryController.carrito){
                            writer.write(j1.toString());
                            writer.newLine();
                        }
                        System.out.println("GUARDADO EXITOSO");
                    } catch (Exception e) {
                        System.out.println("no se pudo agregar");
                        e.printStackTrace();
                    }
                */
           }
        
    }
    
}
