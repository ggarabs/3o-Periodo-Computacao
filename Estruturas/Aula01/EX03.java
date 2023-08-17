import java.util.*;

public class EX03{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);

		System.out.print("Digite o valor de N: ");
		int n = entrada.nextInt();
		
		double resp = 1.0f;
		long aux = 1;
		
		for(int i = 1; i <= n; i++){
			resp += 1.0/aux;
			aux *= i+1;
		}
		
		System.out.printf(String.format("E = %.15f\n", resp));
		entrada.close();
	}
}
