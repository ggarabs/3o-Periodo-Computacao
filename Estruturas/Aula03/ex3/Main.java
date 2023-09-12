import java.util.*;

public class Main{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);

		System.out.print("Digite uma expressão: ");
		String exp = input.nextLine();

		Pilha p = new Pilha(exp.length());

		boolean valid = true;

		for(int i = 0; i < exp.length(); i++){
			if(exp.charAt(i) == '(' || exp.charAt(i) == '[' || exp.charAt(i) == '{' || exp.charAt(i) == '<'){
				p.push(exp.charAt(i));
			}else if(exp.charAt(i) == ')'){
				if(p.top() == '(') p.pop();
				else valid = false;
			}else if(exp.charAt(i) == ']'){
				if(p.top() == '[') p.pop();
				else valid = false;
			}else if(exp.charAt(i) == '}'){
				if(p.top() == '{') p.pop();
				else valid = false;
			}else if(exp.charAt(i) == '>'){
				if(p.top() == '<') p.pop();
				else valid = false;
			}
		}

		if(!p.isEmpty()) valid = false;

		if(valid) System.out.println("Expressão válida!");
		else System.out.println("Expressão inválida!");

		input.close();
	}
}
