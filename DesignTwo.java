import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;

<<<<<<< HEAD
public class DesignTwo implements Design{
	int pitHeight=110;
	int pitWidth=100;
	int mancalaHeight=230;
	int mancalaWidth=100;
	
	@Override
	public Shape getPitShape() {
		return new RoundRectangle2D.Double(0, 0, pitWidth, pitHeight, 10, 10);
	}

	@Override
	public Shape getStoneShape(int x, int y) {
		return new Rectangle2D.Double(x, y, 12, 12);
	}

	@Override
	public Shape getMancalaShape() {
		return new RoundRectangle2D.Double(0, 0, mancalaWidth, mancalaHeight, 10, 10);
	}
=======
/**
 * Concrete class that implement Strategy pattern
 */
public class DesignTwo implements Design {
    int pitHeight = 110;
    int pitWidth = 100;
    int mancalaHeight = 260;
    int mancalaWidth = 100;

    /**
     * Getter for the pit shape
     */
    @Override
    public Shape getPitShape() {
        return new RoundRectangle2D.Double(0, 0, pitWidth, pitHeight, 10, 10);
    }

    /**
     * Getter the stone shape
     */
    @Override
    public Shape getStoneShape(int x, int y) {
        return new Rectangle2D.Double(x, y, 10, 10);
    }

    /**
     * Getter the mancala shape
     */
    @Override
    public Shape getMancalaShape() {
        return new RoundRectangle2D.Double(0, 0, mancalaWidth, mancalaHeight, 10, 10);
    }
>>>>>>> Phuc

    /**
     * Getter the backgroundcolor
     */
    @Override
    public Color getBackgroundColor() {
        return new Color(0, 175, 182);
    }

    /**
     * Getter the stone color
     */
    @Override
    public Color getStoneColor() {
        return Color.WHITE;
    }

<<<<<<< HEAD
	@Override
	public Color getPitColor() {
		return new Color(44,125,211);
	}

	@Override
	public Color getMancalaColor() {
		return new Color(31, 99, 173);
	}

	@Override
	public int getPitWidth() {
		// TODO Auto-generated method stub
		return pitWidth;
	}

	@Override
	public int getPitHeight() {
		// TODO Auto-generated method stub
		return pitHeight;
	}

	@Override
	public int getMancalaWidth() {
		// TODO Auto-generated method stub
		return mancalaWidth;
	}

	@Override
	public int getMancalaHeight() {
		// TODO Auto-generated method stub
		return mancalaHeight;
	}
}
=======
    /**
     * Getter pit color
     */
    @Override
    public Color getPitColor() {
        return new Color(8, 122, 177);
    }

    /**
     * Getter for mancala color
     */
    @Override
    public Color getMancalaColor() {
        return new Color(7, 104, 152);
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
>>>>>>> Phuc
