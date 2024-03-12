

public class PrivMassageBookSysADT {
	private String num[];
	private int front;
	private int rear;
	private int capacity;
	
	public PrivMassageBookSysADT() {
		capacity = 5;
		front = -1;
		rear= -1;
		num = new String[capacity];
	}
	
	public PrivMassageBookSysADT(int capacity) {
		this.capacity = capacity;
		front = -1;
		rear = -1;
		num = new String[capacity];
	}
	
	public void enqueue(String data) {
		String all = "";
		long start = System.nanoTime();
		if(isFull()) {
			System.out.print("The Queue is Full");
		}else {
			rear++;
			num[rear] = data;
			front = 0;
		}
		long end = System.nanoTime();
		all += "Editing Client's data in time units (enqueue): " +  (end - start);
		System.out.println(all);
	}
	
	
	public String dequeue() {
		String all = "";
		long start = System.nanoTime();
		String val = "";
		if(isEmpty()) {
			System.out.println("The Queue is Empty");
		}else {
			val = num[front];
			for (int i = 0; i < rear; i++) {
				num[i]= num[i+1];
			}
			rear--;
		}
		long end = System.nanoTime();
		all += "Data deletion of the Client in time units (dequeue): " +  (end - start);
		System.out.println(all);
		return val;
		
		
	}
	
	@SuppressWarnings("unused")
	private Object JtextArea(String all) {
		return null;
	}


	public String display() {
		String hold = "";
		for(int i = 0; i <= rear; i++) {
			hold += "\n" +num[i] + "";
		}
		return hold;
	}
	
	public String showInfo() {
		return "Client Name          \t" + "Contact Information          \t" 
	+ "Service          \t"+ "Client Number\t\n" + display() + "\n\nNumber of Clients\t: " + getCurrentSize();
	}
	
	public String message() {
		return "THE ZEN DEN BOOKING SYSTEM\n\n\n";
	}
	
	public String frontValue() {
		return num[front];
	}
	
	public String rearValue() {
		return num[rear];
	}
	
	public String peek() {
		if(isEmpty()) {
			System.out.print("The Queue is Empty ");
			return "";
		}else {
			return num[front];
		}
	}
	
	public String last() {
		if(isEmpty()) {
			System.out.print("The Queue is Empty ");
			return "";
		}else {
			return num[rear];
		}
	}
	
	public int count() {
		int count = 0;
		for (int i=0; i <= rear; i++) {
			count += 1 ;
		}
		return count;
	}
	
	public int getCurrentSize() {
		return capacity - (capacity - (rear+1));
	}
	
	public int getCapacity() {
		return capacity;
	}
	
	public boolean isEmpty() {
		return rear == -1;
	}
	
	public boolean isFull() {
		return rear == capacity - 1;
	}
}
