import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by mimtiaze on 30-Jul-16.
 */
public class NotSufficientInfoController {
    public Button closeButton;

    public void actionForCloseButton(){
        Stage newStage=(Stage)closeButton.getScene().getWindow();
        newStage.close();

    }
}
