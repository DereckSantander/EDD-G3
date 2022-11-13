package grupo3.proyectoeddg3;

import java.io.IOException;
import javafx.event.ActionEvent;
import grupo3.proyectoeddg3.list.DoubleCircularLL;
import grupo3.proyectoeddg3.modelo.Juego;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class PrimaryController {
    
    @FXML
    private Button btnCarrDer;

    @FXML
    private Button btnCarrIzq;

    @FXML
    private Button btnCarrito;

    @FXML
    private Button btnGenDown;

    @FXML
    private Button btnGenUp;

    @FXML
    private Button btnTusJuegos;

    @FXML
    private HBox hbCarrusel;

    @FXML
    private HBox hbGeneros;

    @FXML
    private ImageView imv1;

    @FXML
    private ImageView imv2;

    @FXML
    private ImageView imv3;

    @FXML
    private ImageView imv4;

    @FXML
    private ImageView imvC1;

    @FXML
    private ImageView imvC2;

    @FXML
    private ImageView imvC3;

    @FXML
    private ImageView imvC4;

    @FXML
    private Label lbl1;

    @FXML
    private Label lbl2;

    @FXML
    private Label lbl3;

    @FXML
    private Label lbl4;

    @FXML
    private TextField txtFecha;

    @FXML
    private TextField txtTitulo;
    
    public void initialize(){
        //JUEGOS DESTACADOS
        DoubleCircularLL<Juego> listaJuegos = Juego.cargarJuegos("destacados.txt");
        imvC1.setImage(new Image(listaJuegos.getIndex(0).getTitulo()+".png"));
        imvC2.setImage(new Image(listaJuegos.getIndex(1).getTitulo()+".png"));
        imvC3.setImage(new Image(listaJuegos.getIndex(2).getTitulo()+".png"));
        imvC4.setImage(new Image(listaJuegos.getIndex(3).getTitulo()+".png"));
        
        //JUEGOS CATEGORIAS
        DoubleCircularLL<Juego> listaCategorias = Juego.cargarJuegos("categorias.txt");
        imv1.setImage(new Image(listaCategorias.getIndex(0).getTitulo()+".png"));
        lbl1.setText(listaCategorias.getIndex(0).getTitulo());
        imv2.setImage(new Image(listaCategorias.getIndex(1).getTitulo()+".png"));
        lbl2.setText(listaCategorias.getIndex(1).getTitulo());
        imv3.setImage(new Image(listaCategorias.getIndex(2).getTitulo()+".png"));
        lbl3.setText(listaCategorias.getIndex(2).getTitulo());
        imv4.setImage(new Image(listaCategorias.getIndex(3).getTitulo()+".png"));
        lbl4.setText(listaCategorias.getIndex(3).getTitulo());
    }
    
    @FXML
    void CarrDer() {
        
    }
    
}
