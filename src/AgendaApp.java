import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AgendaApp extends Application {
    @Override
    public void start(Stage stage) {
        Button btnListar = new Button("📋 Listar Contactos");
        Button btnBuscar = new Button("🔎 Buscar Contacto");
        Button btnEliminar = new Button("🗑 Eliminar Contacto");
        Button btnModificar = new Button("✏ Modificar Contacto");
        Button btnCupos = new Button("ℹ Cupos disponibles");
        Button btnSalir = new Button("❌ Salir");

        VBox layout = new VBox(10, btnListar, btnBuscar, btnEliminar, btnModificar, btnCupos, btnSalir);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center; -fx-font-size: 14px;");

        Scene scene = new Scene(layout, 300, 400);
        stage.setTitle("Agenda Telefónica");
        stage.setScene(scene);
        stage.show();

        btnSalir.setOnAction(e -> stage.close());
    }

    public static void main(String[] args) {
        launch(args);
    }
}
