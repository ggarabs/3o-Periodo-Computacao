import java.util.*;

public class EX05{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		final int LIM_SUP = 2001;

		System.out.print("Digite o numero N de elementos do vetor: ");
		int N = entrada.nextInt();

		int vetor[] = new int[LIM_SUP];
		int qtd[] = new int[LIM_SUP];
		boolean vis[] = new boolean[LIM_SUP];

		for(int i = 0; i < N; i++){
			System.out.print("v[" + i + "]: ");
			vetor[i] = entrada.nextInt();
			qtd[vetor[i]]++;
		}

		int vetor_resp[] = new int[2*LIM_SUP];

		System.out.print("Vetor resposta: ");

		int j = 0;

		for(int i = 0; i < N; i++){
			if(!vis[vetor[i]]){
				vetor_resp[j] = vetor[i];
				j++;
				vetor_resp[j] = qtd[vetor[i]];
				j++;
				vis[vetor[i]] = true;
			}
		}

		for(int i = 0; i < j; i++) System.out.printf("%d ", vetor_resp[i]);

		System.out.println();
		entrada.close();
	}
}
