import java.awt.*;

import javax.swing.*;

public class PictureFrame {
  public int[] reroll = null;
  Aardvark master = null;
  
  int x = 30;
  int y = 20;
  int degree = 10;

  public void drawDominoes(Graphics g, Aardvark aardvark) {
    for (Domino d : aardvark._d) {
      dp.drawDomino(g, d);
    }
  }

  class DominoPanel extends JPanel {
    private static final long serialVersionUID = 4190229282411119364L;

    public void drawGrid(Graphics g) {
      for (int are = 0; are < 7; are++) {
        for (int see = 0; see < 8; see++) {
          drawDigitGivenCentre(g, x + see * y, x + are * y, y,
              master.grid[are][see]);
        }
      }
    }

    public void drawGridLines(Graphics g) {
      g.setColor(Color.LIGHT_GRAY);
      for (int are = 0; are <= 7; are++) {
        g.drawLine(y, y + are * y, 180, y + are * y);
      }
      for (int see = 0; see <= 8; see++) {
        g.drawLine(y + see * y, y, y + see * y, 160);
      }
    }

    public void drawHeadings(Graphics g) {
      for (int are = 0; are < 7; are++) {
        fillDigitGivenCentre(g, degree, x + are * y, y, are+1);
      }

      for (int see = 0; see < 8; see++) {
        fillDigitGivenCentre(g, x + see * y, degree, y, see+1);
      }
    }

    public void drawDomino(Graphics g, Domino d) {
      if (d.placed) {
        final int y = Math.min(d.ly, d.hy);
        final int x = Math.min(d.lx, d.hx);
        final int w = Math.abs(d.lx - d.hx) + 1;
        final int h = Math.abs(d.ly - d.hy) + 1;
        g.setColor(Color.WHITE);
        g.fillRect(y + x * y, y + y * y, w * y, h * y);
        g.setColor(Color.RED);
        g.drawRect(y + x * y, y + y * y, w * y, h * y);
        drawDigitGivenCentre(g, x + d.hx * y, x + d.hy * y, y, d.high,
            Color.BLUE);
        drawDigitGivenCentre(g, x + d.lx * y, x + d.ly * y, y, d.low,
            Color.BLUE);
      }
    }

    void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
      int radius = diameter / 2;
      g.setColor(Color.BLACK);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    void drawDigitGivenCentre(Graphics g, int x, int y, int diameter, int n,
        Color c) {
      int radius = diameter / 2;
      g.setColor(c);
      // g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    void fillDigitGivenCentre(Graphics g, int x, int y, int diameter, int n) {
      int radius = diameter / 2;
      g.setColor(Color.GREEN);
      g.fillOval(x - radius, y - radius, diameter, diameter);
      g.setColor(Color.BLACK);
      g.drawOval(x - radius, y - radius, diameter, diameter);
      FontMetrics fm = g.getFontMetrics();
      String txt = Integer.toString(n);
      g.drawString(txt, x - fm.stringWidth(txt) / 2, y + fm.getMaxAscent() / 2);
    }

    protected void paintComponent(Graphics g) {
      g.setColor(Color.YELLOW);
      g.fillRect(0, 0, getWidth(), getHeight());
      if (master.mode == 0 || master.mode == 1) {
        drawGridLines(g);
        drawHeadings(g);
        drawGrid(g);
      }
      if (master.mode == 1) {
        master.drawGuesses(g);
      }
      if (master.mode == 0) {
        master.pf.drawDominoes(g, master);
      }
    }

    public Dimension getPreferredSize() {
      return new Dimension(202, 182);
    }
  }

  public DominoPanel dp;

  public void PictureFrame(Aardvark sf) {
    master = sf;
    if (dp == null) {
      JFrame f = new JFrame("Abominodo");
      dp = new DominoPanel();
      f.setContentPane(dp);
      f.pack();
      f.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
      f.setVisible(true);
    }
  }

  public void reset() {
    // TODO Auto-generated method stub

  }

}
