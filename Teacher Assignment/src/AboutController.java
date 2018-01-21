import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

/**
 * Created by mimtiaze on 29-Aug-16.
 */
public class AboutController {
    public Button nextButton;
    public Button prevButton;
    public ImageView imageView;
    private int imageNumber=0;

    public void initialize(){
        Image img;

        if(imageNumber==0){
            img=new Image("SS sir.png");
            imageView.setImage(img);
        }
        else if(imageNumber==1){
            img=new Image("developers.png");
            imageView.setImage(img);
        }

        Image backImage = new Image("left.png");
        prevButton.setGraphic(new ImageView(backImage));
        Image frontImage = new Image("right.png");
        nextButton.setGraphic(new ImageView(frontImage));

    }

    public void actionForNextButton(){
        if(imageNumber==0)
            imageNumber=1;
        else if(imageNumber==1)
            imageNumber=0;

        Image img;

        if(imageNumber==0){
            img=new Image("SS sir.png");
            imageView.setImage(img);
        }
        else if(imageNumber==1){
            img=new Image("developers.png");
            imageView.setImage(img);
        }
    }

    public void actionForPrevButton(){
        if(imageNumber==0)
            imageNumber=1;
        else if(imageNumber==1)
            imageNumber=0;

        Image img;

        if(imageNumber==0){
            img=new Image("SS sir.png");
            imageView.setImage(img);
        }
        else if(imageNumber==1){
            img=new Image("developers.png");
            imageView.setImage(img);
        }

    }
}
