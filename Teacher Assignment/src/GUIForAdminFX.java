import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GUIForAdminFX extends Application {

    Stage mainWindow;
    Label nameLabel;
    Label passLabel;
    TextField nameField;
    Scene userNameInputScene;
    Scene adminScene;
    Scene userScene;
    Button loginButton;
    Label logInFailedMassege;
    Menu fileMenu;
    MenuBar menuBarUser;
    MenuBar menuBarAdmin;
    MenuItem logOut;
    PasswordField passField;
    GridPane gridForLogIn;
    BorderPane borderForMenuAdmin;
    BorderPane borderForMenuUser;
    GridPane box;
    //FlowPane routineGridAdmin;
    //Button[] routineGridButtonsAdmin;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        mainWindow = primaryStage;
        mainWindow.setTitle("Demo");
        mainWindow.setResizable(false);

        logInGui();
        guiAdmin();
        guiUser();


        userNameInputScene = new Scene(gridForLogIn,300,300);
        userScene=new Scene(borderForMenuUser,1160,668);
        adminScene=new Scene(borderForMenuAdmin,1160,668);
        mainWindow.setScene(userNameInputScene);
        mainWindow.show();
    }




    public void logInCheck(){

        /*AddRemoveSearchFaculty.addFaculty("SS","123",true);
        AddRemoveSearchFaculty.addFaculty("Maruf","1234",true);
        AddRemoveSearchFaculty.addFaculty("CMR","1",false);*/

        System.out.println(nameField.getText());
        System.out.println(passField.getText());

        FacultyInfo temp=AddRemoveSearchFaculty.searchForLogInFaculty(nameField.getText(),passField.getText());
        boolean wrongPassword=AddRemoveSearchFaculty.searchForWrongPasswordFaculty(nameField.getText(),passField.getText());

        if(wrongPassword){
            logInFailedMassege.setText("Password not correct !");
        }
        else if(temp==null){
            logInFailedMassege.setText("Faculty not found !");
        }
        else if(temp.isAdmin){
            mainWindow.setScene(adminScene);
        }
        else if(temp.isAdmin==false){
            mainWindow.setScene(userScene);
        }
    }


    public void logInGui(){

        //GridPane
        gridForLogIn=new GridPane();
        gridForLogIn.setPadding(new Insets(10,10,10,10));
        gridForLogIn.setHgap(10);
        gridForLogIn.setVgap(15);


        //************************************ Buttons and Labels on log in scene ********************************
        //name label
        nameLabel=new Label("Username: ");
        gridForLogIn.add(nameLabel,0,2);
        //GridPane.setConstraints(nameLabel,0,2);


        //Name Field
        nameField = new TextField();
        gridForLogIn.add(nameField,1,2);
        nameField.setPromptText("Username ...");

        //Password Label
        passLabel=new Label("Password: ");
        gridForLogIn.add(passLabel,0,3);

        //password Field
        passField = new PasswordField();
        gridForLogIn.add(passField,1,3);
        passField.setPromptText("Password ...");

        //Log In Button
        loginButton=new Button("Log in");
        gridForLogIn.add(loginButton,1,5);


        //Log in failed massege
        logInFailedMassege=new Label("");
        gridForLogIn.add(logInFailedMassege,1,8);


        //******************************** When I hit Enter key on sone specific field **************************

        //If anyone hit enter while on password field
        passField.setOnKeyPressed(e->{
            if(e.getCode().equals(KeyCode.ENTER)){
                logInCheck();
            }
        });

        //If anyone hit enter while on username field
        nameField.setOnKeyPressed(e->{
            if(e.getCode().equals(KeyCode.ENTER)){
                passField.requestFocus();
            }
        });
        loginButton.setOnAction(e-> logInCheck());

        //grid.setGridLinesVisible(true);

    }

    public void guiAdmin(){

        //*************************** Menu **********************************************\
        logOut = new MenuItem("Log Out");

        fileMenu=new Menu("File");
        fileMenu.getItems().add(logOut);



        menuBarAdmin=new MenuBar();
        menuBarAdmin.getMenus().add(fileMenu);


        //grid.getChildren().addAll(nameLabel,nameField,passField,passLabel,loginButton,logInFailedMassege);

        Label adminTest= new Label("This is Admin Interface");


        logOut.setOnAction(e-> {
            passField.setText("");
            nameField.setText("");
            nameField.requestFocus();
            mainWindow.setScene(userNameInputScene);
        });


        borderForMenuAdmin=new BorderPane();

        borderForMenuAdmin.setTop(menuBarAdmin);
        //borderForMenuAdmin.setMargin(menuBarAdmin,new Insets(10,10,20,20));
        //borderForMenuAdmin.setCenter(adminTest);
        //layout2.getChildren().addAll(menuBar);
        //BorderPane.setMargin(menuBar,new Insets(0,0,20,10));

        //box=new GridPane();

        //box.add(borderForMenuAdmin,0,0);
        //box.setGridLinesVisible(true);


        Button[] routineGridButtonsAdmin;

        FlowPane routineGridAdmin=new FlowPane(5,5);
        routineGridButtonsAdmin=new Button[32];

        for(int i=0;i<32;i++){
            routineGridButtonsAdmin[i]=new Button();
            routineGridButtonsAdmin[i].setText("Demo");
            routineGridAdmin.getChildren().add(routineGridButtonsAdmin[i]);
        }

        //box.add(borderForMenuAdmin,0,0);
        //box.add(routineGridAdmin,0,20);
        //box.getChildren().addAll(borderForMenuAdmin,routineGridAdmin);

    }


    public void guiUser(){

        menuBarUser=new MenuBar();
        menuBarUser.getMenus().add(fileMenu);

        Label userTest= new Label("This is User Interface");

        borderForMenuUser=new BorderPane();
        borderForMenuUser.setCenter(userTest);

        borderForMenuUser.setTop(menuBarUser);

    }
}