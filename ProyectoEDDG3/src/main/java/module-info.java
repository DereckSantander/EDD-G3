module grupo3.proyectoeddg3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens grupo3.proyectoeddg3 to javafx.fxml;
    exports grupo3.proyectoeddg3;
}
