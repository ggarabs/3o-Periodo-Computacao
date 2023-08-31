public class Teste{
	public static float calcMedia(Trabalhador[] trab){
		float media = 0.0f;
		for(int i = 0; i < trab.length; i++) media += trab[i].getSalario();
		media /= trab.length;
		return media;
	}

	public static void homensAcimaDaMedia(Trabalhador[] trab, float media){
		for(int i = 0; i < trab.length; i++){
			if(trab[i].getSexo() == 'H' && trab[i].getSalario() > media) trab[i].mostra();
		}
	}



}
