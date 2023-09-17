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
					System.out.println("\nStream Elements: ");
					for(int i = 0; i < 3; i++) stream[i].PrintElementsOfStream(i);
					break;
				case 5: //choice 5 realiza a multiplexação
					MUXstream.MultiplexStreams(stream);
					System.out.println("\nSuccessfully multiplexed streams!\n");
					break;
				case 6: //choice 6 imprime os numeros já multiplexados
					MUXstream.PrintElementsOfStream(4);
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