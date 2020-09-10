
public class GameException extends RuntimeException {

	public GameException(String exc) {
		super("Error: " + exc);
	}
	
}