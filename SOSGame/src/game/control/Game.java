package game.control;

import java.util.Random;
import java.util.Scanner;

import game.model.Board;
import game.model.type.CharacterType;

public class Game {
	
	private Board board;
	private GameControl gameControl = new GameControl();
	private Random random = new Random();
	private String playerCharacter;
	private String computerCharacter;
	private int playerScore;
	private int computerScore;
	private boolean turn;
	private int totalSosScore;

	public Game() {
    	turn = random.nextBoolean();
	}
	
	/**
	 * Gets the board size from the console.
	 * Checks if the game panel size the specified size.
	 * Calls the method to create the board and starts the game.
	 */
	public void start() {
		
		int panelSize;
		
		System.out.print("Please enter the panel size. (Should be min 3x3 and max 7x7.): ");
	       
		Scanner scanner = new Scanner(System.in); 
		panelSize = scanner.nextInt();
		
        if (panelSize<3 || panelSize>7) {		//Checks if the game panel size the specified size.
        	System.out.println("Game panel should be min 3x3 and max 7x7.");
        	start();
        }
        else {
        	board = new Board(panelSize);
        	board.gameBoard();
        	System.out.println("\nGAME STARTED");
        }
        
	}
	
	/**
	 * At the beginning of the game, it determines who starts with which letter.
	 */
    public void setPlayersCharacter() {		
    	
    	boolean character;
    	String charS =  CharacterType.CHAR_S.toString();
    	String charO =  CharacterType.CHAR_O.toString();
    	
    	character = random.nextBoolean();
    	
    	this.playerCharacter = (character) ? charS : charO;	
    	this.computerCharacter = (!character) ? charS : charO;
		System.out.println("\nPlayer Character {" + this.playerCharacter + "}"
						+ "\t Computer Character {" + this.computerCharacter + "}");

    }
    
    /**
     * Calls the method to print the panel to the screen.
     * Calls the method to print the scores to the screen.
     */
    public void drawBoard() {
    	this.board.draw();
    	drawScore();
		System.out.println();
    }
    
    /**
     * Prints the scores to the screen.
     */
    private void drawScore() {
		System.out.println("Player Score: " + this.playerScore);
		System.out.println("Computer Score: " + this.computerScore);	 
	}
	
	/**
	 * Controls the actions of the player in the game.
	 */
	public void playerTurn() {		
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int row;
		int column;
		
		System.out.println("·´¯`·.¸. , . .·´¯`·.. > Player's turn \n");
		
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter row number: ");		row = scanner.nextInt()-1;
		System.out.print("Enter column number: ");	column = scanner.nextInt()-1;
	
		if (board.isEmptyCell(row, column)) {		//It checks if the used space is empty.
        	board.setChar(row, column, playerCharacter);
        	board.getEmptyCoordinates().removeIf(p -> { return p.getX() == row && p.getY() == column; });
        	gameControl.isSOS(this); 
        } else {
            System.out.println("The field you entered is full. Enter a new field.");
            playerTurn();
        }
        
    }
		
	/**
	 * Controls the actions of the computer in the game.
	 */
	public void computerTurn() {	
		
		System.out.println("·´¯`·.¸. , . .·´¯`·.. > Computer's turn \n");
		
		try {
			System.out.println("Computer is playing...");
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		int index;
		int emptyCoordinatesSize;
		int row, column;
		
		emptyCoordinatesSize = board.getEmptyCoordinates().size();
		index = (int) (Math.random()*(emptyCoordinatesSize-1));
		
		row = board.getEmptyCoordinates().get(index).getX();
		column = board.getEmptyCoordinates().get(index).getY();
		
		board.setChar(row, column, computerCharacter);
		gameControl.isSOS(this);
		board.getEmptyCoordinates().remove(index);
		System.out.println("Computer played -> row: " + (row+1) + " column: " + (column+1));
		
	}
	
	//Getters and Setters
	public Board getBoard() {
		return board;
	}
	public void setBoard(Board board) {
		this.board = board;
	}

	public String getPlayerCharacter() {
		return playerCharacter;
	}
	public void setPlayerCharacter(String playerCharacter) {
		this.playerCharacter = playerCharacter;
	}

	public String getComputerCharacter() {
		return computerCharacter;
	}
	public void setComputerCharacter(String computerCharacter) {
		this.computerCharacter = computerCharacter;
	}

	public int getPlayerScore() {
		return playerScore;
	}
	public void setPlayerScore(int playerScore) {
		this.playerScore = playerScore;
	}

	public int getComputerScore() {
		return computerScore;
	}
	public void setComputerScore(int computerScore) {
		this.computerScore = computerScore;
	}
	
	public boolean isTurn() {
		return turn;
	}
	public void setTurn(boolean turn) {
		this.turn = turn;
	}

	public int getTotalSosScore() {
		return totalSosScore;
	}
	public void setTotalSosScore(int totalSosScore) {
		this.totalSosScore = totalSosScore;
	}
	
}
