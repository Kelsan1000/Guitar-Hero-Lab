
public class GuitarHero {

	public static void main(String[] args) {

		// creates an array of GuitarStrings
		GuitarString[] guitar = new GuitarString[37];
		// intended keys to use as notes
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";

		/*
		 * This for loop is to fill in the array of GuitarStrings with frequency values
		 */
		for (int i = 0; i < 37; i++) {
			guitar[i] = new GuitarString(440 * Math.pow(1.05956, (i - 24)));
		}
		while (true) {
			// Checks if the user has typed in a key or not
			if (StdDraw.hasNextKeyTyped()) {
				char key = StdDraw.nextKeyTyped();
				if (keyboard.contains(Character.toString(key))) {
					int letter = keyboard.indexOf(key);
					guitar[letter].pluck();
				}
			}
			double sample = 0;
			// compute the superposition of samples
			for (int j = 0; j < 37; j++) {
				sample = sample + guitar[j].sample();
			}
			// plays the sample audio
			StdAudio.play(sample);

			// advance the simulation of each guitar string by one step
			for (int k = 0; k < 37; k++) {
				guitar[k].tic();
			}
		}
	}

}
