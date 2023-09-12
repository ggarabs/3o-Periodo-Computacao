import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		final int STD_TAM = 4;

		String data;

		do{
			System.out.print("Digite uma data no formato (DD/MM/YYYY): ");
			data = input.nextLine().trim();

			if(!Data.dataValida(data)) System.out.println("Formato inválido!");
			else break;

		}while(true);

		Pilha stack = new Pilha(STD_TAM);

		int pt = 0;
		boolean eh_palindromo = true;

		while(stack.sizeElements() < 4){
			if(!stack.isFull() && data.charAt(pt) != '/'){
				stack.push(data.charAt(pt));
			}
			pt++;
		}

		for(pt++; pt < data.length(); pt++){
			if(!stack.isEmpty() && stack.pop() != data.charAt(pt)){
				eh_palindromo = false;
				break;
			}
		}

		if(eh_palindromo) System.out.println("É um palíndromo.");
		else System.out.println("Não é um palíndromo.");

		input.close();
	}
}
