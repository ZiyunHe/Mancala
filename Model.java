import java.util.ArrayList;

public class Model {
	private ArrayList<Integer> pits;
//	turn: true: player 1, false: player2
	private boolean turn;
	private boolean endGame;
	public Model(int stoneValue) {
		turn = true;
		pits = new ArrayList<Integer>();
		for (int i = 0; i < 14; i++) {
			pits.add(stoneValue);
		}
		endGame = false;
	}
	public boolean getTurn() {
		return turn;
	}
	public void move(int index, boolean turn) {
		int stoneValue = pits.get(index);
		pits.set(index, 0);
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
				pits.set(i,pits.get(i) + 1);
			}
//			if stone ends in your mancala, player get one more turn
			if(index + stoneValue == 6) {
				turn = true;
			} else { 
//			turn player to player 2
				turn = false;
			}
//			check if the last pit was empty
			if((pits.get(index + stoneValue) == 1) && ((index + stoneValue) != 6) && ((index + stoneValue) != 13)){
				int plus = pits.get(12 - (index + stoneValue)) + 1;
				pits.set(6, pits.get(6) + plus );
				pits.set(index + stoneValue, 0);
				pits.set( 12 - (index + stoneValue), 0);
			}
//			check if all pits for player 1 are empty, ends game
			int sum = 0;
			for(int j = 0; j < 6; j++) {
				sum = sum + pits.get(j);
			}
			if(sum == 0) {
				for(int k = 7; k < 13; k++) {
					pits.set(13, (pits.get(13) + pits.get(k)));
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
				pits.set(i,pits.get(i) + 1);
			}
//			if stone ends in your mancala, player get one more turn
			if(index + stoneValue == 13) {
				turn = false;
			} else { 
//			turn player to player 2
				turn = true;
			}
//			check if the last pit was empty
			if((pits.get(index + stoneValue) == 1) && ((index + stoneValue) != 6) && ((index + stoneValue) != 13)){
				int plus = pits.get(12 - (index + stoneValue)) + 1;
				pits.set(13, pits.get(13) + plus );
				pits.set(index + stoneValue, 0);
				pits.set( 12 - (index + stoneValue), 0);
			}
//			check if all pits for player 2 are empty, ends game
			int sum = 0;
			for(int j = 7; j < 13; j++) {
				sum = sum + pits.get(j);
			}
			if(sum == 0) {
				for(int k = 0; k < 6; k++) {
					pits.set(6, (pits.get(6) + pits.get(k)));
				}
				endGame = true;
			}
		}
	}
	
	
}
