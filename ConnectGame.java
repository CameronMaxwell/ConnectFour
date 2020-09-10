
public class ConnectGame {
	
	private DoubleList<DoubleList<String>> matrix;
	private final int WIDTH = 7;
	private final int HEIGHT = 6;
	private GUI gui;
	private boolean isGameActive;
	
	public ConnectGame () {

		matrix = new DoubleList<DoubleList<String>>();

		int i, j;
		
		for (j = 0; j < HEIGHT; j++) {
			DoubleList<String> list = new DoubleList<String>();
			for (i = 0; i < WIDTH; i++) {
				list.addToRear("empty");
			}
			matrix.addToRear(list);
			
		}
		
		isGameActive = true;
		
	}
	

	public void addGUI () {
		gui = new GUI(HEIGHT, WIDTH);
	}
	
	
	public boolean checkWin (String colour) {
		
		// A win is 4 checkers of the same colour in a sequence, either horizontally, vertically, or diagonally in either direction.
		
		if (checkHorizontal(colour) || checkVertical(colour) || checkDiagonalUp(colour) || checkDiagonalDown(colour)) {
			//System.out.println(colour + " won the game!");
			
			// Once someone wins, the game is no longer active.
			isGameActive = false;
			return true;
		}


		return false;
	}
	
	
	
	private boolean checkHorizontal (String colour) {
		DoubleList<String> rowList;
		String nodeValue;
		int currRunNum = 0;
		int maxRun = 0;
		
		for (int i = 0; i < HEIGHT; i++) {
			currRunNum = 0; // Reset the current run for each column.
			rowList = matrix.getElement(i);
		
			for (int j = 0; j < WIDTH; j++) {
				nodeValue = rowList.getElement(j);
				if (nodeValue.equals(colour)) {
					currRunNum++; // Increment counter.
					if (currRunNum > maxRun) maxRun = currRunNum;
				} else {
					currRunNum = 0; // Reset counter to 0.
				}
				
				// If a run of 4 or more occurs, then return true.
				if (currRunNum >= 4) {
					return true;
				}
	
			}
		}

		return false;
	}
	
	
	
	
	
	private boolean checkVertical (String colour) {
		
		DoubleList<String> colList;
		String nodeValue;
		int currRunNum = 0;
		int maxRun = 0;
		
		for (int j = 0; j < WIDTH; j++) {
			currRunNum = 0; // Reset the current run for each column.
			
			for (int i = 0; i < HEIGHT; i++) {
				colList = matrix.getElement(i);
				nodeValue = colList.getElement(j);
				if (nodeValue.equals(colour)) {
					currRunNum++; // Increment counter.
					
					if (currRunNum > maxRun) maxRun = currRunNum;
					
				} else {
					currRunNum = 0; // Reset counter to 0.
				}
				
				// If a run of 4 or more occurs, then return true.
				if (currRunNum >= 4) {
					return true;
				}
	
			}
		}

		return false;
	}
	
	
	
	private boolean checkDiagonalUp (String colour) {
		
		// Starting cell (bottom-left-most cell) of an "up" diagonal can only be in the lower-left 4x3 partition.
		DoubleList<String> rowList;
		String nodeValue;
		int currRunNum = 0;
		int maxRun = 0;
		
		DoubleList<String> tmpRow;
		String tmpCol;
		
		for (int j = HEIGHT-1; j > 2; j--) {
			rowList = matrix.getElement(j);
			for (int i = 0; i < 4; i++) {
				
				currRunNum = 0;
				
				nodeValue = rowList.getElement(i);

				if (nodeValue.equals(colour)) {
					
					currRunNum = 1;
					
					int p = j - 1; // Row above.
					int q = i + 1; // Column to the right.
					
					for (int d = 0; d < 3; d++) {
						
						tmpRow = matrix.getElement(p);
						tmpCol = tmpRow.getElement(q);
						
						if (tmpCol.equals(colour)) {
							// If diagonal cell has the same colour, then increment the run counter.
							currRunNum++;
							if (currRunNum > maxRun) maxRun = currRunNum;

						} else {
							// If diagonal cell does not have the same colour, then break the loop here.
							break;
						}

						p = p - 1; // Row above.
						q = q + 1; // Column to the right.
					}
					
					
					// If a run of 4 or more occurs, then return true.
					if (currRunNum >= 4) {
						return true;
					}

				}

			}
		}
		
		return false;
	}
	
	
	
	private boolean checkDiagonalDown (String colour) {

		// Starting cell (top-left-most cell) of a "down" diagonal can only be in the upper-left 4x3 partition.
		DoubleList<String> rowList;
		String nodeValue;
		int currRunNum = 0;
		int maxRun = 0;
		
		DoubleList<String> tmpRow;
		String tmpCol;
		
		for (int j = 0; j < 3; j++) {
			rowList = matrix.getElement(j);
			for (int i = 0; i < 4; i++) {

				currRunNum = 0;
				
				nodeValue = rowList.getElement(i);

				if (nodeValue.equals(colour)) {
					
					currRunNum = 1;
					
					int p = j + 1; // Row below.
					int q = i + 1; // Column to the right.
					for (int d = 0; d < 3; d++) {
						
						tmpRow = matrix.getElement(p);
						tmpCol = tmpRow.getElement(q);
						
						if (tmpCol.equals(colour)) {
							// If diagonal cell has the same colour, then increment the run counter.
							currRunNum++;
							if (currRunNum > maxRun) maxRun = currRunNum;

						} else {
							// If diagonal cell does not have the same colour, then break the loop here.
							break;
						}

						p = p + 1; // Row below.
						q = q + 1; // Column to the right.
					}
					
					// If a run of 4 or more occurs, then return true.
					if (currRunNum >= 4) {
						return true;
					}
					
				}
			}
		}
		
		
		return false;
	}
	
	private void setElement (int row, int col, String newValue) {
		DoubleList<String> list = matrix.getElement(row);
		
		list.getNode(col).setElement(newValue);
		
		if (gui != null) {
			gui.updateBoard(row, col, newValue);
		}
	}
	
	public String getElement (int row, int col) {
		
		if (col < 0 || col >= WIDTH || row < 0 || row >= HEIGHT) {
			throw new GameException("Invalid row/column");
		}
		
		DoubleList<String> list = matrix.getElement(row);
		
		return list.getNode(col).getElement();
	}
	
	public void dropChecker (int column, String colour) {
		
		if (!isGameActive) {
			throw new GameException("The game already ended.");
		}
		
		if (checkFullBoard()) {
			isGameActive = false;
			throw new GameException("The game is a draw!");
		}
		
		if (column < 0 || column >= WIDTH) {
			throw new GameException("Invalid column");
		}
		
		// Find the lowest open cell in the given column for the checker to fall into.
		DoubleList<String> colList;
		boolean found = false;
		String nodeValue;
		int openRow = -1;
		
		for (int i = HEIGHT - 1; i >= 0 && !found; i--) {
			colList = matrix.getElement(i);
			nodeValue = colList.getNode(column).getElement();
			if (nodeValue.equals("empty")) {
				found = true;
				openRow = i;
			}
		}
		
		if (openRow != -1) {
			setElement(openRow, column, colour);
			
			checkWin(colour);
			
		} else {
			throw new GameException("Full column");
		}
		
		
	}
	
	
	private boolean checkFullBoard () {
		int i, j;
		DoubleList<String> list;
		String el;
		for (j = 0; j < HEIGHT; j++) {
			list = matrix.getElement(j);
			for (i = 0; i < WIDTH; i++) {
				el = list.getElement(i);
				// If even one element is still "empty", the board is not full.
				if (el.equals("empty")) {
					return false;
				}
			}
		}
		return true;
	}

}
