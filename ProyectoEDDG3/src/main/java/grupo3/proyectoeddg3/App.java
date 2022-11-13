package grupo3.proyectoeddg3;

import java.io.FileInputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.io.InputStream;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    public static String pathImagesJuegos = "archivos/ImagesJuegos/";

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("primary"), 1200, 800);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static void setImage(String name,String path,ImageView iView){
        InputStream input = null;
        Image image = null;
        try {
            input = new FileInputStream(path + name + ".jpg");
            image = new Image(input, 100, 100, false, false);
            iView.setImage(image);
        } catch (Exception ex) {
            System.out.println("No se pudo cargar imagen");
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (Exception ex) {
                    System.out.println("Error al cerrar el recurso");
                }
            }
        }
    }

}