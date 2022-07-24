package game.model;

import java.util.ArrayList;
import java.util.List;

import game.model.type.CharacterType;

public class Board {
	
	private int panelSize;
	private String[][] board;
	private List<Point> emptyCoordinates;

	public Board(int panelSize) {
		this.panelSize = panelSize;
	}
	
	/**
	 * Creates the game panel. 
	 * Fills the all place in the game panel with question mark character.
	 */
	public void gameBoard() {	
		
		String charQuestionMark =  CharacterType.CHAR_QUESTION_MARK.toString();
		
    	this.board = new String[this.panelSize][this.panelSize];
    	this.emptyCoordinates = new ArrayList<>();
        for (int i=0; i<this.panelSize; i++) {
        	for (int j=0; j<this.panelSize; j++) {
        		board[i][j] = charQuestionMark;
        		this.emptyCoordinates.add(new Point(i,j)) ;
        	}
        }
       
    }
	
	/**
	 * Prints the panel to the screen.
	 */
	public void draw() {	
		
		System.out.println();
		int i;
		
		System.out.print("   ");
		
		for(i=0; i<this.panelSize; i++)
			System.out.printf(" %d ",i+1);
		
		System.out.println();
		
		i=0;
		for (String[] array1 : this.board) {
			System.out.printf(" %d ",i+1);
            for (String array2 : array1) {
                System.out.print(array2);
            }
            System.out.println();
            i++;
        }
	
    }
	
	/**
	 * Checks if desired cell is empty.
	 */
	public boolean isEmptyCell(int row, int column) {
    	boolean result = false;
    	String charQuestionMark = CharacterType.CHAR_QUESTION_MARK.toString();
        if (board[row][column].equals(charQuestionMark));
            result = true;

        return result;  
    }
	
	/**
	 * Returns the character of the cell in the desired row and column.
	 */
	public String getChar(int row, int column) {
		return this.board[row][column];
	}
	
	/**
	 * Sets the desired character to the cell in the desired row and column.
	 */
	public void setChar(int row, int column, String character) {
		this.board[row][column] = character;
	}
	
	//Getters and Setters
	public int getPanelSize() {
		return panelSize;
	}
	public void setPanelSize(int panelSize) {
		this.panelSize = panelSize;
	}

	public String[][] getBoard() {
		return board;
	}
	public void setBoard(String[][] board) {
		this.board = board;
	}

	public List<Point> getEmptyCoordinates() {
		return emptyCoordinates;
	}

}
