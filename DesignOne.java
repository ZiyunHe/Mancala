import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

/**
 * Concrete class that implement Strategy pattern
 */
public class DesignOne implements Design {

    private int pitWidth = 100;
    private int pitHeight = 110;
    private int mancalaWidth = 120;
    private int mancalaHeight = 260;

    /**
     * Getter for the pit shape
     */
    public Shape getPitShape() {
        return new RoundRectangle2D.Double(0, 0, pitWidth, pitHeight, 10, 10);
    }
    
    /**
     * Getter the stone shape
     */
    @Override
    public Shape getStoneShape(int x, int y) {
        // TODO Auto-generated method stub
        return new Ellipse2D.Double(x, y, 12, 12);
    }
    
    /**
     * Getter the mancala shape
     */
    @Override
    public Shape getMancalaShape() {
        // TODO Auto-generated method stub
        return new RoundRectangle2D.Double(0, 0, mancalaWidth, mancalaHeight, 10, 10);
    }

    /**
     * Getter the backgroundcolor
     */
    @Override
    public Color getBackgroundColor() {
        // TODO Auto-generated method stub
        return Color.WHITE;
    }
    
    /**
     * Getter the stone color
     */
    @Override
    public Color getStoneColor() {
        // TODO Auto-generated method stub
        return Color.WHITE;
    }

    /**
     * Getter pit color
     */
    @Override
    public Color getPitColor() {
        // TODO Auto-generated method stub
        return new Color(83, 188, 156);
    }

    /**
     * Getter for mancala color
     */
    @Override
    public Color getMancalaColor() {
        // TODO Auto-generated method stub
        return new Color(57, 138, 118);
    }

    /**
     * Getter for pit width
     */
    @Override
    public int getPitWidth() {
        // TODO Auto-generated method stub
        return pitWidth;
    }

    /**
     * Getter for pit height
     */
    @Override
    public int getPitHeight() {
        // TODO Auto-generated method stub
        return pitHeight;
    }
    /**
     * Getter for mancala width
     */    
    @Override
    public int getMancalaWidth() {
        // TODO Auto-generated method stub
        return mancalaWidth;
    }
    /**
     * Getter for mancala height
     */
    @Override
    public int getMancalaHeight() {
        // TODO Auto-generated method stub
        return mancalaHeight;
    }

}
