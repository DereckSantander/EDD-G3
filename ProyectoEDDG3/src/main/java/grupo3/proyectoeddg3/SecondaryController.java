package grupo3.proyectoeddg3;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class SecondaryController {
    
    @FXML
    private Button btnVolver;
    @FXML
    private ImageView imvJuego;
    @FXML
    private Label lblTituloJuego;
    @FXML
    private Label lblDesarrolladores;
    @FXML
    private Label lblFechaLanz;
    @FXML
    private Label lblDescripcionJuego;
    @FXML
    private Label lblPrecioJuego;

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
        
    }    
    
}