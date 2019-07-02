
public class GuitarString {

	private RingBuffer g1; //global ringbuffer object
	private RingBuffer g2; //global ringbuffer object used in the testing array
	int tics = 0; //

	GuitarString(double frequency) { // create a guitar string of the given frequency, using a sampling rate of
										// 44,100
		g1 = new RingBuffer(44100 / ((int) Math.ceil(frequency)));
		while (g1.isFull() == false)
			g1.enqueue(0);
	}

	GuitarString(double[] init) { // create a guitar string whose size and initial values are given by the array
		g2 = new RingBuffer(init.length);
		while (g2.isFull() == false)
			g2.enqueue(init.length);
	}

	public void pluck() { // set the buffer to white noise
		for (int i = 0; i < g1.cap; i++) {
			// System.out.println(i);
			g1.dequeue();
			g1.enqueue(-0.5 + Math.random());
		}
	}

	public void tic() { // advance the simulation one time step
		g1.enqueue((0.5) * (g1.dequeue() + g1.peek()) * 0.994);
		tics++;
	}

	public double sample() { // return the current sample
		return g1.peek();
	}

	public int time() { // return number of tics
		return tics;
	}

	public static void main(String[] args) {
		/*
		 * GuitarString g = new GuitarString(10); System.out.println(g.g1.size());
		 * g.pluck(); g.tic(); System.out.println(g.sample());
		 * System.out.println(g.time());
		 */ // used for testing
	}

}
