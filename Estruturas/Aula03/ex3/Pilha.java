public class Pilha{
	private static int MAX_TAM = 100;
	private int topoPilha;
	private char pilha[];

	public Pilha(){
		this(MAX_TAM);
	}

	public Pilha(int N){
		this.pilha = new char[N];
		this.topoPilha = -1;
	}

	public boolean isEmpty(){
		return this.topoPilha == -1;
	}

	public void push(char element){
		if(!this.isFull()) this.pilha[++this.topoPilha] = element;
		else System.out.println("Stack overflow!");
	}

	public int pop(){
		if(!this.isEmpty()) return this.pilha[this.topoPilha--];
		else System.out.println("Stack underflow!");
		return -1;
	}

	public int top(){
		if(!this.isEmpty()) return this.pilha[this.topoPilha];
		System.out.println("Stack underflow!");
		return -1;
	}

	public boolean isFull(){
		return this.topoPilha == this.pilha.length-1;
	}

	public int sizeElements(){
		return this.topoPilha+1;
	}
}
