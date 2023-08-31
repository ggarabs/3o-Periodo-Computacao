import java.util.*;

public class Main{
	private static final int MAX_TRABALHADOR = 50;

	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);

		int N;
		do{			
			System.out.printf("Digite o número de trabalhadores: ");
			N = entrada.nextInt();

			if(N > 50) System.out.printf("ERRO! Digite um valor positivo menor ou igual a 50: ");

		}while(N > 50);

		Trabalhador lista[] = new Trabalhador[N];

		for(int i = 0; i < N; i++){
			String nome, cpf, endereco;
			float salario;
			int idade;
			char sexo;

			System.out.print("Digite o nome do trabalhador: ");
			nome = entrada.next();

			System.out.print("Digite o salário do trabalhador: ");
			salario = entrada.nextFloat();

			System.out.print("Digite o cpf do trabalhador: ");
			cpf = entrada.next();

			System.out.print("Digite a idade do trabalhador: ");
			idade = entrada.nextInt();

			System.out.print("Digite o sexo do trabalhador: ");
			sexo = entrada.next().charAt(0);

			System.out.print("Digite o endereco do trabalhador: ");
			endereco = entrada.next();

			lista[i] = new Trabalhador(nome, salario, cpf, idade, sexo, endereco);
		}

		System.out.print(Teste.calcMedia(lista));
	}
}
