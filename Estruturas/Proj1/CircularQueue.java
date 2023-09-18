public class CircularQueue{
	private int begin, end, qtd;
	private StreamObject queue[];
	private static final int DEFAULT_TAM = 100;

	public CircularQueue(int size_queue){
		this.begin = this.end = this.qtd = 0;
		this.queue = new StreamObject[size_queue];
	}

	public CircularQueue(){ this(DEFAULT_TAM); }

	public int size(){ return this.qtd; }

	public boolean isEmpty(){ return this.size() == 0; }

	public boolean isFull(){ return this.size() == this.queue.length; }

	public void enqueue(StreamObject object){
		if(!this.isFull()){
			this.queue[this.end++] = object;
			this.end %= this.queue.length;
			this.qtd++;
		}else System.out.println("Queue overStreamObject!");
	}

	public StreamObject dequeue(){
		StreamObject aux = new StreamObject();
		if(!this.isEmpty()){
			this.qtd--;
			this.begin = ++this.begin % this.queue.length;
			return queue[(this.begin - 1 + this.queue.length) % this.queue.length];
		}else System.out.println("Queue underStreamObject!");
		return aux;
	}

	public StreamObject front(){
		StreamObject aux = new StreamObject();
		if(!this.isEmpty()) return this.queue[this.begin];
		System.out.println("Queue underStreamObject");
		return aux;
	}

	public StreamObject rear(){
		StreamObject aux = new StreamObject();
		if(!this.isEmpty()) return this.queue[(this.end - 1 + this.queue.length) % this.queue.length];
		System.out.println("Queue underStreamObject");
		return aux;
	}

    public void AddElementsOnStream(int elements[], int ID){ //Adiciona os elementos a fila
		for(int i = 0; i < elements.length; i++){
			StreamObject obj = new StreamObject(ID, elements[i]);
        	this.enqueue(obj);
		}
    }

    public boolean MultiplexStreams(CircularQueue F[]){ //Realiza a multiplexação
		if(F[0].isEmpty() && F[1].isEmpty() && F[2].isEmpty()){
			return false;
		}
        int cont = 0; //Inicializa contador e um vetor interatores
        while(!F[0].isEmpty() || !F[1].isEmpty() || !F[2].isEmpty()){
            if(!F[cont % 3].isEmpty()){ //Verifica se ainda há elementos não processados na fila
                this.enqueue(F[cont % 3].dequeue()); //Insere o elemento da frente da fila atual para a fila MUXF
            }
            cont++;
        }
		return true;
    }

    public int PrintElementsOfStream(int ID){ //Imprime os elementos da fila
		if(this.isEmpty()){
			return 0;
		}
        System.out.printf("Stream %d: [", ID+1);
        for(int i = 0; i < this.size(); i++){
			System.out.printf("%d", this.front().getData()); //Pega o elemento inicial da fila
			if(i != this.size()-1) System.out.printf(", "); //Separa o elemento com virgula
			this.enqueue(this.dequeue());
        }
        System.out.printf("]\n");
		return 1;
    }

	public void PrintElementsOfMUXStream(){ //Imprime os elementos da fila
		if(this.isEmpty()){
			System.out.print("\nMultiplexed stream are Empty! Please add elements to the streams and try multiplexing again!\n");
			return;
		}
		System.out.print("\nMultiplexed stream: [");
		int tam = this.size();
        for(int i = 0; i < tam; i++){
			System.out.printf("(%d,%d)", this.front().getData(), this.front().getID()+1);
			if(i != tam-1) System.out.printf(", "); //Separa o elemento com virgula
			this.dequeue();
        }
        System.out.printf("]\n");
    }

}