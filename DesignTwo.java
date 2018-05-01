import java.awt.Color;
import java.awt.Shape;
import java.awt.geom.RoundRectangle2D;

public class DesignTwo implements Design{

	@Override
	public Shape getPitShape() {
		return new RoundRectangle2D.Double(0, 0, 100, 100, 10, 10);
	}

	@Override
	public Shape getStoneShape() {
		return new RoundRectangle2D.Double(0, 0, 10, 10, 2, 2);
	}

	@Override
	public Shape getMancalaShape() {
		return new RoundRectangle2D.Double(0, 0, 100, 220, 10, 10);
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
}
