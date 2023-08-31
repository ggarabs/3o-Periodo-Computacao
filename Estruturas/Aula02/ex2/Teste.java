public class Teste{
	public static void recebeCirculos(int n, Circulo v[]){
		for(int i = 0; i < n; i++){
			public float raio;

			System.out.printf("CIRCULO %d\n", i);

			do{
				System.out.printf("Digite o raio do círculo: ");
				raio = nextFloat();
				if(raio <= 0.0f) System.out.printf("ERRO! O circulo deve ter um raio com comprimento positivo.");
			}while(raio <= 0.0f);

			Circulo v[i] = new Circulo(raio);

			System.out.println();
		}
	}
}
