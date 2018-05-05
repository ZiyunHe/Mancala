import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller {
	private View view;
	private Model model;
	
	/*
	 * Controller_Cal Constructor creates actions to performs when an user input receive
	 * @param View_Cal
	 * @param Model_Cal
	 */
	public Controller (View vie, Model mode){
		view = vie;
		model = mode;
		
		ChangeListener listener = new ChangeListener() {
			public void stateChanged(ChangeEvent event) {
				view.mancalaRepaint();
				for(int i=0; i<12; i++) {
					view.labelRePaint(i);
				}
				view.setPlayerlable();
				view.repaintUndo();
				
				
				
			}
		};
		model.addChangeListener(listener);
		
	}
	
}
