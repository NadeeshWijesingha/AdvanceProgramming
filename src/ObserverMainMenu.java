import javax.swing.*;
import java.awt.*;

public class ObserverMainMenu extends ObserverAbstract {
    public ObserverMainMenu(ObserverSubject observerSubject) {
        this.observerSubject = observerSubject;
        this.observerSubject.attach(this);
    }

    @Override
    public void displayFrame() {
        aardvarkmainMenuGUI.setLayout(new GridLayout(0, 1));
        label = new JLabel(MultiLinugualStringTable.getMessage(1) + ". " + MultiLinugualStringTable.getMessage(2));
        aardvarkmainMenuGUI.add(label);
        button = new JButton("Play Game");
        button.setBackground(Color.BLUE);
        aardvarkmainMenuGUI.add(button);
        button.addActionListener(this);
        button = new JButton("View High Scores");
        aardvarkmainMenuGUI.add(button);
        button.setBackground(Color.GREEN);
        button.addActionListener(this);
        button = new JButton("View Rules");
        aardvarkmainMenuGUI.add(button);
        button.setBackground(Color.RED);
        button.addActionListener(this);
        button = new JButton("Exit");
        aardvarkmainMenuGUI.add(button);
        button.addActionListener(this);
        aardvarkmainMenuGUI.pack();
        aardvarkmainMenuGUI.setVisible(true);

    }
}
