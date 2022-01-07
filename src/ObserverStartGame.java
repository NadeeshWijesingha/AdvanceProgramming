import javax.swing.*;
import java.awt.*;

public class ObserverStartGame extends ObserverAbstract {
    public ObserverStartGame(ObserverSubject observerSubject) {
        this.observerSubject = observerSubject;
        this.observerSubject.attach(this);
    }

    @Override
    public void displayFrame() {
        aardvarkMainGUI.setLayout(new GridLayout(0, 1));
        label = new JLabel(" Welcome To Abominodo");
        aardvarkMainGUI.add(label);
        aardvarkMainGUI.add(label);
        aardvarkMainGUI.pack();
        aardvarkMainGUI.setVisible(true);
    }
}
