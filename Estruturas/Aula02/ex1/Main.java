public class Main{
	public static void main(String[] args){
		Carro carro1 = new Carro(2023, "Lamborghini", "Hurakan", "Sedan");
		Carro carro2 = new Carro();
		Carro carro3 = new Carro(1977, "Volkswagen", "Fusca", "Hatch");

		Teste.mostraDados(carro1);
		Teste.mostraDados(carro2);
		Teste.mostraDados(carro3);
	}
}
