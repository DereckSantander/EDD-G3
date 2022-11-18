package grupo3.proyectoeddg3;


import java.io.IOException;
import javafx.event.ActionEvent;
import grupo3.proyectoeddg3.list.DoubleCircularLL;
import grupo3.proyectoeddg3.modelo.Juego;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class PrimaryController {
    
    @FXML private Button btnCarrDer;
    @FXML private Button btnCarrIzq;
    @FXML private Button btnCarrito;
    @FXML private Button btnGenDown;
    @FXML private Button btnGenUp;
    @FXML private Button btnTusJuegos;
    @FXML private HBox hbCarrusel;
    @FXML private HBox hbGeneros;
    @FXML private ImageView imv1;
    @FXML private ImageView imv2;
    @FXML private ImageView imv3;
    @FXML private ImageView imv4;
    @FXML private ImageView imvC1;
    @FXML private ImageView imvC2;
    @FXML private ImageView imvC3;
    @FXML private ImageView imvC4;
    @FXML private Label lbl1;
    @FXML private Label lbl2;
    @FXML private Label lbl3;
    @FXML private Label lbl4;
    @FXML private TextField txtTitulo;
    @FXML private TextField txtAño;
    @FXML private Label lblC1;
    @FXML private Label lblC2;
    @FXML private Label lblC3;
    @FXML private Label lblC4;
    @FXML private Button btnBuscar;
    
    public static Juego j;
    public static DoubleCircularLL<Juego> listaJuegos = Juego.cargarJuegos("archivos/juegos.txt");
    public static boolean busquedaC;
    public static String categoríaSeleccionada;
    public static String busqueda;
    
    public void initialize(){
        //JUEGOS DESTACADOS
        
        App.setImage(listaJuegos.getIndex(0).getTitulo(),App.pathImagesJuegos,imvC1);
        App.setImage(listaJuegos.getIndex(1).getTitulo(),App.pathImagesJuegos,imvC2);
        App.setImage(listaJuegos.getIndex(2).getTitulo(),App.pathImagesJuegos,imvC3);
        App.setImage(listaJuegos.getIndex(3).getTitulo(),App.pathImagesJuegos,imvC4);
        
        lblC1.setText(listaJuegos.getIndex(0).getTitulo());
        lblC2.setText(listaJuegos.getIndex(1).getTitulo());
        lblC3.setText(listaJuegos.getIndex(2).getTitulo());
        lblC4.setText(listaJuegos.getIndex(3).getTitulo());
        
        lblC1.setOnMouseClicked(ev ->juegoLabel(lblC1));
        lblC2.setOnMouseClicked(ev ->juegoLabel(lblC2));
        lblC3.setOnMouseClicked(ev ->juegoLabel(lblC3));
        lblC4.setOnMouseClicked(ev ->juegoLabel(lblC4));
        
      
        
        
        //JUEGOS CATEGORIAS
        DoubleCircularLL<Juego> listaCategorias = Juego.cargarJuegos("archivos/categorias.txt");
        App.setImage(listaCategorias.getIndex(0).getTitulo(),App.pathImagesJuegos,imv1);
        App.setImage(listaCategorias.getIndex(1).getTitulo(),App.pathImagesJuegos,imv2);
        App.setImage(listaCategorias.getIndex(2).getTitulo(),App.pathImagesJuegos,imv3);
        App.setImage(listaCategorias.getIndex(3).getTitulo(),App.pathImagesJuegos,imv4);
        
        
        lbl1.setText(listaCategorias.getIndex(0).getGenero());
        lbl2.setText(listaCategorias.getIndex(1).getGenero());
        lbl3.setText(listaCategorias.getIndex(2).getGenero());
        lbl4.setText(listaCategorias.getIndex(3).getGenero());
        
        lbl1.setOnMouseClicked(ev ->categoriaLabel(lbl1));
        lbl2.setOnMouseClicked(ev ->categoriaLabel(lbl2));
        lbl3.setOnMouseClicked(ev ->categoriaLabel(lbl3));
        lbl4.setOnMouseClicked(ev ->categoriaLabel(lbl4));
        
    }
    
    @FXML
    void CarrDer() {
        
    }
    
    @FXML
    private void irAlCarrito(){
        try {
                App.setRoot("carrito");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
    }

    @FXML
    private void buscar(ActionEvent event) {
            busquedaC=false;
            if(txtAño.getText().length()==0 && txtTitulo.getText().length()==0){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error al intentar la búsqueda");
                alert.setHeaderText(null);
                alert.setContentText("Ingrese algún parámetro");
                alert.showAndWait();
            } else {
                System.out.println("Buscando");
                Juego.juegosEncontrados(txtTitulo.getText(),txtAño.getText());
                try {
                App.setRoot("search");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
            
    }
    
    public void juegoLabel(Label label){
            busquedaC=false;
        
            j= Juego.buscarPorTitulo(label.getText());
            try {
                App.setRoot("juego");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        
    }
    
    public void categoriaLabel(Label label){
        busquedaC=true;
        categoríaSeleccionada=label.getText();
        Juego.juegosGenero(label.getText());
            try {
                App.setRoot("search");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
    }
       
}
