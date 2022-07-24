package game.model.type;

public enum CharacterType {
	
	CHAR_S(" S "), 
	CHAR_O(" O "),
	CHAR_QUESTION_MARK(" ? ");
	
	private String character;
	
	CharacterType(String character) {
		this.character = character;
	}
	
	@Override
	public String toString() {
		return character;
	}
	
}
