
public class TestGame {


	public static void main (String[] args) {

		ConnectGame prog = new ConnectGame();
		//prog.addGUI();
		// --------------- Test 1 --------------- [initialization and getElement)

		boolean test1Success = false;
		
		boolean t0 = false, t1 = false, t2 = false;

		if (prog.getElement(0, 0).equals("empty") && prog.getElement(5, 6).equals("empty")) {
			t0 = true;
		}
		try {
			prog.getElement(-1, 3);
		} catch (GameException e) {
			t1 = true;
		}
		try {
			prog.getElement(6, 5);
		} catch (GameException e) {
			t2 = true;
		}
		
		if (t0 && t1 && t2) {
			test1Success = true;
		}

		if (test1Success) {
			System.out.println("Test 1 passed");
		} else {
			System.out.println("Test 1 failed");
		}


		// --------------- Test 2 --------------- [dropChecker]

		partialGame0(prog);
		
		boolean test2Success = false;
		
		if (prog.getElement(5, 2).equals("red") && prog.getElement(4, 2).equals("red") && prog.getElement(3, 4).equals("blue")) {
			test2Success = true;
		}

		if (test2Success) {
			System.out.println("Test 2 passed");
		} else {
			System.out.println("Test 2 failed");
		}

		// --------------- Test 3 --------------- [dropChecker exceptions]

		boolean test3Success = false;
		
		t0 = t1 = false;
		prog.dropChecker(4, "red");
		prog.dropChecker(4, "blue");
		prog.dropChecker(4, "red");
		try {
			prog.dropChecker(4, "blue");
		} catch (GameException e) {
			t0 = true;
		}
		try {
			prog.dropChecker(7, "red");
		} catch (GameException e) {
			t1 = true;
		}

		if (t0 && t1) {
			test3Success = true;
		}
		
		if (test3Success) {
			System.out.println("Test 3 passed");
		} else {
			System.out.println("Test 3 failed");
		}


		// --------------- Test 4 --------------- [horizontal win]

		t0 = t1 = false;
		boolean test4Success = false;
		
		prog = new ConnectGame();
		//prog.addGUI();
		if (!prog.checkWin("blue")) {
			t0 = true;
		}
		partialGame1(prog);
		prog.dropChecker(5, "blue");
		if (prog.checkWin("blue")) {
			t1 = true;
		}
		
		if (t0 && t1) {
			test4Success = true;
		}
		

		if (test4Success) {
			System.out.println("Test 4 passed");
		} else {
			System.out.println("Test 4 failed");
		}

		// --------------- Test 5 --------------- [vertical win]

		t0 = t1 = false;
		boolean test5Success = false;
		
		prog = new ConnectGame();
		//prog.addGUI();
		if (!prog.checkWin("red")) {
			t0 = true;
		}
		partialGame1(prog);
		prog.dropChecker(5, "red");
		prog.dropChecker(6, "blue");
		prog.dropChecker(5, "red");
		if (prog.checkWin("red")) {
			t1 = true;
		}
		
		if (t0 && t1) {
			test5Success = true;
		}

		if (test5Success) {
			System.out.println("Test 5 passed");
		} else {
			System.out.println("Test 5 failed");
		}


		// --------------- Test 6 --------------- [diagonal up win]

		t0 = t1 = false;
		boolean test6Success = false;
		
		prog = new ConnectGame();
		//prog.addGUI();
		if (!prog.checkWin("red")) {
			t0 = true;
		}

		partialGame1(prog);
		prog.dropChecker(3, "red");
		if (prog.checkWin("red")) {
			t1 = true;
		}
		
		if (t0 && t1) {
			test6Success = true;
		}
		
		

		if (test6Success) {
			System.out.println("Test 6 passed");
		} else {
			System.out.println("Test 6 failed");
		}

		// --------------- Test 7 --------------- [diagonal down win]

		t0 = t1 = false;
		boolean test7Success = false;
		
		prog = new ConnectGame();
		//prog.addGUI();
		if (!prog.checkWin("blue")) {
			t0 = true;
		}
		partialGame1(prog);
		
		prog.dropChecker(1, "blue");
		prog.dropChecker(0, "red");
		prog.dropChecker(2, "blue");
		if (prog.checkWin("blue")) {
			t1 = true;
		}
		
		if (t0 && t1) {
			test7Success = true;
		}

		if (test7Success) {
			System.out.println("Test 7 passed");
		} else {
			System.out.println("Test 7 failed");
		}


		// --------------- Test 8 --------------- [play after a win]

		boolean test8Success = false;

		prog = new ConnectGame();
		//prog.addGUI();

		partialGame1(prog);
		prog.dropChecker(5, "blue");
		try {
			prog.dropChecker(1, "red");
		} catch (GameException e) {
			test8Success = true;
		}
		
		if (test8Success) {
			System.out.println("Test 8 passed");
		} else {
			System.out.println("Test 8 failed");
		}

	}
	
	
	public static void partialGame0 (ConnectGame game) {
		game.dropChecker(5, "red");
		game.dropChecker(3, "blue");
		game.dropChecker(2, "red");
		game.dropChecker(1, "blue");
		game.dropChecker(3, "red");
		game.dropChecker(4, "blue");
		game.dropChecker(0, "red");
		game.dropChecker(4, "blue");
		game.dropChecker(0, "red");
		game.dropChecker(4, "blue");
		game.dropChecker(2, "red");
		game.dropChecker(5, "blue");
	}

	public static void partialGame1 (ConnectGame game) {
		game.dropChecker(0, "red");
		game.dropChecker(2, "blue");
		game.dropChecker(2, "red");
		game.dropChecker(4, "blue");
		game.dropChecker(3, "red");
		game.dropChecker(1, "blue");
		game.dropChecker(3, "red");
		game.dropChecker(4, "blue");
		game.dropChecker(6, "red");
		game.dropChecker(3, "blue");
		game.dropChecker(1, "red");
		game.dropChecker(0, "blue");
		
		game.dropChecker(2, "red");
		game.dropChecker(1, "blue");
		game.dropChecker(0, "red");
		game.dropChecker(4, "blue");
		game.dropChecker(5, "red");
		game.dropChecker(6, "blue");
		game.dropChecker(4, "red");
		game.dropChecker(6, "blue");
		game.dropChecker(5, "red");
		game.dropChecker(1, "blue");
	}

}
