import java.util.*;

public class EX04{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);

		System.out.print("Digite o valor de n: ");
		int n = entrada.nextInt();

		long soma = 2, f_ultimo = 1, f_penultimo = 1, atual = 1;

		System.out.print("1 ");

		if(n >= 2){
			System.out.print("1 ");
		
			for(int i = 3; i <= n; i++) {
				atual = f_ultimo + f_penultimo;
				soma += atual;
				f_penultimo = f_ultimo;
				f_ultimo = atual;
				System.out.print(String.format("%d ", atual));
			}
		}

		if(n == 1) soma--;
		
		System.out.printf("\nSoma = %d\n", soma);

		entrada.close();
	}
}
