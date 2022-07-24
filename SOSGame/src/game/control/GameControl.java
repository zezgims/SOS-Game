package game.control;

import game.model.Board;
import game.model.type.CharacterType;

public class GameControl {
	
	/**
	 * S O S checks if there is any.
	 */
	public void isSOS(Game game) {
    	
		Board board = game.getBoard();
		int panelSize = game.getBoard().getPanelSize();
		
		String charS =  CharacterType.CHAR_S.toString();
    	String charO =  CharacterType.CHAR_O.toString();
    	
		int horizantalScore = 0;
    	int verticalScore = 0;
    	int diagonalScore = 0;
    	int newTotalScore;
    	int score;
    	 
    	//Horizantal control
        for (int i=0; i<panelSize; i++) {
            for (int j=0; j<panelSize-2; j++) {
                if (board.getChar(i,j).equals(charS) && board.getChar(i,j+1).equals(charO) && board.getChar(i,j+2).equals(charS)) {
                    horizantalScore++;
                }
            }
        }
        
        //Vertical control
        for (int i=0; i<panelSize-2; i++) {
            for (int j=0; j<panelSize; j++) {
                if (board.getChar(i,j).equals(charS) && board.getChar(i+1,j).equals(charO) && board.getChar(i+2,j).equals(charS)) {
                    verticalScore++;
                }
            }
        }
        
        //Diagonal control
        for (int i = 0; i <panelSize - 2; i++) {
            for (int j = 0; j <panelSize - 2; j++) {
                if (board.getChar(i,j).equals(charS) && board.getChar(i+1,j+1).equals(charO) && board.getChar(i+2,j+2).equals(charS)) {
                    diagonalScore++;
                }
            }
        }
        for (int i = 0; i <panelSize - 2; i++) {
            for (int j =panelSize - 1; j > 1; j--) {
                if (board.getChar(i,j).equals(charS) && board.getChar(i+1,j-1).equals(charO) && board.getChar(i+2,j-2).equals(charS)) {
                    diagonalScore++;
                }
            }
        }
        
        newTotalScore = verticalScore + horizantalScore + diagonalScore;
        if (game.getTotalSosScore() != newTotalScore) {
            score = newTotalScore - game.getTotalSosScore();
            game.setTotalSosScore(newTotalScore);
            if (game.isTurn()) {
            	game.setPlayerScore(game.getPlayerScore() + score);
            	System.out.println("\nPlayer got score!");
            }
            else {
            	game.setComputerScore(game.getComputerScore() + score);
            	System.out.println("\nComputer got score!");
            }
        }
    	else 
    		game.setTurn(!game.isTurn());
    	
    }
	
	/**
	 * Checks if the game is over.
	 */
	public boolean isGameFinished(Game game) {
	    
	    if (game.getBoard().getEmptyCoordinates().size() == 0) {
	        System.out.println("GAME OVER.");
	        System.out.println("WINNER IS : " + winner(game));
	        return true;
	    }
	    
	    return false;
	}
	
	/**
	 * Determines the winner of the game.
	 */
	private String winner(Game game) {
    	
    	if(game.getPlayerScore() > game.getComputerScore())			
    		return "Player";
    	else if(game.getPlayerScore() < game.getComputerScore())		
    		return "Computer";
    	else												
    		return "Draw";
       
    }
	
}
