package grupo3.proyectoeddg3;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class JuegoController {
    
    @FXML
    private Button btnComprar;

    @FXML
    private Button btnValoracionAbajo;

    @FXML
    private Button btnValoracionArriba;

    @FXML
    private Button btnVolver;

    @FXML
    private ComboBox<?> cmbOrdenFeedback;

    @FXML
    private ImageView imvJuego;

    @FXML
    private ImageView imvJuego1;

    @FXML
    private ImageView imvJuego2;

    @FXML
    private Label lblDesarrolladores;

    @FXML
    private Label lblDescripcionJuego;

    @FXML
    private Label lblFechaLanz;

    @FXML
    private Label lblGeneroJuego;

    @FXML
    private Label lblPrecioJuego;

    @FXML
    private Label lblTexto1;

    @FXML
    private Label lblTexto2;

    @FXML
    private Label lblTexto3;

    @FXML
    private Label lblTituloJuego;

    @FXML
    private Label lblUsuario1;

    @FXML
    private Label lblUsuario2;

    @FXML
    private Label lblUsuario3;

    @FXML
    private Label lblValoracion1;

    @FXML
    private Label lblValoracion2;

    @FXML
    private Label lblValoracion3;

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
    
    public void initialize(){
        
        App.setImage(PrimaryController.j.getTitulo(),App.pathImagesJuegos,imvJuego);
        lblTituloJuego.setText(PrimaryController.j.getTitulo());
        lblDesarrolladores.setText(PrimaryController.j.getDesarrolladores());
        lblFechaLanz.setText(PrimaryController.j.getFechaLanzamiento());
        lblDescripcionJuego.setText(PrimaryController.j.getDescripcion());
        lblPrecioJuego.setText('$'+String.valueOf(PrimaryController.j.getPrecio()));
        lblGeneroJuego.setText("Género: "+PrimaryController.j.getGenero());
        
    }    

    @FXML
    private void comprar(ActionEvent event) {
        PrimaryController.carrito.addLast(PrimaryController.j);
    }
    
}