
public class RingBuffer {

	int size;
	double[] buffer;
	int cap;
	int first;
	int last;

	/**
	 * 
	*/
	RingBuffer(int capacity) { // create an empty ring buffer, with given max capacity
		cap = capacity;
		buffer = new double[capacity + 1];
		size = 0;
	}

	public int size() {// return number of items currently in the buffer
		return size;
	}

	public boolean isEmpty() { // is the buffer empty (size equals zero)?
		if (size == 0)
			return true;
		else
			return false;
	}

	public boolean isFull() { // is the buffer full (size equals capacity)?
		if (size == cap)
			return true;
		else
			return false;
	}

	public void enqueue(double x) { // add item x to the end
		if (isFull()) {
			throw new RuntimeException("Queue is full, cannot put in anymore numbers!");
		} else if (isEmpty()) {
			first = size;
			buffer[size++] = x;
			last = size + first;
		} else {
			last = size + first;
			buffer[last % cap] = x;
			size++;

		}
	}

	public double dequeue() { // delete and return item from the front
		if (isEmpty())
			throw new RuntimeException("Queue is empty, cannot remove any numbers!");
		else if (first == cap) {
			first = 0;
			size--;
			return buffer[cap];
		} else {
			size--;
			return buffer[first++];
		}
	}

	public double peek() { // return (but do not delete) item from the front
		if (isEmpty())                                                        
			throw new RuntimeException("Queue is empty, there are no numbers to look at!");
		else
			return buffer[first];
	}

	public static void main(String[] args) {
		/*
		 * RingBuffer b1 = new RingBuffer(10); b1.enqueue(1); b1.enqueue(3);
		 * b1.enqueue(5); b1.enqueue(b1.dequeue() + b1.peek());
		 * System.out.println(b1.dequeue()); System.out.println(b1.dequeue());
		 * System.out.println(b1.dequeue());
		 */ // used for testing
	}

}
