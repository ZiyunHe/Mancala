import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller {
	
	private View v;
	private Model m;
	
	public Controller(View view, Model model) {
		v = view;
		m = model;
		
		v.addChoose3Listener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.setNumberOfStones(3);
			}
		});
		
		v.addChoose4Listener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.setNumberOfStones(4);
			}
		});
		
		v.addChooseDesign1Listener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.setDesignStyle(1);
			}
		});
		
		v.addChooseDesign2Listener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				m.setDesignStyle(2);
			}
		});
		
		v.addPitsListener1(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
				m.move(0);
				v.labelRepaint(0);
			 }
		});
		
		v.addPitsListener2(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
				m.move(1);
				v.labelRepaint(1);
			 }
		});
		
		v.addPitsListener3(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
				m.move(2);
				v.labelRepaint(2);
			 }
		});
		
		v.addPitsListener4(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
				m.move(3);
				v.labelRepaint(3);
			 }
		});
		
		v.addPitsListener5(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
					m.move(4);
					v.labelRepaint(4);
			 }
		});
		
		v.addPitsListener6(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
					m.move(5);
					v.labelRepaint(5);
			 }
		});
		
		v.addPitsListener7(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
					m.move(6);
					v.labelRepaint(6);

			 }
		});
		
		v.addPitsListener8(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
					m.move(7);
					v.labelRepaint(7);

			 }
		});
		
		v.addPitsListener9(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
					m.move(8);
					v.labelRepaint(8);

			 }
		});
		
		v.addPitsListener10(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
					m.move(9);
					v.labelRepaint(9);

			 }
		});
		
		v.addPitsListener11(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
					m.move(10);
					v.labelRepaint(10);

			 }
		});
		
		v.addPitsListener12(new MouseAdapter() {
			 public void mousePressed(MouseEvent e){
					m.move(11);
					v.labelRepaint(11);

			 }
		});
	}
}
