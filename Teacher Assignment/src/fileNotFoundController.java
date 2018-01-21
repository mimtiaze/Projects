import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
;

/**
 * Created by mimtiaze on 05-Aug-16.
 */
public class fileNotFoundController {

    public ImageView errorImage;
    public Button okButton;

    public void initialize(){
        try{
            Image img=new Image("error.png");
            errorImage.setImage(img);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void actionForOkButton() {

        Stage newStage=(Stage)okButton.getScene().getWindow();
        newStage.close();

    }
}
