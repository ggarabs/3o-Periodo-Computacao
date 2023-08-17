import java.util.*;

public class EX01{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);

		System.out.print("Digite o numero M de tanques: ");
		int M = entrada.nextInt();

		System.out.print("Digite a altura h(em cm) de um tanque: ");
		float h = entrada.nextFloat();

		System.out.print("Digite o raio r(em cm) da base do tanque: ");
		float r = entrada.nextFloat();

		final float PI = 3.141592f;
		int volumeBarril = 200*1000;
		float volumeTanque = PI*r*r*h;

		System.out.printf("O numero minimo de barris necessarios para preencher %d tanques eh %d\n", M, (int)Math.ceil(M*volumeTanque/volumeBarril));

		entrada.close();
	}
}
