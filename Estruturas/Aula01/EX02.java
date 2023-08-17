import java.util.*;

public class EX02{
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);

		int intervalo;

		do {
			System.out.print("Digite o horario de partida (HH:MM:SS): ");
			String t1 = entrada.next();

			int h1 = Integer.parseInt(t1.substring(0, 2));
			int m1 = Integer.parseInt(t1.substring(3, 5));
			int s1 = Integer.parseInt(t1.substring(6, 8));

			int t1_res = 3600*h1 + 60*m1 + s1;

			System.out.print("Digite o horario de chegada(HH:MM:SS): ");
                	String t2 = entrada.next();

                	int h2 = Integer.parseInt(t2.substring(0, 2));
                	int m2 = Integer.parseInt(t2.substring(3, 5));
                	int s2 = Integer.parseInt(t2.substring(6, 8));

               		int t2_res = 3600*h2 + 60*m2 + s2;

			intervalo = t2_res - t1_res;

			if(intervalo < 0) System.out.println("Horarios invalidos! Por favor digite um horario de chegada maior que o horario de partida.");

		}while(intervalo < 0);

		float valor = 0.0f;

		int h_res = intervalo/3600;
		intervalo -= 3600*h_res;
		valor += 10.00*h_res;

		int m_res = intervalo/60;
		intervalo -= 60*m_res;
		valor += 0.20*m_res;

		int s_res = intervalo;
		valor += 0.02*s_res;

		System.out.print(String.format("Tempo total de viagem: %d:%d:%d\n", h_res, m_res, s_res));
		System.out.print(String.format("Valor a pagar: R$ %.2f\n", valor));

		entrada.close();
	}
}
