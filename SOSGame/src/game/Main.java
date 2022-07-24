package game;

import game.control.Game;
import game.control.GameControl;

public class Main {
	    
	public static void main(String[] args) {
		
		System.out.println("WELCOME TO SOS GAME");
		
		Game game = new Game();
		GameControl gameControl = new GameControl();
		
		game.start();
		game.setPlayersCharacter();
		game.drawBoard();
		
		while (!gameControl.isGameFinished(game)) {
			if(game.isTurn()) {
				game.playerTurn();
				game.drawBoard();	
			}
			else {
				game.computerTurn();
				game.drawBoard();	
			}	
		}
 
	}

}
