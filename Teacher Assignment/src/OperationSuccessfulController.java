import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * Created by mimtiaze on 30-Jul-16.
 */
public class OperationSuccessfulController {
    public Button closeButton;

    public void actionForCloseButton(){
        Stage tempStage=(Stage)closeButton.getScene().getWindow();
        tempStage.close();
    }
}
