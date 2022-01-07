import javax.swing.*;

public class ObserverPlayer extends ObserverAbstract {
    public ObserverPlayer(ObserverSubject observerSubject){
        this.observerSubject = observerSubject;
        this.observerSubject.attach(this);
    }

    @Override
    public void displayFrame() {
        label = new JLabel(MultiLinugualStringTable.getMessage(0));
        aardvarkMainGUI.add(label);
        text = new JTextField(25);
        aardvarkMainGUI.add(text);
        button = new JButton("PLAY!");
        aardvarkMainGUI.add(button);
        button.addActionListener(this);
        aardvarkMainGUI.pack();
    }
}
