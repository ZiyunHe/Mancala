import java.util.ArrayList;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Model {
	
	private int[] stoneInPit;
	private int[] history;
	private ArrayList<ChangeListener> listeners;
	private int player=1;
	private String winner;
	private int[] playerUndoCount;
	private boolean canUndo= false;
	private int prevPlayer = 2;
	
	
	public Model() {
		listeners = new ArrayList<ChangeListener> ();
		
		stoneInPit = new int[14];
		history = new int[14];
		playerUndoCount = new int[]{-1,3,3};
		
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
			if (i==6 || i==13) {
				stoneInPit[i]= 0;
			}else {
			stoneInPit[i]= stoneNum;
			}
			
		}
		for (int i=0;i<14;i++) {
			history[i] = stoneInPit[i];
		}
		changeListener();
		
	}
	
	public void saveHistory() {
		for (int i=0;i<14;i++) 
			history[i] = stoneInPit[i];
	}
	
	public int getStoneInPits(int pitNum) {
		return stoneInPit[pitNum];
	} 
	
	public int getPlayer() {
		return player;
	}

	
	public void play(int chosenPit) {
		
	      
		canUndo= true;
		
		int stoneNum = stoneInPit[chosenPit] ;
		int stoneNumCopy = stoneInPit[chosenPit] ;
		int chosenPitCopy = chosenPit;
		
		if(stoneNumCopy >0) {
			stoneInPit[chosenPit] = 0;
			
				while (stoneNumCopy >0) {
					chosenPitCopy++;
					if(player==1) {
						if (chosenPitCopy == 13) {
							chosenPitCopy = -1;
							continue;
						}
					}
					if(player==2) {
						if (chosenPitCopy == 13) {
							stoneNumCopy--;
							stoneInPit[chosenPitCopy] = stoneInPit[chosenPitCopy]+1 ;
							
							chosenPitCopy = -1;
							continue;
							
						}
						if (chosenPitCopy == 6) {
							continue;
						}
					}
					stoneInPit[chosenPitCopy] = stoneInPit[chosenPitCopy]+1 ;
					stoneNumCopy--;
				}
				if(chosenPitCopy==-1)
					chosenPitCopy=13;
				if (stoneInPit[chosenPitCopy] ==1 && chosenPitCopy !=6 && chosenPitCopy != 13) {
					if (player ==1 && chosenPitCopy<6) {
						stoneInPit[6] += stoneInPit[12-chosenPitCopy]+1;
						stoneInPit[chosenPitCopy]=0;
						stoneInPit[12-chosenPitCopy]=0;
					}
					if (player ==2 && chosenPitCopy>6) {
						stoneInPit[13] += stoneInPit[12-chosenPitCopy]+1;
						stoneInPit[chosenPitCopy]=0;
						stoneInPit[12-chosenPitCopy]=0;
					}
				}
				if(player == 1 ) {
					if (chosenPit+stoneNum == 19 || chosenPit+ stoneNum ==6 ) {
						prevPlayer = 1; 
						player =1;
					}
					else {
						
						prevPlayer = 1;
						player =2;
					}
				}
				else {
					if (chosenPit+stoneNum == 26 || chosenPit+ stoneNum ==13 ) {
						prevPlayer = 2; 
						player =2;
					}
					else {
						prevPlayer = 2;
						player =1;
					}	
				}
				if(player!= prevPlayer)
					playerUndoCount[player]=  3;
				
				changeListener();
			}	
	}
	
	
	
	
	public boolean isFinish() {
		int sum1=0;
		int sum2=0;
		for(int i=0; i<6; i++ ) 
			sum1+= stoneInPit[i];
		
		for(int i=7; i<13; i++ ) 
			sum2+= stoneInPit[i];
		
		if (sum1==0) { 
			for(int i=0;i<3;i++)
				playerUndoCount[i]=0;
			for(int i=7; i<13; i++ ) 
				stoneInPit[i]=0;
			stoneInPit[13]+=sum2;
			
			if(stoneInPit[13]>stoneInPit[6])
				winner = "the Winer is player B";
			if(stoneInPit[13]==stoneInPit[6])
				winner = "the game is tied";
			if(stoneInPit[13]<stoneInPit[6]) 	
				winner = "the Winer is player A";
			changeListener();
			return true;
		}	
		
		if (sum2==0) { 
			for(int i=0;i<3;i++)
				playerUndoCount[i]=0;
			for(int i=0; i<6; i++ ) 
				stoneInPit[i]=0;
			stoneInPit[6]+=sum1;
			
			if(stoneInPit[13]>stoneInPit[6])
				winner = "the Winer is player B";
			if(stoneInPit[13]==stoneInPit[6])
				winner = "the game is tied";
			if(stoneInPit[13]<stoneInPit[6]) 
				winner = "the Winer is player A";
			
			changeListener();
			return true;
		}	
		return false;
	}
	
	public String getWiner() {
		return winner;
	}
	
	public void undo() {
		
		if(canUndo && playerUndoCount[prevPlayer] > 0) {
			
			canUndo= false;
			playerUndoCount[prevPlayer] -=1;
			player = prevPlayer;
			
			for (int i =0; i<14; i++) {
				stoneInPit[i]=history[i];
			}
			changeListener();
		}
	}
	
	public int getUndoCount() {
		return playerUndoCount[player];
	}
	
	
}
