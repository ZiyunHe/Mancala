import java.awt.Color;
import java.awt.Shape;

/** 
 * Design interface for using strategy pattern
 */
public interface Design {

	public Shape getPitShape();
<<<<<<< HEAD
	public Shape getStoneShape(int x, int y);
=======
	public Shape getStoneShape(int x,int y);
>>>>>>> Phuc
	public Shape getMancalaShape();
	public Color getBackgroundColor();
	public Color getStoneColor();
	public Color getPitColor();
	public Color getMancalaColor();
	public int getPitWidth();
	public int getPitHeight();
	public int getMancalaWidth();
	public int getMancalaHeight();
	
}
