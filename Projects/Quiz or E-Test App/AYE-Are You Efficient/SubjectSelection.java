
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class SubjectSelection extends Quiz{

    public void subjectSelection(Button logInbtn) throws Exception{
      Stage window =(Stage) logInbtn.getScene().getWindow();

    Parent root = FXMLLoader.load(getClass().getResource("SubjectSelection.fxml"));
    Scene scene = new Scene(root,1050,650);
    window.setScene(scene);
      window.setResizable(false);

    window.show();
}
        @FXML
    private Button englishButton;
    @FXML
    private Button mathsButton;
    @FXML
    private Button physicsButton;
    @FXML
    private Button chemistryButton;
    @FXML
    private Button gkButton;
    
    public void englishButtonHandler() throws Exception{
        EnglishQuestions obj = new EnglishQuestions();
        obj.t1 = System.currentTimeMillis();
        obj.questions(englishButton);
    }
    
        public void mathButtonHandler() throws Exception{
        MathQuestions obj = new MathQuestions();
        obj.t1 = System.currentTimeMillis();
        obj.questions(mathsButton);
    }
                public void physicsButtonHandler() throws Exception{
        PhysicsQuestions obj = new PhysicsQuestions();
        obj.t1 = System.currentTimeMillis();
        obj.questions(physicsButton);
    }
        public void chemistryButtonHandler() throws Exception{
        ChemistryQuestions obj = new ChemistryQuestions();
        obj.t1 = System.currentTimeMillis();
        obj.questions(chemistryButton);
    }
        public void gkButtonHandler() throws Exception{
        GeneralKnowledgeQuestions obj = new GeneralKnowledgeQuestions();
        obj.t1 = System.currentTimeMillis();
        obj.questions(gkButton);
    }
        
    
    
}
