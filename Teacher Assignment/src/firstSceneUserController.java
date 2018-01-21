import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

/**
 * Created by mimtiaze on 03-Jul-16.
 */
public class firstSceneUserController {
    @FXML
    private Stage chooseCourseStage;
    private Scene chooseCourseUserScene;
    private Parent chooseCourseUserRoot;

    public ImageView imageView;

    public Label emptyLabelForGetScene;

    public void initialize(){
        try{
            Image img=new Image("firstSceneImage.jpg");
            imageView.setImage(img);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actionForChooseSectionMenuItem(){
        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getResource("routineGridShowUser.fxml"));
            chooseCourseUserScene=new Scene(chooseCourseUserRoot,850,500);

            chooseCourseStage = (Stage) emptyLabelForGetScene.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseUserScene);
            chooseCourseStage.centerOnScreen();
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }


    public void actionForChooseCourseMenuItem(){
        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getResource("chooseCourseUser.fxml"));
            chooseCourseUserScene=new Scene(chooseCourseUserRoot,850,500);

            chooseCourseStage = (Stage) emptyLabelForGetScene.getScene().getWindow();

            chooseCourseStage.setScene(chooseCourseUserScene);
            chooseCourseStage.centerOnScreen();
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }


    public void actionForChangePasswordMenuItem(){
        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getResource("changePasswordUser.fxml"));
            chooseCourseUserScene=new Scene(chooseCourseUserRoot,400,300);

            chooseCourseStage = new Stage();

            chooseCourseStage.setScene(chooseCourseUserScene);
            chooseCourseStage.centerOnScreen();
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForHelpMenuItem(){
        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getResource("help.fxml"));
            chooseCourseUserScene=new Scene(chooseCourseUserRoot,600,400);

            chooseCourseStage = new Stage();

            chooseCourseStage.setScene(chooseCourseUserScene);
            chooseCourseStage.centerOnScreen();
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForAboutMenuItem(){
        try{
            chooseCourseUserRoot= FXMLLoader.load(getClass().getClassLoader().getResource("about.fxml"));
            chooseCourseUserScene=new Scene(chooseCourseUserRoot,600,400);

            chooseCourseStage = new Stage();

            chooseCourseStage.setScene(chooseCourseUserScene);
            chooseCourseStage.setResizable(false);
            chooseCourseStage.show();
        }catch(Exception e){
            System.out.println("Error: "+e.getMessage());
        }
    }

    public void actionForCloseMenuItem(){

        SavingCoursesAndFacultyInfo.savingCoursesInfo();
        SavingCoursesAndFacultyInfo.savingFacultyInfo();

        chooseCourseStage = (Stage) emptyLabelForGetScene.getScene().getWindow();
        chooseCourseStage.close();
    }

}
