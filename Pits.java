import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.text.*;

/**
 * Pits Icon for drawing the stone in the pit
 */
public class Pits implements Icon {
    private Design design;
    private int pitNumber;
    private int stoneNumber;
    private int xx = 14;
    private int yy = -5;

    /**
     * Pits Icon Constructor 
     * @params Design
     * @params pitnumber
     * @params stoneNumber
     */
    public Pits(Design design, int pitNumber, int stoneNumber) {
        this.design = design;
        this.pitNumber = pitNumber;
        this.stoneNumber = stoneNumber;

    }

    /**
     * Get the Icon Shape given the number of stone
     * @params numStonw
     */
    public Shape stonePosition(int numStone) {

        if (numStone % 5 == 0) {

            xx = 14;
            yy += 13;
        }
        if (numStone % 5 != 0) {
            xx += 16;
        }
        int x = xx;
        int y = yy;

        return design.getStoneShape(x, y);

    }

    /**
     * Contain method given the point
     * @params point
     */
    public boolean contains(Point2D point) {
        return design.getPitShape().contains(point);
    }

    /**
     * Setter for Pit number and Stone number
     * 
     * @params pitnum
     * @params stonenum
     */
    public void setUpdate(int pitnum, int stonenum) {
        pitNumber = pitnum;
        stoneNumber = stonenum;
    }

    /**
     * Paint method
     */
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {

        Graphics2D g2 = (Graphics2D) g;
        if (pitNumber != 6 && pitNumber != 13) {
            g2.setColor(design.getPitColor());
            g2.fill(design.getPitShape());

            for (int i = 0; i < stoneNumber; i++) {
                g2.setColor(design.getStoneColor());
                g2.fill(stonePosition(i));
            }

        } else {
            g2.setColor(design.getMancalaColor());
            g2.fill(design.getMancalaShape());
            for (int i = 0; i < stoneNumber; i++) {
                g2.setColor(design.getStoneColor());
                g2.fill(stonePosition(i));
            }
        }

    }

    /**
     * Getter for the mancala shape width
     */
    @Override
    public int getIconWidth() {
        if (pitNumber == 6 || pitNumber == 13)
            return design.getMancalaWidth();
        return design.getPitWidth();
    }

    /**
     * Getter for the mancala shape height
     */
    @Override
    public int getIconHeight() {
        if (pitNumber == 6 || pitNumber == 13)
            return design.getMancalaHeight();
        return design.getPitHeight();
    }

}
