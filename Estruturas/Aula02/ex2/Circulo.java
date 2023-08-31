import java.util.*;

public class Circulo{
	private float raio;

	public Circulo(float newRaio){
		setRaio(newRaio);
	}

	public float getRaio(){
		return this.raio;
	}

	public void setRaio(float raio){
		Scanner i = new Scanner(System.in);
		while(raio <= 0){
			System.out.println("Raio inválido! Não existe círculo com raio não positivo.");
			System.out.printf("Digite o raio do círculo: ");
			raio = i.nextFloat();
		}
		this.raio = raio;
	}

	public float calculaDiametro(){
		return 2*getRaio();
	}

	public float calculaArea(){
		return (float)(Math.PI*Math.pow(getRaio(), 2));
	}

	public void mostraDados(){
		System.out.printf("\nCÍRCULO - ESPECIFICAÇÕES\n");
		System.out.printf("Raio: %.2fm\n", getRaio());
		System.out.printf("Diâmetro: %.2fm\n", calculaDiametro());
		System.out.printf("Área: %.2fm²\n", calculaArea());
	}
}	
