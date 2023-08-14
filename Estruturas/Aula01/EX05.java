import java.util.Scanner;

public class EX05{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		final int LIM_SUP = 2001;

		System.out.print("Digite o numero N de elementos do vetor: ");
		int N = entrada.nextInt();

		int vetor[] = new int[LIM_SUP];
		int qtd[] = new int[LIM_SUP];
		boolean vis[] = new boolean[LIM_SUP];

		for(int i = 0; i < N; i++) qtd[i] = 0;

		for(int i = 0; i < N; i++){
			System.out.print("v[" + i + "]: ");
			vetor[i] = entrada.nextInt();
			qtd[vetor[i]]++;
		}

		System.out.print("Vetor resposta: ");

		for(int i = 0; i < N; i++){
			if(!vis[vetor[i]]){
				System.out.print(vetor[i] + " " + qtd[vetor[i]] + " ");
				vis[vetor[i]] = true;
			}
		}

		System.out.println();

		entrada.close();
	}
}
