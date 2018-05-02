import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.util.*;
import java.text.*;

public class View {

	private Model model;
	private int numberOfStone = 3;
	private Design design = new DesignOne();
	private JFrame frame;
	JLabel curentPlayer;
	
	
	public View() {
	//	Model model	goes into View() parameter
	//	this.model= model;
		
		frame = new JFrame("Mancala");
		frame.setLayout(new BorderLayout(10,10));
	
		
		setUp(frame);
		
		
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.pack();
	     frame.setVisible(true);
	}
	
	
	public void setUp(JFrame fram) {
		JDialog dialog = new JDialog(fram, true);
		
		dialog.setTitle("SetUp for Mancala Game");
		dialog.setSize(360, 320);
		
		JLabel stoneOption = new JLabel("Choose How Many Stones\n: ");
		JRadioButton chooseThree = new JRadioButton("Three",true);
		JRadioButton chooseFour = new JRadioButton("Four");
		ButtonGroup Group_stone_button = new ButtonGroup();
		Group_stone_button.add(chooseThree);
		Group_stone_button.add(chooseFour );
		JPanel panel1 = new JPanel();
		
		panel1.add(stoneOption);
		panel1.add(chooseThree);
		panel1.add(chooseFour);
		
		JLabel designOption = new JLabel ("Choose Design: ");
		JRadioButton chooseDesign_1 = new JRadioButton ("Design 1", true);
		JRadioButton chooseDesign_2 = new JRadioButton ("Design 2");
		ButtonGroup Group_design_button = new ButtonGroup();
		Group_design_button.add(chooseDesign_1);
		Group_design_button.add(chooseDesign_2);
		JPanel panel2 = new JPanel();
		
		panel2.add(designOption);
		panel2.add(chooseDesign_1);
		panel2.add(chooseDesign_2);
		

	    BufferedImage image = null;
	    try{
	      image = new BufferedImage(334, 150, BufferedImage.TYPE_INT_ARGB);
	      image = ImageIO.read(new File("mancala.jpeg"));
	    }catch(IOException e){
	      System.out.println("Error: "+e);
	    }
	    JLabel  topImage = new JLabel(new ImageIcon(image));
	    JPanel panel0= new JPanel();
		panel0.add(topImage);
		
		Container container= dialog.getContentPane();
		JButton begin = new JButton ("Begin");
		begin.setForeground(Color.RED);
		begin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				container.setVisible(false);
				board();
				dialog.dispose();
				
			}
		});
		chooseThree.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfStone = 3;
				System.out.println(numberOfStone);
			}
		});
		chooseFour.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				numberOfStone = 4;
				System.out.println(numberOfStone);
			}
		});
		
		chooseDesign_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				design = new DesignOne();
			}
		});
		
		chooseDesign_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				design = new DesignTwo();
			}
		});
		
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		container.add(panel0);
		container.add(panel1);
		container.add(panel2);
		container.add(begin);
		dialog.setVisible(true);
		dialog.setResizable(false);
		
	}
	
	
	public void board() {
		 curentPlayer = new JLabel("Player .(1) or (2).. turn");
		 frame.add(curentPlayer, BorderLayout.NORTH);
		 
		 Pits mancala1 = new Pits(design,6, 27);
		 JLabel Mancala_1 = new JLabel(mancala1);
		 frame.add(Mancala_1, BorderLayout.EAST);
		 
		 Pits mancala2 = new Pits(design,13, 35);
		 JLabel Mancala_2 = new JLabel(mancala2);
		 frame.add(Mancala_2, BorderLayout.WEST);
		 
		 JPanel pitsBoard = new JPanel();
		 pitsBoard.setLayout(new GridLayout(2,6,10,10));
		 for(int i= 0; i<12;i++) {
			 Pits pit = new Pits(design,pitOrder(i), 11);
			 JLabel pits = new JLabel(pit);
			 pitsBoard.add(pits);
			 
		 }
		 
		 frame.add(pitsBoard, BorderLayout.CENTER);
		 
		 JButton undoButton = new JButton("Undo: 3");
		 JPanel u = new JPanel();
		 u.add(undoButton);
		 frame.add(u, BorderLayout.SOUTH);
		 
		 
	}
	
	public int pitOrder(int i) {
		if (i==0) return 12;
		if (i==1) return 11;
		if (i==2) return 10;
		if (i==3) return 9;
		if (i==4) return 8;
		if (i==5) return 7;
		if (i==6) return 0;
		if (i==7) return 1;
		if (i==8) return 2;
		if (i==9) return 3;
		if (i==10) return 4;
		return 5;
		
	}
}
