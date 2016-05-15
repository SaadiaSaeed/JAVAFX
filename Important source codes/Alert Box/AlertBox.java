
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AlertBox extends Application {
    
    @Override
    public void start(Stage primaryStage) {
     
         Stage window= new Stage();
    window.setTitle("Alert!");
    window.setResizable(false);
    window.initModality(Modality.APPLICATION_MODAL);
    window.setMinWidth(400);
    window.setMinHeight(150);
    window.setMaxHeight(250);
    window.setMaxWidth(800);
    Label label = new Label();
    label.setText("Message to display!");
    Button close = new Button("Close");
    close.setOnAction(e -> window.close());
    VBox layout = new VBox(10);
    layout.getChildren().addAll(label,close);
    layout.setAlignment(Pos.CENTER);
      layout.setStyle("-fx-padding: 10;");
    Scene scene= new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
    

    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
