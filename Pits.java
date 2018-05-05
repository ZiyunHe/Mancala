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

public class Pits implements Icon{
	private Design design;
	private int pitNumber;
	private int stoneNumber;
	private  int xx=14;
	private  int yy=-5;
	
	public Pits(Design design, int pitNumber, int stoneNumber){
		this.design= design;
		this.pitNumber= pitNumber;
		this.stoneNumber = stoneNumber;
		
		
	}
	
	public Shape stonePosition(int numStone) {
		
		if (numStone%5 == 0  ) {
			
			xx = 14;
			yy += 13;
		}
		if (numStone%5 != 0 ) {
			xx += 16;
		}
		int x=xx;
		int y=yy;
		
		return design.getStoneShape(x,y);
		
	}
	
	public boolean contains(Point2D point)
    {
       return design.getPitShape().contains(point);
    }
	
	public void setUpdate(int  pitnum, int stonenum ) {
		pitNumber = pitnum;
		stoneNumber = stonenum;
	}
	
	@Override
	public void paintIcon(Component c, Graphics g, int x, int y) {
		
			
		Graphics2D g2 = (Graphics2D) g;
		if(pitNumber != 6 && pitNumber != 13) {
			g2.setColor(design.getPitColor());
			g2.fill(design.getPitShape());
			
			for (int i = 0 ; i< stoneNumber; i++) {
				g2.setColor(design.getStoneColor());
				g2.fill(stonePosition(i));
			}
			
			
		}else {
			g2.setColor(design.getMancalaColor());
			g2.fill(design.getMancalaShape());
			for (int i = 0 ; i< stoneNumber; i++) {
				g2.setColor(design.getStoneColor());
				g2.fill(stonePosition(i));
			}
		}
		
		
		
		
	}
	

	@Override
	public int getIconWidth() {
		if (pitNumber ==6 || pitNumber == 13)
			return design.getMancalaWidth();
		return design.getPitWidth();
	}

	@Override
	public int getIconHeight() {
		if (pitNumber ==6 || pitNumber == 13)
			return design.getMancalaHeight();
		return design.getPitHeight();
	}

}
