import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SetUp extends JDialog {
	
	private Container container;
	private int numberOfStone;
	private Design design;
	private JPanel panel;
	private JLabel stoneOption;
	private JLabel designOption;
	private JRadioButton chooseThree;
	private JRadioButton chooseFour;
	private JRadioButton chooseDesign_1;
	private JRadioButton chooseDesign_2;
	private ButtonGroup Group_stone_button;
	private ButtonGroup Group_design_button;
	private JButton begin;
	
	public SetUp () {
		setTitle("SetUp for Mancala Game");
		setSize(500, 550);
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		stoneOption = new JLabel("Choose How Many Stones: ");
		chooseThree = new JRadioButton("Three",true);
		chooseThree = new JRadioButton("Four");
		Group_stone_button = new ButtonGroup();
		Group_stone_button.add(chooseThree);
		Group_stone_button.add(chooseFour );
		
		
		designOption = new JLabel ("Choose Design: ");
		chooseDesign_1 = new JRadioButton ("Design 1", true);
		chooseDesign_2 = new JRadioButton ("Design 1");
		Group_design_button = new ButtonGroup();
		Group_design_button.add(chooseDesign_1);
		Group_design_button.add(chooseDesign_2);
		
		begin = new JButton ("Begin");
		//begin.addActionListener(new ActionListi);
		
		
	}
	
}
