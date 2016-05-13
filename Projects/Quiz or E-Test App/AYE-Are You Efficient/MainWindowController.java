
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;


public class MainWindowController extends DataBase{
    
     @FXML
    private Button logInbtn;
    @FXML
    private PasswordField password;
    @FXML
    private TextField username;
    @FXML
    private PasswordField createPass;
    @FXML
    private TextField fName;
    @FXML
    private TextField lName;
    @FXML
    private TextField email;
    @FXML
    private TextField uName;
    @FXML
    private RadioButton male;
    @FXML
    private Button closeAlert;
    
           public void signUp() throws Exception{
            String firstName= fName.getText();
            String lastName= lName.getText();
            String Email= email.getText();
            String userName= uName.getText();
            String password= createPass.getText();
            if(firstName.length()==0){
            alertBox("Please complete all the fields and then signup again.");
            }            
            else if(lastName.length()==0){
            alertBox("Please complete all the fields and then signup again.");
            }
            
            else if(Email.length()==0){
            alertBox("Please complete all the fields and then signup again.");
            }            
            else if(userName.length()==0){
            alertBox("Please complete all the fields and then signup again.");
            }            
            else if(password.length()==0){
            alertBox("Please complete all the fields and then signup again.");
            }
            
            
 String inserRecordQuery= "insert into USERS values('"+firstName+"','"+lastName+"','"+Email+"','"+userName+"','"+password+"')" ;
 Statement statement = null;
 Connection connection = super.dataBase();

 
 if (connection != null) {
 System.out.println("nSuccessfullly connected to Oracle DB");
 
 try {
 statement = connection.createStatement();
  final String queryCheck3 = "SELECT email from USERS WHERE username='"+userName+"'and email ='"+Email+"'";
  final String queryCheck1 = "SELECT USERNAME from USERS WHERE username = ?";
    final String queryCheck2 = "SELECT EMAIL from USERS WHERE email = ?";
final PreparedStatement ps1 = connection.prepareStatement(queryCheck1);
final PreparedStatement ps2 = connection.prepareStatement(queryCheck2);
ps1.setString(1, userName);
ps2.setString(1, Email);

ResultSet resultSet3 = statement.executeQuery(queryCheck3);
final ResultSet resultSet1 = ps1.executeQuery();
final ResultSet resultSet2 = ps2.executeQuery();

if(resultSet3.next()==true){
    alertBox("Username and email already exists!");
   
}

else if(resultSet1.next()== true){
    alertBox("Username already exists!");
}
else if(resultSet2.next()==true){
    alertBox("Email already exists!");
}
 
 
 
 
 System.out.println("Insert Record Query :"+inserRecordQuery);
 
 
 
 statement.executeUpdate(inserRecordQuery);
     alertBox("Registered successfully!, kindly login to continue.");
            fName.setText(null);
            lName.setText(null);
            email.setText(null);
            uName.setText(null);
            createPass.setText(null);
 //System.out.println("nRecord Inserted Successfully");
 } catch (SQLException e) {
 e.printStackTrace();
 }
 
 } else {
 System.out.println("nFailed to connect to Oracle DB");
 }
                       
        }
           
  public void logIn() throws Exception{
 String user= username.getText();
 String pass = password.getText();
 if(user.length()==0 && pass.length()==0){
     alertBox("Please enter username and password");
 }
 else if(user.length()==0){
     alertBox("Please enter the username");
     return;
 }
 else if (pass.length()==0){
     alertBox("Please enter the password");
     return;
 }
 
 Statement statement = null;
 Connection connection = super.dataBase();
 
 if (connection != null) {
 System.out.println("nSuccessfullly connected to Oracle DB");
 
 try {
 statement = connection.createStatement();
  final String queryCheck3 = "SELECT email from USERS WHERE username='"+user+"'and password ='"+pass+"'";
  final String queryCheck1 = "SELECT USERNAME from USERS WHERE username = ?";
    final String queryCheck2 = "SELECT PASSWORD from USERS WHERE password = ?";
final PreparedStatement ps1 = connection.prepareStatement(queryCheck1);
final PreparedStatement ps2 = connection.prepareStatement(queryCheck2);
ps1.setString(1, user);
ps2.setString(1, pass);

ResultSet resultSet3 = statement.executeQuery(queryCheck3);
final ResultSet resultSet1 = ps1.executeQuery();
final ResultSet resultSet2 = ps2.executeQuery();

if(resultSet3.next()==true){
    SubjectSelection sceneTwoObject = new SubjectSelection();
    sceneTwoObject.subjectSelection(logInbtn);
   
}

else if(resultSet1.next()== true && resultSet2.next()==false){
    alertBox("That password is incorrect!");
}
else if(resultSet2.next()==true && resultSet1.next()==false){
    alertBox("Invalid username!");
}
 
 } catch (SQLException e) {
 e.printStackTrace();
 }
 
 } else {
 System.out.println("nFailed to connect to Oracle DB");
 }
 
  }
 
   public void alertBox(String message) throws Exception{
     
         Stage window= new Stage();
    window.setTitle("Alert!");
    window.setResizable(false);
    window.initModality(Modality.APPLICATION_MODAL);
    window.setMinWidth(400);
    window.setMinHeight(150);
    window.setMaxHeight(250);
    window.setMaxWidth(800);
    Label label = new Label();
    label.setText(message);
    label.setStyle("-fx-text-fill: white; -fx-padding:5; -fx-font: 15pt \"Regular\";");
    Button close = new Button("Close");
    close.setOnAction(e -> window.close());
    VBox layout = new VBox(10);
    layout.getChildren().addAll(label,close);
    layout.setAlignment(Pos.CENTER);
   layout.setId("pane");
   layout.setStyle("-fx-padding: 10;");
   close.setStyle("-fx-background-color: greenyellow; -fx-text-fill: black;");
   
   layout.getStylesheets().addAll(this.getClass().getResource("mainwindow.css").toExternalForm());
    Scene scene= new Scene(layout);
    window.setScene(scene);
    window.showAndWait();
    
}
    
}
