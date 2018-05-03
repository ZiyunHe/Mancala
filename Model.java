import java.util.ArrayList;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class Model {
	
	private int[] stoneInPit;
	private ArrayList<ChangeListener> listeners;
	
//	turn: true: player 1, false: player2
	private boolean turn;
	private boolean endGame;
	
	
	public Model(int stoneValue) {
		turn = true;
		stoneInPit = new int[13];
		endGame = false;
	}
	
	
	/*
	 * add ChangeListener into the listener ArrayList
	 * @param ChangeListener c
	 */
	public void addChangeListener(ChangeListener c) {
		listeners.add(c);
	}
	
	public void changeListener() {
		for (ChangeListener l : listeners) 
			l.stateChanged(new ChangeEvent(this));
	}
	
	//start with 3 or 4 
	public void setStoneNumber(int stoneNum) {
		for (int i = 0; i<14;i++) {
			stoneInPit[i]= stoneNum;
		}
		changeListener();
		
	}
	
	
	
	
	
	
	public boolean getTurn() {
		return turn;
	}
	
	public void move(int index, boolean turn) {
		int stoneValue = stoneInPit[index];
		stoneInPit[index]= 0;
		if(turn) {
//			Player 1 turn, index starts at 0 , escape 13
			int i = index;
			while (i < index + stoneValue) {
				i++;
				if(i > 13) {
					i = 0;
				}
				if (i == 13) {
					stoneValue++;
					continue;
				}
				stoneInPit[i] = stoneInPit[i] + 1;
			}
//			if stone ends in your mancala, player get one more turn
			if(index + stoneValue == 6) {
				turn = true;
			} else { 
//			turn player to player 2
				turn = false;
			}
//			check if the last pit was empty
			if((stoneInPit[index + stoneValue] == 1) && ((index + stoneValue) != 6) && ((index + stoneValue) != 13)){
				int plus = stoneInPit[12 - (index + stoneValue)] + 1;
				stoneInPit[6]= stoneInPit[6] + plus ;
				stoneInPit[index + stoneValue] =0;
				stoneInPit[ 12 - (index + stoneValue)]= 0;
			}
//			check if all pits for player 1 are empty, ends game
			int sum = 0;
			for(int j = 0; j < 6; j++) {
				sum = sum + stoneInPit[j];
			}
			if(sum == 0) {
				for(int k = 7; k < 13; k++) {
					stoneInPit[13] = (stoneInPit[13] + stoneInPit[k]);
				}
				endGame = true;
			}
		} else {
// 			Player 2 turn, index starts at 7, escape index 6
			int i = index;
			while (i < index + stoneValue) {
				i++;
				if(i > 13) {
					i = 0;
				}
				if (i == 7) {
					stoneValue++;
					continue;
				}
				stoneInPit[i]=stoneInPit[i] + 1;
			}
//			if stone ends in your mancala, player get one more turn
			if(index + stoneValue == 13) {
				turn = false;
			} else { 
//			turn player to player 2
				turn = true;
			}
//			check if the last pit was empty
			if((stoneInPit[index + stoneValue] == 1) && ((index + stoneValue) != 6) && ((index + stoneValue) != 13)){
				int plus = stoneInPit[12 - (index + stoneValue)] + 1;
				stoneInPit[13]= stoneInPit[13] + plus ;
				stoneInPit[index + stoneValue] =0;
				stoneInPit[ 12 - (index + stoneValue)]= 0;
			}
//			check if all pits for player 2 are empty, ends game
			int sum = 0;
			for(int j = 7; j < 13; j++) {
				sum = sum + stoneInPit[j];
			}
			if(sum == 0) {
				for(int k = 0; k < 6; k++) {
					stoneInPit[6]= (stoneInPit[6] + stoneInPit[k]);
				}
				endGame = true;
			}
		}
	}
	
	
}
