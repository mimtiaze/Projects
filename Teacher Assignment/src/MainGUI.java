import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by mimtiaze on 03-Jul-16.
 */
public class MainGUI extends Application {

    Scene logInScene;
    Scene firstSceneAdminScene;
    Scene firstSceneUserScene;
    Scene testScreenScene;
    Stage mainWindow;

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent logInroot = FXMLLoader.load(getClass().getResource("logIn.fxml"));


        //Debug purpose
        //Parent logInroot = FXMLLoader.load(getClass().getResource("routineGridShowAdmin.fxml"));
        //Parent logInroot = FXMLLoader.load(getClass().getResource("dropSectionAdmin.fxml"));
        //Parent logInroot = FXMLLoader.load(getClass().getResource("setLabTheoryLimitAdmin.fxml"));
        //Parent logInroot = FXMLLoader.load(getClass().getResource("observeByFacultyAdmin.fxml"));
        //Parent logInroot = FXMLLoader.load(getClass().getResource("fileNotFound.fxml"));
        //Parent logInroot = FXMLLoader.load(getClass().getResource("firstSceneAdmin.fxml"));
        //Parent logInroot = FXMLLoader.load(getClass().getResource("firstSceneUser.fxml"));
        //Parent logInroot = FXMLLoader.load(getClass().getResource("observeFacultyAsList.fxml"));
        //logInScene=new Scene(logInroot,850,500);
        //logInScene=new Scene(logInroot,300,120);
        logInScene=new Scene(logInroot,350,250);

        SavingCoursesAndFacultyInfo.loadingFacultyInfo();
        SavingCoursesAndFacultyInfo.loadingCoursesInfo();


        /*AddRemoveSearchFaculty.addFaculty("","CMR","12",false,1,5,4);
        AddRemoveSearchFaculty.addFaculty("","HS","12",false,1,5,4);
        AddRemoveSearchFaculty.addFaculty("","MNH","12",false,1,5,4);
        AddRemoveSearchFaculty.addFaculty("","SaIm","12",false,1,5,4);
        AddRemoveSearchFaculty.addFaculty("","KM","12",false,1,5,4);
        AddRemoveSearchFaculty.addFaculty("","MME","12",false,1,5,4);
        AddRemoveSearchFaculty.addFaculty("","SA","12",false,1,5,4);
        AddRemoveSearchFaculty.addFaculty("","SS","12",true,1,5,4);
        AddRemoveSearchFaculty.addFaculty("","Mbad","12",false,2,5,4);
        AddRemoveSearchFaculty.addFaculty("","Thy","12",false,2,5,4);
        AddRemoveSearchFaculty.addFaculty("","Novia","12",false,2,5,4);
        AddRemoveSearchFaculty.addFaculty("","Sanjay","12",false,3,5,4);
        AddRemoveSearchFaculty.addFaculty("","Akash","12",false,3,5,4);
        AddRemoveSearchFaculty.addFaculty("","Samia","12",false,3,5,4);
        AddRemoveSearchFaculty.addFaculty("","Sworna","12",false,3,5,4);
        AddRemoveSearchFaculty.addFaculty("","Afrin","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Khairul","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","Imtiaz","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Shafin","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Nasif","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Maitraye","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Nasim","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Rana","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Tasnim","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Samiha","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Kamrul","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Nayem","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Rizwan","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Bappy","12",false,4,5,4);
        AddRemoveSearchFaculty.addFaculty("","Sajid","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","Ashraf","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","Shantanu","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","Maruf","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","SamiaShafiq","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","Ashraful","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","Minhaj","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","Jamshed","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","Arif","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","Khusnur","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","Tamjid","12",false,5,5,4);
        AddRemoveSearchFaculty.addFaculty("","Dr Rifat","12",false,5,5,4);*/


        //debug
        //logInController.nowSelectedFaculty="CMR";

        mainWindow=primaryStage;


        mainWindow.setTitle("Project TA");
        mainWindow.setScene(logInScene);
        mainWindow.setResizable(false);
        mainWindow.show();


        mainWindow.setOnCloseRequest(e->{
            SavingCoursesAndFacultyInfo.savingCoursesInfo();
            SavingCoursesAndFacultyInfo.savingFacultyInfo();
            mainWindow.close();
        });
    }


    public static void main(String[] args) {
        //new TakeInput();

        SavingCoursesAndFacultyInfo.loadingCoursesInfo();
        SavingCoursesAndFacultyInfo.loadingFacultyInfo();

        launch(args);
    }

}
