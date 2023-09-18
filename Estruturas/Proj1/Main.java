import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		CircularQueue[] stream = new CircularQueue[3]; //Cria os fluxos
		CircularQueue MUXstream = new CircularQueue(); //Cria a fila para o multiplexador

		for(int i = 0; i < 3; i++) stream[i] = new CircularQueue(); //Cria 3 filas circulares

		boolean EndOfProgram = false;
		do {
			int choice = IOfunctions.choice(); //Passa a choice do menu realizada pelo usuario

			switch (choice) {
				case 1: 
					System.out.print("\nEnter a list of numbers to be placed in Stream 1 separated by commas: ");
					String values = input.nextLine(); //Coloca os elementos em values
					System.out.println();
					int elements[] = AuxiliarMethods.split(values);
					stream[(choice-1)%3].AddElementsOnStream(elements, (choice-1)%3);
					System.out.print("Successfully saved!\n");
					break;
				case 2: 
					System.out.print("\nEnter a list of numbers to be placed in Stream 2 separated by commas:");
					values = input.nextLine(); //Coloca os elementos em values
					System.out.println();
					elements = AuxiliarMethods.split(values);
					stream[(choice-1)%3].AddElementsOnStream(elements, (choice-1)%3);
					System.out.print("Successfully saved!\n");
					break;
				case 3: 
					System.out.print("\nEnter a list of numbers to be placed in Stream 3 separated by commas:");
					values = input.nextLine(); //Coloca os elementos em values retirando os espaços
					System.out.println();
					elements = AuxiliarMethods.split(values);
					stream[(choice-1)%3].AddElementsOnStream(elements, (choice-1)%3);
					System.out.print("Successfully saved!\n");
					break;
				case 4: //choice 4 imprime os valores das 3 filas
					int aux[] = new int[3];
					int EveryStreamIsEmpty = 0;
					System.out.println("\nStream Elements: ");
					for(int i = 0; i < 3; i++){
						aux[i] = stream[i].PrintElementsOfStream(i);
						EveryStreamIsEmpty += aux[i];
					}
					if(EveryStreamIsEmpty == 0) System.out.println("\nAll the Streams are empty! Please add elements to the streams and try multiplexing again!\n");
					else for(int i = 0; i < 3; i++){
						if(aux[i] == 0) System.out.printf("Stream %d is empty!\n", i+1);
					}
					break;
				case 5: //choice 5 realiza a multiplexação
					if(MUXstream.MultiplexStreams(stream)){
						System.out.println("\nSuccessfully multiplexed streams!\n");
					}else System.out.println("\nAll the Streams are empty! Please add elements to the streams and try multiplexing again!\n");
					break;
				case 6: //choice 6 imprime os numeros já multiplexados
					MUXstream.PrintElementsOfMUXStream();
					break;
				case 7: //choice 7 finaliza o programa
					EndOfProgram = true;
					System.out.printf("\nProgram Closed! Thank you very much for using the Multiplexer!\n");
					break;
				default:
					break;
			}
		} while (!EndOfProgram); //Se final do programa for diferente de verdadeiro fica em loop

		input.close(); //Fecha o input
	}
}