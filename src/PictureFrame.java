import javax.swing.*;
import java.awt.*;

public class PictureFrame {
    public DominoPanel dominoPanel;
    Aardvark aardvark;
    int x = 30;
    int y = 20;
    int degree = 10;

    public void drawDominoes(Graphics graphics, Aardvark aardvark) {
        for (Domino d : aardvark._d) {
            dominoPanel.drawDomino(graphics, d);
        }
    }

    public void PictureFrame(Aardvark aardvark) {
        this.aardvark = aardvark;
        if (dominoPanel == null) {
            JFrame f = new JFrame("Abominodo");
            dominoPanel = new DominoPanel();
            f.setContentPane(dominoPanel);
            f.pack();
            f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
            f.setVisible(true);
        }
    }

    class DominoPanel extends JPanel {
        private static final long serialVersionUID = 4190229282411119364L;

        public void drawGrid(Graphics graphics) {
            for (int are = 0; are < 7; are++) {
                for (int see = 0; see < 8; see++) {
                    drawDigitGivenCentre(graphics, x + see * y, x + are * y, y,
                            aardvark.grid[are][see]);
                }
            }
        }

        public void drawGridLines(Graphics graphics) {
            graphics.setColor(Color.LIGHT_GRAY);
            for (int are = 0; are <= 7; are++) {
                graphics.drawLine(y, y + are * y, 180, y + are * y);
            }
            for (int see = 0; see <= 8; see++) {
                graphics.drawLine(y + see * y, y, y + see * y, 160);
            }
        }

        public void drawHeadings(Graphics graphics) {
            for (int are = 0; are < 7; are++) {
                fillDigitGivenCentre(graphics, degree, x + are * y, y, are + 1);
            }

            for (int see = 0; see < 8; see++) {
                fillDigitGivenCentre(graphics, x + see * y, degree, y, see + 1);
            }
        }

        public void drawDomino(Graphics graphics, Domino domino) {
            if (domino.placed) {
                final int y = Math.min(domino.ly, domino.hy);
                final int x = Math.min(domino.lx, domino.hx);
                final int w = Math.abs(domino.lx - domino.hx) + 1;
                final int h = Math.abs(domino.ly - domino.hy) + 1;
                graphics.setColor(Color.WHITE);
                graphics.fillRect(y + x * y, y + y * y, w * y, h * y);
                graphics.setColor(Color.RED);
                graphics.drawRect(y + x * y, y + y * y, w * y, h * y);
                drawDigitGivenCentre(graphics, x + domino.hx * y, x + domino.hy * y, domino.high
                );
                drawDigitGivenCentre(graphics, x + domino.lx * y, x + domino.ly * y, domino.low
                );
            }
        }

        void drawDigitGivenCentre(Graphics graphics, int x, int y, int diameter, int n) {
            graphics.setColor(Color.BLACK);
            FontMetrics fm = graphics.getFontMetrics();
            String txt = Integer.toString(n);
            graphics.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
        }

        void drawDigitGivenCentre(Graphics graphics,
                                  int x,
                                  int y,
                                  int n) {
            graphics.setColor(Color.BLUE);
            FontMetrics fm = graphics.getFontMetrics();
            String txt = Integer.toString(n);
            graphics.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
        }

        void fillDigitGivenCentre(Graphics graphics, int x, int y, int diameter, int n) {
            int radius = diameter / 2;
            graphics.setColor(Color.GREEN);
            graphics.fillOval(x - radius, y - radius, diameter, diameter);
            graphics.setColor(Color.BLACK);
            graphics.drawOval(x - radius, y - radius, diameter, diameter);
            FontMetrics fm = graphics.getFontMetrics();
            String txt = Integer.toString(n);
            graphics.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
        }

        @Override
        protected void paintComponent(Graphics graphics) {
            graphics.setColor(Color.YELLOW);
            graphics.fillRect(0, 0, getWidth(), getHeight());
            if (aardvark.mode == 0 || aardvark.mode == 1) {
                drawGridLines(graphics);
                drawHeadings(graphics);
                drawGrid(graphics);
            }
            if (aardvark.mode == 1) {
                aardvark.drawGuesses(aardvark, graphics);
            }
            if (aardvark.mode == 0) {
                aardvark.pictureFrame.drawDominoes(graphics, aardvark);
            }
        }

        public Dimension getPreferredSize() {
            return new Dimension(202, 182);
        }
    }

}
