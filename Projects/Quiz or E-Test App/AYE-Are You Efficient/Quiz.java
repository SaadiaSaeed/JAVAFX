
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Quiz extends Application {
    static Stage Stage;
    @Override
    public void start(Stage primaryStage) throws Exception{
        Stage = primaryStage;
        Stage.setTitle("AYE-Are You Efficient");
        Stage.getIcons().add(new Image(getClass().getResourceAsStream("aye.png")));
        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainWindow.fxml"));
        Parent root = loader.load();
 
        Scene scene = new Scene(root,1050,600);
        Stage.setScene(scene); 
        Stage.show();
        Stage.setResizable(true);
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
