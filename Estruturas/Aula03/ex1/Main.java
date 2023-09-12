import java.util.*;
import java.text.Normalizer;

public class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.print("Digite uma frase: ");
		String frase = input.nextLine();

		String modificada = Normalizer.normalize(frase, Normalizer.Form.NFD);
		modificada = modificada.trim().replaceAll("\\s+", "").toLowerCase();
		modificada = modificada.replaceAll("\\p{Punct}", "");
		modificada = modificada.replaceAll("[^\\p{ASCII}]", "");

		Pilha stack = new Pilha(modificada.length());

		for(int i = 0; i <= modificada.length()/2; i++){
			if(!stack.isFull()) stack.push(modificada.charAt(i));
		}

		if(modificada.length() % 2 == 0 && modificada.length() > 0) stack.pop();

		boolean eh_palindromo = true;

		for(int i = modificada.length()/2; i < modificada.length(); i++){
			if(!stack.isEmpty() && stack.pop() != modificada.charAt(i)){
				eh_palindromo = false;
				break;
			}
		}

		if(eh_palindromo) System.out.printf("A frase '%s' é palíndromo.\n", frase);
		else System.out.printf("A frase '%s' não é palíndromo.\n", frase);

		input.close();
	}
}
