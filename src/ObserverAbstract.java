import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ObserverAbstract extends JFrame implements ActionListener {
    static JTextField text;
    static JFrame aardvarkMainGUI = new JFrame("Aardvark");
    static JFrame aardvarkmainMenuGUI = new JFrame("Aardvark Main Menu");
    static JFrame aardvarkSelectDifficulty = new JFrame("Aardvark Difficulty Menu");
    static JButton button;
    static JLabel label;
    static MVCModel model = new MVCModel();
    static MVCView view = new MVCView();
    static MVCController controller = new MVCController(model, view);
    static protected Aardvark aardvark;
    static int level;

    protected ObserverSubject observerSubject;

    public abstract void displayFrame();

    public void actionPerformed(ActionEvent e)
    {
        String s = e.getActionCommand();
        if (s.equals("Ok")) {
            controller.setPlayerName(text.getText().trim());
            aardvark.playerName = model.getName();
            aardvarkMainGUI.dispose();
            aardvarkmainMenuGUI.setVisible(true);
        } else if (s.equals("Play")){
            aardvarkSelectDifficulty.setVisible(true);
        } else if (s.equals("View Rules")){
            aardvark.viewRules();
        } else if (s.equals("View High Scores")){
            aardvark.viewHighScores();
        } else if (s.equals("Exit")){
            aardvark.quit();
        } else if (s.equals("Simples")){
            level = 1;
            aardvark.play();
        } else if (s.equals("Not-so-simples")){
            level = 2;
            aardvark.play();
        } else if (s.equals("Super-duper-shuffled")){
            level = 3;
            aardvark.play();
        }
    }
}
