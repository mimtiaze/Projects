import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by mimtiaze on 17-Sep-16.
 */
public class HelpController {
    public ImageView imageView;

    public void initialize(){
        try{
            Image img=new Image("help.png");
            imageView.setImage(img);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
