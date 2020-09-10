
public class TestDLL {

	public static void main (String[] args) {


		// --------------- Test 1 --------------- [constructor and toString]
		
		boolean test1Success = false;
		
		DoubleList<Integer> intList = new DoubleList<Integer>();
		
		if (intList.toString().equals("Empty list")) {
			test1Success = true;
		}

		if (test1Success) {
			System.out.println("Test 1 passed");
		} else {
			System.out.println("Test 1 failed");
		}


		// --------------- Test 2 --------------- [addToRear and toString]

		boolean test2Success = false;
		
		for (int i = 20; i >= 10; i-=2) {
			intList.addToRear(i);
		}

		if (intList.toString().trim().equals("20 18 16 14 12 10")) {
			test2Success = true;
		}

		if (test2Success) {
			System.out.println("Test 2 passed");
		} else {
			System.out.println("Test 2 failed");
		}

		// --------------- Test 3 --------------- [setNode]

		boolean test3Success = false;
		
		intList.setElement(1, 32);
		intList.setElement(3, 7);
		intList.setElement(4, 15);
		intList.setElement(5, 41);

		if (intList.toString().trim().equals("20 32 16 7 15 41")) {
			test3Success = true;
		}

		if (test3Success) {
			System.out.println("Test 3 passed");
		} else {
			System.out.println("Test 3 failed");
		}


		// --------------- Test 4 --------------- [getNode]

		boolean test4Success = false;
		
		DoubleNode<Integer> n0 = intList.getNode(0);
		DoubleNode<Integer> n1 = intList.getNode(2);
		DoubleNode<Integer> n2 = intList.getNode(5);
		
		if (n0.getElement().equals(20) && n1.getElement().equals(16) && n2.getElement().equals(41)) {
			test4Success = true;
		}

		if (test4Success) {
			System.out.println("Test 4 passed");
		} else {
			System.out.println("Test 4 failed");
		}

		// --------------- Test 5 --------------- [getNode exceptions]

		boolean test5Success = false;
		boolean t1 = false, t2 = false;
		
		try {
			intList.getNode(-1);
		} catch (DoubleListException e) {
			t1 = true;
		}
		try {
			intList.getNode(6);
		} catch (DoubleListException e) {
			t2 = true;
		}
		if (t1 && t2) {
			test5Success = true;
		}

		if (test5Success) {
			System.out.println("Test 5 passed");
		} else {
			System.out.println("Test 5 failed");
		}


		// --------------- Test 6 --------------- [traverseForwards]

		boolean test6Success = false;
		
		n0 = intList.traverseForwards(0);
		n1 = intList.traverseForwards(1);
		n2 = intList.traverseForwards(4);
		if (n0.getElement().equals(20) && n1.getElement().equals(32) && n2.getElement().equals(15)) {
			test6Success = true;
		}

		if (test6Success) {
			System.out.println("Test 6 passed");
		} else {
			System.out.println("Test 6 failed");
		}

		// --------------- Test 7 --------------- [traverseBackwards]

		boolean test7Success = false;
		
		n0 = intList.traverseBackwards(0);
		n1 = intList.traverseBackwards(3);
		n2 = intList.traverseBackwards(5);
		if (n0.getElement().equals(41) && n1.getElement().equals(16) && n2.getElement().equals(20)) {
			test7Success = true;
		}

		if (test7Success) {
			System.out.println("Test 7 passed");
		} else {
			System.out.println("Test 7 failed");
		}

	}
	
}
