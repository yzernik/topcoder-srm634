/*
 * Solution to 250 point problem.
 */

public class AppleWord {

	private final String apple = "apple";

	public int minRep(String word) {

		String w = word.toLowerCase();

		int[] reps = new int[apple.length()];

		for (int i = 0; i < w.length(); i++) {
			int[] newReps = new int[apple.length()];

			for (int j = 0; j < apple.length(); j++) {
				newReps[j] = -1;
				int x = w.charAt(i) == apple.charAt(j) ? 0 : 1;

				if (i == 0 && j == 0) {
					newReps[j] = x;
				}

				if (i >= 1 && j >= 1 && reps[j - 1] != -1) {
					int a = reps[j - 1] + x;
					newReps[j] = a;
				}

				if (i >= 1 && reps[j] != -1) {
					int b = reps[j] + x;
					if (b < newReps[j] || newReps[j] == -1) {
						newReps[j] = b;
					}
				}

			}
			reps = newReps;
			newReps = new int[apple.length()];
		}

		return reps[apple.length() - 1];
	}
}
