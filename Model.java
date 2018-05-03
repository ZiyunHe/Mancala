import java.util.ArrayList;

public class Model {
    private ArrayList<Integer> pits;
    // pits history
    private ArrayList<Integer> pitsHistory;
    //	turn: true: player 1, false: player2
    private boolean turn;
    private boolean endGame;
    // Keep track of undo
    private boolean canUndo;
    private int[] undoTimes;
    private int numberOfStones = 3;
    private int designStyle = 1;

    public Model() {
        turn = true;
        pits = new ArrayList<Integer>();
        endGame = false;
        undoTimes = new int[] {3,3};
        for (int i = 0; i < 13; i++) {
            pits.add(numberOfStones);
        }
    }
    
    public void setNumberOfStones(int n) {
    		numberOfStones = n;
    		for (int i = 0; i < 14; i++) {
            pits.add(numberOfStones);
        }
    }
    
    public int getNumberOfStones() {
    		return numberOfStones;
    }
    
    public void setDesignStyle(int n) {
		designStyle = n;
    }

	public Design getDesignStyle() {
		if(designStyle == 1) {
			return new DesignOne();
		}
		return new DesignTwo();
	}

    public boolean getTurn() {
        return turn;
    }
    

    public void move(int index) {
        //int numberOfStones = pits.get(index);
    	System.out.println(index);
        pits.set(index, 0);
        if (turn) {
            //			Player 1 turn, index starts at 0 , escape 13
            int i = index;
            while (i < index + numberOfStones) {
                i++;
                if (i > 13) {
                    i = 0;
                }
                if (i == 13) {
                    numberOfStones++;
                    continue;
                }
                pits.set(i, pits.get(i) + 1);
            }
            // save pits history for undo
            saveHistory();
            //			if stone ends in your mancala, player get one more turn
            if (index + numberOfStones == 6) {
                turn = true;
            } else {
                //			turn player to player 2
                turn = false;
            }
            //			check if the last pit was empty
            if ((pits.get(index + numberOfStones) == 1) && ((index + numberOfStones) != 6) && ((index + numberOfStones) != 13)) {
                int plus = pits.get(12 - (index + numberOfStones)) + 1;
                pits.set(6, pits.get(6) + plus);
                pits.set(index + numberOfStones, 0);
                pits.set(12 - (index + numberOfStones), 0);
            }
        } else {
            // 			Player 2 turn, index starts at 7, escape index 6
            int i = index;
            while (i < (index + numberOfStones - 1)) {
                i++;
                if (i > 13) {
                    i = 0;
                }
                if (i == 7) {
                    numberOfStones++;
                    continue;
                }
                pits.set(i, pits.get(i) + 1);
            }
            // save pits history for undo
            saveHistory();
            //			if stone ends in your mancala, player get one more turn
            if (index + numberOfStones == 13) {
                turn = false;
            } else {
                //			turn player to player 2
                turn = true;
            }
            //			check if the last pit was empty
            if ((pits.get(index + numberOfStones) == 1) && ((index + numberOfStones) != 6) && ((index + numberOfStones) != 13)) {
                int plus = pits.get(12 - (index + numberOfStones)) + 1;
                pits.set(13, pits.get(13) + plus);
                pits.set(index + numberOfStones, 0);
                pits.set(12 - (index + numberOfStones), 0);
            }
            //			check if all pits for player 2 are empty, ends game
            int sum = 0;
            for (int j = 7; j < 13; j++) {
                sum = sum + pits.get(j);
            }
            if (sum == 0) {
                for (int k = 0; k < 6; k++) {
                    pits.set(6, (pits.get(6) + pits.get(k)));
                }
                endGame = true;
            }
        }
        //checkWin(turn);
    }

    public void checkWin(boolean player1){
        if(player1){
            //			check if all pits for player 1 are empty, ends game
            int sum = 0;
            for (int j = 0; j < 6; j++) {
                sum = sum + pits.get(j);
            }
            if (sum == 0) {
                for (int k = 7; k < 13; k++) {
                    pits.set(13, (pits.get(13) + pits.get(k)));
                }
                endGame = true;
            }
        } else {
             //			check if all pits for player 2 are empty, ends game
            int sum = 0;
            for (int j = 7; j < 13; j++) {
                sum = sum + pits.get(j);
            }
            if (sum == 0) {
                for (int k = 0; k < 6; k++) {
                    pits.set(6, (pits.get(6) + pits.get(k)));
                }
                endGame = true;
            }
        }
    }
    
    public void saveHistory(){
        this.pitsHistory = pits;
        this.canUndo = true;
    }
    public void undo(boolean player){
        this.canUndo = false;
        this.pits = this.pitsHistory;
        if(player){
            undoTimes[0]--;
        } else{
            undoTimes[1]--;
        }
    }
    public int getUndo(boolean player){
        if(player){
            return undoTimes[0];
        } else return undoTimes[1];
    }
}
