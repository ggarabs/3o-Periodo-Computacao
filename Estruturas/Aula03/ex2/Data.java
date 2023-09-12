public class Data{
	public static boolean dataValida(String formato){
		boolean tam = formato.length() == 10;
		boolean bar = formato.charAt(2) == '/' && formato.charAt(5) == '/';
		boolean num = true;
		for(int i = 0; i < 10; i++){
			if(i == 2 || i == 5) continue;
			if(!Character.isDigit(formato.charAt(i))) num = false;
		}
		return tam && bar && num;
	}
}
