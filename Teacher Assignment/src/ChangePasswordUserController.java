import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;

/**
 * Created by mimtiaze on 15-Sep-16.
 */
public class ChangePasswordUserController {

    public PasswordField newPasswordField;
    public PasswordField typeAgainPasswordField;
    public Label warningLabel;

    public void initialize(){
        warningLabel.setVisible(false);
    }


    public void actionForCancelButton(ActionEvent event) {
        Stage newStage=(Stage) newPasswordField.getScene().getWindow();
        newStage.close();
    }

    public void actionForNewPasswordField(){
        typeAgainPasswordField.requestFocus();
    }

    public void actionForTypeAgainField(){
        actionForDoneButton();
    }


    public void actionForDoneButton() {
        String newPasswordText=newPasswordField.getText();
        String typeAgainText=typeAgainPasswordField.getText();

        if(newPasswordText.equals("") || newPasswordText==null || typeAgainText.equals("") || typeAgainText==null){
            warningLabel.setText("Password field should not be empty!");
            warningLabel.setVisible(true);
        }else if(!newPasswordText.equals(typeAgainText)){
            warningLabel.setText("Password not matched!");
            warningLabel.setVisible(true);
        }else{

            if(logInController.userFacultyInfo!=null){
                logInController.userFacultyInfo.password=newPasswordText;

                Stage current=(Stage) newPasswordField.getScene().getWindow();
                current.close();


                try{
                    Parent newParent= FXMLLoader.load(getClass().getClassLoader().getResource("operationSuccessful.fxml"));
                    Scene newScene=new Scene(newParent,300,100);

                    Stage newStage=new Stage();

                    newStage.setScene(newScene);
                    newStage.setTitle("Message");
                    newStage.setResizable(false);
                    newStage.centerOnScreen();
                    newStage.show();

                }catch (Exception e){
                    e.printStackTrace();
                }
            }

        }

    }
}
