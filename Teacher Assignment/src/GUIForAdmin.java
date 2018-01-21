import javax.swing.*;
import java.awt.*;

/**
 * Created by mimtiaze on 01-Jul-16.
 */
public class GUIForAdmin extends JFrame {

    JPanel routineGrid;
    JButton testBtn;

    public GUIForAdmin(){
        setSize(1160,668);
        setLocation(100,50);
        setTitle("Project - TA (Admin)");

        routineGrid=new JPanel();
        routineGrid.setBackground(Color.green);
        //testBtn=new JButton("Test");

        //testBtn.setPreferredSize(new Dimension(960,334));

        routineGrid.setSize(new Dimension(960,334));
        routineGrid.setLayout(null);

        JLabel label = new JLabel(
                "This JPanel uses Absolute Positioning"
                , JLabel.CENTER);
        //label.setSize(300, 30);
        //label.setLocation(5, 5);

        label.setBounds(500,5,300,30);

        JButton button = new JButton("USELESS");
        //button.setSize(100, 30);
        //button.setLocation(95, 45);
        button.setBounds(95,45,100,30);

        routineGrid.add(label);
        routineGrid.add(button);

        add(routineGrid);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
