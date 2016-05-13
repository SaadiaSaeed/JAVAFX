
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Alqama
 */
public class MathQuestions extends DataBase implements QuestionInterface{
       
 @FXML
    private Label totalquestions;
    @FXML
    private Label score;
    @FXML
    private Label remarks;
static Stage window;
private static int totalQuestions;
  private static int ID = 1;
    private int id =1;
     static long t1;
    static int wrong1 = 0;
    static int correct1=0;
    static String answer = null;
    @FXML
    Text questionText;
    @FXML
    Button option1;
    @FXML
    Button option2;
    @FXML
    Button option3;
    @FXML
    Button option4;
    static MathQuestions controller = null;
    static MathQuestions con = null;

      
   
@Override
  public void questions(Button btn){

//option1.setMouseTransparent(true);
 //loading FXML
 if(System.currentTimeMillis()-t1<300000){
     if(ID==1){
      window =(Stage) btn.getScene().getWindow();
Parent root = null;
      try {
          FXMLLoader loader = new FXMLLoader(getClass().getResource("MathQuestions.fxml"));
          root = loader.load();
          controller = (MathQuestions) loader.getController();
          con = (MathQuestions) loader.getController(); 
      } catch (IOException iOException) {
          System.out.println("FXML loading exception");
      }
    
    Scene scene = new Scene(root);
 
           // window.hide();
    window.setScene(scene); 
     
     }
     
     
    Connection connection = super.dataBase();
     Statement statement = null;
 Statement statement1=null;
  

 if(connection !=null){

          try{
              statement=connection.createStatement();
              statement1=connection.createStatement();
        ResultSet rs = statement.executeQuery("SELECT *FROM MATH WHERE ID="+id);
        ResultSet rs1 = statement1.executeQuery("SELECT MAX(ID) FROM MATH");
        if(rs1.next()){
        totalQuestions = rs1.getInt(1);
        }
          if(rs.next()){
           String q = rs.getString(1);
           String op1 =rs.getString(2);
           String op2 =rs.getString(3);
           String op3 =rs.getString(4);
           String op4 =rs.getString(5);
           answer =rs.getString(6);
               controller.questionText.setText(q);
                   controller.option1.setText(op1);
                   controller.option2.setText(op2);
                   controller.option3.setText(op3);
                   controller.option4.setText(op4);
             
          }
          else{

         result();
          }

      }
      catch(SQLException e){
          System.out.println("Something went wrong during retreiving");
      }
 }
 else{
 System.out.println("something is wrong");
 }
    window.show();
 window.setMaximized(true);
      window.setResizable(true);    
 }
 
    


}
  @Override
  public void button1()throws Exception{
       id = ++ID;
      if(System.currentTimeMillis()-t1>300000){
              MainWindowController conn = new MainWindowController();
              conn.alertBox("Time's up!");
              result();
      }
      else if(System.currentTimeMillis()-t1<300000){

      
      if(option1.getText().equals(answer)){
      ++correct1;
      }
      else{
          ++wrong1; 
      }
      
        
        questions(option1);}
       
  }
  
  
  @Override
    public void button2()throws Exception{
       id = ++ID;
      if(System.currentTimeMillis()-t1>300000){
              MainWindowController conn = new MainWindowController();
              conn.alertBox("Time's up!");
              result();
      }
      else if(System.currentTimeMillis()-t1<300000){

      
      if(option2.getText().equals(answer)){
      ++correct1;
      }
      else{
          ++wrong1; 
      }
      
        
        questions(option1);}
       
  }
    
    
        @Override
        public void button3()throws Exception{
       id = ++ID;
      if(System.currentTimeMillis()-t1>300000){
          System.out.println("Shukar Alhamdulillah");
              MainWindowController conn = new MainWindowController();
              conn.alertBox("Time's up!");
              result();
      }
      else if(System.currentTimeMillis()-t1<300000){

      
      if(option3.getText().equals(answer)){
      ++correct1;
      }
      else{
          ++wrong1; 
      }
      
        
        questions(option1);}
       
  }
        
        
        
        
        @Override
            public void button4()throws Exception{
       id = ++ID;
      if(System.currentTimeMillis()-t1>300000){
              MainWindowController conn = new MainWindowController();
             conn.alertBox("Time's up!");
            result();
      }
      else if(System.currentTimeMillis()-t1<300000){

      
      if(option4.getText().equals(answer)){
      ++correct1;
      }
      else{
          ++wrong1; 
      }
      
        
        questions(option1);}
       
  }
        
@Override
   public void result(){
                //Stage stage = (Stage)option1.getScene().getWindow();
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("MathResult.fxml"));
                  try {
                      Parent ro = null;
                      ro = loader.load();
                      Scene res = new Scene(ro);
                      window.setScene(res);
                  } catch (IOException ex) {
                      Logger.getLogger(MathQuestions.class.getName()).log(Level.SEVERE, null, ex);
                  }
                  controller = (MathQuestions) loader.getController();
                  controller.totalquestions.setText("Total Questions: "+totalQuestions);
                  controller.score.setText("Efficiency level: "+correct1);
                  if((correct1<=(totalQuestions)/4)){
                      controller.remarks.setText("Remarks: Fail!");
                  }
                  else if ((correct1<(totalQuestions)/2) && (correct1>(totalQuestions)/4)){
                  controller.remarks.setText("Remarks: Need Improvement!");
                  }
                  else if ((correct1<=(totalQuestions)/2) && (correct1>(totalQuestions)/3)){
                  controller.remarks.setText("Remarks: Average!");
                  }
                  else if ((correct1>=(totalQuestions)/2) && (correct1<(totalQuestions))){
                  controller.remarks.setText("Remarks: Good!");
                  }
                  else if (correct1>=(totalQuestions)){
                  controller.remarks.setText("Remarks: Excellent!");
                  }
                  
                  window.close();
                  window.setMaximized(true);
                  window.show();
            }

}
