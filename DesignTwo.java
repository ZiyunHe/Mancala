import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

public class DesignTwo implements Design{
	int pitHeight=200;
	int pitWidth=250;
	int mancalaHeight=220;
	int mancalaWidth=100;
	
	@Override
	public Shape getPitShape() {
		return new RoundRectangle2D.Double(0, 0, pitWidth, pitHeight, 10, 10);
	}

	@Override
	public Shape getStoneShape(int x, int y) {
		return new RoundRectangle2D.Double(x, y, 12, 12, 2, 2);
	}

	@Override
	public Shape getMancalaShape() {
		return new RoundRectangle2D.Double(0, 0, mancalaWidth, mancalaHeight, 10, 10);
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
		return new Color(216,57,100);
	}

	@Override
	public Color getMancalaColor() {
		return new Color(179, 46, 91);
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