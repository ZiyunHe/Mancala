import java.awt.Color;
import java.awt.Shape;
<<<<<<< HEAD
import java.awt.geom.Rectangle2D;
=======
>>>>>>> Phuc
import java.awt.geom.RoundRectangle2D;

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
<<<<<<< HEAD
	public Shape getStoneShape(int x, int y) {
		return new Rectangle2D.Double(x, y, 12, 12);
=======
	public Shape getPitShape() {
		return new RoundRectangle2D.Double(0, 0, 100, 100, 10, 10);
	}

	@Override
	public Shape getStoneShape() {
		return new RoundRectangle2D.Double(0, 0, 10, 10, 2, 2);
>>>>>>> Phuc
	}

	@Override
	public Shape getMancalaShape() {
<<<<<<< HEAD
		return new RoundRectangle2D.Double(0, 0, mancalaWidth, mancalaHeight, 10, 10);
=======
		return new RoundRectangle2D.Double(0, 0, 100, 220, 10, 10);
>>>>>>> Phuc
	}

	@Override
	public Color getBackgroundColor() {
		return Color.WHITE;
	}

	@Override
	public Color getStoneColor() {
		return Color.WHITE;
	}

	@Override
	public Color getPitColor() {
<<<<<<< HEAD
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
		return new Color(216,57,100);
	}

    @Override
    public Color getMancalaColor() {
        return new Color(179, 46, 91);
    }
}
>>>>>>> Phuc
