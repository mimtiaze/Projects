import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * Created by mimtiaze on 30-Jul-16.
 */
public class CreateFacultyController {
    public TextField fullNameField;
    public TextField shortNameField;
    public TextField priorityField;
    public TextField maxClassBreakTextField;
    public TextField classTakenInDaysTextField;
    public PasswordField passwordField;
    public CheckBox isAdminCheckBox;
    public Button cancelButton;
    public Button addButton;


    public void actionForAddButton(ActionEvent event) {
        String shortName=shortNameField.getText();
        String fullName=fullNameField.getText();
        String password=passwordField.getText();
        boolean isAdmin=isAdminCheckBox.isSelected();

        String priorityString=priorityField.getText();
        int priority;
        if(priorityString==null || priorityString.equals(""))
            priority=5;
        else
            priority=Integer.parseInt(priorityString);

        int maxBreakInt;
        int classTakenInDaysInt;
        String maxBreak=maxClassBreakTextField.getText();
        if(maxBreak==null || maxBreak.equals(""))
            maxBreakInt=5;
        else{
            maxBreakInt=Integer.parseInt(maxBreak);
        }

        String classTakenInDays=classTakenInDaysTextField.getText();
        if(classTakenInDays==null || classTakenInDays.equals(""))
            classTakenInDaysInt=4;
        else{
            classTakenInDaysInt=Integer.parseInt(classTakenInDays);
        }

        if(shortName==null || shortName.equals("")){
            try{
                Parent newParent= FXMLLoader.load(getClass().getClassLoader().getResource("notSufficientInfo.fxml"));
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
        else{
            AddRemoveSearchFaculty.addFaculty(fullName,shortName,password,isAdmin,priority,maxBreakInt,classTakenInDaysInt);
            fullNameField.setText("");
            shortNameField.setText("");
            passwordField.setText("");
            priorityField.setText("");
            isAdminCheckBox.setSelected(false);


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

    public void actionForCancelButton(ActionEvent event) {
        Stage tempStage=(Stage) cancelButton.getScene().getWindow();
        tempStage.close();
    }

    public void actionForFullNameField(ActionEvent event) {
        shortNameField.requestFocus();
    }

    public void actionForPasswordFiled(ActionEvent event) {
        priorityField.requestFocus();
    }

    public void actionForShortNameField(ActionEvent event) {
        passwordField.requestFocus();
    }

    public void actionForPriorityField(){
        addButton.requestFocus();
    }

}
