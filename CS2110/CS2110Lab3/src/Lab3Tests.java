public class Lab3Tests {

	public static void main(String[] args) {
		int whichVersion = 0; // a number such that 0 <= whichVersion < 37
		for (int i = 1; i < 37; ++i) {
			whichVersion = i;
			
//			if (i == 2 || i == 29){
//				String anExpression = "-(3 + 3 ((((((( ((( ))) (( ))";
//				boolean valid = Expression.isValid(whichVersion, anExpression);
//				if (valid) {
//					System.out.println(whichVersion + " - " + anExpression
//							+ " - " + valid);
//				}
//				
//				anExpression = "+(3)";
//				valid = Expression.isValid(whichVersion, anExpression);
//				if (valid) {
//					System.out.println(whichVersion + " - " + anExpression
//							+ " - " + valid);
//				}
//	
//			}
			
			if (!(i == 4 || i == 7 || i == 8 || i == 14 || i == 36 || i == 9 || i == 13 || i == 2 || i == 29 || i == 11 || i == 25 || i == 18)) {

				String anExpression = "3e6";
				boolean valid = Expression.isValid(whichVersion, anExpression);
				if (!valid) {
					System.out.println(whichVersion + " - " + anExpression
							+ " - " + valid);
				}

				anExpression = "1**3";
				valid = Expression.isValid(whichVersion, anExpression);
				if (valid) {
					System.out.println(whichVersion + " - " + anExpression
							+ " - " + valid);
				}

				anExpression = "3+/3";
				valid = Expression.isValid(whichVersion, anExpression);
				if (valid) {
					System.out.println(whichVersion + " - " + anExpression
							+ " - " + valid);
				}

				anExpression = "1";
				valid = Expression.isValid(whichVersion, anExpression);
				if (!valid) {
					System.out.println(whichVersion + " - " + anExpression
							+ " - " + valid);
				}

			}

		}
		System.out.println("Done");
	}
}
