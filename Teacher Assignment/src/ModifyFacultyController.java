import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by mimtiaze on 30-Jul-16.
 */
public class ModifyFacultyController {


    public TextField fullNameField;
    public TextField shortNameField;
    public TextField priorityField;
    public PasswordField passwordField;
    public CheckBox isAdminCheckBox;
    public Button doneButton;
    public Button removeButton;
    public ComboBox facultyShowComboBox;
    public TextField maxClassBreakTextField;
    public TextField classTakenInDaysTextField;
    public Button seePasswordButton;
    public TextField passwordShownField;
    public boolean isPasswordShownFieldActive;

    public void initialize(){
        addOptionForFacultyShowComboBox();
        isPasswordShownFieldActive=false;
        passwordShownField.setVisible(false);
        passwordField.setVisible(true);

        try{
            Image seePasswordImage=new Image("eye.png");
            seePasswordButton.setGraphic(new ImageView(seePasswordImage));
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void addOptionForFacultyShowComboBox(){
        facultyShowComboBox.getItems().clear();

        FacultyInfo temp = AddRemoveSearchFaculty.facultyHeadPointer;
        while(temp!=null){
            facultyShowComboBox.getItems().add(temp.facultyName);
            temp=temp.next;
        }

        new AutoCompleteComboBoxListener<>(facultyShowComboBox);
    }

    public void actionForFacultyShowComboBox(){
        String tempFacultyName=(String)facultyShowComboBox.getValue();
        FacultyInfo tempFacultyInfo=AddRemoveSearchFaculty.searchFaculty(tempFacultyName);
        if(tempFacultyInfo!=null){
            fullNameField.setText(tempFacultyInfo.facultyFullName);
            shortNameField.setText(tempFacultyInfo.facultyName);
            passwordField.setText(tempFacultyInfo.password);
            if(tempFacultyInfo.isAdmin)
                isAdminCheckBox.setSelected(true);
            else
                isAdminCheckBox.setSelected(false);
            String temp=Integer.toString(tempFacultyInfo.priority);
            priorityField.setText(temp);
            temp=Integer.toString(tempFacultyInfo.maxClassBreak);
            maxClassBreakTextField.setText(temp);
            temp=Integer.toString(tempFacultyInfo.classTakenInThisNumberOfDays);
            classTakenInDaysTextField.setText(temp);
        }
    }


    public void actionForDoneButton(ActionEvent event) {
        String tempFacultyName=shortNameField.getText();
        FacultyInfo tempFacultyInfo=AddRemoveSearchFaculty.searchFaculty(tempFacultyName);

        if(tempFacultyInfo!=null){
            tempFacultyInfo.facultyFullName=fullNameField.getText();
            tempFacultyInfo.facultyName=shortNameField.getText();
            //tempFacultyInfo.password=passwordField.getText();
            boolean tempAdminCheck=isAdminCheckBox.isSelected();
            tempFacultyInfo.isAdmin=tempAdminCheck;

            if(!isPasswordShownFieldActive){
                tempFacultyInfo.password=passwordField.getText();
            }else{
                tempFacultyInfo.password=passwordShownField.getText();
            }

            String priorityString=priorityField.getText();
            int priority=Integer.parseInt(priorityString);

            if(priorityString.equals("") || priorityString==null)
                priority=AddRemoveSearchFaculty.priorityLimit;

            tempFacultyInfo.priority=priority;


            String maxBreak=maxClassBreakTextField.getText();
            if(maxBreak==null || maxBreak.equals(""))
                tempFacultyInfo.maxClassBreak=5;
            else{
                tempFacultyInfo.maxClassBreak=Integer.parseInt(maxBreak);
            }

            String classTakenInDays=classTakenInDaysTextField.getText();
            if(classTakenInDays==null || classTakenInDays.equals(""))
                tempFacultyInfo.classTakenInThisNumberOfDays=4;
            else{
                tempFacultyInfo.classTakenInThisNumberOfDays=Integer.parseInt(classTakenInDays);
            }

            // There is a problem with that function, repair it !!!
            AddRemoveSearchFaculty.modifyFacultyPriority(tempFacultyInfo.facultyName,priority);


            /*Stage chooseCourseStage = (Stage) doneButton.getScene().getWindow();
            chooseCourseStage.close();*/


            try{
                Parent newRoot= FXMLLoader.load(getClass().getClassLoader().getResource("operationSuccessful.fxml"));
                Scene newScene=new Scene(newRoot,300,100);

                Stage newStage = new Stage();

                newStage.setScene(newScene);
                newStage.setTitle("Messege");
                newStage.setResizable(false);
                newStage.centerOnScreen();
                newStage.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            try{
                Parent newRoot= FXMLLoader.load(getClass().getClassLoader().getResource("notSufficientInfo.fxml"));
                Scene newScene=new Scene(newRoot,300,100);

                Stage newStage = new Stage();

                newStage.setScene(newScene);
                newStage.setTitle("Messege");
                newStage.setResizable(false);
                newStage.centerOnScreen();
                newStage.show();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }

    public void actionForFullNameField(ActionEvent event) {
        shortNameField.requestFocus();
    }

    public void actionForShortNameField(ActionEvent event) {
        passwordField.requestFocus();
    }

    public void actionForPasswordField(ActionEvent event) {
        priorityField.requestFocus();
    }

    public void actionForPriorityField(){
        doneButton.requestFocus();
    }

    public void actionForSeePasswordButton(){
        //passwordField
        if(!isPasswordShownFieldActive){
            isPasswordShownFieldActive=true;
            String str=passwordField.getText();
            passwordShownField.setText(str);
            passwordField.setVisible(false);
            passwordShownField.setVisible(true);
        }else{
            isPasswordShownFieldActive=false;
            String str=passwordShownField.getText();
            passwordField.setText(str);
            passwordField.setVisible(true);
            passwordShownField.setVisible(false);
        }
    }


    public void actionForRemoveButton(ActionEvent event) {
        String remove=shortNameField.getText();
        AddRemoveSearchFaculty.removeFaculty(remove);

        addOptionForFacultyShowComboBox();
        fullNameField.setText("");
        shortNameField.setText("");
        passwordField.setText("");
        priorityField.setText("");
        maxClassBreakTextField.setText("");
        classTakenInDaysTextField.setText("");
        isAdminCheckBox.setSelected(false);


        try{
            Parent newRoot= FXMLLoader.load(getClass().getClassLoader().getResource("operationSuccessful.fxml"));
            Scene newScene=new Scene(newRoot,300,100);

            Stage newStage = new Stage();

            newStage.setScene(newScene);
            newStage.setTitle("Messege");
            newStage.setResizable(false);
            newStage.centerOnScreen();
            newStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }




}
