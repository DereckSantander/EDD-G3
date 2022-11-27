package grupo3.proyectoeddg3;

import grupo3.proyectoeddg3.list.DoubleCircularLL;
import grupo3.proyectoeddg3.modelo.Feedback;
import grupo3.proyectoeddg3.PrimaryController;
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
    
    public static int feedbackMostrado = 0;

    @FXML
    private void switchToPrimary() throws IOException {
        feedbackMostrado = 0;
        App.setRoot("primary");
    }
    
    
    public void initialize(){
        App.setImage(PrimaryController.j.getTitulo(),App.pathImagesJuegos,imvJuego,200,280);
        lblTituloJuego.setText(PrimaryController.j.getTitulo());
        lblDesarrolladores.setText("Desarrollado por: " + PrimaryController.j.getDesarrolladores());
        lblFechaLanz.setText("Año: "+PrimaryController.j.getFechaLanzamiento());
        lblGeneroJuego.setText("Género: "+PrimaryController.j.getGenero());
        lblDescripcionJuego.setText(PrimaryController.j.getDescripcion());
        
        if(PrimaryController.j.getPrecio() >0){
            lblPrecioJuego.setText('$'+String.valueOf(PrimaryController.j.getPrecio()));
        }else{
            lblPrecioJuego.setText("Gratis");
        }
        
        
        
        llenarFeedback(feedbackMostrado);
        
    }    

    @FXML
    private void comprar(ActionEvent event) {
        PrimaryController.carrito.addLast(PrimaryController.j);
    }
    
    @FXML
    void fbAbajo(ActionEvent event) {
        llenarFeedback(feedbackMostrado);
        feedbackMostrado+=3;
        try {
            App.setRoot("juego");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @FXML
    void fbArriba(ActionEvent event) {
        llenarFeedback(feedbackMostrado);
        feedbackMostrado-=3;
        try {
            App.setRoot("juego");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    public void llenarFeedback(int indice){
        DoubleCircularLL<Feedback> feedbackMostrados = feedbackCargado(indice);
        
        lblUsuario1.setText(feedbackMostrados.getIndex(0).getNombreUsuario());
        lblValoracion1.setText(String.valueOf(feedbackMostrados.getIndex(0).getValoracion()));
        lblTexto1.setText(feedbackMostrados.getIndex(0).getDescripcion());
        
        lblUsuario2.setText(feedbackMostrados.getIndex(1).getNombreUsuario());
        lblValoracion2.setText(String.valueOf(feedbackMostrados.getIndex(1).getValoracion()));
        lblTexto2.setText(feedbackMostrados.getIndex(1).getDescripcion());
        
        lblUsuario3.setText(feedbackMostrados.getIndex(2).getNombreUsuario());
        lblValoracion3.setText(String.valueOf(feedbackMostrados.getIndex(2).getValoracion()));
        lblTexto3.setText(feedbackMostrados.getIndex(2).getDescripcion());
    }
    
    public static DoubleCircularLL<Feedback> feedbackJuego(){
        DoubleCircularLL<Feedback> feedbackJuegoEscogido = new DoubleCircularLL<>();
        for(Feedback fb: PrimaryController.listaFeedback){
            if(fb.getTituloJuego().equals(PrimaryController.j.getTitulo())){
                feedbackJuegoEscogido.addLast(fb);
            }
        }
        
        return feedbackJuegoEscogido;
    }
    
    public static DoubleCircularLL<Feedback> feedbackCargado(int indice){
        DoubleCircularLL<Feedback> listaCargada = new DoubleCircularLL<>();
        int tope = indice+2;
        for(int i = indice;i<=tope;i++){
            Feedback fb = feedbackJuego().getIndex(i);
            listaCargada.addLast(fb);
        }
        return listaCargada;
    }
    
}