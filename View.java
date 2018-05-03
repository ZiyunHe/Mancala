import java.awt.*;
import java.awt.event.*;
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
	//private Design design = new DesignOne();
	private JFrame frame;
	JLabel curentPlayer;
	
	private JButton begin;
	private JRadioButton chooseThree;
	private JRadioButton chooseFour;
	private JRadioButton chooseDesign_1;
	private JRadioButton chooseDesign_2;
	
	private JLabel[] pits = new JLabel[13];
	
	public View(Model m) {
	//	Model model	goes into View() parameter
		this.model= m;
		 frame = new JFrame("Mancala");
		 frame.setLayout(new BorderLayout(10,10));
		setUp();
	     
	}
	
	
	public void setUp() {
		JDialog dialog = new JDialog();
		
		dialog.setTitle("SetUp for Mancala Game");
		dialog.setSize(360, 320);
		
		JLabel stoneOption = new JLabel("Choose How Many Stones\n: ");
		chooseThree = new JRadioButton("Three",true);
		chooseFour = new JRadioButton("Four");
		ButtonGroup Group_stone_button = new ButtonGroup();
		Group_stone_button.add(chooseThree);
		Group_stone_button.add(chooseFour );
		JPanel panel1 = new JPanel();
		
		panel1.add(stoneOption);
		panel1.add(chooseThree);
		panel1.add(chooseFour);
		
		JLabel designOption = new JLabel ("Choose Design: ");
		chooseDesign_1 = new JRadioButton ("Design 1", true);
		chooseDesign_2 = new JRadioButton ("Design 2");
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
	      image = ImageIO.read(new File("mancala.jpg"));
	    }catch(IOException e){
	      System.out.println("Error: "+e);
	    }
	    JLabel  topImage = new JLabel(new ImageIcon(image));
	    JPanel panel0= new JPanel();
		panel0.add(topImage);
		
		Container container= dialog.getContentPane();
		begin = new JButton ("Begin");
		begin.setForeground(Color.RED);

		begin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent event) {
				container.setVisible(false);
				board();
				dialog.dispose();
			}
		});
		
		 // creating pits based on setup information
		 for(int i= 0; i<12;i++) {
			 Pits pit = new Pits(model.getDesignStyle(), pitOrder(i), model.getNumberOfStones());
			 pits[i] = new JLabel(pit);
		 }

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
		 
		 Pits mancala1 = new Pits(model.getDesignStyle(),6, 0);
		 JLabel Mancala_1 = new JLabel(mancala1);
		 frame.add(Mancala_1, BorderLayout.EAST);
		 
		 Pits mancala2 = new Pits(model.getDesignStyle(),13, 0);
		 JLabel Mancala_2 = new JLabel(mancala2);
		 frame.add(Mancala_2, BorderLayout.WEST);
		 
		 JPanel pitsBoard = new JPanel();
		 pitsBoard.setLayout(new GridLayout(2,6,10,10));
		 
		 for(int i = 0; i < 12; i++) {
			 pits[i].setIcon(new Pits(model.getDesignStyle(), pitOrder(i), model.getNumberOfStones()));
			 pitsBoard.add(pits[i]);
		 }
		 
		 frame.add(pitsBoard, BorderLayout.CENTER);
		 
		 JButton undoButton = new JButton("Undo: 3");
		 JPanel u = new JPanel();
		 u.add(undoButton);
		 frame.add(u, BorderLayout.SOUTH);
		 
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     frame.pack();
	     frame.setVisible(true);
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
	
	public void labelRepaint(int index) {
		pits[index].setIcon(new Pits(model.getDesignStyle(), pitOrder(index), model.getNumberOfStones()));
	}
	
	public void addPitsListener1(MouseAdapter a) {
		pits[0].addMouseListener(a);
	}
	
	public void addPitsListener2(MouseAdapter a) {
		pits[1].addMouseListener(a);
	}
	
	public void addPitsListener3(MouseAdapter a) {
		pits[2].addMouseListener(a);
	}
	
	public void addPitsListener4(MouseAdapter a) {
		pits[3].addMouseListener(a);
	}
	
	public void addPitsListener5(MouseAdapter a) {
		pits[4].addMouseListener(a);
	}
	
	public void addPitsListener6(MouseAdapter a) {
		pits[5].addMouseListener(a);
	}
	
	public void addPitsListener7(MouseAdapter a) {
		pits[6].addMouseListener(a);
	}
	
	public void addPitsListener8(MouseAdapter a) {
		pits[7].addMouseListener(a);
	}
	
	public void addPitsListener9(MouseAdapter a) {
		pits[8].addMouseListener(a);
	}
	
	public void addPitsListener10(MouseAdapter a) {
		pits[9].addMouseListener(a);
	}
	
	public void addPitsListener11(MouseAdapter a) {
		pits[10].addMouseListener(a);
	}
	
	public void addPitsListener12(MouseAdapter a) {
		pits[11].addMouseListener(a);
	}
	
	public void addChoose3Listener(ActionListener e) {
		chooseThree.addActionListener(e);
	}
	
	public void addChoose4Listener(ActionListener e) {
		chooseFour.addActionListener(e);
	}

	public void addChooseDesign1Listener(ActionListener e) {
		chooseDesign_1.addActionListener(e);
	}

	public void addChooseDesign2Listener(ActionListener e) {
		chooseDesign_2.addActionListener(e);
	}
}
