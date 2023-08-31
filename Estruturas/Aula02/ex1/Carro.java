public class Carro{
	private int ano;
	private String marca, modelo, categoria;

	public Carro(int ano, String marca, String modelo, String categoria){
		setAno(ano);
		setMarca(marca);
		setModelo(modelo);
		setCategoria(categoria);
	}

	public Carro(){
		this(0, "", "", "");
	}

	public int getAno(){
		return this.ano;
	}

	public void setAno(int newAno){
		this.ano = newAno;
	}

	public String getMarca(){
		return this.marca;
	}

	public void setMarca(String newMarca){
		this.marca = newMarca;
	}

	public String getModelo(){
		return this.modelo;
	}

	public void setModelo(String newModelo){
		this.modelo = newModelo;
	}

	public String getCategoria(){
		return this.categoria;
	}

	public void setCategoria(String newCategoria){
		this.categoria = newCategoria;
	}
}
