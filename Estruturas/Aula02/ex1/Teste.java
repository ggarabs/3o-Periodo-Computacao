public class Teste{
	public static void mostraDados(Carro car){
		System.out.printf("\nCARRO - ESPECIFICAÇÕES\n");
		System.out.printf("Ano: %d\n", car.getAno());
		System.out.printf("Marca: %s\n", car.getMarca());
		System.out.printf("Modelo: %s\n", car.getModelo());
		System.out.printf("Categoria: %s\n\n", car.getCategoria());
	}
}
