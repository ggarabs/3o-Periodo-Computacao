import java.util.*;

public class Trabalhador{
	private String nome, cpf, endereco;
	private float salario;
	private int idade;
	private char sexo;

	public Trabalhador(String nome, float salario, String cpf, int idade, char sexo, String endereco){
		setNome(nome);
		setSalario(salario);
		setCpf(cpf);
		setIdade(idade);
		setSexo(sexo);
		setEndereco(endereco);
	}
	
	public Trabalhador(){
		this("", 0.0f, "", 0, 'a', "");
	}

	public String getNome(){
		return this.nome;
	}

	public void setNome(String newNome){
		this.nome = newNome;
	}

	public float getSalario(){
		return this.salario;
	}

	public void setSalario(float newSalario){
		this.salario = newSalario;
	}

	public String getCpf(){
		return this.cpf;
	}

	public void setCpf(String newCpf){
		Scanner i = new Scanner(System.in);
		while(newCpf.length() != 11){
			System.out.println("Formato inválido! O número de CPF precisa ter 11 dígitos");
			System.out.println("Digite o CPF do trabalhador: ");
			newCpf = i.next();
		}
		this.cpf = newCpf;
	}

	public int getIdade(){
		return this.idade;
	}

	public void setIdade(int newIdade){
		this.idade = newIdade;
	}

	public char getSexo(){
		return this.sexo;
	}

	public void setSexo(char newSexo){
		Scanner i = new Scanner(System.in);
		newSexo = Character.toUpperCase(newSexo);
		while(newSexo != 'M'&& newSexo != 'F'){
			System.out.println("Formato inválido! O sexo deve ser (M/f).");
			System.out.println("Digite o sexo do trabalhador: ");
			newSexo = i.next().charAt(0);
			newSexo = Character.toUpperCase(newSexo);
		}
		this.sexo = newSexo;
	}

	public String getEndereco(){
		return this.endereco;
	}

	public void setEndereco(String newEndereco){
		this.endereco = newEndereco;
	}

	public float calculaSalarioAnual(){
		return 12.0f*getSalario();
	}

	public void mostra(){
		System.out.printf("\nESPECIFICAÇÕES DO TRABALHADOR: ");
		System.out.printf("Nome: %s", getNome());
		System.out.printf("Salário: %.2f", getSalario());
		System.out.printf("CPF: %s", getCpf());
		System.out.printf("Idade: %d", getIdade());
		System.out.printf("Sexo: %c", getSexo());
		System.out.printf("Endereço: %s\n", getEndereco());
	}

}
