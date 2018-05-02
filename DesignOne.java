import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class DesignOne implements Design {
	
	private int pitWidth = 100;
	private int pitHeight = 110;
	private int mancalaWidth = 120;
	private int mancalaHeight = 230;

	
	public Shape getPitShape() {
		return new RoundRectangle2D.Double(0, 0, pitWidth, pitHeight, 10, 10);
	}

	@Override
	public Shape getStoneShape(int x, int y) {
		// TODO Auto-generated method stub
		return new Ellipse2D.Double(x,y,12,12);
	}

	@Override
	public Shape getMancalaShape() {
		// TODO Auto-generated method stub
		return new RoundRectangle2D.Double(0, 0, mancalaWidth, mancalaHeight, 10, 10);
	}

	@Override
	public Color getBackgroundColor() {
		// TODO Auto-generated method stub
		return Color.WHITE;
	}

	@Override
	public Color getStoneColor() {
		// TODO Auto-generated method stub
		return Color.WHITE;
	}

	@Override
	public Color getPitColor() {
		// TODO Auto-generated method stub
		return new Color(83,188,156);
	}
	@Override
	public Color getMancalaColor() {
		// TODO Auto-generated method stub
		return new Color(57,138,118);
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
